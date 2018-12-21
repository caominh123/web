package Public.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.fabric.Response;

public class MySQLConnUtils {
	 public static Connection getMySQLConnection()
	         throws ClassNotFoundException, SQLException {

	     String hostName = "localhost";
	     String dbName = "thitracnhiem";
	     String userName = "root";
	     String password = "14111998";
	     return getMySQLConnection(hostName, dbName, userName, password);
	 }
	  
	 public static Connection getMySQLConnection(String hostName, String dbName,
	         String userName, String password) throws SQLException,
	         ClassNotFoundException {
	    
	     Class.forName("com.mysql.jdbc.Driver");
	   
	     Connection con=DriverManager.getConnection(  
	    		 "jdbc:mysql://localhost:3307/thitracnhiem?useUnicode=true&characterEncoding=UTF-8","root","14111998");  
	    		   
		//String connectionURL = "jdbc:mysql://" + hostName + ":3307/" + dbName;
	     //Connection conn = DriverManager.getConnection(connectionURL, userName,password);
	     
	     return con; 
	 }
	 public static void main(String[] args) throws SQLException,
	    ClassNotFoundException {

	    	System.out.println("Get connection ... ");

	    	Connection conn = getMySQLConnection();

	    	System.out.println("Get connection " + conn);

	    	System.out.println("Done!");
	    }
}
