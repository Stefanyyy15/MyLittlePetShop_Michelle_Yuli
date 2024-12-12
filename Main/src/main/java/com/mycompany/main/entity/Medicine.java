
package com.mycompany.main.entity;

import com.mycompany.main.enums.Type;
import com.mycompany.main.persistence.ConnectionDB;
import static com.mycompany.main.persistence.ConnectionDB.getConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Scanner;

public class Medicine {

    private int int_medicine;
    private Type type;
    private String manufacturer;
    private Date due_date;
    private PharmaceuticalProduct pharmaceutical_product;
    private String dosage;

    public Medicine(int int_medicine, Type type, String manufacturer, Date due_date, PharmaceuticalProduct pharmaceutical_product, String dosage) {
        this.int_medicine = int_medicine;
        this.type = type;
        this.manufacturer = manufacturer;
        this.due_date = due_date;
        this.pharmaceutical_product = pharmaceutical_product;
        this.dosage = dosage;
    }

    public int getInt_medicine() {
        return int_medicine;
    }

    public void setInt_medicine(int int_medicine) {
        this.int_medicine = int_medicine;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Date getDue_date() {
        return due_date;
    }

    public void setDue_date(Date due_date) {
        this.due_date = due_date;
    }

    public PharmaceuticalProduct getPharmaceutical_product() {
        return pharmaceutical_product;
    }

    public void setPharmaceutical_product(PharmaceuticalProduct pharmaceutical_product) {
        this.pharmaceutical_product = pharmaceutical_product;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public class MedicineCRUD {

        private static Scanner scanner = new Scanner(System.in);

        // Método para registrar un medicamento
        public static void registerMedicine() {
            System.out.println("---- Register Medicine ----");

            String type = inputWithValidation(scanner, "Enter Type (Antibiotic/Anti-inflammatory/Antiparasitic): ", "Antibiotic|Anti-inflammatory|Antiparasitic", "Invalid type.");
            String manufacturer = inputWithValidation(scanner, "Enter Manufacturer: ", ".+", "Manufacturer cannot be empty.");
            String dueDate = inputWithValidation(scanner, "Enter Due Date (yyyy-mm-dd): ", "\\d{4}-\\d{2}-\\d{2}", "Invalid date format.");
            listPharmaceuticalProducts();
            int pharmaceuticalProductId = Integer.parseInt(inputWithValidation(scanner, "Enter Pharmaceutical Product ID: ", "\\d+", "Invalid ID."));
            String dosage = inputOptional(scanner, "Enter Dosage (optional): ");

            try (Connection conn = ConnectionDB.getConnection()) {
                String query = "INSERT INTO Medicines (type, manufacturer, due_date, id_pharmaceutical_product, dosage) VALUES (?, ?, ?, ?, ?)";
                try (PreparedStatement stmt = conn.prepareStatement(query)) {
                    stmt.setString(1, type);
                    stmt.setString(2, manufacturer);
                    stmt.setDate(3, dueDate.isBlank() ? null : java.sql.Date.valueOf(dueDate));
                    stmt.setInt(4, pharmaceuticalProductId);
                    stmt.setString(5, dosage.isBlank() ? null : dosage);
                    stmt.executeUpdate();
                    System.out.println("Medicine registered successfully.");
                }
            } catch (SQLException e) {
                System.out.println("Error saving the medicine: " + e.getMessage());
            }
        }

        // Método para editar un medicamento
        public static void editMedicine() {
            System.out.println("---- Edit Medicine ----");

            System.out.print("Enter the Medicine ID to edit: ");
            int medicineId = Integer.parseInt(scanner.nextLine());

            try (Connection conn = ConnectionDB.getConnection()) {
                String query = "SELECT * FROM Medicines WHERE id_medicine = ?";
                try (PreparedStatement stmt = conn.prepareStatement(query)) {
                    stmt.setInt(1, medicineId);
                    try (ResultSet rs = stmt.executeQuery()) {
                        if (!rs.next()) {
                            System.out.println("Medicine not found.");
                            return;
                        }

                        System.out.println("Medicine found. Enter new values (leave blank to keep current value):");
                        String type = inputOptional(scanner, "Enter Type (Antibiotic/Anti-inflammatory/Antiparasitic): [Current: " + rs.getString("type") + "] ");
                        String manufacturer = inputOptional(scanner, "Enter Manufacturer: [Current: " + rs.getString("manufacturer") + "] ");
                        String dueDate = inputOptional(scanner, "Enter Due Date (yyyy-mm-dd): [Current: " + rs.getDate("due_date") + "] ");
                        String pharmaceuticalProductId = inputOptional(scanner, "Enter Pharmaceutical Product ID: [Current: " + rs.getInt("id_pharmaceutical_product") + "] ");
                        String dosage = inputOptional(scanner, "Enter Dosage: [Current: " + rs.getString("dosage") + "] ");

                        query = "UPDATE Medicines SET type = COALESCE(?, type), manufacturer = COALESCE(?, manufacturer), due_date = COALESCE(?, due_date), id_pharmaceutical_product = COALESCE(?, id_pharmaceutical_product), dosage = COALESCE(?, dosage) WHERE id_medicine = ?";
                        try (PreparedStatement updateStmt = conn.prepareStatement(query)) {
                            updateStmt.setString(1, type.isBlank() ? null : type);
                            updateStmt.setString(2, manufacturer.isBlank() ? null : manufacturer);
                            updateStmt.setDate(3, dueDate.isBlank() ? null : java.sql.Date.valueOf(dueDate));
                            updateStmt.setString(4, pharmaceuticalProductId.isBlank() ? null : pharmaceuticalProductId);
                            updateStmt.setString(5, dosage.isBlank() ? null : dosage);
                            updateStmt.setInt(6, medicineId);

                            int rowsUpdated = updateStmt.executeUpdate();
                            if (rowsUpdated > 0) {
                                System.out.println("Medicine updated successfully.");
                            } else {
                                System.out.println("No changes were made.");
                            }
                        }
                    }
                }
            } catch (SQLException e) {
                System.out.println("Error updating the medicine: " + e.getMessage());
            }
        }

        // Método para eliminar un medicamento
        public static void deleteMedicine() {
            System.out.println("---- Delete Medicine ----");

            System.out.print("Enter the Medicine ID to delete: ");
            int medicineId = Integer.parseInt(scanner.nextLine());

            try (Connection conn = ConnectionDB.getConnection()) {
                String query = "DELETE FROM Medicines WHERE id_medicine = ?";
                try (PreparedStatement stmt = conn.prepareStatement(query)) {
                    stmt.setInt(1, medicineId);
                    int rowsDeleted = stmt.executeUpdate();
                    if (rowsDeleted > 0) {
                        System.out.println("Medicine deleted successfully.");
                    } else {
                        System.out.println("Medicine not found.");
                    }
                }
            } catch (SQLException e) {
                System.out.println("Error deleting the medicine: " + e.getMessage());
            }
        }

        // Método para ver un medicamento
        public static void viewMedicine() {
            System.out.println("---- View Medicine ----");

            System.out.print("Enter the Medicine ID to view: ");
            int medicineId = Integer.parseInt(scanner.nextLine());

            try (Connection conn = ConnectionDB.getConnection()) {
                String query = "SELECT * FROM Medicines WHERE id_medicine = ?";
                try (PreparedStatement stmt = conn.prepareStatement(query)) {
                    stmt.setInt(1, medicineId);
                    try (ResultSet rs = stmt.executeQuery()) {
                        if (rs.next()) {
                            System.out.println("Medicine Details:");
                            System.out.println("ID: " + rs.getInt("id_medicine"));
                            System.out.println("Type: " + rs.getString("type"));
                            System.out.println("Manufacturer: " + rs.getString("manufacturer"));
                            System.out.println("Due Date: " + rs.getDate("due_date"));
                            System.out.println("Pharmaceutical Product ID: " + rs.getInt("id_pharmaceutical_product"));
                            System.out.println("Dosage: " + rs.getString("dosage"));
                        } else {
                            System.out.println("Medicine not found.");
                        }
                    }
                }
            } catch (SQLException e) {
                System.out.println("Error viewing the medicine: " + e.getMessage());
            }
        }

        // Método para listar medicamentos
        public static void listMedicines() {
            try (Connection conn = ConnectionDB.getConnection()) {
                String query = "SELECT * FROM Medicines";
                try (PreparedStatement stmt = conn.prepareStatement(query); ResultSet rs = stmt.executeQuery()) {

                    System.out.println("---- List of Medicines ----");
                    while (rs.next()) {
                        System.out.println("ID: " + rs.getInt("id_medicine"));
                        System.out.println("Type: " + rs.getString("type"));
                        System.out.println("Manufacturer: " + rs.getString("manufacturer"));
                        System.out.println("Due Date: " + rs.getDate("due_date"));
                        System.out.println("Pharmaceutical Product ID: " + rs.getInt("id_pharmaceutical_product"));
                        System.out.println("Dosage: " + rs.getString("dosage"));
                        System.out.println("--------------------------");
                    }
                }
            } catch (SQLException e) {
                System.out.println("Error listing medicines: " + e.getMessage());
            }
        }

        // Método para listar productos farmacéuticos
        // Listar productos farmacéuticos
        public static void listPharmaceuticalProducts() {
            System.out.println("---- List of Pharmaceutical Products ----");
            try (Connection conn = getConnection()) {
                String query = "SELECT * FROM PharmaceuticalProduct";
                try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
                    while (rs.next()) {
                        int id = rs.getInt("id_pharmaceutical_product");
                        String name = rs.getString("name");
                        System.out.printf("ID: %d, Name: %s\n", id, name);
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        // Método para entrada con validación
        private static String inputWithValidation(Scanner scanner, String prompt, String regex, String errorMessage) {
            while (true) {
                System.out.print(prompt);
                String input = scanner.nextLine();
                if (input.matches(regex)) {
                    return input;
                }
                System.out.println(errorMessage);
            }
        }

        // Método para entrada opcional
        private static String inputOptional(Scanner scanner, String prompt) {
            System.out.print(prompt);
            return scanner.nextLine();
        }
    }

}
