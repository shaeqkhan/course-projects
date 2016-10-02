package pkg.entity;

// JDBC libraries
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import pkg.connection.DBConnection;

public class UserHasHometown {

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
    	
    	sbInsert.append("INSERT INTO USERHASHOMETOWN");
    	sbInsert.append(" VALUES ");
    	sbInsert.append("(" + getUserID() + ", '" + getCity() + "', '" + getState() + "', '" + getCountry()+ "')");			
    	
    	Statement statement = connection.createStatement();
    	try {
      		// Insert the data
      		statement.executeUpdate (sbInsert.toString());
    	} catch (SQLException e) {
      		System.out.println("Error inserting user hometown: " + e);
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
    	
    	sbInsert.append("UPDATE USERHASHOMETOWN");
    	sbInsert.append(" SET CITY = '" + getCity() + "', ");
    	sbInsert.append("STATE = '" + getState() + "', "); 
    	sbInsert.append("COUNTRY = '" + getCountry() + "'");    	
    	sbInsert.append("WHERE USER_ID = " + getUserID());    							
    	
    	Statement statement = connection.createStatement();
    	try {
      		// Insert the data
      		statement.executeUpdate (sbInsert.toString());
    	} catch (SQLException e) {
      		System.out.println("Error updating USERHASHOMETOWN: " + e);
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
    	
    	sbDelete.append("DELETE FROM USERHASHOMETOWN ");
    	sbDelete.append("WHERE USER_ID = " + getUserID());
    	
    	Statement statement = connection.createStatement();
    	try {
      		// Insert the data
      		statement.executeUpdate (sbDelete.toString());
    	} catch (SQLException e) {
      		System.out.println("Error deleting USERHASHOMETOWN: " + e);
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
  	public UserHasHometown[] loadAll() throws SQLException {
    	// get the connection
    	Connection connection = DBConnection.getConnection();
        
    	// create the SELECT SQL
    	StringBuffer sbSelect = new StringBuffer();
    	sbSelect.append("SELECT USER_ID, CITY, STATE, COUNTRY FROM USERHASHOMETOWN");
    
   	 	Statement statement = null;
    	ResultSet rs = null;
	    ArrayList<UserHasHometown> collection = new ArrayList<UserHasHometown>();
	    
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
	          UserHasHometown userHometown = new UserHasHometown();
	          userHometown.setUserID(rs.getInt("USER_ID"));
	          userHometown.setCity(rs.getString("CITY"));
	          userHometown.setState(rs.getString("STATE"));
	          userHometown.setCountry(rs.getString("COUNTRY"));	          
	          
	          // store it in the list
	          collection.add(userHometown);
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
	    return (UserHasHometown[])collection.toArray(new UserHasHometown[0]);  
	  }    
    
}