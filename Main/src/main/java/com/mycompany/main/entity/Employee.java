
package com.mycompany.main.entity;

import java.sql.*;
import java.util.Scanner;
import java.util.Date;
import java.util.regex.Pattern;
import com.mycompany.main.enums.IdentityType;
import com.mycompany.main.enums.PositionType;
import com.mycompany.main.enums.Shift;
import com.mycompany.main.persistence.ConnectionDB;


public class Employee extends Person{
    private int id_employee;
    private String second_last_name;
    private double wage;
    private PositionType position_type;
    private Date hire_date;
    private Shift shift;

    public Employee(int id_employee, String second_last_name, double wage, PositionType position_type, Date hire_date, Shift shift, String first_name, String last_name, IdentityType identity_type, String identification_number, String rut, String phone, String email, String address, String emergency_contact_name, String emergency_contact_phone) {
        super(first_name, last_name, identity_type, identification_number, rut, phone, email, emergency_contact_name, emergency_contact_phone);
        this.id_employee = id_employee;
        this.second_last_name = second_last_name;
        this.wage = wage;
        this.position_type = position_type;
        this.hire_date = hire_date;
        this.shift = shift;
    }

    

    public int getId_employee() {
        return id_employee;
    }

    public void setId_employee(int id_employee) {
        this.id_employee = id_employee;
    }

    public String getSecond_last_name() {
        return second_last_name;
    }

    public void setSecond_last_name(String second_last_name) {
        this.second_last_name = second_last_name;
    }

    public double getWage() {
        return wage;
    }

    public void setWage(double wage) {
        this.wage = wage;
    }

    public PositionType getPosition_type() {
        return position_type;
    }

    public void setPosition_type(PositionType position_type) {
        this.position_type = position_type;
    }

    public Date getHire_date() {
        return hire_date;
    }

    public void setHire_date(Date hire_date) {
        this.hire_date = hire_date;
    }

    public Shift getShift() {
        return shift;
    }

    public void setShift(Shift shift) {
        this.shift = shift;
    }

public class EmployeeCRUD {
    public static int registerNewEmployee() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("---- Register New Employee ----");

        String firstName = inputWithValidation(scanner, "Enter First Name: ", "[A-Za-z ]+", "Invalid name. Only letters and spaces are allowed.");
        String lastName = inputWithValidation(scanner, "Enter Last Name: ", "[A-Za-z ]+", "Invalid name. Only letters and spaces are allowed.");
        String secondLastName = inputWithValidation(scanner, "Enter Second Last Name: ", "[A-Za-z ]+", "Invalid name. Only letters and spaces are allowed.");
        
        String identityType = inputWithValidation(scanner, "Enter Identity Type (CC/CE/Passport): ", "CC|CE|Passport", "Invalid identity type. Use CC, CE, or Passport.");
        String identificationNumber = inputWithValidation(scanner, "Enter Identification Number: ", "\\d+", "Invalid ID. Only numbers are allowed.");
        
        String phone = inputWithValidation(scanner, "Enter Phone: ", "\\d{7,15}", "Invalid phone number.");
        String email = inputWithValidation(scanner, "Enter Email: ", "[\\w.%+-]+@[\\w.-]+\\.[A-Za-z]{2,6}", "Invalid email address.");
        
        double wage = inputDouble(scanner, "Enter Wage: ");
        
        PositionType positionType = inputPositionType(scanner);
        Shift shift = inputShift(scanner);
        
        Date hireDate = new Date(); 

