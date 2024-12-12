
package com.mycompany.main.entity;

import com.mycompany.main.enums.TypeActivity;
import com.mycompany.main.persistence.ConnectionDB;
import java.sql.*;
import java.util.Date;
import java.util.Scanner;

public class SpecialActivitie {
    private int id_special_activity;
    private String name;
    private String descripcion;
    private Date date_special_activity;
    private String place;
    private TypeActivity type;

    public SpecialActivitie(int id_special_activity, String name, String descripcion, Date date_special_activity, String place, TypeActivity type) {
        this.id_special_activity = id_special_activity;
        this.name = name;
        this.descripcion = descripcion;
        this.date_special_activity = date_special_activity;
        this.place = place;
        this.type = type;
    }

    @Override
    public String toString() {
        return "SpecialActivities{" + "id_special_activity=" + id_special_activity + ", name=" + name + ", descripcion=" + descripcion + ", date_special_activity=" + date_special_activity + ", place=" + place + ", type=" + type + '}';
    }

    public int getId_special_activity() {
        return id_special_activity;
    }

    public void setId_special_activity(int id_special_activity) {
        this.id_special_activity = id_special_activity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getDate_special_activity() {
        return date_special_activity;
    }

    public void setDate_special_activity(Date date_special_activity) {
        this.date_special_activity = date_special_activity;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public TypeActivity getType() {
        return type;
    }

    public void setType(TypeActivity type) {
        this.type = type;
    }
    
    private static final Scanner scanner = new Scanner(System.in);

    public static void listSpecialActivities() {
        System.out.println("---- List of Special Activities ----");
        try (Connection conn = ConnectionDB.getConnection()) {
            String query = "SELECT * FROM SpecialActivities";
            try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
                while (rs.next()) {
                    int id = rs.getInt("id_special_activity");
                    String name = rs.getString("name");
                    String description = rs.getString("description");
                    Date dateActivity = rs.getDate("date_special_activity");
                    String place = rs.getString("place");
                    String type = rs.getString("type");

                    System.out.printf("ID: %d, Name: %s, Description: %s, Date: %s, Place: %s, Type: %s\n",
                            id, name, description, dateActivity, place, type);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void registerSpecialActivity() {
        System.out.println("---- Register Special Activity ----");
        scanner.nextLine(); // Consumir salto de línea

        System.out.print("Enter Activity Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Description: ");
        String description = scanner.nextLine();

        System.out.print("Enter Date (YYYY-MM-DD): ");
        String dateActivity = scanner.nextLine();

        System.out.print("Enter Place: ");
        String place = scanner.nextLine();

        System.out.print("Enter Type (Vaccination, Adoption, Training, Health Check): ");
        String type = scanner.nextLine();

        try (Connection conn = ConnectionDB.getConnection()) {
            String query = "INSERT INTO SpecialActivities (name, description, date_special_activity, place, type) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setString(1, name);
                stmt.setString(2, description);
                stmt.setString(3, dateActivity);
                stmt.setString(4, place);
                stmt.setString(5, type);

                stmt.executeUpdate();
                System.out.println("Special activity registered successfully.");
            }
        } catch (SQLException e) {
            System.out.println("Error saving the special activity: " + e.getMessage());
        }
    }

    public static void editSpecialActivity() {
        System.out.println("---- Edit Special Activity ----");
        System.out.print("Enter Activity ID to edit: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir salto de línea

        System.out.print("Enter new Activity Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter new Description: ");
        String description = scanner.nextLine();

        System.out.print("Enter new Date (YYYY-MM-DD): ");
        String dateActivity = scanner.nextLine();

        System.out.print("Enter new Place: ");
        String place = scanner.nextLine();

        System.out.print("Enter new Type (Vaccination, Adoption, Training, Health Check): ");
        String type = scanner.nextLine();

        try (Connection conn = ConnectionDB.getConnection()) {
            String query = "UPDATE SpecialActivities SET name = ?, description = ?, date_special_activity = ?, place = ?, type = ? WHERE id_special_activity = ?";
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setString(1, name);
                stmt.setString(2, description);
                stmt.setString(3, dateActivity);
                stmt.setString(4, place);
                stmt.setString(5, type);
                stmt.setInt(6, id);

                int rowsAffected = stmt.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Special activity updated successfully.");
                } else {
                    System.out.println("Special activity not found.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteSpecialActivity() {
        System.out.println("---- Delete Special Activity ----");
        System.out.print("Enter Activity ID to delete: ");
        int id = scanner.nextInt();

        try (Connection conn = ConnectionDB.getConnection()) {
            String query = "DELETE FROM SpecialActivities WHERE id_special_activity = ?";
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setInt(1, id);

                int rowsAffected = stmt.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Special activity deleted successfully.");
                } else {
                    System.out.println("Special activity not found.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}