package fryShack.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Migrate_v3 {
	// JBDC driver name and database url
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver", DB_URL = "jdbc:mysql://localhost/FRYSHACK?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
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
			System.out.println("Creating tables...");
			// Create and execute the SQL query
			statement = connection.createStatement();
			String sql = 	"CREATE TABLE FRIES"
					+ "(id INTEGER not NULL, "
					+ "name VARCHAR(255), "
					+ "price DOUBLE(8,2), "
					+ "PRIMARY KEY ( id ))";
			String sql2 = 	"CREATE TABLE SAUCES"
					+ "(id INTEGER not NULL, "
					+ "name VARCHAR(255), "
					+ "price DOUBLE(8,2), "
					+ "size VARCHAR(255), "
					+ "PRIMARY KEY ( id ))";
			String sql3 = 	"CREATE TABLE TOPPINGS"
					+ "(id INTEGER not NULL, "
					+ "name VARCHAR(255), "
					+ "price DOUBLE(8,2), "
					+ "PRIMARY KEY ( id ))";
			statement.executeUpdate(sql);
			statement.executeUpdate(sql2);
			statement.executeUpdate(sql3);
			
			System.out.println("Tables created sucessfully...");
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
