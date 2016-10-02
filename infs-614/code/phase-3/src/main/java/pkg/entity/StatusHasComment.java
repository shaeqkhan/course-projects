package pkg.entity;

// JDBC libraries
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import pkg.connection.DBConnection;

public class StatusHasComment {

    //instance variables
    private int status_id;
    private int comment_id;
    
    //getter and setters
    public void setStatusID(int status_id){ this.status_id = status_id; }
    
    public void setCommentID(int comment_id){ this.comment_id = comment_id; }
	
	public int getStatusID() { return status_id; }
	
	public int getCommentID() { return comment_id; }
	
	
	public void insertData () throws SQLException {
    
    	// get the connection
    	Connection connection = DBConnection.getConnection();
		
		// create the INSERT SQL
    	StringBuffer sbInsert = new StringBuffer();
    	
    	sbInsert.append("INSERT INTO STATUSHASCOMMENT");
    	sbInsert.append(" VALUES ");
    	sbInsert.append("(" + getStatusID() + ", " + getCommentID() + ")");			
    	
    	Statement statement = connection.createStatement();
    	try {
      		// Insert the data
      		statement.executeUpdate (sbInsert.toString());
    	} catch (SQLException e) {
      		System.out.println("Error inserting new comment for a status: " + e);
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
    	
    	sbDelete.append("DELETE FROM STATUSHASCOMMENT ");
    	sbDelete.append("WHERE STATUS_ID = " + getStatusID());
    	sbDelete.append("AND COMMENT_ID = " + getCommentID());
    	
    	Statement statement = connection.createStatement();
    	try {
      		// Insert the data
      		statement.executeUpdate (sbDelete.toString());
    	} catch (SQLException e) {
      		System.out.println("Error deleting STATUSHASCOMMENT: " + e);
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
  	public StatusHasComment[] loadAll() throws SQLException {
    	// get the connection
    	Connection connection = DBConnection.getConnection();
        
    	// create the SELECT SQL
    	StringBuffer sbSelect = new StringBuffer();
    	sbSelect.append(" SELECT STATUS_ID, COMMENT_ID FROM STATUSHASCOMMENT");
    
   	 	Statement statement = null;
    	ResultSet rs = null;
	    ArrayList<StatusHasComment> collection = new ArrayList<StatusHasComment>();
	    
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
	          // as an USERISFIEND object
	          StatusHasComment statusHasComment = new StatusHasComment();
	          statusHasComment.setStatusID(rs.getInt("STATUS_ID"));
	          statusHasComment.setCommentID(rs.getInt("COMMENT_ID"));
	          
	          // store it in the list
	          collection.add(statusHasComment);
	        }        
	      }
	    } catch (SQLException e) {
	      System.err.println("Error in SQL statement: " + e);
	    } 
	    finally
	    {  
	      rs.close();
	      statement.close();
	      DBConnection.close(connection);
	    }
	    
	    //   return the array
	    return (StatusHasComment[])collection.toArray(new StatusHasComment[0]);  
	  }    
    
}