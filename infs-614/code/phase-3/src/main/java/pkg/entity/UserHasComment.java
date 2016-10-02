package pkg.entity;

// JDBC libraries
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import pkg.connection.DBConnection;

public class UserHasComment {

    //instance variables
    private int user_id;
    private int comment_id;
    
    //getter and setters
    public void setUserID(int user_id){ this.user_id = user_id; }
    
    public void setCommentID(int comment_id){ this.comment_id = comment_id; }
	
	public int getUserID() { return user_id; }
	
	public int getCommentID() { return comment_id; }
	
	public void insertData () throws SQLException {
    
    	// get the connection
    	Connection connection = DBConnection.getConnection();
		
		// create the INSERT SQL
    	StringBuffer sbInsert = new StringBuffer();
    	
    	sbInsert.append("INSERT INTO USERHASCOMMENT");
    	sbInsert.append(" VALUES ");
    	sbInsert.append("(" + getUserID() + ", " + getCommentID() + ")");			
    	
    	Statement statement = connection.createStatement();
    	try {
      		// Insert the data
      		statement.executeUpdate (sbInsert.toString());
    	} catch (SQLException e) {
      		System.out.println("Error inserting new user comment: " + e);
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
    	
    	sbDelete.append("DELETE FROM USERHASCOMMENT ");
    	sbDelete.append("WHERE USER_ID = " + getUserID());
    	sbDelete.append(" AND COMMENT_ID = " + getCommentID());
    	
    	Statement statement = connection.createStatement();
    	try {
      		// Insert the data
      		statement.executeUpdate (sbDelete.toString());
    	} catch (SQLException e) {
      		System.out.println("Error deleting tuple from USERHASCOMMENT: " + e);
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
  	public UserHasComment[] loadAll() throws SQLException {
    	// get the connection
    	Connection connection = DBConnection.getConnection();
        
    	// create the SELECT SQL
    	StringBuffer sbSelect = new StringBuffer();
    	sbSelect.append(" SELECT USER_ID, COMMENT_ID FROM USERHASCOMMENT");
    
   	 	Statement statement = null;
    	ResultSet rs = null;
	    ArrayList<UserHasComment> collection = new ArrayList<UserHasComment>();
	    
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
	          UserHasComment userHasComment = new UserHasComment();
	          userHasComment.setUserID(rs.getInt("USER_ID"));
	          userHasComment.setCommentID(rs.getInt("COMMENT_ID"));
	          
	          // store it in the list
	          collection.add(userHasComment);
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
	    return (UserHasComment[])collection.toArray(new UserHasComment[0]);  
	  }    
    
}