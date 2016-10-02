package pkg.entity;

// JDBC libraries
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import pkg.connection.DBConnection;

public class UserPostsStatus {

    //instance variables
    private int user_id;
    private int status_id;
    
    //getter and setters
    public void setUserID(int user_id){ this.user_id = user_id; }
    
    public void setStatusID(int status_id){ this.status_id = status_id; }
	
	public int getUserID() { return user_id; }
	
	public int getStatusID() { return status_id; }
	
	public void insertData () throws SQLException {
    
    	// get the connection
    	Connection connection = DBConnection.getConnection();
		
		// create the INSERT SQL
    	StringBuffer sbInsert = new StringBuffer();
    	
    	sbInsert.append("INSERT INTO USERPOSTSSTATUS");
    	sbInsert.append(" VALUES ");
    	sbInsert.append("(" + getUserID() + ", " + getStatusID() + ")");			
    	
    	Statement statement = connection.createStatement();
    	try {
      		// Insert the data
      		statement.executeUpdate (sbInsert.toString());
    	} catch (SQLException e) {
      		System.out.println("Error inserting new user status: " + e);
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
    	
    	sbDelete.append("DELETE FROM USERPOSTSSTATUS ");
    	sbDelete.append("WHERE USER_ID = " + getUserID());
    	sbDelete.append(" AND STATUS_ID = " + getStatusID());
    	
    	Statement statement = connection.createStatement();
    	try {
      		// Insert the data
      		statement.executeUpdate (sbDelete.toString());
    	} catch (SQLException e) {
      		System.out.println("Error deleting tuple from USERPOSTSSTATUS: " + e);
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
  	public UserPostsStatus[] loadAll() throws SQLException {
    	// get the connection
    	Connection connection = DBConnection.getConnection();
        
    	// create the SELECT SQL
    	StringBuffer sbSelect = new StringBuffer();
    	sbSelect.append(" SELECT USER_ID, STATUS_ID FROM USERPOSTSSTATUS");
    
   	 	Statement statement = null;
    	ResultSet rs = null;
	    ArrayList<UserPostsStatus> collection = new ArrayList<UserPostsStatus>();
	    
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
	          UserPostsStatus userPostsStatus = new UserPostsStatus();
	          userPostsStatus.setUserID(rs.getInt("USER_ID"));
	          userPostsStatus.setStatusID(rs.getInt("STATUS_ID"));
	          
	          // store it in the list
	          collection.add(userPostsStatus);
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
	    return (UserPostsStatus[])collection.toArray(new UserPostsStatus[0]);  
	  }    
    
}