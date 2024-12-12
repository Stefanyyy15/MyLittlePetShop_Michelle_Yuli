
package com.mycompany.main.entity;

import com.mycompany.main.entity.Owner.OwnerCRUD;
import com.mycompany.main.enums.StatusAppoinment;
import com.mycompany.main.persistence.ConnectionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Appointment {
    private int id_appointment;
    private Date date_appointment;
    private String query_type;
    private String diagnostic;
    private String treatment;
    private String reason_visit;
    private String recommendations;
    private StatusAppoinment status;

    public Appointment(int id_appointment, Date date_appointment, String query_type, String diagnostic, String treatment, String reason_visit, String recommendations, StatusAppoinment status) {
        this.id_appointment = id_appointment;
        this.date_appointment = date_appointment;
        this.query_type = query_type;
        this.diagnostic = diagnostic;
        this.treatment = treatment;
        this.reason_visit = reason_visit;
        this.recommendations = recommendations;
        this.status = status;
    }

    public StatusAppoinment getStatus() {
        return status;
    }

    public void setStatus(StatusAppoinment status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Appointment{" + "id_appointment=" +
                id_appointment + ", date_appointment=" + 
                date_appointment + ", query_type=" + 
                query_type + ", diagnostic=" + 
                diagnostic + ", treatment=" + 
                treatment + ", reason_visit=" + 
                reason_visit + ", recommendations=" + 
                recommendations + '}';
    }

    public int getId_appointment() {
        return id_appointment;
    }

    public void setId_appointment(int id_appointment) {
        this.id_appointment = id_appointment;
    }

    public Date getDate_appointment() {
        return date_appointment;
    }

    public void setDate_appointment(Date date_appointment) {
        this.date_appointment = date_appointment;
    }

    public String getQuery_type() {
        return query_type;
    }

    public void setQuery_type(String query_type) {
        this.query_type = query_type;
    }

    public String getDiagnostic() {
        return diagnostic;
    }

    public void setDiagnostic(String diagnostic) {
        this.diagnostic = diagnostic;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    public String getReason_visit() {
        return reason_visit;
    }

    public void setReason_visit(String reason_visit) {
        this.reason_visit = reason_visit;
    }

    public String getRecommendations() {
        return recommendations;
    }

    public void setRecommendations(String recommendations) {
        this.recommendations = recommendations;
    }
    
    public class AppointmentManagement {
    private static final Scanner scanner = new Scanner(System.in);

    public static void listAppointments() {
        System.out.println("---- List of Appointments ----");
        try (Connection conn = ConnectionDB.getConnection()) {
            String query = "SELECT a.*, o.first_name AS owner_name, e.first_name AS employee_name, p.name AS pet_name " +
                           "FROM Appointments a " +
                           "JOIN Owner o ON a.id_owner = o.id_owner " +
                           "JOIN Employees e ON a.id_employee = e.id_employee " +
                           "JOIN Pets p ON a.id_pet = p.id_pet";
            
            try (Statement stmt = conn.createStatement(); 
                 ResultSet rs = stmt.executeQuery(query)) {
                while (rs.next()) {
                    System.out.printf(
                        "ID: %d, Date: %s, Query Type: %s, Status: %s\n" +
                        "  Owner: %s, Employee: %s, Pet: %s\n" +
                        "  Reason: %s\n" +
                        "  Diagnostic: %s\n" +
                        "  Treatment: %s\n" +
                        "  Recommendations: %s\n\n",
                        rs.getInt("id_appointment"),
                        rs.getTimestamp("date_appointment"),
                        rs.getString("query_type"),
                        rs.getString("status"),
                        rs.getString("owner_name"),
                        rs.getString("employee_name"),
                        rs.getString("pet_name"),
                        rs.getString("reason_visit"),
                        rs.getString("diagnostic"),
                        rs.getString("treatment"),
                        rs.getString("recommendations")
                    );
                }
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving appointments: " + e.getMessage());
        }
    }

    public static void registerAppointment() {
        System.out.println("---- Register New Appointment ----");
        
        //OwnerCRUD.searchOwnerByIdentification();
        int ownerId = inputInt(scanner, "Enter Owner ID: ");
        
        //Sale.searchEmployeeByIdentification();
        int employeeId = inputInt(scanner, "Enter Employee ID: ");
        
        Pet.listPets();
        int petId = inputInt(scanner, "Enter Pet ID: ");
        
        // Date input with validation
        String dateAppointment = inputWithValidation(scanner,"Enter Appointment Date and Time (YYYY-MM-DD HH:MM): ", "\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}", "Invalid date format. Use YYYY-MM-DD HH:MM.");
        
        // Query Type
        String queryType = inputWithValidation(scanner, "Enter Query Type: ", "[A-Za-z0-9 ]+", "Invalid query type. Only letters, numbers, and spaces allowed.");
        
        // Reason for Visit
        String reasonVisit = inputWithValidation(scanner, "Enter Reason for Visit: ", ".+", "Reason cannot be empty.");
        
        // Diagnostic
        String diagnostic = inputWithValidation(scanner, "Enter Diagnostic: ", ".+", "Diagnostic cannot be empty.");
        
        // Treatment
        String treatment = inputWithValidation(scanner, "Enter Treatment: ", ".+", "Treatment cannot be empty.");
        
        // Recommendations
        String recommendations = inputWithValidation(scanner, "Enter Recommendations: ", ".+", "Recommendations cannot be empty.");
        
        // Status
        String status = inputWithValidation(scanner, 
            "Enter Status (Scheduled/In Progress/Completed/Cancelled): ", 
            "Scheduled|In Progress|Completed|Cancelled", 
            "Invalid status. Choose from: Scheduled, In Progress, Completed, Cancelled.");

        try (Connection conn = ConnectionDB.getConnection()) {
            String query = "INSERT INTO Appointments " +
                "(date_appointment, query_type, diagnostic, treatment, reason_visit, " +
                "recommendations, id_owner, id_employee, id_pet, status) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setString(1, dateAppointment);
                stmt.setString(2, queryType);
                stmt.setString(3, diagnostic);
                stmt.setString(4, treatment);
                stmt.setString(5, reasonVisit);
                stmt.setString(6, recommendations);
                stmt.setInt(7, ownerId);
                stmt.setInt(8, employeeId);
                stmt.setInt(9, petId);
                stmt.setString(10, status);

                int rowsInserted = stmt.executeUpdate();
                if (rowsInserted > 0) {
                    System.out.println("Appointment registered successfully.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Error saving the appointment: " + e.getMessage());
        }
    }

    public static void editAppointment() {
        System.out.println("---- Edit Appointment ----");
        
        // Get Appointment ID to edit
        int appointmentId = inputInt(scanner, "Enter Appointment ID to edit: ");
        
        // Get Owner ID
        int ownerId = inputInt(scanner, "Enter new Owner ID: ");
        
        // Get Employee ID
        int employeeId = inputInt(scanner, "Enter new Employee ID: ");
        
        // Get Pet ID
        int petId = inputInt(scanner, "Enter new Pet ID: ");
        
        // Date input with validation
        String dateAppointment = inputWithValidation(scanner, 
            "Enter new Appointment Date and Time (YYYY-MM-DD HH:MM): ", 
            "\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}", 
            "Invalid date format. Use YYYY-MM-DD HH:MM.");
        
        // Query Type
        String queryType = inputWithValidation(scanner, "Enter new Query Type: ", "[A-Za-z0-9 ]+", "Invalid query type. Only letters, numbers, and spaces allowed.");
        
        // Reason for Visit
        String reasonVisit = inputWithValidation(scanner, "Enter new Reason for Visit: ", ".+", "Reason cannot be empty.");
        
        // Diagnostic
        String diagnostic = inputWithValidation(scanner, "Enter new Diagnostic: ", ".+", "Diagnostic cannot be empty.");
        
        // Treatment
        String treatment = inputWithValidation(scanner, "Enter new Treatment: ", ".+", "Treatment cannot be empty.");
        
        // Recommendations
        String recommendations = inputWithValidation(scanner, "Enter new Recommendations: ", ".+", "Recommendations cannot be empty.");
        
        // Status
        String status = inputWithValidation(scanner, "Enter new Status (Scheduled/In Progress/Completed/Cancelled): ", "Scheduled|In Progress|Completed|Cancelled", "Invalid status. Choose from: Scheduled, In Progress, Completed, Cancelled.");

        try (Connection conn = ConnectionDB.getConnection()) {
            String query = "UPDATE Appointments SET " +
                "date_appointment = ?, query_type = ?, diagnostic = ?, treatment = ?, " +
                "reason_visit = ?, recommendations = ?, id_owner = ?, id_employee = ?, " +
                "id_pet = ?, status = ? WHERE id_appointment = ?";
            
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setString(1, dateAppointment);
                stmt.setString(2, queryType);
                stmt.setString(3, diagnostic);
                stmt.setString(4, treatment);
                stmt.setString(5, reasonVisit);
                stmt.setString(6, recommendations);
                stmt.setInt(7, ownerId);
                stmt.setInt(8, employeeId);
                stmt.setInt(9, petId);
                stmt.setString(10, status);
                stmt.setInt(11, appointmentId);

                int rowsAffected = stmt.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Appointment updated successfully.");
                } else {
                    System.out.println("Appointment not found.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Error updating appointment: " + e.getMessage());
        }
    }

    public static void deleteAppointment() {
        System.out.println("---- Delete Appointment ----");
        
        // Get Appointment ID to delete
        int appointmentId = inputInt(scanner, "Enter Appointment ID to delete: ");

        try (Connection conn = ConnectionDB.getConnection()) {
            String query = "DELETE FROM Appointments WHERE id_appointment = ?";
            
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setInt(1, appointmentId);

                int rowsAffected = stmt.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Appointment deleted successfully.");
                } else {
                    System.out.println("Appointment not found.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Error deleting appointment: " + e.getMessage());
        }
    }

    // Utility methods for input validation and handling
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
