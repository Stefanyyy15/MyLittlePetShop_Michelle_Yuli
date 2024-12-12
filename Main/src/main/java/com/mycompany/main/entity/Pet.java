package com.mycompany.main.entity;

import com.mycompany.main.entity.Owner.OwnerCRUD;
import com.mycompany.main.enums.Gender;
import com.mycompany.main.enums.AdoptionStatus;
import com.mycompany.main.persistence.ConnectionDB;
import java.sql.*;
import java.util.Scanner;

public class Pet {

    private int id_pet;
    private String name;
    private Specie id_specie;
    private String breed;
    private Date date_birth; // para el formato de fecha 
    private Gender gender;
    private int weight;
    private int height;
    private String microchip_number;
    private boolean tatto;
    private long photo;
    private String dryfood;
    private int numbertimes;
    private String allergies;
    private String chronic_conditions;
    private Date last_veterinary_visit;
    private AdoptionStatus adoption_status;
    private Owner id_owner;
    private Sickness sickness;

    public Pet(String name, Specie id_specie, String breed, Date date_birth, Gender gender, int weight, int height, String microchip_number, boolean tatto, long photo, String dryfood, int numbertimes, String allergies, String chronic_conditions, Date last_veterinary_visit, AdoptionStatus adoption_status, Owner id_owner, Sickness sickness) {
        this.name = name;
        this.id_specie = id_specie;
        this.breed = breed;
        this.date_birth = date_birth;
        this.gender = gender;
        this.weight = weight;
        this.height = height;
        this.microchip_number = microchip_number;
        this.tatto = tatto;
        this.photo = photo;
        this.dryfood = dryfood;
        this.numbertimes = numbertimes;
        this.allergies = allergies;
        this.chronic_conditions = chronic_conditions;
        this.last_veterinary_visit = last_veterinary_visit;
        this.adoption_status = adoption_status;
        this.id_owner = id_owner;
        this.sickness = sickness;
    }

    public boolean isTatto() {
        return tatto;
    }

    public void setTatto(boolean tatto) {
        this.tatto = tatto;
    }

    public long getPhoto() {
        return photo;
    }

    public void setPhoto(long photo) {
        this.photo = photo;
    }

    public int getId_pet() {
        return id_pet;
    }

