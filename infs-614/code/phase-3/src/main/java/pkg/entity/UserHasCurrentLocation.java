package pkg.entity;

// JDBC libraries
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import pkg.connection.DBConnection;

public class UserHasCurrentLocation {

    //instance variables
    private int user_id;
    private String city;
    private String state;
    private String country;    
    
    //getter and setters
    public void setUserID(int user_id){ this.user_id = user_id; }
    
    public void setCity(String city){ this.city = city; }
    
    public void setState(String state) { this.state = state; }
    
    public void setCountry(String country) { this.country = country; }    
	
	public int getUserID() { return user_id; }
	
	public String getCity() { return city; }
	
	public String getState() { return state; }
	
	public String getCountry() { return country; }	
		
	public void insertData () throws SQLException {
    
    	// get the connection
    	Connection connection = DBConnection.getConnection();
		
		// create the INSERT SQL
    	StringBuffer sbInsert = new StringBuffer();
    	
    	sbInsert.append("INSERT INTO USERHASCURRENTLOCATION");
    	sbInsert.append(" VALUES ");
    	sbInsert.append("(" + getUserID() + ", '" + getCity() + "', '" + getState() + "', '" + getCountry()+ "')");			
    	
    	Statement statement = connection.createStatement();
    	try {
      		// Insert the data
      		statement.executeUpdate (sbInsert.toString());
    	} catch (SQLException e) {
      		System.out.println("Error inserting user current location: " + e);
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
    	
    	sbInsert.append("UPDATE USERHASCURRENTLOCATION");
    	sbInsert.append(" SET CITY = '" + getCity() + "', ");
    	sbInsert.append("STATE = '" + getState() + "', "); 
    	sbInsert.append("COUNTRY = '" + getCountry() + "'");    	
    	sbInsert.append("WHERE USER_ID = " + getUserID());    							
    	
    	Statement statement = connection.createStatement();
    	try {
      		// Insert the data
      		statement.executeUpdate (sbInsert.toString());
    	} catch (SQLException e) {
      		System.out.println("Error updating USERHASCURRENTLOCATION: " + e);
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
    	
    	sbDelete.append("DELETE FROM USERHASCURRENTLOCATION ");
    	sbDelete.append("WHERE USER_ID = " + getUserID());
    	
    	Statement statement = connection.createStatement();
    	try {
      		// Insert the data
      		statement.executeUpdate (sbDelete.toString());
    	} catch (SQLException e) {
      		System.out.println("Error deleting USERHASCURRENTLOCATION: " + e);
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
  	public UserHasCurrentLocation[] loadAll() throws SQLException {
    	// get the connection
    	Connection connection = DBConnection.getConnection();
        
    	// create the SELECT SQL
    	StringBuffer sbSelect = new StringBuffer();
    	sbSelect.append(" SELECT USER_ID, CITY, STATE, COUNTRY FROM USERHASCURRENTLOCATION");
    
   	 	Statement statement = null;
    	ResultSet rs = null;
	    ArrayList<UserHasCurrentLocation> collection = new ArrayList<UserHasCurrentLocation>();
	    
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
	          UserHasCurrentLocation currentLocation = new UserHasCurrentLocation();
	          currentLocation.setUserID(rs.getInt("USER_ID"));
	          currentLocation.setCity(rs.getString("CITY"));
	          currentLocation.setState(rs.getString("STATE"));
	          currentLocation.setCountry(rs.getString("COUNTRY"));	          
	          
	          // store it in the list
	          collection.add(currentLocation);
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
	    return (UserHasCurrentLocation[])collection.toArray(new UserHasCurrentLocation[0]);  
	  }    
    
}