        try (Connection conn = ConnectionDB.getConnection()) {
            String query = "INSERT INTO Employees (first_name, last_name, second_last_name, identity_type, identification_number, wage, position_type, hire_date, phone, email, shift) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
                stmt.setString(1, firstName);
                stmt.setString(2, lastName);
                stmt.setString(3, secondLastName);
                stmt.setString(4, identityType);
                stmt.setString(5, identificationNumber);
                stmt.setDouble(6, wage);
                stmt.setString(7, positionType.toString());
                stmt.setDate(8, new java.sql.Date(hireDate.getTime()));
                stmt.setString(9, phone);
                stmt.setString(10, email);
                stmt.setString(11, shift.toString());

                int rowsInserted = stmt.executeUpdate();
                if (rowsInserted > 0) {
                    try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                        if (generatedKeys.next()) {
                            return generatedKeys.getInt(1); 
                            
                        }
                    }
                }
            }
            System.out.println("Employee registered successfully.");
        } catch (SQLException e) {
            System.out.println("Error registering employee: " + e.getMessage());
        }
        return -1; // Retorna -1 en caso de error.
    }

    public static void listEmployees() {
        System.out.println("---- List of Employees ----");
        try (Connection conn = ConnectionDB.getConnection()) {
            String query = "SELECT id_employee, first_name, last_name, second_last_name, position_type FROM Employees";
            try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
                while (rs.next()) {
                    int idEmployee = rs.getInt("id_employee");
                    String firstName = rs.getString("first_name");
                    String lastName = rs.getString("last_name");
                    String secondLastName = rs.getString("second_last_name");
                    String positionType = rs.getString("position_type");

                    System.out.printf("ID: %d, Name: %s %s %s, Position: %s\n",
                            idEmployee, firstName, lastName, secondLastName, positionType);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving employees: " + e.getMessage());
        }
    }

    public static void searchEmployeeByIdentification() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("---- Search Employee by Identification ----");
        String id = inputWithValidation(scanner, "Enter the Employee Identification Number to search: ", "\\d+", "Invalid ID. Only numbers are allowed.");

        try (Connection conn = ConnectionDB.getConnection()) {
            String query = "SELECT id_employee, first_name, last_name, second_last_name FROM Employees WHERE identification_number = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                pstmt.setString(1, id);

                try (ResultSet rs = pstmt.executeQuery()) {
                    if (rs.next()) {
                        int idEmployee = rs.getInt("id_employee");
                        String firstName = rs.getString("first_name");
                        String lastName = rs.getString("last_name");
                        String secondLastName = rs.getString("second_last_name");

                        System.out.printf("ID: %d, Name: %s %s %s\n", idEmployee, firstName, lastName, secondLastName);
                    } else {
                        System.out.println("No employee found with the provided ID.");
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving employee: " + e.getMessage());
        }
    }

    public static void editEmployee() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("---- Edit Employee ----");
        System.out.print("Enter Employee ID to edit: ");
        int employeeId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter new First Name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter new Last Name: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter new Second Last Name: ");
        String secondLastName = scanner.nextLine();
        System.out.print("Enter new Phone: ");
        String phone = scanner.nextLine();
        System.out.print("Enter new Email: ");
        String email = scanner.nextLine();
        System.out.print("Enter new Wage: ");
        double wage = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        PositionType positionType = inputPositionType(scanner);
        Shift shift = inputShift(scanner);

        try (Connection conn = ConnectionDB.getConnection()) {
            String query = "UPDATE Employees SET first_name = ?, last_name = ?, second_last_name = ?, phone = ?, email = ?, wage = ?, position_type = ?, shift = ? WHERE id_employee = ?";
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setString(1, firstName);
                stmt.setString(2, lastName);
                stmt.setString(3, secondLastName);
                stmt.setString(4, phone);
                stmt.setString(5, email);
                stmt.setDouble(6, wage);
                stmt.setString(7, positionType.toString());
                stmt.setString(8, shift.toString());
                stmt.setInt(9, employeeId);

                int rowsAffected = stmt.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Employee updated successfully.");
                } else {
                    System.out.println("Employee not found.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Error updating employee: " + e.getMessage());
        }
    }

    public static void deleteEmployee() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("---- Delete Employee ----");
        System.out.print("Enter Employee ID to delete: ");
        int employeeId = scanner.nextInt();

        try (Connection conn = ConnectionDB.getConnection()) {
            String query = "DELETE FROM Employees WHERE id_employee = ?";
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setInt(1, employeeId);
                int rowsAffected = stmt.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Employee deleted successfully.");
                } else {
                    System.out.println("Employee not found.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Error deleting employee: " + e.getMessage());
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

    private static double inputDouble(Scanner scanner, String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Double.parseDouble(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Please try again.");
            }
        }
    }

    private static PositionType inputPositionType(Scanner scanner) {
        System.out.println("Select Position Type:");
        for (PositionType type : PositionType.values()) {
            System.out.println(type.ordinal() + 1 + ". " + type);
        }
        while (true) {
            try {
                System.out.print("Enter Position Type number: ");
                int choice = Integer.parseInt(scanner.nextLine().trim());
                if (choice > 0 && choice <= PositionType.values().length) {
                    return PositionType.values()[choice - 1];
                }
                System.out.println("Invalid selection. Please try again.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

    private static Shift inputShift(Scanner scanner) {
        System.out.println("Select Shift:");
        for (Shift shift : Shift.values()) {
            System.out.println(shift.ordinal() + 1 + ". " + shift);
        }
        while (true) {
            try {
                System.out.print("Enter Shift number: ");
                int choice = Integer.parseInt(scanner.nextLine().trim());
                if (choice > 0 && choice <= Shift.values().length) {
                    return Shift.values()[choice - 1];
                }
                System.out.println("Invalid selection. Please try again.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }
}
    
}