    public void setId_pet(int id_pet) {
        this.id_pet = id_pet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Specie getId_specie() {
        return id_specie;
    }

    public void setId_specie(Specie id_specie) {
        this.id_specie = id_specie;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public Date getDate_birth() {
        return date_birth;
    }

    public void setDate_birth(Date date_birth) {
        this.date_birth = date_birth;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getMicrochip_number() {
        return microchip_number;
    }

    public void setMicrochip_number(String microchip_number) {
        this.microchip_number = microchip_number;
    }

    public String getDryfood() {
        return dryfood;
    }

    public void setDryfood(String dryfood) {
        this.dryfood = dryfood;
    }

    public int getNumbertimes() {
        return numbertimes;
    }

    public void setNumbertimes(int numbertimes) {
        this.numbertimes = numbertimes;
    }

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public String getChronic_conditions() {
        return chronic_conditions;
    }

    public void setChronic_conditions(String chronic_conditions) {
        this.chronic_conditions = chronic_conditions;
    }

    public Date getLast_veterinary_visit() {
        return last_veterinary_visit;
    }

    public void setLast_veterinary_visit(Date last_veterinary_visit) {
        this.last_veterinary_visit = last_veterinary_visit;
    }

    public AdoptionStatus getAdoption_status() {
        return adoption_status;
    }

    public void setAdoption_status(AdoptionStatus adoption_status) {
        this.adoption_status = adoption_status;
    }

    public Owner getId_owner() {
        return id_owner;
    }

    public void setId_owner(Owner id_owner) {
        this.id_owner = id_owner;
    }

    public Sickness getSickness() {
        return sickness;
    }

    public void setSickness(Sickness sickness) {
        this.sickness = sickness;
    }

    public static String inputWithValidation(Scanner scanner, String prompt, String regex, String errorMessage) {
        String input;
        while (true) {
            System.out.print(prompt);
            input = scanner.nextLine();
            if (input.matches(regex)) {
                break;
            } else {
                System.out.println(errorMessage);
            }
        }
        return input;
    }

    public static String inputOptional(Scanner scanner, String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public static void registerPet() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("---- Register Pet ----");

        String name = inputWithValidation(scanner, "Enter Name: ", "[A-Za-z ]+", "Invalid name. Only letters and spaces are allowed.");
        String breed = inputWithValidation(scanner, "Enter Breed: ", "[A-Za-z ]+", "Invalid breed. Only letters and spaces are allowed.");
        String dateBirth = inputWithValidation(scanner, "Enter Date of Birth (yyyy-mm-dd): ", "\\d{4}-\\d{2}-\\d{2}", "Invalid date format. Use yyyy-mm-dd.");
        String gender = inputWithValidation(scanner, "Enter Gender (Male/Female/Non-binary): ", "Male|Female|Non-binary", "Invalid gender. Use Male, Female, or Non-binary.");
        double weight = Double.parseDouble(inputWithValidation(scanner, "Enter Weight (kg): ", "\\d+(\\.\\d+)?", "Invalid weight. Only numbers are allowed."));
        double height = Double.parseDouble(inputWithValidation(scanner, "Enter Height (cm): ", "\\d+(\\.\\d+)?", "Invalid height. Only numbers are allowed."));
        String microchipNumber = inputOptional(scanner, "Enter Microchip Number (optional): ");
        boolean tattoo = Boolean.parseBoolean(inputWithValidation(scanner, "Has Tattoo? (true/false): ", "true|false", "Invalid input. Use true or false."));
        String dryfood = inputWithValidation(scanner, "Enter Dry Food: ", ".+", "Dry food cannot be empty.");
        int numberTimes = Integer.parseInt(inputWithValidation(scanner, "Enter Number of Feedings per Day: ", "\\d+", "Invalid number."));
        String allergies = inputOptional(scanner, "Enter Allergies (optional): ");
        String chronicConditions = inputOptional(scanner, "Enter Chronic Conditions (optional): ");
        String lastVisit = inputOptional(scanner, "Enter Last Veterinary Visit (yyyy-mm-dd HH:mm:ss, optional): ");
        String adoptionStatus = inputWithValidation(scanner, "Enter Adoption Status (ADOPTED/NOT_ADOPTED/IN_PROGRESS): ", "ADOPTED|NOT_ADOPTED|IN_PROGRESS", "Invalid status.");

        System.out.println("Do you already have a registered owner? (yes/no)");
        String response = scanner.nextLine().toLowerCase();

        int ownerId;
        if (response.equals("no")) {
            System.out.println("---- Register New Owner ----");
            ownerId = OwnerCRUD.registerNewOwner();
            if (ownerId == -1) {
                System.out.println("Failed to register the owner.");
                return;
            }
        } else {
            System.out.print("Enter Owner ID: ");
            ownerId = Integer.parseInt(scanner.nextLine());
        }

        try (Connection conn = ConnectionDB.getConnection()) {
            String query = "INSERT INTO Pets (name, breed, date_birth, gender, weight, height, microchip_number, tatto, dryfood, numberTimes, allergies, chronic_conditions, last_veterinary_visit, adoption_status, id_owner) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setString(1, name);
                stmt.setString(2, breed);
                stmt.setDate(3, Date.valueOf(dateBirth));
                stmt.setString(4, gender);
                stmt.setDouble(5, weight);
                stmt.setDouble(6, height);
                stmt.setString(7, microchipNumber.isBlank() ? null : microchipNumber);
                stmt.setBoolean(8, tattoo);
                stmt.setString(9, dryfood);
                stmt.setInt(10, numberTimes);
                stmt.setString(11, allergies.isBlank() ? null : allergies);
                stmt.setString(12, chronicConditions.isBlank() ? null : chronicConditions);
                stmt.setTimestamp(13, lastVisit.isBlank() ? null : Timestamp.valueOf(lastVisit));
                stmt.setString(14, adoptionStatus);
                stmt.setInt(15, ownerId);
                stmt.executeUpdate();
                System.out.println("Pet registered successfully.");
            }
        } catch (SQLException e) {
            System.out.println("Error saving the pet: " + e.getMessage());
        }
    }

    public static void editPet() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("---- Edit Pet ----");

        System.out.print("Enter the Pet ID to edit: ");
        int petId = Integer.parseInt(scanner.nextLine());

        try (Connection conn = ConnectionDB.getConnection()) {
            String query = "SELECT * FROM Pets WHERE id_pet = ?";
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setInt(1, petId);
                try (ResultSet rs = stmt.executeQuery()) {
                    if (!rs.next()) {
                        System.out.println("Pet not found.");
                        return;
                    }

                    System.out.println("Pet found. Enter new values (leave blank to keep current value):");
                    
                    String name = inputOptional(scanner, "Enter Name: [Current: " + rs.getString("name") + "] ");
                    String breed = inputOptional(scanner, "Enter Breed: [Current: " + rs.getString("breed") + "] ");
                    String dateBirth = inputOptional(scanner, "Enter Date of Birth (yyyy-mm-dd): [Current: " + rs.getDate("date_birth") + "] ");
                    String gender = inputOptional(scanner, "Enter Gender (Male/Female/Non-binary): [Current: " + rs.getString("gender") + "] ");
                    String weight = inputOptional(scanner, "Enter Weight (kg): [Current: " + rs.getDouble("weight") + "] ");
                    String height = inputOptional(scanner, "Enter Height (cm): [Current: " + rs.getDouble("height") + "] ");
                    String microchipNumber = inputOptional(scanner, "Enter Microchip Number: [Current: " + rs.getString("microchip_number") + "] ");
                    String tattoo = inputOptional(scanner, "Has Tattoo? (true/false): [Current: " + rs.getBoolean("tatto") + "] ");
                    String dryfood = inputOptional(scanner, "Enter Dry Food: [Current: " + rs.getString("dryfood") + "] ");
                    String numberTimes = inputOptional(scanner, "Enter Number of Feedings per Day: [Current: " + rs.getInt("numberTimes") + "] ");
                    String allergies = inputOptional(scanner, "Enter Allergies: [Current: " + rs.getString("allergies") + "] ");
                    String chronicConditions = inputOptional(scanner, "Enter Chronic Conditions: [Current: " + rs.getString("chronic_conditions") + "] ");
                    String lastVisit = inputOptional(scanner, "Enter Last Veterinary Visit (yyyy-mm-dd HH:mm:ss): [Current: " + rs.getTimestamp("last_veterinary_visit") + "] ");
                    String adoptionStatus = inputOptional(scanner, "Enter Adoption Status (ADOPTED/NOT_ADOPTED/IN_PROGRESS): [Current: " + rs.getString("adoption_status") + "] ");

                    query = "UPDATE Pets SET name = COALESCE(?, name), breed = COALESCE(?, breed), date_birth = COALESCE(?, date_birth), gender = COALESCE(?, gender), weight = COALESCE(?, weight), height = COALESCE(?, height), microchip_number = COALESCE(?, microchip_number), tatto = COALESCE(?, tatto), dryfood = COALESCE(?, dryfood), numberTimes = COALESCE(?, numberTimes), allergies = COALESCE(?, allergies), chronic_conditions = COALESCE(?, chronic_conditions), last_veterinary_visit = COALESCE(?, last_veterinary_visit), adoption_status = COALESCE(?, adoption_status) WHERE id_pet = ?";
                    try (PreparedStatement updateStmt = conn.prepareStatement(query)) {
                        updateStmt.setString(1, name.isBlank() ? null : name);
                        updateStmt.setString(2, breed.isBlank() ? null : breed);
                        updateStmt.setDate(3, dateBirth.isBlank() ? null : Date.valueOf(dateBirth));
                        updateStmt.setString(4, gender.isBlank() ? null : gender);
                        updateStmt.setString(5, weight.isBlank() ? null : weight);
                        updateStmt.setString(6, height.isBlank() ? null : height);
                        updateStmt.setString(7, microchipNumber.isBlank() ? null : microchipNumber);
                        updateStmt.setString(8, tattoo.isBlank() ? null : tattoo);
                        updateStmt.setString(9, dryfood.isBlank() ? null : dryfood);
                        updateStmt.setString(10, numberTimes.isBlank() ? null : numberTimes);
                        updateStmt.setString(11, allergies.isBlank() ? null : allergies);
                        updateStmt.setString(12, chronicConditions.isBlank() ? null : chronicConditions);
                        updateStmt.setString(13, lastVisit.isBlank() ? null : lastVisit);
                        updateStmt.setString(14, adoptionStatus.isBlank() ? null : adoptionStatus);
                        updateStmt.setInt(15, petId);

                        int rowsUpdated = updateStmt.executeUpdate();
                        if (rowsUpdated > 0) {
                            System.out.println("Pet updated successfully.");
                        } else {
                            System.out.println("No changes were made.");
                        }
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Error updating the pet: " + e.getMessage());
        }
    }

    public static void listPets() {
        System.out.println("---- List of Pets ----");
        try (Connection conn = ConnectionDB.getConnection()) {
            String query = "SELECT id_pet, name, breed, date_birth, gender, weight, height, tatto FROM Pets";
            try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
                while (rs.next()) {
                    System.out.printf("ID: %d, Name: %s, Breed: %s, Date of Birth: %s, Gender: %s, Weight: %d, Height: %d, Tattoo: %b%n",
                            rs.getInt("id_pet"), rs.getString("name"), rs.getString("breed"), rs.getString("date_birth"),
                            rs.getString("gender"), rs.getInt("weight"), rs.getInt("height"), rs.getBoolean("tatto"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving pets: " + e.getMessage());
        }
    }
    
    public static void deletePet() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("---- Delete Pet ----");

        int petId = Integer.parseInt(inputWithValidation(scanner, "Enter Pet ID to delete: ", "\\d+", "Invalid ID. Only numbers are allowed."));

        try (Connection conn = ConnectionDB.getConnection()) {
            String query = "DELETE FROM Pets WHERE id_pet = ?";
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setInt(1, petId);
                int rowsAffected = stmt.executeUpdate();
                System.out.println(rowsAffected > 0 ? "Pet deleted successfully." : "Pet not found.");
            }
        } catch (SQLException e) {
            System.out.println("Error deleting the pet: " + e.getMessage());
        }
    }
}

