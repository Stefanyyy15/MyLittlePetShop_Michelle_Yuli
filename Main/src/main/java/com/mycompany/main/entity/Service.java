package com.mycompany.main.entity;

import com.mycompany.main.enums.Category;
import java.util.Date;
import com.mycompany.main.persistence.ConnectionDB;
import java.sql.*;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Service {

    private int id_service;
    private String name;
    private Date date_service;
    private Double price;
    private String details;
    private Category category;

    @Override
    public String toString() {
        return "Services{" + "id_service="
                + id_service + ", name="
                + name + ", date_service="
                + date_service + ", price="
                + price + ", details="
                + details + ", category="
                + category + '}';
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
            System.out.println("Error retrieving services: " + e.getMessage());
        }
    }

    public static void registerService() {
        System.out.println("---- Register Service ----");

        String name = inputWithValidation(scanner, "Enter Service Name: ", "[A-Za-z0-9 ]+", "Invalid name. Only letters, numbers, and spaces allowed.");

        String dateService = inputWithValidation(scanner, "Enter Service Date (YYYY-MM-DD): ",
                "\\d{4}-\\d{2}-\\d{2}", "Invalid date format. Use YYYY-MM-DD.");

        double price = inputDoubleWithValidation(scanner, "Enter Price: ", "Invalid price. Please enter a positive number.");

        String details = inputOptional(scanner, "Enter Details: ");

        String category = inputWithValidation(scanner,
                "Enter Category (Grooming, Medical, Training, Boarding): ",
                "Grooming|Medical|Training|Boarding",
                "Invalid category. Choose from: Grooming, Medical, Training, Boarding.");

        try (Connection conn = ConnectionDB.getConnection()) {
            String query = "INSERT INTO Services (name, date_service, price, details, category) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setString(1, name);
                stmt.setString(2, dateService);
                stmt.setDouble(3, price);
                stmt.setString(4, details);
                stmt.setString(5, category);

                int rowsInserted = stmt.executeUpdate();
                if (rowsInserted > 0) {
                    System.out.println("Service registered successfully.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Error saving the service: " + e.getMessage());
        }
    }

    public static void editService() {
        System.out.println("---- Edit Service ----");
        listServices();
        int serviceId = inputInt(scanner, "Enter Service ID to edit: ");

        String name = inputWithValidation(scanner, "Enter new Service Name: ",
                "[A-Za-z0-9 ]+", "Invalid name. Only letters, numbers, and spaces allowed.");

        String dateService = inputWithValidation(scanner, "Enter new Service Date (YYYY-MM-DD): ",
                "\\d{4}-\\d{2}-\\d{2}", "Invalid date format. Use YYYY-MM-DD.");

        double price = inputDoubleWithValidation(scanner, "Enter new Price: ",
                "Invalid price. Please enter a positive number.");

        String details = inputOptional(scanner, "Enter new Details: ");

        String category = inputWithValidation(scanner,
                "Enter new Category (Grooming, Medical, Training, Boarding): ",
                "Grooming|Medical|Training|Boarding",
                "Invalid category. Choose from: Grooming, Medical, Training, Boarding.");

        try (Connection conn = ConnectionDB.getConnection()) {
            String query = "UPDATE Services SET name = ?, date_service = ?, price = ?, details = ?, category = ? WHERE id_service = ?";
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setString(1, name);
                stmt.setString(2, dateService);
                stmt.setDouble(3, price);
                stmt.setString(4, details);
                stmt.setString(5, category);
                stmt.setInt(6, serviceId);

                int rowsAffected = stmt.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Service updated successfully.");
                } else {
                    System.out.println("Service not found.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Error updating service: " + e.getMessage());
        }
    }

    public static void deleteService() {
        System.out.println("---- Delete Service ----");

        int serviceId = inputInt(scanner, "Enter Service ID to delete: ");

        try (Connection conn = ConnectionDB.getConnection()) {
            String query = "DELETE FROM Services WHERE id_service = ?";
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setInt(1, serviceId);

                int rowsAffected = stmt.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Service deleted successfully.");
                } else {
                    System.out.println("Service not found.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Error deleting service: " + e.getMessage());
        }
    }

    // Utility methods similar to those in the Owner management class
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
}