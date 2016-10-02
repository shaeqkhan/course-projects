package pkg.entity;

// JDBC libraries
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import pkg.connection.DBConnection;

public class PhotoHasTag {

    //instance variables
    private int photo_id;
    private int tag_id;
    private int created_by_user_id;
    
    //getter and setters
    public void setPhotoID(int photo_id){ this.photo_id = photo_id; }
    
    public void setTagID(int tag_id){ this.tag_id = tag_id; }
    
    public void setCreatedByUserID(int created_by_user_id){ this.created_by_user_id = created_by_user_id; }
	
	public int getPhotoID() { return photo_id; }
	
	public int getTagID() { return tag_id; }
	
	public int getCreatedByUserID() { return created_by_user_id; }
	
	public void insertData () throws SQLException {
    
    	// get the connection
    	Connection connection = DBConnection.getConnection();
    	        	
    	// create the INSERT SQL
    	StringBuffer sbInsert = new StringBuffer();
    	
    	sbInsert.append("INSERT INTO PHOTOHASTAG");
    	sbInsert.append(" VALUES ");
    	sbInsert.append("(" + getPhotoID() + ", " +	getTagID() + ", " + getCreatedByUserID() + ")");
    							
    	
    	Statement statement = connection.createStatement();
    	try {
      		// Insert the data
      		statement.executeUpdate (sbInsert.toString());
    	} catch (SQLException e) {
      		System.out.println("Error inserting new tag for photo: " + e);
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
    	
    	sbDelete.append("DELETE FROM PHOTOHASTAG ");
    	sbDelete.append("WHERE PHOTO_ID = " + getPhotoID());
    	sbDelete.append("AND TAG_ID = " + getTagID());
    	
    	Statement statement = connection.createStatement();
    	try {
      		// Insert the data
      		statement.executeUpdate (sbDelete.toString());
    	} catch (SQLException e) {
      		System.out.println("Error deleting PhotoHasTag: " + e);
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
  	public PhotoHasTag[] loadAll() throws SQLException {
    	// get the connection
    	Connection connection = DBConnection.getConnection();
        
    	// create the SELECT SQL
    	StringBuffer sbSelect = new StringBuffer();
    	sbSelect.append(" SELECT PHOTO_ID, TAG_ID, CREATED_BY_USER_ID FROM PHOTOHASTAG");
    
   	 	Statement statement = null;
    	ResultSet rs = null;
	    ArrayList<PhotoHasTag> collection = new ArrayList<PhotoHasTag>();
	    
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
	          PhotoHasTag photoHasTag = new PhotoHasTag();
	          photoHasTag.setPhotoID(rs.getInt("PHOTO_ID"));
	          photoHasTag.setTagID(rs.getInt("TAG_ID"));
	          photoHasTag.setCreatedByUserID(rs.getInt("CREATED_BY_USER_ID"));
	          
	          // store it in the list
	          collection.add(photoHasTag);
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
	    return (PhotoHasTag[])collection.toArray(new PhotoHasTag[0]);  
	  }    
    
}