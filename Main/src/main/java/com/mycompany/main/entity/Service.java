package com.mycompany.main.entity;

import com.mycompany.main.enums.Category;
import java.util.Date;
import com.mycompany.main.persistence.ConnectionDB;
import java.sql.*;
import java.util.Scanner;

public class Service {
    private int id_service;
    private String name;
    private Date date_service;
    private Double price;
    private String details;
    private Category category;

    @Override
    public String toString() {
        return "Services{" + "id_service=" + 
                id_service + ", name=" + 
                name + ", date_service=" + 
                date_service + ", price=" + 
                price + ", details=" + 
                details + ", category=" + 
                category + '}';
    }

    public int getId_service() {
        return id_service;
    }

    public void setId_service(int id_service) {
        this.id_service = id_service;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate_service() {
        return date_service;
    }

    public void setDate_service(Date date_service) {
        this.date_service = date_service;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
    
    private static final Scanner scanner = new Scanner(System.in);

    public static void listServices() {
        System.out.println("---- List of Services ----");
        try (Connection conn = ConnectionDB.getConnection()) {
            String query = "SELECT * FROM Services";
            try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
                while (rs.next()) {
                    int id = rs.getInt("id_service");
                    String name = rs.getString("name");
                    Date dateService = rs.getDate("date_service");
                    double price = rs.getDouble("price");
                    String details = rs.getString("details");
                    String category = rs.getString("category");

                    System.out.printf("ID: %d, Name: %s, Date: %s, Price: %.2f, Details: %s, Category: %s\n",
                            id, name, dateService, price, details, category);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Registrar un nuevo servicio
    public static void registerService() {
        System.out.println("---- Register Service ----");
        scanner.nextLine(); // Consumir salto de línea

        System.out.print("Enter Service Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Service Date (YYYY-MM-DD): ");
        String dateService = scanner.nextLine();

        System.out.print("Enter Price: ");
        double price = scanner.nextDouble();

        scanner.nextLine(); // Consumir salto de línea
        System.out.print("Enter Details: ");
        String details = scanner.nextLine();

        System.out.print("Enter Category (Grooming, Medical, Training, Boarding): ");
        String category = scanner.nextLine();

        try (Connection conn = ConnectionDB.getConnection()) {
            String query = "INSERT INTO Services (name, date_service, price, details, category) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setString(1, name);
                stmt.setString(2, dateService);
                stmt.setDouble(3, price);
                stmt.setString(4, details);
                stmt.setString(5, category);

                stmt.executeUpdate();
                System.out.println("Service registered successfully.");
            }
        } catch (SQLException e) {
            System.out.println("Error saving the service: " + e.getMessage());
        }
    }

    // Actualizar un servicio
    public static void editService() {
        System.out.println("---- Edit Service ----");
        System.out.print("Enter Service ID to edit: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir salto de línea

        System.out.print("Enter new Service Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter new Service Date (YYYY-MM-DD): ");
        String dateService = scanner.nextLine();

        System.out.print("Enter new Price: ");
        double price = scanner.nextDouble();

        scanner.nextLine(); // Consumir salto de línea
        System.out.print("Enter new Details: ");
        String details = scanner.nextLine();

        System.out.print("Enter new Category (Grooming, Medical, Training, Boarding): ");
        String category = scanner.nextLine();

        try (Connection conn = ConnectionDB.getConnection()) {
            String query = "UPDATE Services SET name = ?, date_service = ?, price = ?, details = ?, category = ? WHERE id_service = ?";
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setString(1, name);
                stmt.setString(2, dateService);
                stmt.setDouble(3, price);
                stmt.setString(4, details);
                stmt.setString(5, category);
                stmt.setInt(6, id);

                int rowsAffected = stmt.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Service updated successfully.");
                } else {
                    System.out.println("Service not found.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Eliminar un servicio
    public static void deleteService() {
        System.out.println("---- Delete Service ----");
        System.out.print("Enter Service ID to delete: ");
        int id = scanner.nextInt();

        try (Connection conn = ConnectionDB.getConnection()) {
            String query = "DELETE FROM Services WHERE id_service = ?";
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setInt(1, id);

                int rowsAffected = stmt.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Service deleted successfully.");
                } else {
                    System.out.println("Service not found.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
