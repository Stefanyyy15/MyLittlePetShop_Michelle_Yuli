package com.mycompany.main.entity;

import java.sql.*;
import java.util.Scanner;
import java.util.regex.Pattern;
import com.mycompany.main.persistence.ConnectionDB;

public class MedicalSupplie {

    private int MedicalSupplies;
    private String type;
    private String supplies;
    private PharmaceuticalProduct id_pharmaceutical_product;

    public MedicalSupplie(int MedicalSupplies, String type, String supplies, PharmaceuticalProduct id_pharmaceutical_product) {
        this.MedicalSupplies = MedicalSupplies;
        this.type = type;
        this.supplies = supplies;
        this.id_pharmaceutical_product = id_pharmaceutical_product;
    }

    @Override
    public String toString() {
        return "MedicalSupplies{" + "MedicalSupplies=" + MedicalSupplies + ", type=" + type + ", supplies=" + supplies + ", id_pharmaceutical_product=" + id_pharmaceutical_product + '}';
    }

    public int getMedicalSupplies() {
        return MedicalSupplies;
    }

    public void setMedicalSupplies(int MedicalSupplies) {
        this.MedicalSupplies = MedicalSupplies;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSupplies() {
        return supplies;
    }

    public void setSupplies(String supplies) {
        this.supplies = supplies;
    }

    public PharmaceuticalProduct getId_pharmaceutical_product() {
        return id_pharmaceutical_product;
    }

    public void setId_pharmaceutical_product(PharmaceuticalProduct id_pharmaceutical_product) {
        this.id_pharmaceutical_product = id_pharmaceutical_product;
    }

    public class MedicalSuppliesCRUD {

        public static int registerNewMedicalSupply() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("---- Register New Medical Supply ----");

            String type = inputWithValidation(scanner, "Enter Type: ", "[A-Za-z0-9 ]+", "Invalid type. Only alphanumeric characters and spaces are allowed.");
            String supplies = inputWithValidation(scanner, "Enter Supplies Description: ", ".+", "Supplies description cannot be empty.");

            PharmaceuticalProduct pharmaceuticalProduct = selectPharmaceuticalProduct(scanner);

            try (Connection conn = ConnectionDB.getConnection()) {
                String query = "INSERT INTO MedicalSupplies (type, supplies, id_pharmaceutical_product) VALUES (?, ?, ?)";
                try (PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
                    stmt.setString(1, type);
                    stmt.setString(2, supplies);
                    stmt.setInt(3, pharmaceuticalProduct.getId_pharmaceutical_product());

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
                System.out.println("Error registering medical supply: " + e.getMessage());
            }
            return -1; // Retorna -1 en caso de error.
        }

        public static void listMedicalSupplies() {
            System.out.println("---- List of Medical Supplies ----");
            try (Connection conn = ConnectionDB.getConnection()) {
                String query = "SELECT ms.id_medical_supplies, ms.type, ms.supplies, pp.name AS product_name "
                        + "FROM MedicalSupplies ms "
                        + "LEFT JOIN PharmaceuticalProduct pp ON ms.id_pharmaceutical_product = pp.id_pharmaceutical_product";
                try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
                    while (rs.next()) {
                        int idMedicalSupplies = rs.getInt("id_medical_supplies");
                        String type = rs.getString("type");
                        String supplies = rs.getString("supplies");
                        String productName = rs.getString("product_name");

                        System.out.printf("ID: %d, Type: %s, Supplies: %s, Pharmaceutical Product: %s\n",
                                idMedicalSupplies, type, supplies,
                                productName != null ? productName : "Not Assigned");
                    }
                }
            } catch (SQLException e) {
                System.out.println("Error retrieving medical supplies: " + e.getMessage());
            }
        }

        public static void searchMedicalSuppliesByType() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("---- Search Medical Supplies by Type ----");
            String type = inputWithValidation(scanner, "Enter the Medical Supply Type to search: ", "[A-Za-z0-9 ]+", "Invalid type. Only alphanumeric characters and spaces are allowed.");

            try (Connection conn = ConnectionDB.getConnection()) {
                String query = "SELECT id_medical_supplies, type, supplies FROM MedicalSupplies WHERE type LIKE ?";
                try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                    pstmt.setString(1, "%" + type + "%");

                    try (ResultSet rs = pstmt.executeQuery()) {
                        boolean found = false;
                        while (rs.next()) {
                            found = true;
                            int idMedicalSupplies = rs.getInt("id_medical_supplies");
                            String foundType = rs.getString("type");
                            String supplies = rs.getString("supplies");

                            System.out.printf("ID: %d, Type: %s, Supplies: %s\n",
                                    idMedicalSupplies, foundType, supplies);
                        }

                        if (!found) {
                            System.out.println("No medical supplies found with the provided type.");
                        }
                    }
                }
            } catch (SQLException e) {
                System.out.println("Error retrieving medical supplies: " + e.getMessage());
            }
        }

        public static void editMedicalSupply() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("---- Edit Medical Supply ----");
            System.out.print("Enter Medical Supply ID to edit: ");
            int medicalSuppliesId = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            String type = inputWithValidation(scanner, "Enter new Type: ", "[A-Za-z0-9 ]+", "Invalid type. Only alphanumeric characters and spaces are allowed.");
            String supplies = inputWithValidation(scanner, "Enter new Supplies Description: ", ".+", "Supplies description cannot be empty.");

            PharmaceuticalProduct pharmaceuticalProduct = selectPharmaceuticalProduct(scanner);

            try (Connection conn = ConnectionDB.getConnection()) {
                String query = "UPDATE MedicalSupplies SET type = ?, supplies = ?, id_pharmaceutical_product = ? WHERE id_medical_supplies = ?";
                try (PreparedStatement stmt = conn.prepareStatement(query)) {
                    stmt.setString(1, type);
                    stmt.setString(2, supplies);
                    stmt.setInt(3, pharmaceuticalProduct.getId_pharmaceutical_product());
                    stmt.setInt(4, medicalSuppliesId);

                    int rowsAffected = stmt.executeUpdate();
                    if (rowsAffected > 0) {
                        System.out.println("Medical Supply updated successfully.");
                    } else {
                        System.out.println("Medical Supply not found.");
                    }
                }
            } catch (SQLException e) {
                System.out.println("Error updating medical supply: " + e.getMessage());
            }
        }

        public static void deleteMedicalSupply() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("---- Delete Medical Supply ----");
            System.out.print("Enter Medical Supply ID to delete: ");
            int medicalSuppliesId = scanner.nextInt();

            try (Connection conn = ConnectionDB.getConnection()) {
                String query = "DELETE FROM MedicalSupplies WHERE id_medical_supplies = ?";
                try (PreparedStatement stmt = conn.prepareStatement(query)) {
                    stmt.setInt(1, medicalSuppliesId);
                    int rowsAffected = stmt.executeUpdate();
                    if (rowsAffected > 0) {
                        System.out.println("Medical Supply deleted successfully.");
                    } else {
                        System.out.println("Medical Supply not found.");
                    }
                }
            } catch (SQLException e) {
                System.out.println("Error deleting medical supply: " + e.getMessage());
            }
        }

        private static PharmaceuticalProduct selectPharmaceuticalProduct(Scanner scanner) {
            System.out.println("Select Pharmaceutical Product:");

            // Primero, listar los productos farmacéuticos disponibles
            try (Connection conn = ConnectionDB.getConnection()) {
                String query = "SELECT id_pharmaceutical_product, name FROM PharmaceuticalProduct";
                try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {

                    while (rs.next()) {
                        int id = rs.getInt("id_pharmaceutical_product");
                        String name = rs.getString("name");
                        System.out.printf("%d. %s\n", id, name);
                    }
                    System.out.println("0. No Product");
                }
            } catch (SQLException e) {
                System.out.println("Error retrieving pharmaceutical products: " + e.getMessage());
                return null;
            }

            // Selección del producto
            while (true) {
                try {
                    System.out.print("Enter Pharmaceutical Product ID: ");
                    int productId = Integer.parseInt(scanner.nextLine().trim());

                    if (productId == 0) {
                        return null;
                    }

                    try (Connection conn = ConnectionDB.getConnection()) {
                        String query = "SELECT * FROM PharmaceuticalProduct WHERE id_pharmaceutical_product = ?";
                        try (PreparedStatement stmt = conn.prepareStatement(query)) {
                            stmt.setInt(1, productId);
                            try (ResultSet rs = stmt.executeQuery()) {
                                if (rs.next()) {
                                    return new PharmaceuticalProduct(
                                            productId,
                                            rs.getString("name"),
                                            rs.getString("description"),
                                            rs.getDouble("price")
                                    );
                                }
                            }
                        }
                    }

                    System.out.println("Invalid Pharmaceutical Product ID. Please try again.");
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a valid number.");
                } catch (SQLException e) {
                    System.out.println("Error validating pharmaceutical product: " + e.getMessage());
                    return null;
                }
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
    }
}
