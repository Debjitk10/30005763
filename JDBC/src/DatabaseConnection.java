import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/documentdb";
    private static final String USER = "root";
    private static final String PASSWORD = "Debjit@2002";

    public static Connection getConnection() throws SQLException {
        // Explicitly load the MySQL JDBC driver (optional with newer versions)
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("MySQL JDBC Driver not found", e);
        }

        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void main(String[] args) {
        try (Connection conn = getConnection()) {
            if (conn != null) {
                System.out.println("Connected to the database successfully!");
            } else {
                System.out.println("Failed to make connection!");
            }
        } catch (SQLException e) {
            // Print the stack trace for more detailed error information
            e.printStackTrace();
            System.out.println("SQL Exception: " + e.getMessage());
        }
    }
}
