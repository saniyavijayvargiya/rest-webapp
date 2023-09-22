package rest;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DBConnect {

	static Connection con;   
	
	public static Connection getCon() {
		try {
			Properties prop = new Properties();
			InputStream input = new FileInputStream("C:\\Users\\Saniya\\eclipse-workspace\\rest\\resources\\system.properties");
			prop.load(input);
			
			String driver = prop.getProperty("driver");
			String url = prop.getProperty("url");
			String username = prop.getProperty("username");
			String pass = prop.getProperty("password");
			
			Class.forName(driver);
			con = DriverManager.getConnection(url, username, pass);
		} 
		catch (Exception exc) {
			System.out.println(exc);
		}
		return con;
	}	
}
