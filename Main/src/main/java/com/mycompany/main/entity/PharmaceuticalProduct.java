package com.mycompany.main.entity;

import com.mycompany.main.enums.ProductType;
import com.mycompany.main.persistence.ConnectionDB;
import java.util.Date;
import java.sql.*;
import java.util.Scanner;
import java.util.regex.Pattern;

public class PharmaceuticalProduct {

    private int id_pharmaceutical_product;
    private String name;
    private String description;
    private double price;
    private int stock_quantity;
    private Date expiration_date;
    private String manufacturer;
    private ProductType product_type;

    public PharmaceuticalProduct(int id_pharmaceutical_product, String name, String description, double price, int stock_quantity, Date expiration_date, String manufacturer, ProductType product_type) {
        this.id_pharmaceutical_product = id_pharmaceutical_product;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock_quantity = stock_quantity;
        this.expiration_date = expiration_date;
        this.manufacturer = manufacturer;
        this.product_type = product_type;
    }

    public PharmaceuticalProduct(int id_pharmaceutical_product, String name, String description, double price) {
        this.id_pharmaceutical_product = id_pharmaceutical_product;
        this.name = name;
        this.description = description;
        this.price = price;
    }
    

    public int getId_pharmaceutical_product() {
        return id_pharmaceutical_product;
    }

