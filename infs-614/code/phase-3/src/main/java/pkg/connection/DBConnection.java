package pkg.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	// DB connection properties
   	static private final String driver = "oracle.jdbc.driver.OracleDriver";
   	static private final String jdbcUrl = "jdbc:oracle:thin:@apollo.ite.gmu.edu:1521:ite10g";

   	// IMPORTANT: DO NOT PUT YOUR LOGIN INFORMATION HERE. INSTEAD, PROMPT USER FOR HIS/HER LOGIN/PASSWD 
   	static private String username = "";
   	static private String password = "";
   
   	static public void setLogin(String username, String password){
   		DBConnection.username = username;
   		DBConnection.password = password;	
   	}
   	
   	/* 
   	 * Method to get the connection for the database
   	 * @return java.sql.Connection object
   	 */
  	static public Connection getConnection() {
    	// register the JDBC driver
    	try {
      		Class.forName(driver);
    	} catch (ClassNotFoundException e) {
      		e.printStackTrace();
    	}
    
    	// create a connection
    	Connection connection = null;
    	try {
      		connection = DriverManager.getConnection (jdbcUrl, username, password);
      		//System.out.println("\nConnection established!\n");
    	} catch (SQLException e) {
      		System.err.println("Incorrect username or password: " + e);
    	}
    	return connection;
  	}  	
  	
  	/*
	 * @param connection
	 * @throws SQLException
	 */
	static public void close(Connection connection) throws SQLException {
	    try {
	      connection.close();
	      //System.out.println("\nConnection closed successfully!\n");
	    } catch (SQLException e) {
	      System.err.println("Error in closing connection: " + e);
	    }
	}
	
}
