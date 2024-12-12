package com.mycompany.main.entity;

import com.mycompany.main.enums.TypeSurgery;
import java.util.Date;
import com.mycompany.main.persistence.ConnectionDB;
import java.sql.*;
import java.util.Scanner;

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
    
    public static void registerMedicalProcedure() {
        Scanner scanner = new Scanner(System.in);
        try (Connection conn = ConnectionDB.getConnection()) {
            System.out.println("Enter Medical Procedure Name:");
            String name = scanner.nextLine();
            System.out.println("Enter used inputs:");
            String usedInputs = scanner.nextLine();
            TypeSurgery typeSurgery = null;
            while (true) {
                System.out.println("Enter Type of Surgery (SURGERY, STERILIZATION, RADIOGRAPHY):");
                String inputTypeSurgery = scanner.nextLine().toUpperCase();
                try {
                    typeSurgery = TypeSurgery.valueOf(inputTypeSurgery); // Usamos valueOf para convertir la cadena a un valor del enum
                    break;  // Si es válido, salimos del bucle
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid input. Please enter one of the following: SURGERY, STERILIZATION, RADIOGRAPHY.");
                }
            }
            System.out.println("Does the procedure require exam analysis? (true/false):");
            boolean examAnalysis = scanner.nextBoolean();
            scanner.nextLine(); // Consume newline
            System.out.println("Enter the date of the procedure (YYYY-MM-DD):");
            String dateStr = scanner.nextLine();
            System.out.println("Enter the price of the procedure:");
            double price = scanner.nextDouble();
            System.out.println("Enter Pet ID:");
            int petId = scanner.nextInt();
            System.out.println("Enter Employee ID:");
            int employeeId = scanner.nextInt();

            // Convert date string to java.sql.Date
            java.sql.Date dateProcedure = java.sql.Date.valueOf(dateStr);

            String sql = "INSERT INTO MedicalProcedure (name, used_inputs, type_surgery, exam_analysis, date_procedure, price, id_pet, id_employee) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, name);
                stmt.setString(2, usedInputs);
                stmt.setString(3, typeSurgery.name());
                stmt.setBoolean(4, examAnalysis);
                stmt.setDate(5, dateProcedure); // Usamos java.sql.Date para la fecha
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

    // List all Medical Procedures
    public static void listMedicalProcedures() {
        try (Connection conn = ConnectionDB.getConnection()) {
            String sql = "SELECT * FROM MedicalProcedure";
            try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
                while (rs.next()) {
                    System.out.println("ID: " + rs.getInt("id_medical_procedure") +
                            ", Name: " + rs.getString("name") +
                            ", Used Inputs: " + rs.getString("used_inputs") +
                            ", Type of Surgery: " + rs.getString("type_surgery") +
                            ", Exam Analysis: " + rs.getBoolean("exam_analysis") +
                            ", Date of Procedure: " + rs.getDate("date_procedure") +
                            ", Price: " + rs.getDouble("price") +
                            ", Pet ID: " + rs.getInt("id_pet") +
                            ", Employee ID: " + rs.getInt("id_employee"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Error listing medical procedures: " + e.getMessage());
        }
    }

    public static void editMedicalProcedure() {
        try (Connection conn = ConnectionDB.getConnection()) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter Medical Procedure ID to edit:");
            int id = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            System.out.println("Enter new Medical Procedure Name:");
            String name = scanner.nextLine();
            System.out.println("Enter new Used Inputs:");
            String usedInputs = scanner.nextLine();
            TypeSurgery typeSurgery = null;
            while (true) {
                System.out.println("Enter Type of Surgery (SURGERY, STERILIZATION, RADIOGRAPHY):");
                String inputTypeSurgery = scanner.nextLine().toUpperCase();
                try {
                    typeSurgery = TypeSurgery.valueOf(inputTypeSurgery); // Usamos valueOf para convertir la cadena a un valor del enum
                    break;  // Si es válido, salimos del bucle
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid input. Please enter one of the following: SURGERY, STERILIZATION, RADIOGRAPHY.");
                }
            }
            System.out.println("Enter new Exam Analysis (true/false):");
            boolean examAnalysis = scanner.nextBoolean();
            System.out.println("Enter new Date of Procedure (YYYY-MM-DD):");
            String dateStr = scanner.next();
            
            // Validar que la fecha esté en el formato correcto
            java.sql.Date dateProcedure = null;
            try {
                dateProcedure = java.sql.Date.valueOf(dateStr); // Intentamos convertir la fecha
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid date format. Please use YYYY-MM-DD.");
                return;  // Salimos si la fecha es inválida
            }

            System.out.println("Enter new Price:");
            double price = scanner.nextDouble();
            System.out.println("Enter new Pet ID:");
            int petId = scanner.nextInt();
            System.out.println("Enter new Employee ID:");
            int employeeId = scanner.nextInt();

            String sql = "UPDATE MedicalProcedure SET name = ?, used_inputs = ?, type_surgery = ?, exam_analysis = ?, date_procedure = ?, price = ?, id_pet = ?, id_employee = ? WHERE id_medical_procedure = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, name);
                stmt.setString(2, usedInputs);
                stmt.setString(3, typeSurgery.name());
                stmt.setBoolean(4, examAnalysis);
                stmt.setDate(5, dateProcedure);
                stmt.setDouble(6, price);
                stmt.setInt(7, petId);
                stmt.setInt(8, employeeId);
                stmt.setInt(9, id);
                stmt.executeUpdate();
                System.out.println("Medical procedure updated successfully!");
            }
        } catch (SQLException e) {
            System.out.println("Error editing medical procedure: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        editMedicalProcedure();
    }


    public static void deleteMedicalProcedure() {
        try (Connection conn = ConnectionDB.getConnection()) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter Medical Procedure ID to delete:");
            int id = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            String sql = "DELETE FROM MedicalProcedure WHERE id_medical_procedure = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, id);
                stmt.executeUpdate();
                System.out.println("Medical procedure deleted successfully!");
            }
        } catch (SQLException e) {
            System.out.println("Error deleting medical procedure: " + e.getMessage());
        }
    }
}
    
