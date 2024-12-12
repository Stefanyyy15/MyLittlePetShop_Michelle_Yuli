package com.mycompany.main.entity;

import com.mycompany.main.enums.ProductType;
import com.mycompany.main.persistence.ConnectionDB;
import java.util.Date;
import java.sql.*;
import java.util.Scanner;

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

    public PharmaceuticalProduct(int id, String name, String description, double price) {
        this.id_pharmaceutical_product = id;
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

    // Listar todos los productos farmacéuticos
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
            e.printStackTrace();
        }
    }

    // Registrar un nuevo producto farmacéutico
    public static void registerPharmaceuticalProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("---- Register Pharmaceutical Product ----");

        System.out.print("Enter Product Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Description: ");
        String description = scanner.nextLine();

        System.out.print("Enter Price: ");
        double price = scanner.nextDouble();

        System.out.print("Enter Stock Quantity: ");
        int stockQuantity = scanner.nextInt();

        scanner.nextLine(); // Consumir salto de línea
        System.out.print("Enter Expiration Date (YYYY-MM-DD): ");
        String expirationDate = scanner.nextLine();

        System.out.print("Enter Manufacturer: ");
        String manufacturer = scanner.nextLine();

        System.out.print("Enter Product Type (Medicine, Supply): ");
        String productType = scanner.nextLine();

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

                stmt.executeUpdate();
                System.out.println("Pharmaceutical Product registered successfully.");
            }
        } catch (SQLException e) {
            System.out.println("Error saving the pharmaceutical product: " + e.getMessage());
        }
    }

    // Actualizar un producto farmacéutico
    public static void editPharmaceuticalProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("---- Edit Pharmaceutical Product ----");
        System.out.print("Enter Product ID to edit: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir salto de línea

        System.out.print("Enter new Product Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter new Description: ");
        String description = scanner.nextLine();

        System.out.print("Enter new Price: ");
        double price = scanner.nextDouble();

        System.out.print("Enter new Stock Quantity: ");
        int stockQuantity = scanner.nextInt();

        scanner.nextLine(); // Consumir salto de línea
        System.out.print("Enter new Expiration Date (YYYY-MM-DD): ");
        String expirationDate = scanner.nextLine();

        System.out.print("Enter new Manufacturer: ");
        String manufacturer = scanner.nextLine();

        System.out.print("Enter new Product Type (Medicine, Vaccine, Supply): ");
        String productType = scanner.nextLine();

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
                stmt.setInt(8, id);

                int rowsAffected = stmt.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Pharmaceutical Product updated successfully.");
                } else {
                    System.out.println("Pharmaceutical Product not found.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Eliminar un producto farmacéutico
    public static void deletePharmaceuticalProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("---- Delete Pharmaceutical Product ----");
        System.out.print("Enter Product ID to delete: ");
        int id = scanner.nextInt();

        try (Connection conn = ConnectionDB.getConnection()) {
            String query = "DELETE FROM PharmaceuticalProduct WHERE id_pharmaceutical_product = ?";
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setInt(1, id);

                int rowsAffected = stmt.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Pharmaceutical Product deleted successfully.");
                } else {
                    System.out.println("Pharmaceutical Product not found.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}