    public void setId_pharmaceutical_product(int id_pharmaceutical_product) {
        this.id_pharmaceutical_product = id_pharmaceutical_product;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock_quantity() {
        return stock_quantity;
    }

    public void setStock_quantity(int stock_quantity) {
        this.stock_quantity = stock_quantity;
    }

    public Date getExpiration_date() {
        return expiration_date;
    }

    public void setExpiration_date(Date expiration_date) {
        this.expiration_date = expiration_date;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public ProductType getProduct_type() {
        return product_type;
    }

    public void setProduct_type(ProductType product_type) {
        this.product_type = product_type;
    }

    public class PharmaceuticalProductCRUD {

        private static final Scanner scanner = new Scanner(System.in);

        public static void listPharmaceuticalProducts() {
            System.out.println("---- List of Pharmaceutical Products ----");
            try (Connection conn = ConnectionDB.getConnection()) {
                String query = "SELECT * FROM PharmaceuticalProduct";
                try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
                    while (rs.next()) {
                        int id = rs.getInt("id_pharmaceutical_product");
                        String name = rs.getString("name");
                        String description = rs.getString("description");
                        double price = rs.getDouble("price");
                        int stock = rs.getInt("stock_quantity");
                        Date expiration = rs.getDate("expiration_date");
                        String manufacturer = rs.getString("manufacturer");
                        String productType = rs.getString("product_type");

                        System.out.printf("ID: %d, Name: %s, Description: %s, Price: %.2f, Stock: %d, Expiration: %s, Manufacturer: %s, Type: %s\n",
                                id, name, description, price, stock, expiration, manufacturer, productType);
                    }
                }
            } catch (SQLException e) {
                System.out.println("Error retrieving pharmaceutical products: " + e.getMessage());
            }
        }

        public static void registerPharmaceuticalProduct() {
            System.out.println("---- Register Pharmaceutical Product ----");

            String name = inputWithValidation(scanner,
                    "Enter Product Name: ",
                    "[A-Za-z0-9 ]+",
                    "Invalid name. Only letters, numbers, and spaces allowed.");

            String description = inputOptional(scanner, "Enter Description: ");

            double price = inputDoubleWithValidation(scanner,
                    "Enter Price: ",
                    "Invalid price. Please enter a positive number.");

            int stockQuantity = inputIntWithValidation(scanner,
                    "Enter Stock Quantity: ",
                    "Invalid stock quantity. Please enter a non-negative number.");

            String expirationDate = inputWithValidation(scanner,
                    "Enter Expiration Date (YYYY-MM-DD): ",
                    "\\d{4}-\\d{2}-\\d{2}",
                    "Invalid date format. Use YYYY-MM-DD.");

            String manufacturer = inputWithValidation(scanner,
                    "Enter Manufacturer: ",
                    "[A-Za-z0-9 ]+",
                    "Invalid manufacturer name. Only letters, numbers, and spaces allowed.");

            String productType = inputWithValidation(scanner,
                    "Enter Product Type (Medicine, Vaccine, Supply): ",
                    "Medicine|Vaccine|Supply",
                    "Invalid product type. Choose from: Medicine, Vaccine, Supply.");

            try (Connection conn = ConnectionDB.getConnection()) {
                String query = "INSERT INTO PharmaceuticalProduct (name, description, price, stock_quantity, expiration_date, manufacturer, product_type) "
                        + "VALUES (?, ?, ?, ?, ?, ?, ?)";
                try (PreparedStatement stmt = conn.prepareStatement(query)) {
                    stmt.setString(1, name);
                    stmt.setString(2, description);
                    stmt.setDouble(3, price);
                    stmt.setInt(4, stockQuantity);
                    stmt.setString(5, expirationDate);
                    stmt.setString(6, manufacturer);
                    stmt.setString(7, productType);

                    int rowsInserted = stmt.executeUpdate();
                    if (rowsInserted > 0) {
                        System.out.println("Pharmaceutical Product registered successfully.");
                    }
                }
            } catch (SQLException e) {
                System.out.println("Error saving the pharmaceutical product: " + e.getMessage());
            }
        }

        public static void editPharmaceuticalProduct() {
            System.out.println("---- Edit Pharmaceutical Product ----");
            listPharmaceuticalProducts();
            int productId = inputInt(scanner, "Enter Product ID to edit: ");

            String name = inputWithValidation(scanner,
                    "Enter new Product Name: ",
                    "[A-Za-z0-9 ]+",
                    "Invalid name. Only letters, numbers, and spaces allowed.");

            String description = inputOptional(scanner, "Enter new Description: ");

            double price = inputDoubleWithValidation(scanner,
                    "Enter new Price: ",
                    "Invalid price. Please enter a positive number.");

            int stockQuantity = inputIntWithValidation(scanner,
                    "Enter new Stock Quantity: ",
                    "Invalid stock quantity. Please enter a non-negative number.");

            String expirationDate = inputWithValidation(scanner,
                    "Enter new Expiration Date (YYYY-MM-DD): ",
                    "\\d{4}-\\d{2}-\\d{2}",
                    "Invalid date format. Use YYYY-MM-DD.");

            String manufacturer = inputWithValidation(scanner,
                    "Enter new Manufacturer: ",
                    "[A-Za-z0-9 ]+",
                    "Invalid manufacturer name. Only letters, numbers, and spaces allowed.");

            String productType = inputWithValidation(scanner,
                    "Enter new Product Type (Medicine, Vaccine, Supply): ",
                    "Medicine|Vaccine|Supply",
                    "Invalid product type. Choose from: Medicine, Vaccine, Supply.");

            try (Connection conn = ConnectionDB.getConnection()) {
                String query = "UPDATE PharmaceuticalProduct SET name = ?, description = ?, price = ?, stock_quantity = ?, "
                        + "expiration_date = ?, manufacturer = ?, product_type = ? WHERE id_pharmaceutical_product = ?";
                try (PreparedStatement stmt = conn.prepareStatement(query)) {
                    stmt.setString(1, name);
                    stmt.setString(2, description);
                    stmt.setDouble(3, price);
                    stmt.setInt(4, stockQuantity);
                    stmt.setString(5, expirationDate);
                    stmt.setString(6, manufacturer);
                    stmt.setString(7, productType);
                    stmt.setInt(8, productId);

                    int rowsAffected = stmt.executeUpdate();
                    if (rowsAffected > 0) {
                        System.out.println("Pharmaceutical Product updated successfully.");
                    } else {
                        System.out.println("Pharmaceutical Product not found.");
                    }
                }
            } catch (SQLException e) {
                System.out.println("Error updating pharmaceutical product: " + e.getMessage());
            }
        }

        public static void deletePharmaceuticalProduct() {
            System.out.println("---- Delete Pharmaceutical Product ----");

            int productId = inputInt(scanner, "Enter Product ID to delete: ");

            try (Connection conn = ConnectionDB.getConnection()) {
                String query = "DELETE FROM PharmaceuticalProduct WHERE id_pharmaceutical_product = ?";
                try (PreparedStatement stmt = conn.prepareStatement(query)) {
                    stmt.setInt(1, productId);

                    int rowsAffected = stmt.executeUpdate();
                    if (rowsAffected > 0) {
                        System.out.println("Pharmaceutical Product deleted successfully.");
                    } else {
                        System.out.println("Pharmaceutical Product not found.");
                    }
                }
            } catch (SQLException e) {
                System.out.println("Error deleting pharmaceutical product: " + e.getMessage());
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

        private static int inputIntWithValidation(Scanner scanner, String prompt, String errorMessage) {
            while (true) {
                try {
                    System.out.print(prompt);
                    int value = Integer.parseInt(scanner.nextLine().trim());
                    if (value >= 0) {
                        return value;
                    }
                    System.out.println(errorMessage);
                } catch (NumberFormatException e) {
                    System.out.println(errorMessage);
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
    }
}
