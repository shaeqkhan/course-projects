package pkg.entity;

// JDBC libraries
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import pkg.connection.DBConnection;

public class Users {

    //instance variables
    private int user_id;
    private String username;
    private String password;
    private String first_name;
    private String last_name;
    private Date birthday;
    private String gender;
    private String about_me;
    
    //getter and setters
    public void setUserID(int user_id){ this.user_id = user_id; }
    
    public void setUsername(String username){ this.username = username; }
    
    public void setPassword(String password) { this.password = password; }
    
    public void setFirstName(String first_name) { this.first_name = first_name; }
    
    public void setLastName(String last_name) { this.last_name = last_name; }

	public void setBirthday(Date birthday) { this.birthday = birthday; }
	
	public void setGender(String gender){ this.gender = gender; }
	
	public void setAboutMe(String about_me) { this.about_me = about_me; }
	
	public int getUserID() { return user_id; }
	
	public String getUsername() { return username; }
	
	public String getPassword() { return password; }
	
	public String getFirstName() { return first_name; }
	
	public String getLastName() { return last_name; }
	
	public Date getBirthday() { return birthday; }
	
	public String getGender() { return gender; }
	
	public String getAboutMe() { return about_me; }
	
	public void insertData () throws SQLException {
    
    	// get the connection
    	Connection connection = DBConnection.getConnection();
    	    	
    	Date d = getBirthday();
    	String date = d.toString();
    
    	String finalDate = "";
    	
    	int pos1 = date.indexOf(" ");
    	System.out.println(pos1);
    	String mon = date.substring(pos1+1,7);
    	    	
    	String day = date.substring(8,10);
    	    	
    	String year = date.substring(date.lastIndexOf(" ")+3);
    	
    	finalDate = day + "-" + mon + "-" + year;
        	
    	// create the INSERT SQL
    	StringBuffer sbInsert = new StringBuffer();
    	
    	sbInsert.append("INSERT INTO USERS");
    	sbInsert.append(" VALUES ");
    	sbInsert.append("(" + getUserID() + ", '" + 
    							getUsername() + "', '" + 
    							getPassword() + "', '" + 
    							getFirstName() + "', '" + 
    							getLastName() + "', '" + 
    							finalDate + "', '" + 
    							getGender() + "', '" +
    							getAboutMe() + "')");
    							
    	
    	Statement statement = connection.createStatement();
    	try {
      		// Insert the data
      		statement.executeUpdate (sbInsert.toString());
    	} catch (SQLException e) {
      		System.out.println("Error inserting new user: " + e);
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
    	
    	sbInsert.append("UPDATE USERS");
    	sbInsert.append(" SET USERNAME = " + getUserID() + ", ");
    	sbInsert.append("PASSWORD = '" + getPassword() + "', "); 
    	sbInsert.append("FIRST_NAME = '" + getFirstName() + "', "); 
    	sbInsert.append("LAST_NAME = '" + getLastName() + "', ");
    	sbInsert.append("ABOUT_ME = '" + getAboutMe() + "' ");
    	sbInsert.append("WHERE USER_ID = " + getUserID());    							
    	
    	Statement statement = connection.createStatement();
    	try {
      		// Insert the data
      		statement.executeUpdate (sbInsert.toString());
    	} catch (SQLException e) {
      		System.out.println("Error updating user: " + e);
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
    	
    	Statement statement = connection.createStatement();
    	try {
      		// Insert the data
      		statement.executeUpdate (sbDelete.toString());
    	} catch (SQLException e) {
      		System.out.println("Error deleting user: " + e);
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
  	public Users[] loadAll() throws SQLException {
    	// get the connection
    	Connection connection = DBConnection.getConnection();
        
    	// create the SELECT SQL
    	StringBuffer sbSelect = new StringBuffer();
    	sbSelect.append(" SELECT USER_ID, USERNAME, PASSWORD, FIRST_NAME, LAST_NAME, BIRTHDAY, GENDER, ABOUT_ME FROM USERS");
    
   	 	Statement statement = null;
    	ResultSet rs = null;
	    ArrayList<Users> collection = new ArrayList<Users>();
	    
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
	          Users user = new Users();
	          user.setUserID(rs.getInt("USER_ID"));
	          user.setUsername(rs.getString("USERNAME"));
	          user.setPassword(rs.getString("PASSWORD"));
	          user.setFirstName(rs.getString("FIRST_NAME"));
	          user.setLastName(rs.getString("LAST_NAME"));
	          user.setBirthday(rs.getDate("BIRTHDAY"));
	          user.setGender(rs.getString("GENDER"));
	          user.setAboutMe(rs.getString("ABOUT_ME"));
	          
	          // store it in the list
	          collection.add(user);
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
	    return (Users[])collection.toArray(new Users[0]);  
	  }    
    
}