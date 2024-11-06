package demo.nec.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
this class is consist of database utilities such as username,url,pass
this class is common for all modules for db connection
* */
public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/comapany_db";
    private static final String USER = "root";
    private static final String PASSWORD = "Poonam@2910";

    // Connection instance
    private static Connection connection = null;

    // Private constructor to prevent instantiation
    private DatabaseConnection() {}

    // Get database connection
    public static Connection getConnection() {
        if (connection == null) {
            try {
                // Load MySQL JDBC Driver
                Class.forName("com.mysql.cj.jdbc.Driver");
                // Establish connection
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("Database connected successfully!");
            } catch (ClassNotFoundException e) {
                System.err.println("MySQL JDBC Driver not found.");
                e.printStackTrace();
            } catch (SQLException e) {
                System.err.println("Connection failed!");
                e.printStackTrace();
            }
        }
        return connection;
    }

    // Close database connection
    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Database connection closed.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
