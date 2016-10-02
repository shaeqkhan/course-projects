package pkg.entity;

// JDBC libraries
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import pkg.connection.DBConnection;

public class Comments {

    //instance variables
    private int comment_id;
    private String comment_content;    
    private Date comment_time_stamp;
    
    
    //getter and setters
    public void setCommentID(int comment_id){ this.comment_id = comment_id; }
    
    public void setCommentContent(String comment_content){ this.comment_content = comment_content; }    

	public void setCommentTimestamp(Date comment_time_stamp) { this.comment_time_stamp = comment_time_stamp; }	
	
	public int getCommentID() { return comment_id; }
	
	public String getCommentContent() { return comment_content; }
		
	public Date getCommentTimestamp() { return comment_time_stamp; }	
	
	public void insertData () throws SQLException {
    
    	// get the connection
    	Connection connection = DBConnection.getConnection();
    	        	
    	// create the INSERT SQL
    	StringBuffer sbInsert = new StringBuffer();
    	
    	sbInsert.append("INSERT INTO COMMENTS");
    	sbInsert.append(" VALUES ");
    	sbInsert.append("(" + getCommentID() + ", '" + 
    							getCommentContent() + "', systimestamp)");
    							
    	
    	Statement statement = connection.createStatement();
    	try {
      		// Insert the data
      		statement.executeUpdate (sbInsert.toString());
    	} catch (SQLException e) {
      		System.out.println("Error inserting new comment: " + e);
		}
		finally{
			statement.close();
			DBConnection.close(connection);
		}
		
	}
	
	public void updateData() throws SQLException {
		
		// get the connection
    	Connection connection = DBConnection.getConnection();
    	        	
    	// create the INSERT SQL
    	StringBuffer sbInsert = new StringBuffer();
    	
    	sbInsert.append("UPDATE COMMENTS ");
    	sbInsert.append("SET COMMENT_CONTENT = '" + getCommentContent() + "', " );		
		sbInsert.append("COMMENT_TIME_STAMP = systimestamp " );
		sbInsert.append("WHERE COMMENT_ID = " + getCommentID());
		
		Statement statement = connection.createStatement();
    	try {
      		// Insert the data
      		statement.executeUpdate (sbInsert.toString());
    	} catch (SQLException e) {
      		System.out.println("Error updating COMMENTS: " + e);
		}
		finally{
			statement.close();
			DBConnection.close(connection);
		}
	}
	
	public void deleteTuple() throws SQLException {
		
		// get the connection
    	Connection connection = DBConnection.getConnection();
    	
    	// create the INSERT SQL
    	StringBuffer sbDelete = new StringBuffer();
    	
    	sbDelete.append("DELETE FROM COMMENTS ");
    	sbDelete.append("WHERE COMMENT_ID = " + getCommentID());
    	
    	Statement statement = connection.createStatement();
    	try {
      		// Insert the data
      		statement.executeUpdate (sbDelete.toString());
    	} catch (SQLException e) {
      		System.out.println("Error deleting COMMENTS: " + e);
		}
		finally{
			statement.close();
			DBConnection.close(connection);
		}
			
	}
	
	/*
     * @return
     * @throws SQLException
     */
  	public Comments[] loadAll() throws SQLException {
    	// get the connection
    	Connection connection = DBConnection.getConnection();
        
    	// create the SELECT SQL
    	StringBuffer sbSelect = new StringBuffer();
    	sbSelect.append(" SELECT COMMENT_ID, COMMENT_CONTENT, COMMENT_TIME_STAMP FROM COMMENTS");
    
   	 	Statement statement = null;
    	ResultSet rs = null;
	    ArrayList<Comments> collection = new ArrayList<Comments>();
	    
	    try
	    {
	      // create the statement
	      statement = connection.createStatement();
	      
	      // Insert the data
	      rs = statement.executeQuery(sbSelect.toString());
	      
	      if (rs != null) {    
	        // when the resultset is not null, there are records returned
	        while (rs.next())
	        {
	          // loop through each result and store the data
	          // as an Users object
	          Comments comments = new Comments();
	          comments.setCommentID(rs.getInt("COMMENT_ID"));
	          comments.setCommentContent(rs.getString("COMMENT_CONTENT"));
	          comments.setCommentTimestamp(rs.getTimestamp("COMMENT_TIME_STAMP"));
	          
	          // store it in the list
	          collection.add(comments);
	        }        
	      }
	    } catch (SQLException e)	    {
	      System.err.println("Error in SQL statement: " + e);
	    } 
	    finally
	    {  
	      rs.close();
	      statement.close();
	      DBConnection.close(connection);
	    }
	    
	    //   return the array
	    return (Comments[])collection.toArray(new Comments[0]);  
	  }    
    
}