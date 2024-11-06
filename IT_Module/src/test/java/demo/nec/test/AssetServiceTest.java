package demo.nec.test;


import com.demo.nec.AssetService;
import demo.nec.common.DatabaseConnection;
import java.sql.Connection;
import java.sql.SQLException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import java.sql.PreparedStatement;
import org.junit.jupiter.api.*;
import java.sql.ResultSet;


    public class AssetServiceTest {

        private static Connection connection;
        private AssetService assetService;

        @BeforeAll
        public static void setupDatabaseConnection() {
            connection = DatabaseConnection.getConnection();
        }

        @BeforeEach
        public void setUp() {
            assetService = new AssetService();
        }

        @AfterEach
        public void cleanUp() throws SQLException {
            try (PreparedStatement stmt = connection.prepareStatement("DELETE FROM asset")) {
                stmt.executeUpdate();
            }
            try (PreparedStatement stmt = connection.prepareStatement("DELETE FROM asset_it")) {
                stmt.executeUpdate();
            }
        }

        @AfterAll
        public static void tearDownDatabaseConnection() throws SQLException {
            if (connection != null) {
                connection.close();
            }
        }

        @Test
        public void testAssignAssetToEmp() {
            // Prepare input data for the method
            System.setIn(new java.io.ByteArrayInputStream("1\n100\nLaptop\n".getBytes()));

            // Call the method and assert that no exceptions are thrown
            Assertions.assertDoesNotThrow(() -> assetService.assignAssetToEmp());

            // Verify data in the database
            try (PreparedStatement stmt = connection.prepareStatement("SELECT * FROM asset WHERE Empid = 116 AND AssetId = 5643 AND AssetName = 'HP Core Laptop'")) {
                ResultSet rs = stmt.executeQuery();
                Assertions.assertTrue(rs.next(), "Asset should have been assigned to the employee");
            } catch (SQLException e) {
                e.printStackTrace();
                Assertions.fail("Database verification failed");
            }
        }

        @Test
        public void testCreateRequestForIssue() {
            // Prepare input data for the method
            System.setIn(new java.io.ByteArrayInputStream("1\n100\nLaptop\nElectronics\n200\nPending\nScreen issue\n".getBytes()));

            // Call the method and assert that no exceptions are thrown
            Assertions.assertDoesNotThrow(() -> assetService.createRequestForIssue());

            // Verify data in the database
            try (PreparedStatement stmt = connection.prepareStatement("SELECT * FROM asset WHERE Emp_id = 1189 AND Asset_id = 2352 AND Asset_Name = 'HP Mouse'")) {
                ResultSet rs = stmt.executeQuery();
                Assertions.assertTrue(rs.next(), "Request should have been created for the asset");
                Assertions.assertEquals("Mouse", rs.getString("Asset_Type"));
                Assertions.assertEquals("open", rs.getString("Status"));
                Assertions.assertEquals("sensor is not working ", rs.getString("Description"));
            } catch (SQLException e) {
                e.printStackTrace();
                Assertions.fail("Database verification failed");
            }
        }
    }
