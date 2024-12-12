
package com.mycompany.main.entity;

import java.sql.*;
import java.util.*;
import com.mycompany.main.persistence.ConnectionDB;

public class Supplier {

    private int id_supplier;
    private String company_name;
    private String contact;
    private String email;

    public Supplier(int id_supplier, String company_name, String contact, String email) {
        this.id_supplier = id_supplier;
        this.company_name = company_name;
        this.contact = contact;
        this.email = email;
    }

    public Supplier(String company_name, String contact, String email) {
        this.company_name = company_name;
        this.contact = contact;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Suppliers{" + "id_supplier=" + id_supplier + ", company_name=" + company_name + ", contact=" + contact + ", email=" + email + '}';
    }

    public int getId_supplier() {
        return id_supplier;
    }

    public void setId_supplier(int id_supplier) {
        this.id_supplier = id_supplier;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Register a new Supplier
    public class SupplierCrud {

        private static final Scanner scanner = new Scanner(System.in);


        // Reusable input validation method
        private static String inputWithValidation(String prompt, String regex, String errorMessage) {
            while (true) {
                System.out.println(prompt);
                String input = scanner.nextLine().trim();
                if (input.matches(regex)) {
                    return input;
                } else {
                    System.out.println(errorMessage);
                }
            }
        }

        // Reusable method for integer input
        private static int inputInt(Scanner scanner, String prompt) {
            while (true) {
                try {
                    System.out.println(prompt);
                    return Integer.parseInt(scanner.nextLine().trim());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a valid number.");
                }
            }
        }

        // Register a new supplier
        public static void registerSupplier() {
            try (Connection conn = ConnectionDB.getConnection()) {
                String company_name = inputWithValidation("Enter Company Name:", "[A-Za-z ]+","Invalid name. Use letters and spaces only.");
                String contact = inputWithValidation("Enter Contact:", "[0-9\\-]+","Invalid contact. Use numbers and dashes only.");
                String email = inputWithValidation("Enter Supplier Email:","^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$","Invalid email. Use a valid email format.");

                String sql = "INSERT INTO suppliers (company_name, contact, email) VALUES (?, ?, ?)";
                try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                    stmt.setString(1, company_name);
                    stmt.setString(2, contact);
                    stmt.setString(3, email);
                    stmt.executeUpdate();
                    System.out.println("Supplier registered successfully!");
                }
            } catch (SQLException e) {
                System.out.println("Error registering supplier: " + e.getMessage());
            }
        }

        // List all suppliers
        public static void listSuppliers() {
            try (Connection conn = ConnectionDB.getConnection()) {
                String sql = "SELECT * FROM suppliers ORDER BY id_supplier";
                try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
                    System.out.println("---- List of Suppliers ----");
                    while (rs.next()) {
                        System.out.printf("ID: %d, Company Name: %s, Contact: %s, Email: %s%n",
                                rs.getInt("id_supplier"), rs.getString("company_name"),
                                rs.getString("contact"), rs.getString("email"));
                    }
                }
            } catch (SQLException e) {
                System.out.println("Error listing suppliers: " + e.getMessage());
            }
        }

        // Edit a supplier
        public static void editSupplier() {
            try (Connection conn = ConnectionDB.getConnection()) {
                listSuppliers(); // Show list of suppliers for selection
                int id_supplier = inputInt(scanner, "Enter Supplier ID to edit:");
                String company_name = inputWithValidation("Enter new Supplier Name:", "[A-Za-z ]+","Invalid name. Use letters and spaces only.");
                String contact = inputWithValidation("Enter new Supplier Contact:", "[0-9\\-]+","Invalid contact. Use numbers and dashes only.");
                String email = inputWithValidation("Enter new Supplier Email:","^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$","Invalid email. Use a valid email format.");

                String sql = "UPDATE suppliers SET company_name = ?, contact = ?, email = ? WHERE id_supplier = ?";
                try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                    stmt.setString(1, company_name);
                    stmt.setString(2, contact);
                    stmt.setString(3, email);
                    stmt.setInt(4, id_supplier);
                    int rowsAffected = stmt.executeUpdate();
                    if (rowsAffected > 0) {
                        System.out.println("Supplier updated successfully!");
                    } else {
                        System.out.println("Supplier ID not found.");
                    }
                }
            } catch (SQLException e) {
                System.out.println("Error editing supplier: " + e.getMessage());
            }
        }

        // Delete a supplier
        public static void deleteSupplier() {
            try (Connection conn = ConnectionDB.getConnection()) {
                listSuppliers(); // Show list of suppliers for selection
                int id_supplier = inputInt(scanner, "Enter Supplier ID to delete:");

                String sql = "DELETE FROM suppliers WHERE id_supplier = ?";
                try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                    stmt.setInt(1, id_supplier);
                    int rowsAffected = stmt.executeUpdate();
                    if (rowsAffected > 0) {
                        System.out.println("Supplier deleted successfully!");
                    } else {
                        System.out.println("Supplier ID not found.");
                    }
                }
            } catch (SQLException e) {
                System.out.println("Error deleting supplier: " + e.getMessage());
            }
        }

    }
}