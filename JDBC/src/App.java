import java.sql.*;
import java.util.Scanner;

public class App {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nDocument Management System");
            System.out.println("1. Manage Documents");
            System.out.println("2. Manage Clients");
            System.out.println("3. Manage Cases");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> manageDocuments();
                case 2 -> manageClients();
                case 3 -> manageCases();
                case 4 -> System.exit(0);
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Document Management
    private static void manageDocuments() {
        System.out.println("\nDocument Management");
        System.out.println("1. Upload New Document");
        System.out.println("2. View Document Details");
        System.out.println("3. Update Document Information");
        System.out.println("4. Delete Document");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1 -> uploadDocument();
            case 2 -> viewDocumentDetails();
            case 3 -> updateDocumentInformation();
            case 4 -> deleteDocument();
            default -> System.out.println("Invalid choice. Please try again.");
        }
    }

    private static void uploadDocument() {
        System.out.print("Enter document title: ");
        String title = scanner.nextLine();
        System.out.print("Enter document description: ");
        String description = scanner.nextLine();
        System.out.print("Enter document file path: ");
        String filePath = scanner.nextLine();

        String sql = "INSERT INTO document (title, description, file_path) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, title);
            pstmt.setString(2, description);
            pstmt.setString(3, filePath);

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Document uploaded successfully.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void viewDocumentDetails() {
        System.out.print("Enter document ID: ");
        int documentId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        String sql = "SELECT * FROM document WHERE document_id = ?";

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, documentId);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                System.out.println("Document ID: " + rs.getInt("document_id"));
                System.out.println("Title: " + rs.getString("title"));
                System.out.println("Description: " + rs.getString("description"));
                System.out.println("File Path: " + rs.getString("file_path"));
            } else {
                System.out.println("Document not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void updateDocumentInformation() {
        System.out.print("Enter document ID to update: ");
        int documentId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter new title: ");
        String title = scanner.nextLine();
        System.out.print("Enter new description: ");
        String description = scanner.nextLine();
        System.out.print("Enter new file path: ");
        String filePath = scanner.nextLine();

        String sql = "UPDATE document SET title = ?, description = ?, file_path = ? WHERE document_id = ?";

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, title);
            pstmt.setString(2, description);
            pstmt.setString(3, filePath);
            pstmt.setInt(4, documentId);

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Document updated successfully.");
            } else {
                System.out.println("Document not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void deleteDocument() {
        System.out.print("Enter document ID to delete: ");
        int documentId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        String sql = "DELETE FROM document WHERE document_id = ?";

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, documentId);

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Document deleted successfully.");
            } else {
                System.out.println("Document not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Client Management
    private static void manageClients() {
        System.out.println("\nClient Management");
        System.out.println("1. Add New Client");
        System.out.println("2. View Client Details");
        System.out.println("3. Update Client Information");
        System.out.println("4. Delete Client");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1 -> addNewClient();
            case 2 -> viewClientDetails();
            case 3 -> updateClientInformation();
            case 4 -> deleteClient();
            default -> System.out.println("Invalid choice. Please try again.");
        }
    }

    private static void addNewClient() {
        System.out.print("Enter client name: ");
        String name = scanner.nextLine();
        System.out.print("Enter client email: ");
        String email = scanner.nextLine();
        System.out.print("Enter client phone number: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Enter client address: ");
        String address = scanner.nextLine();

        String sql = "INSERT INTO client (name, email, phone_number, address) VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.setString(3, phoneNumber);
            pstmt.setString(4, address);

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Client added successfully.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void viewClientDetails() {
        System.out.print("Enter client ID: ");
        int clientId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        String sql = "SELECT * FROM client WHERE client_id = ?";

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, clientId);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                System.out.println("Client ID: " + rs.getInt("client_id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Email: " + rs.getString("email"));
                System.out.println("Phone Number: " + rs.getString("phone_number"));
                System.out.println("Address: " + rs.getString("address"));
            } else {
                System.out.println("Client not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void updateClientInformation() {
        System.out.print("Enter client ID to update: ");
        int clientId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter new name: ");
        String name = scanner.nextLine();
        System.out.print("Enter new email: ");
        String email = scanner.nextLine();
        System.out.print("Enter new phone number: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Enter new address: ");
        String address = scanner.nextLine();

        String sql = "UPDATE client SET name = ?, email = ?, phone_number = ?, address = ? WHERE client_id = ?";

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.setString(3, phoneNumber);
            pstmt.setString(4, address);
            pstmt.setInt(5, clientId);

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Client updated successfully.");
            } else {
                System.out.println("Client not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void deleteClient() {
        System.out.print("Enter client ID to delete: ");
        int clientId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        String sql = "DELETE FROM client WHERE client_id = ?";

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, clientId);

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Client deleted successfully.");
            } else {
                System.out.println("Client not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Case Management
    private static void manageCases() {
        System.out.println("\nCase Management");
        System.out.println("1. Create New Case");
        System.out.println("2. View Case Details");
        System.out.println("3. Update Case Information");
        System.out.println("4. Close Case");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1 -> createNewCase();
            case 2 -> viewCaseDetails();
            case 3 -> updateCaseInformation();
            case 4 -> closeCase();
            default -> System.out.println("Invalid choice. Please try again.");
        }
    }

    private static void createNewCase() {
        System.out.print("Enter case title: ");
        String title = scanner.nextLine();
        System.out.print("Enter case description: ");
        String description = scanner.nextLine();
        System.out.print("Enter client ID: ");
        int clientId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter open date (yyyy-MM-dd): ");
        String openDateStr = scanner.nextLine();
        Date openDate = Date.valueOf(openDateStr);

        String sql = "INSERT INTO casetable (title, description, client_id, status, open_date, close_date) VALUES (?, ?, ?, 'Open', ?, NULL)";

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, title);
            pstmt.setString(2, description);
            pstmt.setInt(3, clientId);
            pstmt.setDate(4, openDate);

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Case created successfully.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void viewCaseDetails() {
        System.out.print("Enter case ID: ");
        int caseId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        String sql = "SELECT * FROM casetable WHERE case_id = ?";

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, caseId);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                System.out.println("Case ID: " + rs.getInt("case_id"));
                System.out.println("Title: " + rs.getString("title"));
                System.out.println("Description: " + rs.getString("description"));
                System.out.println("Client ID: " + rs.getInt("client_id"));
                System.out.println("Status: " + rs.getString("status"));
                System.out.println("Open Date: " + rs.getDate("open_date"));
                System.out.println("Close Date: " + rs.getDate("close_date"));
            } else {
                System.out.println("Case not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void updateCaseInformation() {
        System.out.print("Enter case ID to update: ");
        int caseId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter new title: ");
        String title = scanner.nextLine();
        System.out.print("Enter new description: ");
        String description = scanner.nextLine();

        String sql = "UPDATE casetable SET title = ?, description = ? WHERE case_id = ?";

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, title);
            pstmt.setString(2, description);
            pstmt.setInt(3, caseId);

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Case updated successfully.");
            } else {
                System.out.println("Case not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void closeCase() {
        System.out.print("Enter case ID to close: ");
        int caseId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter close date (yyyy-MM-dd): ");
        String closeDateStr = scanner.nextLine();
        Date closeDate = Date.valueOf(closeDateStr);

        String sql = "UPDATE casetable SET status = 'Closed', close_date = ? WHERE case_id = ?";

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDate(1, closeDate);
            pstmt.setInt(2, caseId);

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Case closed successfully.");
            } else {
                System.out.println("Case not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
