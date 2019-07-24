package fryShack.database;

import java.sql.*;

public class Migrate {
	// JBDC driver name and database url
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver", DB_URL = "jdbc:mysql://localhost?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	// Database credentials
	static final String USERNAME = "root", PASSWORD = "7H!5!SmYw8W0rD";

	public static void run() {
		Connection connection = null;
		Statement statement = null;
		
		try {
			// Register the JDBC Driver
			Class.forName(JDBC_DRIVER);
			System.out.println("Connecting to database...");
			
			// Open the database connection
			connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
			System.out.println("Creating database...");
			// Create and execute the SQL query
			statement = connection.createStatement();
			String sql = "CREATE DATABASE FRYSHACK";
			statement.executeUpdate(sql);
			
			System.out.println("Database created sucessfully...");
		} catch (SQLException e) {
			System.out.println("SQLException");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Exception");
			e.printStackTrace();
		}finally {
			try {
				if (statement != null) {
					// Close the statement
					statement.close();
				}
			} catch (SQLException e) {
				// TODO: handle exception
			}
			
			try {
				if (connection != null) {
					// Close the connection
					connection.close();
				}
			} catch (SQLException e2) {
				// TODO: handle exception
			}
		}
	}
}
