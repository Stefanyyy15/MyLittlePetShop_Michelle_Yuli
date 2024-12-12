
package com.mycompany.main.entity;

import com.mycompany.main.entity.Appointment.AppointmentManagement;
import com.mycompany.main.entity.Owner.OwnerCRUD;
import java.util.Date;
import com.mycompany.main.persistence.ConnectionDB;
import java.sql.*;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Sale {
    private int id_sale;
    private String name;
    private Date date_sale;
    private Double total;
    private Owner id_owner;
    private Employee id_employee;
    private Appointment id_appointment;

    public Sale(int id_sale, String name, Date date_sale, Double total, Owner id_owner, Employee id_employee, Appointment id_appointment) {
        this.id_sale = id_sale;
        this.name = name;
        this.date_sale = date_sale;
        this.total = total;
        this.id_owner = id_owner;
        this.id_employee = id_employee;
        this.id_appointment = id_appointment;
    }

    @Override
    public String toString() {
        return "Sales{" + "id_sale=" + id_sale + ", name=" + name + ", date_sale=" + date_sale + ", total=" + total + ", id_owner=" + id_owner + ", id_employee=" + id_employee + ", id_appointment=" + id_appointment + '}';
    }

    public int getId_sale() {
        return id_sale;
    }

    public void setId_sale(int id_sale) {
        this.id_sale = id_sale;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate_sale() {
        return date_sale;
    }

    public void setDate_sale(Date date_sale) {
        this.date_sale = date_sale;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Owner getId_owner() {
        return id_owner;
    }

    public void setId_owner(Owner id_owner) {
        this.id_owner = id_owner;
    }

    public Employee getId_employee() {
        return id_employee;
    }

    public void setId_employee(Employee id_employee) {
        this.id_employee = id_employee;
    }

    public Appointment getId_appointment() {
        return id_appointment;
    }

    public void setId_appointment(Appointment id_appointment) {
        this.id_appointment = id_appointment;
    }
    
   public static int registerNewSale() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("---- Register New Sale ----");

    String name = inputWithValidation(scanner, "Enter Sale Name: ", "[A-Za-z0-9 ]+", "Invalid name. Only letters, numbers, and spaces are allowed.");
    String dateStr = inputWithValidation(scanner, "Enter Sale Date (YYYY-MM-DD): ", "\\d{4}-\\d{2}-\\d{2}", "Invalid date format. Use YYYY-MM-DD.");
    String total = inputWithValidation(scanner, "Enter Total Amount: ", "\\d+(\\.\\d{1,2})?", "Invalid amount. Only numbers with up to 2 decimal places.");

    String ownerId = null;
    boolean ownerValid = false;
    while (!ownerValid) {
        ownerId = inputWithValidation(scanner, "Enter Owner ID: ", "\\d+", "Invalid ID. Only numbers are allowed.");
        if (OwnerCRUD.searchOwnerByIdentification(ownerId)) {  // Assuming this method returns true if the ID exists
            ownerValid = true;
        } else {
            System.out.println("Owner ID not found. Please try again.");
        }
    }

    String employeeId = null;
    boolean employeeValid = false;
    while (!employeeValid) {
        employeeId = inputWithValidation(scanner, "Enter Employee ID: ", "\\d+", "Invalid ID. Only numbers are allowed.");
        if (searchEmployeeByIdentification(employeeId)) {  // Assuming this method returns true if the ID exists
            employeeValid = true;
        } else {
            System.out.println("Employee ID not found. Please try again.");
        }
    }

    // Validating Appointment ID
    AppointmentManagement.listAppointments();
    String appointmentId = inputWithValidation(scanner, "Enter Appointment ID: ", "\\d+", "Invalid ID. Only numbers are allowed.");

    try (Connection conn = ConnectionDB.getConnection()) {
        String query = "INSERT INTO Sales (name, date_sale, total, id_owner, id_employee, id_appointment) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, name);
            stmt.setDate(2, java.sql.Date.valueOf(dateStr));
            stmt.setDouble(3, Double.parseDouble(total));
            stmt.setInt(4, Integer.parseInt(ownerId));
            stmt.setInt(5, Integer.parseInt(employeeId));
            stmt.setInt(6, Integer.parseInt(appointmentId));

            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        return generatedKeys.getInt(1);
                    }
                }
            }
        }
    } catch (SQLException e) {
        System.out.println("Error registering sale: " + e.getMessage());
    }
    return -1;
}

    public static void listSales() {
        System.out.println("---- List of Sales ----");
        try (Connection conn = ConnectionDB.getConnection()) {
            String query = "SELECT id_sale, name, date_sale, total FROM Sales";
            try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
                while (rs.next()) {
                    int idSale = rs.getInt("id_sale");
                    String name = rs.getString("name");
                    Date dateSale = rs.getDate("date_sale");
                    double total = rs.getDouble("total");

                    System.out.printf("ID: %d, Name: %s, Date: %s, Total: %.2f\n",
                            idSale, name, dateSale, total);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving sales: " + e.getMessage());
        }
    }

    public static void editSale() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("---- Edit Sale ----");
        System.out.print("Enter Sale ID to edit: ");
        int saleId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter new Sale Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter new Sale Date (YYYY-MM-DD): ");
        String dateStr = scanner.nextLine();
        System.out.print("Enter new Total: ");
        String total = scanner.nextLine();

        try (Connection conn = ConnectionDB.getConnection()) {
            String query = "UPDATE Sales SET name = ?, date_sale = ?, total = ? WHERE id_sale = ?";
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setString(1, name);
                stmt.setDate(2, java.sql.Date.valueOf(dateStr));
                stmt.setDouble(3, Double.parseDouble(total));
                stmt.setInt(4, saleId);

                int rowsAffected = stmt.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Sale updated successfully.");
                } else {
                    System.out.println("Sale not found.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Error updating sale: " + e.getMessage());
        }
    }

    public static void deleteSale() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("---- Delete Sale ----");
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Sale ID to delete: ");
        int saleId = scanner.nextInt();

        try (Connection conn = ConnectionDB.getConnection()) {
            String query = "DELETE FROM Sales WHERE id_sale = ?";
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setInt(1, saleId);
                int rowsAffected = stmt.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Sale deleted successfully.");
                } else {
                    System.out.println("Sale not found.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Error deleting sale: " + e.getMessage());
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

    public static boolean searchEmployeeByIdentification(String identificationNumber) {
    try (Connection conn = ConnectionDB.getConnection()) {
        String query = "SELECT id_employee, first_name, last_name, identification_number FROM Employees WHERE identification_number = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, identificationNumber);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    int idEmployee = rs.getInt("id_employee");
                    String firstName = rs.getString("first_name");
                    String lastName = rs.getString("last_name");
                    String foundIdentificationNumber = rs.getString("identification_number");

                    System.out.printf("Employee ID: %d, Name: %s %s, Identification: %s\n", 
                        idEmployee, firstName, lastName, foundIdentificationNumber);
                    return true;  // Employee found
                } else {
                    System.out.println("No employee found with the provided identification number.");
                    return false;  // Employee not found
                }
            }
        }
    } catch (SQLException e) {
        System.out.println("Error retrieving employee: " + e.getMessage());
        return false;  // Error case, treat as not found
    }
    }}

