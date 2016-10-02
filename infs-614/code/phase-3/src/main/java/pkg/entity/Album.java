package pkg.entity;

// JDBC libraries
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import pkg.connection.DBConnection;

public class Album {
        
    //instance variables
    private int album_id;
    private String album_title;
    private String album_description;    
    private Date album_time_stamp;
    private int cover_photo_id;
    
    
    //getter and setters
    public void setAlbumID(int album_id){ this.album_id = album_id; }
    
    public void setAlbumTitle(String album_title){ this.album_title = album_title; }
    
    public void setAlbumDescription(String album_description){ this.album_description = album_description; }    

	public void setAlbumTimestamp(Date album_time_stamp) { this.album_time_stamp = album_time_stamp; }
	
	public void setCoverPhotoID(int cover_photo_id)	{ this.cover_photo_id = cover_photo_id; }
	
	public int getAlbumID() { return album_id; }
	
	public String getAlbumTitle() { return album_title; }
	
	public String getAlbumDescription() { return album_description; }
		
	public Date getAlbumTimestamp() { return album_time_stamp; }
	
	public int getCoverPhotoID() { return cover_photo_id; }	
	
	public void insertData () throws SQLException {
    
    	// get the connection
    	Connection connection = DBConnection.getConnection();
    	        	
    	// create the INSERT SQL
    	StringBuffer sbInsert = new StringBuffer();
    	
    	sbInsert.append("INSERT INTO ALBUM");
    	sbInsert.append(" VALUES ");
    	sbInsert.append("(" + getAlbumID() + ", '" + 
    							getAlbumTitle() + "', '" +
    							getAlbumDescription() + "', systimestamp, " +
    							getCoverPhotoID() + ")");
    							
    	
    	Statement statement = connection.createStatement();
    	try {
      		// Insert the data
      		statement.executeUpdate (sbInsert.toString());
    	} catch (SQLException e) {
      		System.out.println("Error inserting new album: " + e);
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
    	
    	sbInsert.append("UPDATE ALBUM ");
    	sbInsert.append("SET ALBUM_TITLE = '" + getAlbumTitle() + "', " );
		sbInsert.append("ALBUM_DESCRIPTION = '" + getAlbumDescription() + "', " );
		sbInsert.append("ALBUM_TIME_STAMP = systimestamp, " );
		sbInsert.append("COVER_PHOTO_ID = " + getCoverPhotoID());
		sbInsert.append("WHERE ALBUM_ID = " + getAlbumID());
		
		Statement statement = connection.createStatement();
    	try {
      		// Insert the data
      		statement.executeUpdate (sbInsert.toString());
    	} catch (SQLException e) {
      		System.out.println("Error updating album: " + e);
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
    	
    	sbDelete.append("DELETE FROM ALBUM ");
    	sbDelete.append("WHERE ALBUM_ID = " + getAlbumID());
    	
    	Statement statement = connection.createStatement();
    	try {
      		// Insert the data
      		statement.executeUpdate (sbDelete.toString());
    	} catch (SQLException e) {
      		System.out.println("Error deleting Album: " + e);
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
  	public Album[] loadAll() throws SQLException {
    	// get the connection
    	Connection connection = DBConnection.getConnection();
        
    	// create the SELECT SQL
    	StringBuffer sbSelect = new StringBuffer();
    	sbSelect.append(" SELECT ALBUM_ID, ALBUM_TITLE, ALBUM_DESCRIPTION, ALBUM_TIME_STAMP, COVER_PHOTO_ID FROM ALBUM");
    
   	 	Statement statement = null;
    	ResultSet rs = null;
	    ArrayList<Album> collection = new ArrayList<Album>();
	    
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
	          Album album = new Album();
	          album.setAlbumID(rs.getInt("ALBUM_ID"));
	          album.setAlbumTitle(rs.getString("ALBUM_TITLE"));
	          album.setAlbumDescription(rs.getString("ALBUM_DESCRIPTION"));
	          album.setAlbumTimestamp(rs.getTimestamp("ALBUM_TIME_STAMP"));
	          album.setCoverPhotoID(rs.getInt("COVER_PHOTO_ID"));
	          
	          // store it in the list
	          collection.add(album);
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
	    return (Album[])collection.toArray(new Album[0]);  
	  }    
    
}