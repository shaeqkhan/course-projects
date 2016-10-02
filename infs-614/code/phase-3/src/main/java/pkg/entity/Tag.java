package pkg.entity;

// JDBC libraries
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import pkg.connection.DBConnection;

public class Tag {

    //instance variables
    private int tag_id;
    private int tag_user_id;    
    private Date tag_time_stamp;
    private int tag_x_coordinate;
    private int tag_y_coordinate;
        
    
    //getter and setters
    public void setTagID(int tag_id){ this.tag_id = tag_id; }
    
    public void setTagUserID(int tag_user_id){ this.tag_user_id = tag_user_id; }

	public void setTagTimestamp(Date tag_time_stamp) { this.tag_time_stamp = tag_time_stamp; }	
	
	public void setTagXCoordinate(int tag_x_coordinate) { this.tag_x_coordinate = tag_x_coordinate; }
	
	public void setTagYCoordinate(int tag_y_coordinate) { this.tag_y_coordinate = tag_y_coordinate; }
	
	public int getTagID() { return tag_id; }
	
	public int getTagUserID() { return tag_user_id; }
		
	public Date getTagTimestamp() { return tag_time_stamp; }
	
	public int getTagXCoordinate() { return tag_x_coordinate; }	
	
	public int getTagYCoordinate() { return tag_y_coordinate; }
	
	public void insertData () throws SQLException {
    
    	// get the connection
    	Connection connection = DBConnection.getConnection();
    	        	
    	// create the INSERT SQL
    	StringBuffer sbInsert = new StringBuffer();
    	
    	sbInsert.append("INSERT INTO TAG");
    	sbInsert.append(" VALUES ");
    	sbInsert.append("(" + getTagID() + ", " + getTagUserID() + ", systimestamp, " +
    						  getTagXCoordinate() + ", " + 
    						  getTagYCoordinate() + ")");
    							
    	
    	Statement statement = connection.createStatement();
    	try {
      		// Insert the data
      		statement.executeUpdate (sbInsert.toString());
    	} catch (SQLException e) {
      		System.out.println("Error inserting new tag: " + e);
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
    	
    	sbInsert.append("UPDATE TAG ");
    	sbInsert.append("SET TAG_USER_ID = " + getTagUserID() + ", " );    				
		sbInsert.append("TAG_TIME_STAMP = systimestamp, " );
		sbInsert.append("TAG_X_COORDINATE = " + getTagXCoordinate() + ", " );
		sbInsert.append("TAG_Y_COORDINATE = " + getTagYCoordinate());
		sbInsert.append(" WHERE TAG_ID = " + getTagID());
		
		Statement statement = connection.createStatement();
    	try {
      		// Insert the data
      		statement.executeUpdate (sbInsert.toString());
    	} catch (SQLException e) {
      		System.out.println("Error updating TAG: " + e);
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
    	
    	sbDelete.append("DELETE FROM TAG ");
    	sbDelete.append("WHERE TAG_ID = " + getTagID());
    	
    	Statement statement = connection.createStatement();
    	try {
      		// Insert the data
      		statement.executeUpdate (sbDelete.toString());
    	} catch (SQLException e) {
      		System.out.println("Error deleting TAG: " + e);
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
  	public Tag[] loadAll() throws SQLException {
    	// get the connection
    	Connection connection = DBConnection.getConnection();
        
    	// create the SELECT SQL
    	StringBuffer sbSelect = new StringBuffer();
    	sbSelect.append(" SELECT TAG_ID, TAG_USER_ID, TAG_TIME_STAMP, TAG_X_COORDINATE, TAG_Y_COORDINATE FROM TAG");
    
   	 	Statement statement = null;
    	ResultSet rs = null;
	    ArrayList<Tag> collection = new ArrayList<Tag>();
	    
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
	          Tag tag = new Tag();
	          tag.setTagID(rs.getInt("TAG_ID"));
	          tag.setTagUserID(rs.getInt("TAG_USER_ID"));
	          tag.setTagTimestamp(rs.getTimestamp("TAG_TIME_STAMP"));
	          tag.setTagXCoordinate(rs.getInt("TAG_X_COORDINATE"));
	          tag.setTagYCoordinate(rs.getInt("TAG_Y_COORDINATE"));
	          
	          // store it in the list
	          collection.add(tag);
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
	    return (Tag[])collection.toArray(new Tag[0]);  
	  }    
    
}