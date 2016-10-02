package pkg.entity;

// JDBC libraries
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import pkg.connection.DBConnection;

public class UserIsFriend {

    //instance variables
    private int user_id;
    private int friend_id;
    
    //getter and setters
    public void setUserID(int user_id){ this.user_id = user_id; }
    
    public void setFriendID(int friend_id){ this.friend_id = friend_id; }
	
	public int getUserID() { return user_id; }
	
	public int getFriendID() { return friend_id; }
	
	public void insertData () throws SQLException {
    
    	// get the connection
    	Connection connection = DBConnection.getConnection();
		
		// create the INSERT SQL
    	StringBuffer sbInsert = new StringBuffer();
    	
    	sbInsert.append("INSERT INTO USERISFRIEND");
    	sbInsert.append(" VALUES ");
    	sbInsert.append("(" + getUserID() + ", " + getFriendID() + ")");			
    	
    	Statement statement = connection.createStatement();
    	try {
      		// Insert the data
      		statement.executeUpdate (sbInsert.toString());
    	} catch (SQLException e) {
      		System.out.println("Error inserting new friend: " + e);
		}
		finally{
			statement.close();
			DBConnection.close(connection);
		}
	}
	
	public void updateData () throws SQLException {
    
    	// get the connection
    	Connection connection = DBConnection.getConnection();
    	
    	// create the INSERT SQL
    	StringBuffer sbInsert = new StringBuffer();
    	
    	sbInsert.append("UPDATE USERISFRIEND");
    	sbInsert.append(" SET FRIEND_ID = " + getFriendID());
    	sbInsert.append(" WHERE USER_ID = " + getUserID());
    	    							
    	
    	Statement statement = connection.createStatement();
    	try {
      		// Insert the data
      		statement.executeUpdate (sbInsert.toString());
    	} catch (SQLException e) {
      		System.out.println("Error updating USERISFRIEND: " + e);
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
    	
    	sbDelete.append("DELETE FROM USERS ");
    	sbDelete.append("WHERE USER_ID = " + getUserID());
    	sbDelete.append("AND FRIEND_ID = " + getFriendID());
    	
    	Statement statement = connection.createStatement();
    	try {
      		// Insert the data
      		statement.executeUpdate (sbDelete.toString());
    	} catch (SQLException e) {
      		System.out.println("Error deleting USERISFRIEND: " + e);
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
  	public UserIsFriend[] loadAll() throws SQLException {
    	// get the connection
    	Connection connection = DBConnection.getConnection();
        
    	// create the SELECT SQL
    	StringBuffer sbSelect = new StringBuffer();
    	sbSelect.append(" SELECT USER_ID, FRIEND_ID FROM USERISFRIEND");
    
   	 	Statement statement = null;
    	ResultSet rs = null;
	    ArrayList<UserIsFriend> collection = new ArrayList<UserIsFriend>();
	    
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
	          UserIsFriend userIsFriend = new UserIsFriend();
	          userIsFriend.setUserID(rs.getInt("USER_ID"));
	          userIsFriend.setFriendID(rs.getInt("FRIEND_ID"));
	          
	          // store it in the list
	          collection.add(userIsFriend);
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
	    return (UserIsFriend[])collection.toArray(new UserIsFriend[0]);  
	  }    
    
}