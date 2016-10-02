package pkg.entity;

// JDBC libraries
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import pkg.connection.DBConnection;

public class Status implements Comparable<Status> {

    //instance variables
    private int status_id;
    private String status_message;    
    private Date status_time_stamp;
    
    
    //getter and setters
    public void setStatusID(int status_id){ this.status_id = status_id; }
    
    public void setStatusMessage(String status_message){ this.status_message = status_message; }    

	public void setStatusTimestamp(Date status_time_stamp) { this.status_time_stamp = status_time_stamp; }	
	
	public int getStatusID() { return status_id; }
	
	public String getStatusMessage() { return status_message; }
		
	public Date getStatusTimestamp() { return status_time_stamp; }
	
	public int compareTo(Status s) {
    	Date d1 = getStatusTimestamp();
    	Date d2 = s.getStatusTimestamp();
    	if(d1.compareTo(d2) < 0)
    		return 1;
    	else 
    		return -1;
    	
  	}	
	
	public void insertData () throws SQLException {
    
    	// get the connection
    	Connection connection = DBConnection.getConnection();
    	        	
    	// create the INSERT SQL
    	StringBuffer sbInsert = new StringBuffer();
    	
    	sbInsert.append("INSERT INTO STATUS");
    	sbInsert.append(" VALUES ");
    	sbInsert.append("(" + getStatusID() + ", '" + 
    							getStatusMessage() + "', systimestamp)");
    							
    	
    	Statement statement = connection.createStatement();
    	try {
      		// Insert the data
      		statement.executeUpdate (sbInsert.toString());
    	} catch (SQLException e) {
      		System.out.println("Error inserting new status: " + e);
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
    	
    	sbInsert.append("UPDATE STATUS ");
    	sbInsert.append("SET STATUS_MESSAGE = '" + getStatusMessage() + "', " );		
		sbInsert.append("STATUS_TIME_STAMP = systimestamp " );
		sbInsert.append("WHERE STATUS_ID = " + getStatusID());
		
		Statement statement = connection.createStatement();
    	try {
      		// Insert the data
      		statement.executeUpdate (sbInsert.toString());
    	} catch (SQLException e) {
      		System.out.println("Error updating Status: " + e);
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
    	
    	sbDelete.append("DELETE FROM STATUS ");
    	sbDelete.append("WHERE STATUS_ID = " + getStatusID());
    	
    	Statement statement = connection.createStatement();
    	try {
      		// Insert the data
      		statement.executeUpdate (sbDelete.toString());
    	} catch (SQLException e) {
      		System.out.println("Error deleting status: " + e);
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
  	public Status[] loadAll() throws SQLException {
    	// get the connection
    	Connection connection = DBConnection.getConnection();
        
    	// create the SELECT SQL
    	StringBuffer sbSelect = new StringBuffer();
    	sbSelect.append(" SELECT STATUS_ID, STATUS_MESSAGE, STATUS_TIME_STAMP FROM STATUS");
    
   	 	Statement statement = null;
    	ResultSet rs = null;
	    ArrayList<Status> collection = new ArrayList<Status>();
	    
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
	          Status status = new Status();
	          status.setStatusID(rs.getInt("STATUS_ID"));
	          status.setStatusMessage(rs.getString("STATUS_MESSAGE"));
	          status.setStatusTimestamp(rs.getTimestamp("STATUS_TIME_STAMP"));
	          
	          // store it in the list
	          collection.add(status);
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
	    return (Status[])collection.toArray(new Status[0]);  
	  }    
    
}