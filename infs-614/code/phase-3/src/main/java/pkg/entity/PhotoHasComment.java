package pkg.entity;

// JDBC libraries
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import pkg.connection.DBConnection;

public class PhotoHasComment {

    //instance variables
    private int photo_id;
    private int comment_id;
    private int photo_comment_user_id;
    
    //getter and setters
    public void setPhotoID(int photo_id){ this.photo_id = photo_id; }
    
    public void setCommentID(int comment_id){ this.comment_id = comment_id; }
    
    public void setPhotoCommentUserID(int photo_comment_user_id){ this.photo_comment_user_id = photo_comment_user_id; }
	
	public int getPhotoID() { return photo_id; }
	
	public int getCommentID() { return comment_id; }
	
	public int getPhotoCommentUserID() { return photo_comment_user_id; }
	
	public void insertData () throws SQLException {
    
    	// get the connection
    	Connection connection = DBConnection.getConnection();
    	        	
    	// create the INSERT SQL
    	StringBuffer sbInsert = new StringBuffer();
    	
    	sbInsert.append("INSERT INTO PHOTOHASCOMMENT");
    	sbInsert.append(" VALUES ");
    	sbInsert.append("(" + getPhotoID() + ", " +	getCommentID() + ", " + getPhotoCommentUserID() + ")");
    							
    	
    	Statement statement = connection.createStatement();
    	try {
      		// Insert the data
      		statement.executeUpdate (sbInsert.toString());
    	} catch (SQLException e) {
      		System.out.println("Error inserting new commment for photo: " + e);
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
    	
    	sbDelete.append("DELETE FROM PHOTOHASCOMMENT ");
    	sbDelete.append("WHERE PHOTO_ID = " + getPhotoID());
    	sbDelete.append("AND COMMENT_ID = " + getCommentID());
    	
    	Statement statement = connection.createStatement();
    	try {
      		// Insert the data
      		statement.executeUpdate (sbDelete.toString());
    	} catch (SQLException e) {
      		System.out.println("Error deleting PhotoHasComment: " + e);
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
  	public PhotoHasComment[] loadAll() throws SQLException {
    	// get the connection
    	Connection connection = DBConnection.getConnection();
        
    	// create the SELECT SQL
    	StringBuffer sbSelect = new StringBuffer();
    	sbSelect.append(" SELECT PHOTO_ID, COMMENT_ID, PHOTO_COMMENT_USER_ID FROM PHOTOHASCOMMENT");
    
   	 	Statement statement = null;
    	ResultSet rs = null;
	    ArrayList<PhotoHasComment> collection = new ArrayList<PhotoHasComment>();
	    
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
	          PhotoHasComment u = new PhotoHasComment();
	          u.setPhotoID(rs.getInt("PHOTO_ID"));
	          u.setCommentID(rs.getInt("COMMENT_ID"));
	          u.setPhotoCommentUserID(rs.getInt("PHOTO_COMMENT_USER_ID"));
	          
	          // store it in the list
	          collection.add(u);
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
	    return (PhotoHasComment[])collection.toArray(new PhotoHasComment[0]);  
	  }    
    
}