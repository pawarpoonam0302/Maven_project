package nec.com.db;

import demo.nec.common.DatabaseConnection;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

/*
* database test class
* it cosist of test cases related to databse connection */
class DatabaseConnectionTest {

    private static Connection connection;

    @BeforeAll
    static void setUp() {
        // Initialize connection before tests
        connection = DatabaseConnection.getConnection();
    }

    @Test
    void testSingletonConnection() {
        // Ensure getConnection() returns the same instance
        Connection connection1 = DatabaseConnection.getConnection();
        Connection connection2 = DatabaseConnection.getConnection();
        assertSame(connection1, connection2, "getConnection should return the same instance");
    }

    @Test
    void testConnectionNotNull() {
        // Ensure the connection is not null
        assertNotNull(connection, "Connection should not be null");
    }

    @Test
    void testConnectionIsValid() throws SQLException {
        // Check if the connection is valid (timeout of 2 seconds)
        assertTrue(connection.isValid(2), "Connection should be valid");
    }

    @AfterAll
    static void tearDown() {
        // Close connection after all tests
        DatabaseConnection.closeConnection();
        try {
            assertTrue(connection.isClosed(), "Connection should be closed after calling closeConnection()");
        } catch (SQLException e) {
            fail("SQLException thrown while checking if connection is closed");
        }
    }
}

