package pkg.entity;

// JDBC libraries
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import pkg.connection.DBConnection;

public class UserHasAlbum {

    //instance variables
    private int user_id;
    private int album_id;
    private String privacy_setting;
    
    //getter and setters
    public void setUserID(int user_id){ this.user_id = user_id; }
    
    public void setAlbumID(int album_id){ this.album_id = album_id; }
    
    public void setPrivacySetting(String privacy_setting) {this.privacy_setting = privacy_setting; }
	
	public int getUserID() { return user_id; }
	
	public int getAlbumID() { return album_id; }
	
	public String getPrivacySetting() { return privacy_setting; }
	
	public void insertData () throws SQLException {
    
    	// get the connection
    	Connection connection = DBConnection.getConnection();
    	 
    	// create the INSERT SQL
    	StringBuffer sbInsert = new StringBuffer();
    	
    	sbInsert.append("INSERT INTO USERHASALBUM");
    	sbInsert.append(" VALUES ");
    	sbInsert.append("(" + getUserID() + ", " + getAlbumID() + ", '" + getPrivacySetting() + "')");    							
    	
    	Statement statement = connection.createStatement();
    	try {
      		// Insert the data
      		statement.executeUpdate (sbInsert.toString());
    	} catch (SQLException e) {
      		System.out.println("Error inserting new user's album: " + e);
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
    	
    	sbInsert.append("UPDATE USERHASALBUM");
    	sbInsert.append(" SET PRIVACY_SETTING = '" + getPrivacySetting() + "' ");    	
    	sbInsert.append("WHERE USER_ID = " + getUserID());
    	sbInsert.append(" AND ALBUM_ID = " + getAlbumID());    							
    	
    	Statement statement = connection.createStatement();
    	try {
      		// Insert the data
      		statement.executeUpdate (sbInsert.toString());
    	} catch (SQLException e) {
      		System.out.println("Error updating USERHASALBUM: " + e);
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
    	sbDelete.append(" AND ALBUM_ID = " + getAlbumID());
    	
    	Statement statement = connection.createStatement();
    	try {
      		// Insert the data
      		statement.executeUpdate (sbDelete.toString());
    	} catch (SQLException e) {
      		System.out.println("Error deleting tuple from USERHASALBUM: " + e);
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
  	public UserHasAlbum[] loadAll() throws SQLException {
    	// get the connection
    	Connection connection = DBConnection.getConnection();
        
    	// create the SELECT SQL
    	StringBuffer sbSelect = new StringBuffer();
    	sbSelect.append(" SELECT USER_ID, ALBUM_ID, PRIVACY_SETTING FROM USERHASALBUM");
    
   	 	Statement statement = null;
    	ResultSet rs = null;
	    ArrayList<UserHasAlbum> collection = new ArrayList<UserHasAlbum>();
	    
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
	          UserHasAlbum userHasAlbum = new UserHasAlbum();
	          userHasAlbum.setUserID(rs.getInt("USER_ID"));
	          userHasAlbum.setAlbumID(rs.getInt("ALBUM_ID"));
	          userHasAlbum.setPrivacySetting(rs.getString("PRIVACY_SETTING"));
	          
	          // store it in the list
	          collection.add(userHasAlbum);
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
	    return (UserHasAlbum[])collection.toArray(new UserHasAlbum[0]);  
	  }    
    
}