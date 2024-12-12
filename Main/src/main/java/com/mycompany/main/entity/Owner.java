package com.mycompany.main.entity;

import com.mycompany.main.enums.IdentityType;
import com.mycompany.main.persistence.ConnectionDB;
import java.sql.*;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Owner extends Person {

    private int id_owner;

    public Owner(int id_owner, String first_name, String last_name) {
        super(first_name, last_name);
        this.id_owner = id_owner;
    }

    public Owner(int id_owner, String first_name, String last_name, IdentityType identity_type, String identification_number, String rut, String phone, String email, String emergency_contact_name, String emergency_contact_phone) {
        super(first_name, last_name, identity_type, identification_number, rut, phone, email, emergency_contact_name, emergency_contact_phone);
        this.id_owner = id_owner;
    }


    public int getId_owner() {
        return id_owner;
    }

    public void setId_owner(int id_owner) {
        this.id_owner = id_owner;
    }

    public class OwnerCRUD {

        public static int registerNewOwner() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("---- Register New Owner ----");

            String firstName = inputWithValidation(scanner, "Enter First Name: ", "[A-Za-z ]+", "Invalid name. Only letters and spaces are allowed.");
            String lastName = inputWithValidation(scanner, "Enter Last Name: ", "[A-Za-z ]+", "Invalid name. Only letters and spaces are allowed.");
            String identityType = inputWithValidation(scanner, "Enter Identity Type (CC/CE/Passport): ", "CC|CE|Passport", "Invalid identity type. Use CC, CE, or Passport.");
            String identificationNumber = inputWithValidation(scanner, "Enter Identification Number: ", "\\d+", "Invalid ID. Only numbers are allowed.");
            String rut = inputOptional(scanner, "Enter RUT (Optional): ");
            String phone = inputWithValidation(scanner, "Enter Phone: ", "\\d{7,15}", "Invalid phone number.");
            String email = inputWithValidation(scanner, "Enter Email: ", "[\\w.%+-]+@[\\w.-]+\\.[A-Za-z]{2,6}", "Invalid email address.");
            String address = inputOptional(scanner, "Enter Address: ");
            String emergencyContactName = inputWithValidation(scanner, "Enter Emergency Contact Name: ", "[A-Za-z ]+", "Invalid name. Only letters and spaces are allowed.");
            String emergencyContactPhone = inputWithValidation(scanner, "Enter Emergency Contact Phone: ", "\\d{7,15}", "Invalid phone number.");

            try (Connection conn = ConnectionDB.getConnection()) {
                String query = "INSERT INTO Owner (first_name, last_name, identity_type, identification_number, rut, phone, email, address, emergency_contact_name, emergency_contact_phone) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                try (PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
                    stmt.setString(1, firstName);
                    stmt.setString(2, lastName);
                    stmt.setString(3, identityType);
                    stmt.setString(4, identificationNumber);
                    stmt.setString(5, rut);
                    stmt.setString(6, phone);
                    stmt.setString(7, email);
                    stmt.setString(8, address);
                    stmt.setString(9, emergencyContactName);
                    stmt.setString(10, emergencyContactPhone);

                    int rowsInserted = stmt.executeUpdate();
                    if (rowsInserted > 0) {
                        try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                            if (generatedKeys.next()) {
                                return generatedKeys.getInt(1); // Retorna el ID generado.
                            }
                        }
                    }
                }
            } catch (SQLException e) {
                System.out.println("Error registering owner: " + e.getMessage());
            }
            return -1; // Retorna -1 en caso de error.
        }

        public static void listOwners() {
            System.out.println("---- List of Owners ----");
            try (Connection conn = ConnectionDB.getConnection()) {
                String query = "SELECT id_owner, first_name, last_name, phone, email FROM Owner";
                try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
                    while (rs.next()) {
                        int idOwner = rs.getInt("id_owner");
                        String firstName = rs.getString("first_name");
                        String lastName = rs.getString("last_name");
                        String phone = rs.getString("phone");
                        String email = rs.getString("email");

                        System.out.printf("ID: %d, Name: %s %s, Phone: %s, Email: %s\n",
                                idOwner, firstName, lastName, phone, email);
                    }
                }
            } catch (SQLException e) {
                System.out.println("Error retrieving owners: " + e.getMessage());
            }
        }

       public static boolean searchOwnerByIdentification(String id) {
    try (Connection conn = ConnectionDB.getConnection()) {
        String query = "SELECT id_owner, first_name, last_name FROM Owner WHERE identification_number = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, id);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    int idOwner = rs.getInt("id_owner");
                    String firstName = rs.getString("first_name");
                    String lastName = rs.getString("last_name");

                    System.out.printf("ID: %d, Name: %s %s\n", idOwner, firstName, lastName);
                    return true;  // Owner found
                } else {
                    System.out.println("No owner found with the provided ID.");
                    return false;  // Owner not found
                }
            }
        }
    } catch (SQLException e) {
        System.out.println("Error retrieving owner: " + e.getMessage());
        return false;  // Error case, treat as not found
    }
}


        public static void editOwner() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("---- Edit Owner ----");
            System.out.print("Enter Owner ID to edit: ");
            int ownerId = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            System.out.print("Enter new First Name: ");
            String firstName = scanner.nextLine();
            System.out.print("Enter new Last Name: ");
            String lastName = scanner.nextLine();
            System.out.print("Enter new Phone: ");
            String phone = scanner.nextLine();
            System.out.print("Enter new Email: ");
            String email = scanner.nextLine();

            try (Connection conn = ConnectionDB.getConnection()) {
                String query = "UPDATE Owner SET first_name = ?, last_name = ?, phone = ?, email = ? WHERE id_owner = ?";
                try (PreparedStatement stmt = conn.prepareStatement(query)) {
                    stmt.setString(1, firstName);
                    stmt.setString(2, lastName);
                    stmt.setString(3, phone);
                    stmt.setString(4, email);
                    stmt.setInt(5, ownerId);

                    int rowsAffected = stmt.executeUpdate();
                    if (rowsAffected > 0) {
                        System.out.println("Owner updated successfully.");
                    } else {
                        System.out.println("Owner not found.");
                    }
                }
            } catch (SQLException e) {
                System.out.println("Error updating owner: " + e.getMessage());
            }
        }

        public static void deleteOwner() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("---- Delete Owner ----");
            scanner.nextLine(); // Consume newline
            System.out.print("Enter Owner ID to delete: ");
            int ownerId = scanner.nextInt();

            try (Connection conn = ConnectionDB.getConnection()) {
                String query = "DELETE FROM Owner WHERE id_owner = ?";
                try (PreparedStatement stmt = conn.prepareStatement(query)) {
                    stmt.setInt(1, ownerId);
                    int rowsAffected = stmt.executeUpdate();
                    if (rowsAffected > 0) {
                        System.out.println("Owner deleted successfully.");
                    } else {
                        System.out.println("Owner not found.");
                    }
                }
            } catch (SQLException e) {
                System.out.println("Error deleting owner: " + e.getMessage());
            }
        }

        private static String inputWithValidation(Scanner scanner, String prompt, String regex, String errorMessage) {
            String input;
            while (true) {
                System.out.print(prompt);
                input = scanner.nextLine().trim();
                if (Pattern.matches(regex, input)) {
                    break;
                }
                System.out.println(errorMessage);
            }
            return input;
        }

        private static String inputOptional(Scanner scanner, String prompt) {
            System.out.print(prompt);
            return scanner.nextLine().trim();
        }

        private static int inputInt(Scanner scanner, String prompt) {
            while (true) {
                try {
                    System.out.print(prompt);
                    return Integer.parseInt(scanner.nextLine().trim());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid number. Please try again.");
                }
            }
        }
    }
}
