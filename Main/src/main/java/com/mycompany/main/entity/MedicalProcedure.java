package com.mycompany.main.entity;

import com.mycompany.main.entity.Employee.EmployeeCRUD;
import com.mycompany.main.enums.TypeSurgery;
import java.util.Date;
import com.mycompany.main.persistence.ConnectionDB;
import java.sql.*;
import java.util.Scanner;
import java.util.regex.Pattern;

public class MedicalProcedure {

    private int id_medical_procedure;
    private String name;
    private String used_inputs;
    private TypeSurgery type_surgery;
    private boolean exam_analysis;
    private Date date_procedure;
    private double price;
    private Pet id_pet;
    private Employee id_employee;

    public MedicalProcedure(int id_medical_procedure, String name, String used_inputs, TypeSurgery type_surgery, boolean exam_analysis, Date date_procedure, double price, Pet id_pet, Employee id_employee) {
        this.id_medical_procedure = id_medical_procedure;
        this.name = name;
        this.used_inputs = used_inputs;
        this.type_surgery = type_surgery;
        this.exam_analysis = exam_analysis;
        this.date_procedure = date_procedure;
        this.price = price;
        this.id_pet = id_pet;
        this.id_employee = id_employee;
    }

    public int getId_medical_procedure() {
        return id_medical_procedure;
    }

