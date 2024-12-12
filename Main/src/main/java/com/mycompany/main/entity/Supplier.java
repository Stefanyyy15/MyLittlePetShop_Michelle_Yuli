
package com.mycompany.main.entity;

import com.mycompany.main.persistence.ConnectionDB;
import java.sql.*;
import java.util.*;

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
    
    static Scanner scanner = new Scanner(System.in);

    // Register a new Supplier
    public static void registerSupplier() {
        try (Connection conn = ConnectionDB.getConnection()) {
            System.out.println("Enter Supplier Name:");
            String name = scanner.nextLine();
            System.out.println("Enter Supplier Contact:");
            String contact = scanner.nextLine();
            System.out.println("Enter Supplier Email:");
            String email = scanner.nextLine(); // Nuevo campo para email

            String sql = "INSERT INTO suppliers (name, contact, email) VALUES (?, ?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, name);
                stmt.setString(2, contact);
                stmt.setString(3, email); // Se agrega el email a la consulta
                stmt.executeUpdate();
                System.out.println("Supplier registered successfully!");
            }
        } catch (SQLException e) {
            System.out.println("Error registering supplier: " + e.getMessage());
        }
    }

    // List all Suppliers
    public static void listSuppliers() {
        try (Connection conn = ConnectionDB.getConnection()) {
            String sql = "SELECT * FROM suppliers";
            try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
                while (rs.next()) {
                    System.out.println("ID: " + rs.getInt("id") + ", Name: " + rs.getString("name") +
                            ", Contact: " + rs.getString("contact") + ", Email: " + rs.getString("email"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Error listing suppliers: " + e.getMessage());
        }
    }

    // Edit Supplier
    public static void editSupplier() {
        try (Connection conn = ConnectionDB.getConnection()) {
            System.out.println("Enter Supplier ID to edit:");
            int id = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            System.out.println("Enter new Supplier Name:");
            String name = scanner.nextLine();
            System.out.println("Enter new Supplier Contact:");
            String contact = scanner.nextLine();
            System.out.println("Enter new Supplier Email:");
            String email = scanner.nextLine(); // Nuevo campo para email

            String sql = "UPDATE suppliers SET name = ?, contact = ?, email = ? WHERE id = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, name);
                stmt.setString(2, contact);
                stmt.setString(3, email); // Se agrega el email a la consulta
                stmt.setInt(4, id);
                stmt.executeUpdate();
                System.out.println("Supplier updated successfully!");
            }
        } catch (SQLException e) {
            System.out.println("Error editing supplier: " + e.getMessage());
        }
    }

    // Delete Supplier
    public static void deleteSupplier() {
        try (Connection conn = ConnectionDB.getConnection()) {
            System.out.println("Enter Supplier ID to delete:");
            int id = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            String sql = "DELETE FROM suppliers WHERE id = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, id);
                stmt.executeUpdate();
                System.out.println("Supplier deleted successfully!");
            }
        } catch (SQLException e) {
            System.out.println("Error deleting supplier: " + e.getMessage());
        }
    }
}    

