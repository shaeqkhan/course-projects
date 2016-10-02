package pkg.entity;

// JDBC libraries
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import pkg.connection.DBConnection;

public class Photo {
    
    //instance variables
    private int photo_id;
    private String photo_caption;    
    private Date photo_time_stamp;
    
    
    //getter and setters
    public void setPhotoID(int photo_id){ this.photo_id = photo_id; }
    
    public void setPhotoCaption(String photo_caption){ this.photo_caption = photo_caption; }    

	public void setPhotoTimestamp(Date photo_time_stamp) { this.photo_time_stamp = photo_time_stamp; }	
	
	public int getPhotoID() { return photo_id; }
	
	public String getPhotoCaption() { return photo_caption; }
		
	public Date getPhotoTimestamp() { return photo_time_stamp; }	
	
	public void insertData () throws SQLException {
    
    	// get the connection
    	Connection connection = DBConnection.getConnection();
    	        	
    	// create the INSERT SQL
    	StringBuffer sbInsert = new StringBuffer();
    	
    	sbInsert.append("INSERT INTO PHOTO");
    	sbInsert.append(" VALUES ");
    	sbInsert.append("(" + getPhotoID() + ", '" + 
    							getPhotoCaption() + "', systimestamp)");
    							
    	
    	Statement statement = connection.createStatement();
    	try {
      		// Insert the data
      		statement.executeUpdate (sbInsert.toString());
    	} catch (SQLException e) {
      		System.out.println("Error inserting new photo: " + e);
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
    	
    	sbInsert.append("UPDATE PHOTO ");
    	sbInsert.append("SET PHOTO_CAPTION = '" + getPhotoCaption() + "', " );		
		sbInsert.append("PHOTO_TIME_STAMP = systimestamp " );
		sbInsert.append("WHERE PHOTO_ID = " + getPhotoID());
		
		Statement statement = connection.createStatement();
    	try {
      		// Insert the data
      		statement.executeUpdate (sbInsert.toString());
    	} catch (SQLException e) {
      		System.out.println("Error updating PHOTO: " + e);
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
    	
    	sbDelete.append("DELETE FROM PHOTO ");
    	sbDelete.append("WHERE PHOTO_ID = " + getPhotoID());
    	
    	Statement statement = connection.createStatement();
    	try {
      		// Insert the data
      		statement.executeUpdate (sbDelete.toString());
    	} catch (SQLException e) {
      		System.out.println("Error deleting photo: " + e);
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
  	public Photo[] loadAll() throws SQLException {
    	// get the connection
    	Connection connection = DBConnection.getConnection();
        
    	// create the SELECT SQL
    	StringBuffer sbSelect = new StringBuffer();
    	sbSelect.append(" SELECT PHOTO_ID, PHOTO_CAPTION, PHOTO_TIME_STAMP FROM PHOTO");
    
   	 	Statement statement = null;
    	ResultSet rs = null;
	    ArrayList<Photo> collection = new ArrayList<Photo>();
	    
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
	          Photo photo = new Photo();
	          photo.setPhotoID(rs.getInt("PHOTO_ID"));
	          photo.setPhotoCaption(rs.getString("PHOTO_CAPTION"));
	          photo.setPhotoTimestamp(rs.getTimestamp("PHOTO_TIME_STAMP"));
	          
	          // store it in the list
	          collection.add(photo);
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
	    return (Photo[])collection.toArray(new Photo[0]);  
	  }    
    
}