    public void setId_medical_procedure(int id_medical_procedure) {
        this.id_medical_procedure = id_medical_procedure;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsed_inputs() {
        return used_inputs;
    }

    public void setUsed_inputs(String used_inputs) {
        this.used_inputs = used_inputs;
    }

    public TypeSurgery getType_surgery() {
        return type_surgery;
    }

    public void setType_surgery(TypeSurgery type_surgery) {
        this.type_surgery = type_surgery;
    }

    public boolean isExam_analysis() {
        return exam_analysis;
    }

    public void setExam_analysis(boolean exam_analysis) {
        this.exam_analysis = exam_analysis;
    }

    public Date getDate_procedure() {
        return date_procedure;
    }

    public void setDate_procedure(Date date_procedure) {
        this.date_procedure = date_procedure;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Pet getId_pet() {
        return id_pet;
    }

    public void setId_pet(Pet id_pet) {
        this.id_pet = id_pet;
    }

    public Employee getId_employee() {
        return id_employee;
    }

    public void setId_employee(Employee id_employee) {
        this.id_employee = id_employee;
    }

    public class MedicalProcedureCrud {

        private static final Scanner scanner = new Scanner(System.in);

        public static void registerMedicalProcedure() {
            System.out.println("---- Register Medical Procedure ----");

            String name = inputWithValidation(scanner, "Enter Medical Procedure Name: ", "[A-Za-z0-9 ]+",
                    "Invalid name. Only letters, numbers, and spaces allowed.");

            String usedInputs = inputOptional(scanner, "Enter Used Inputs: ");

            TypeSurgery typeSurgery = null;
            while (typeSurgery == null) {
                String inputTypeSurgery = inputWithValidation(scanner,
                        "Enter Type of Surgery (SURGERY, STERILIZATION, RADIOGRAPHY): ",
                        "SURGERY|STERILIZATION|RADIOGRAPHY",
                        "Invalid input. Choose from: SURGERY, STERILIZATION, RADIOGRAPHY.");
                typeSurgery = TypeSurgery.valueOf(inputTypeSurgery);
            }

            boolean examAnalysis = inputBoolean(scanner, "Does the procedure require exam analysis? (true/false): ",
                    "Invalid input. Please enter true or false.");

            String dateStr = inputWithValidation(scanner, "Enter the date of the procedure (YYYY-MM-DD): ",
                    "\\d{4}-\\d{2}-\\d{2}", "Invalid date format. Use YYYY-MM-DD.");
            java.sql.Date dateProcedure = java.sql.Date.valueOf(dateStr);

            double price = inputDoubleWithValidation(scanner, "Enter the price of the procedure: ",
                    "Invalid price. Please enter a positive number.");
            Pet.listPets();
            int petId = inputInt(scanner, "Enter Pet ID: ");
            EmployeeCRUD.listEmployees();
            int employeeId = inputInt(scanner, "Enter Employee ID: ");

            try (Connection conn = ConnectionDB.getConnection()) {
                String sql = "INSERT INTO MedicalProcedure (name, used_inputs, type_surgery, exam_analysis, date_procedure, price, id_pet, id_employee) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
                try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                    stmt.setString(1, name);
                    stmt.setString(2, usedInputs);
                    stmt.setString(3, typeSurgery.name());
                    stmt.setBoolean(4, examAnalysis);
                    stmt.setDate(5, dateProcedure);
                    stmt.setDouble(6, price);
                    stmt.setInt(7, petId);
                    stmt.setInt(8, employeeId);
                    stmt.executeUpdate();
                    System.out.println("Medical procedure registered successfully!");
                }
            } catch (SQLException e) {
                System.out.println("Error registering medical procedure: " + e.getMessage());
            }
        }

        public static void listMedicalProcedures() {
            System.out.println("---- List of Medical Procedures ----");
            try (Connection conn = ConnectionDB.getConnection()) {
                String query = "SELECT * FROM MedicalProcedures";
                try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
                    while (rs.next()) {
                        int id = rs.getInt("id_procedure");
                        String name = rs.getString("name");
                        String description = rs.getString("description");
                        double cost = rs.getDouble("cost");
                        int duration = rs.getInt("duration");
                        String petType = rs.getString("pet_type");
                        Date dateProcedure = rs.getDate("date_procedure");

                        System.out.printf("ID: %d, Name: %s, Description: %s, Cost: %.2f, Duration: %d min, Pet Type: %s, Date: %s\n",
                                id, name, description, cost, duration, petType, dateProcedure);
                    }
                }
            } catch (SQLException e) {
                System.out.println("Error retrieving medical procedures: " + e.getMessage());
            }
        }

        public static void editMedicalProcedure() {
            System.out.println("---- Edit Medical Procedure ----");
            listMedicalProcedures(); // Mostrar los procedimientos disponibles
            int procedureId = inputInt(scanner, "Enter Procedure ID to edit: ");

            String name = inputWithValidation(scanner, "Enter new Procedure Name: ",
                    "[A-Za-z0-9 ]+", "Invalid name. Only letters, numbers, and spaces allowed.");

            String description = inputOptional(scanner, "Enter new Description: ");

            double cost = inputDoubleWithValidation(scanner, "Enter new Cost: ",
                    "Invalid cost. Please enter a positive number.");

            int duration = inputInt(scanner, "Enter new Duration (in minutes): ");

            String petType = inputOptional(scanner, "Enter new Pet Type (e.g., Dog, Cat): ");

            String dateProcedure = inputWithValidation(scanner, "Enter new Procedure Date (YYYY-MM-DD): ",
                    "\\d{4}-\\d{2}-\\d{2}", "Invalid date format. Use YYYY-MM-DD.");

            try (Connection conn = ConnectionDB.getConnection()) {
                String query = "UPDATE MedicalProcedures SET name = ?, description = ?, cost = ?, duration = ?, pet_type = ?, date_procedure = ? WHERE id_procedure = ?";
                try (PreparedStatement stmt = conn.prepareStatement(query)) {
                    stmt.setString(1, name);
                    stmt.setString(2, description);
                    stmt.setDouble(3, cost);
                    stmt.setInt(4, duration);
                    stmt.setString(5, petType);
                    stmt.setString(6, dateProcedure);
                    stmt.setInt(7, procedureId);

                    int rowsAffected = stmt.executeUpdate();
                    if (rowsAffected > 0) {
                        System.out.println("Medical Procedure updated successfully.");
                    } else {
                        System.out.println("Procedure not found.");
                    }
                }
            } catch (SQLException e) {
                System.out.println("Error updating procedure: " + e.getMessage());
            }
        }

        public static void deleteMedicalProcedure() {
            System.out.println("---- Delete Medical Procedure ----");

            int procedureId = inputInt(scanner, "Enter Procedure ID to delete: ");

            try (Connection conn = ConnectionDB.getConnection()) {
                String query = "DELETE FROM MedicalProcedures WHERE id_procedure = ?";
                try (PreparedStatement stmt = conn.prepareStatement(query)) {
                    stmt.setInt(1, procedureId);

                    int rowsAffected = stmt.executeUpdate();
                    if (rowsAffected > 0) {
                        System.out.println("Medical Procedure deleted successfully.");
                    } else {
                        System.out.println("Procedure not found.");
                    }
                }
            } catch (SQLException e) {
                System.out.println("Error deleting procedure: " + e.getMessage());
            }
        }

        // Utility methods for input validation
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

        private static double inputDoubleWithValidation(Scanner scanner, String prompt, String errorMessage) {
            while (true) {
                try {
                    System.out.print(prompt);
                    double value = Double.parseDouble(scanner.nextLine().trim());
                    if (value >= 0) {
                        return value;
                    }
                    System.out.println(errorMessage);
                } catch (NumberFormatException e) {
                    System.out.println(errorMessage);
                }
            }
        }

        private static boolean inputBoolean(Scanner scanner, String prompt, String errorMessage) {
            while (true) {
                System.out.print(prompt);
                String input = scanner.nextLine().trim().toLowerCase();
                if (input.equals("true") || input.equals("false")) {
                    return Boolean.parseBoolean(input);
                }
                System.out.println(errorMessage);
            }
        }

        public static void main(String[] args) {
            registerMedicalProcedure();
        }
    }

}