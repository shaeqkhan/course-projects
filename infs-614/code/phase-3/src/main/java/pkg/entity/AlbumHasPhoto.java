package pkg.entity;

// JDBC libraries
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import pkg.connection.DBConnection;

public class AlbumHasPhoto {

    //instance variables
    private int album_id;
    private int photo_id;
    
    //getter and setters
    public void setAlbumID(int album_id){ this.album_id = album_id; }
    
    public void setPhotoID(int photo_id){ this.photo_id = photo_id; }
	
	public int getAlbumID() { return album_id; }
	
	public int getPhotoID() { return photo_id; }
	
	public void insertData () throws SQLException {
    
    	// get the connection
    	Connection connection = DBConnection.getConnection();
		
		// create the INSERT SQL
    	StringBuffer sbInsert = new StringBuffer();
    	
    	sbInsert.append("INSERT INTO ALBUMHASPHOTO");
    	sbInsert.append(" VALUES ");
    	sbInsert.append("(" + getAlbumID() + ", " + getPhotoID() + ")");			
    	
    	Statement statement = connection.createStatement();
    	try {
      		// Insert the data
      		statement.executeUpdate (sbInsert.toString());
    	} catch (SQLException e) {
      		System.out.println("Error inserting new photo in album: " + e);
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
    	
    	sbDelete.append("DELETE FROM ALBUMHASPHOTO ");
    	sbDelete.append("WHERE ALBUM_ID = " + getAlbumID());
    	sbDelete.append("AND PHOTO_ID = " + getPhotoID());
    	
    	Statement statement = connection.createStatement();
    	try {
      		// Insert the data
      		statement.executeUpdate (sbDelete.toString());
    	} catch (SQLException e) {
      		System.out.println("Error deleting AlbumHasPhoto: " + e);
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
  	public AlbumHasPhoto[] loadAll() throws SQLException {
    	// get the connection
    	Connection connection = DBConnection.getConnection();
        
    	// create the SELECT SQL
    	StringBuffer sbSelect = new StringBuffer();
    	sbSelect.append(" SELECT ALBUM_ID, PHOTO_ID FROM ALBUMHASPHOTO");
    
   	 	Statement statement = null;
    	ResultSet rs = null;
	    ArrayList<AlbumHasPhoto> collection = new ArrayList<AlbumHasPhoto>();
	    
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
	          AlbumHasPhoto albumHasPhoto = new AlbumHasPhoto();
	          albumHasPhoto.setAlbumID(rs.getInt("ALBUM_ID"));
	          albumHasPhoto.setPhotoID(rs.getInt("PHOTO_ID"));
	          
	          // store it in the list
	          collection.add(albumHasPhoto);
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
	    return (AlbumHasPhoto[])collection.toArray(new AlbumHasPhoto[0]);  
	  }    
    
}