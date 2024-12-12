package com.mycompany.main.entity;

import java.util.Date;
import com.mycompany.main.persistence.ConnectionDB;
import java.sql.*;
import java.util.Scanner;

public class Vaccine {
    private int id_vaccine;
    private String name;
    private String type;
    private Date date_entry;
    private Date due_date;
    private PharmaceuticalProduct pharmaceutical_product;
    private Specie id_specie;
    private String batch_number;

    public Vaccine(int id_vaccine, String name, String type, Date date_entry, Date due_date, PharmaceuticalProduct pharmaceutical_product, Specie id_specie, String batch_number) {
        this.id_vaccine = id_vaccine;
        this.name = name;
        this.type = type;
        this.date_entry = date_entry;
        this.due_date = due_date;
        this.pharmaceutical_product = pharmaceutical_product;
        this.id_specie = id_specie;
        this.batch_number = batch_number;
    }

    public int getId_vaccine() {
        return id_vaccine;
    }

    public void setId_vaccine(int id_vaccine) {
        this.id_vaccine = id_vaccine;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDate_entry() {
        return date_entry;
    }

    public void setDate_entry(Date date_entry) {
        this.date_entry = date_entry;
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

    public Specie getId_specie() {
        return id_specie;
    }

    public void setId_specie(Specie id_specie) {
        this.id_specie = id_specie;
    }

    public String getBatch_number() {
        return batch_number;
    }

    public void setBatch_number(String batch_number) {
        this.batch_number = batch_number;
    }
    
     private static final Scanner scanner = new Scanner(System.in);

    // Listar todas las vacunas
    public static void listVaccines() {
        System.out.println("---- List of Vaccines ----");
        try (Connection conn = ConnectionDB.getConnection()) {
            String query = "SELECT * FROM Vaccines";
            try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
                while (rs.next()) {
                    int id = rs.getInt("id_vaccine");
                    String name = rs.getString("name");
                    String type = rs.getString("type");
                    Date dateEntry = rs.getDate("date_entry");
                    Date dueDate = rs.getDate("due_date");
                    int idPharma = rs.getInt("id_pharmaceutical_product");
                    int idSpecies = rs.getInt("id_species");
                    String batchNumber = rs.getString("batch_number");

                    System.out.printf("ID: %d, Name: %s, Type: %s, Date Entry: %s, Due Date: %s, Pharma ID: %d, Species ID: %d, Batch Number: %s\n",
                            id, name, type, dateEntry, dueDate, idPharma, idSpecies, batchNumber);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Listar productos farmacéuticos
    public static void listPharmaceuticalProducts() {
        System.out.println("---- List of Pharmaceutical Products ----");
        try (Connection conn = ConnectionDB.getConnection()) {
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

    // Listar especies
    public static void listSpecies() {
        System.out.println("---- List of Species ----");
        try (Connection conn = ConnectionDB.getConnection()) {
            String query = "SELECT * FROM Species";
            try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
                while (rs.next()) {
                    int id = rs.getInt("id_species");
                    String name = rs.getString("name");
                    System.out.printf("ID: %d, Name: %s\n", id, name);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Registrar una nueva vacuna
    public static void registerVaccine() {
        System.out.println("---- Register Vaccine ----");
        scanner.nextLine(); // Consumir salto de línea

        System.out.print("Enter Vaccine Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Vaccine Type: ");
        String type = scanner.nextLine();

        System.out.print("Enter Date of Entry (YYYY-MM-DD): ");
        String dateEntry = scanner.nextLine();

        System.out.print("Enter Due Date (YYYY-MM-DD): ");
        String dueDate = scanner.nextLine();

        // Listar productos farmacéuticos y pedir ID
        listPharmaceuticalProducts();
        System.out.print("Enter Pharmaceutical Product ID: ");
        int pharmaId = scanner.nextInt();

        // Listar especies y pedir ID
        listSpecies();
        System.out.print("Enter Species ID: ");
        int speciesId = scanner.nextInt();

        scanner.nextLine(); // Consumir salto de línea
        System.out.print("Enter Batch Number: ");
        String batchNumber = scanner.nextLine();

        try (Connection conn = ConnectionDB.getConnection()) {
            String query = "INSERT INTO Vaccines (name, type, date_entry, due_date, id_pharmaceutical_product, id_species, batch_number) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setString(1, name);
                stmt.setString(2, type);
                stmt.setString(3, dateEntry);
                stmt.setString(4, dueDate);
                stmt.setInt(5, pharmaId);
                stmt.setInt(6, speciesId);
                stmt.setString(7, batchNumber);

                stmt.executeUpdate();
                System.out.println("Vaccine registered successfully.");
            }
        } catch (SQLException e) {
            System.out.println("Error saving the vaccine: " + e.getMessage());
        }
    }
}
