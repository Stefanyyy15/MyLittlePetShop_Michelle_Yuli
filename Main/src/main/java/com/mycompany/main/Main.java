package com.mycompany.main;

import com.mycompany.main.entity.*;
import com.mycompany.main.entity.Appointment.AppointmentManagement;
import com.mycompany.main.entity.Employee.EmployeeCRUD;
import com.mycompany.main.entity.MedicalProcedure.MedicalProcedureCrud;
import com.mycompany.main.entity.Owner.OwnerCRUD;
import com.mycompany.main.entity.MedicalSupplie.MedicalSuppliesCRUD;
import com.mycompany.main.entity.Medicine.MedicineCRUD;
import static com.mycompany.main.entity.PharmaceuticalProduct.*;
import com.mycompany.main.entity.PharmaceuticalProduct.PharmaceuticalProductCRUD;
import com.mycompany.main.entity.Supplier.SupplierCrud;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int mainOption;

        do {
            System.out.println("                      _           __       _");
            System.out.println("|   o _|__|_ |  _    |_) _ _|_   (_ |_  _ |_)");
            System.out.println("|__ |  |_ |_ | (/_   |  (/_ |_   __)| |(_)|");
            System.out.println("");
            System.out.println("---- MAIN MENU ----");
            System.out.println("1. Owner & Pet");
            System.out.println("2. Pharmaceutical Product");
            System.out.println("3. Medical Procedure & Service");
            System.out.println("4. Supplier & Employee");
            System.out.println("5. Agenda & Sale");
            System.out.println("6. Special Activities");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            mainOption = scanner.nextInt();

            switch (mainOption) {
                case 1 ->
                    ownerAndPetMenu();
                case 2 ->
                    pharmaceuticalProduct();
                case 3 ->
                    medicalProcedureandServiceMenu();
                case 4 ->
                    supplierandemployee();
                case 5 ->
                    AgendaandSaleMenu();
                case 6 ->
                    SpecialActivityMenu();
                case 0 ->
                    System.out.println("Exiting the system. Goodbye!");
                default ->
                    System.out.println("Invalid option. Please try again.");
            }
        } while (mainOption != 0);
    }
    
    public static void ownerAndPetMenu() {
        int petOption;

        do {
            System.out.println("\n---- OWNER MENU ----");
            System.out.println("1. Register Owner");
            System.out.println("2. List Owners");
            System.out.println("3. Edit Owner");
            System.out.println("4. Delete Owner");
            System.out.println("\n-----PET MENU-------");
            System.out.println("5. Register Pet");
            System.out.println("6. Show medical history");
            System.out.println("7. Edit Pet");
            System.out.println("8. Delete Pet");
            System.out.println("0. Return to Main Menu");
            System.out.print("Choose an option: ");
            petOption = scanner.nextInt();
            scanner.nextLine();

            switch (petOption) {
                case 1 ->
                    OwnerCRUD.registerNewOwner();
                case 2 ->
                    OwnerCRUD.listOwners();
                case 3 ->
                    OwnerCRUD.editOwner();
                case 4 ->
                    OwnerCRUD.deleteOwner();
                case 5 ->
                    Pet.registerPet();
                case 6 ->
                    Pet.listPets();
                case 7 ->
                    Pet.editPet();
                case 8 ->
                    Pet.deletePet();
                case 0 ->
                    System.out.println("Returning to Main Menu.");
                default ->
                    System.out.println("Invalid option. Please try again.");
            }
        } while (petOption != 0);
    }

    public static void supplierandemployee() {
        int inventoryOption;

        do {
            System.out.println("\n---- SUPPLIER MENU ----");
            System.out.println("1. Register Supplier");
            System.out.println("2. List Suppliers");
            System.out.println("3. Edit Supplier");
            System.out.println("4. Delete Supplier");
            System.out.println("\n----INVENTORY MENU ----");
            System.out.println("5. Register Employee");
            System.out.println("6. List Employees");
            System.out.println("7. Edit Employee");
            System.out.println("8. Delete Employee");
            System.out.println("0. Return to Main Menu");
            System.out.print("Choose an option: ");
            inventoryOption = scanner.nextInt();
            scanner.nextLine();

            switch (inventoryOption) {
                case 1 ->
                    SupplierCrud.registerSupplier();
                case 2 ->
                    SupplierCrud.listSuppliers();
                case 3 ->
                    SupplierCrud.editSupplier();
                case 4 ->
                    SupplierCrud.deleteSupplier();
                case 5 ->
                    EmployeeCRUD.registerNewEmployee();
                case 6 ->
                    EmployeeCRUD.listEmployees();
                case 7 ->
                    EmployeeCRUD.editEmployee();
                case 8 ->
                    EmployeeCRUD.deleteEmployee();
                case 0 ->
                    System.out.println("Returning to Main Menu.");
                default ->
                    System.out.println("Invalid option. Please try again.");
            }
        } while (inventoryOption != 0);
    }

    public static void medicalProcedureandServiceMenu() {
        int ProcedureOption;

        do {
            System.out.println("\n---- MEDICAL PROCEDURE MENU ----");
            System.out.println("1. Register Medical Procedure");
            System.out.println("2. List Medical Procedures");
            System.out.println("3. Edit Medical Procedure");
            System.out.println("4. Delete Medical Procedure");
            System.out.println("\n---- SERVICE MENU ----");
            System.out.println("5. Register Service");
            System.out.println("6. List Service ");
            System.out.println("7. Edit Service ");
            System.out.println("8. Delete Service ");
            System.out.println("0. Return to Main Menu");
            System.out.print("Choose an option: ");
            ProcedureOption = scanner.nextInt();
            scanner.nextLine();

            switch (ProcedureOption) {
                case 1 ->
                    MedicalProcedureCrud.registerMedicalProcedure();
                case 2 ->
                    MedicalProcedureCrud.listMedicalProcedures();
                case 3 ->
                    MedicalProcedureCrud.editMedicalProcedure();
                case 4 ->
                    MedicalProcedureCrud.deleteMedicalProcedure();
                case 5 ->
                    Service.registerService();
                case 6 ->
                    Service.listServices();
                case 7 ->
                    Service.editService();
                case 8 ->
                    Service.deleteService();
                case 0 ->
                    System.out.println("Returning to Main Menu.");
                default ->
                    System.out.println("Invalid option. Please try again.");
            }
        } while (ProcedureOption != 0);
    }

    public static void pharmaceuticalProduct() {
        int pharmaceuticaloption;

        do {
            System.out.println("\n---- PHARMACEUTICAL PRODUCT MENU ----");
            System.out.println("1. Register Pharmaceutical Product");
            System.out.println("2. Show Inventory Pharmaceutical Products");
            System.out.println("3. Edit Pharmaceutical Product");
            System.out.println("4. Delete Pharmaceutical Product");
            System.out.println("\n---- VACCINE MENU ----");
            System.out.println("5. Register Vaccine");
            System.out.println("6. Show Inventory Vaccines");
            System.out.println("7. Edit Vaccine");
            System.out.println("8. Delete Vaccine");
            System.out.println("\n---- MEDICINE MENU ----");
            System.out.println("9. Register Medicine");
            System.out.println("10. Show Inventory Medicines");
            System.out.println("11. Edit Medicine");
            System.out.println("12. Delete Medicine");
            System.out.println("\n---- SUPPLIER MENU ----");
            System.out.println("13. Register Medical Supplie");
            System.out.println("14. Show Inventory Medical Supplies");
            System.out.println("15. Edit Medical Supplies");
            System.out.println("16. Delete Medical Supplies");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            pharmaceuticaloption = scanner.nextInt();

            switch (pharmaceuticaloption) {
                case 1 ->
                    PharmaceuticalProductCRUD.registerPharmaceuticalProduct();
                case 2 ->
                    PharmaceuticalProductCRUD.listPharmaceuticalProducts();
                case 3 ->
                    PharmaceuticalProductCRUD.editPharmaceuticalProduct();
                case 4 ->
                    PharmaceuticalProductCRUD.deletePharmaceuticalProduct();
                case 5 ->
                    Vaccine.registerVaccine();
                case 6 ->
                    Vaccine.listVaccines();
                case 7 ->
                    Vaccine.listPharmaceuticalProducts();
                case 8 ->
                    Vaccine.listSpecies();
                case 9 ->
                    MedicineCRUD.registerMedicine();
                case 10 ->
                    MedicineCRUD.listMedicines();
                case 11 ->
                    MedicineCRUD.editMedicine();
                case 12 ->
                    MedicineCRUD.deleteMedicine();
                case 13 ->
                    MedicalSuppliesCRUD.registerNewMedicalSupply();
                case 14 ->
                    MedicalSuppliesCRUD.listMedicalSupplies();
                case 15 ->
                    MedicalSuppliesCRUD.editMedicalSupply();
                case 16 ->
                    MedicalSuppliesCRUD.deleteMedicalSupply();
                case 0 ->
                    System.out.println("Exiting the system.");
                default ->
                    System.out.println("Invalid option. Please try again.");
            }
        } while (pharmaceuticaloption != 0);
    }

    public static void SpecialActivityMenu() {
        int specialOption;

        do {
            System.out.println("\n---- SPECIAL ACTIVITY MENU ----");
            System.out.println("1. Register Special Activity");
            System.out.println("2. List Special Activities");
            System.out.println("3. Edit Special Activity");
            System.out.println("4. Delete Special Activity");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            specialOption = scanner.nextInt();

            switch (specialOption) {
                case 1 ->
                    SpecialActivitie.registerSpecialActivity();
                case 2 ->
                    SpecialActivitie.listSpecialActivities();
                case 3 ->
                    SpecialActivitie.editSpecialActivity();
                case 4 ->
                    SpecialActivitie.deleteSpecialActivity();
                case 0 ->
                    System.out.println("Exiting the system.");
                default ->
                    System.out.println("Invalid option. Please try again.");
            }
        } while (specialOption != 0);
    }
public static void AgendaandSaleMenu() {
        int agendaOption;

        do {
            System.out.println("\n---- AGENDA MENU ----");
            System.out.println("1. Register Appointment");
            System.out.println("2. List Appointments");
            System.out.println("3. Edit Appointment");
            System.out.println("4. Delete Appointment");
            System.out.println("\n---- SALE MENU ----");
            System.out.println("5. Register Sale");
            System.out.println("6. List Sales");
            System.out.println("7. Edit Sale");
            System.out.println("8. Delete Sale");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            agendaOption = scanner.nextInt();

            switch (agendaOption) {
                case 1 ->
                    AppointmentManagement.registerAppointment();
                case 2 ->
                    AppointmentManagement.listAppointments();
                case 3 ->
                    AppointmentManagement.editAppointment();
                case 4 ->
                    AppointmentManagement.deleteAppointment();
                case 5 ->
                    Sale.registerNewSale();
                case 6 ->
                    Sale.listSales();
                case 7 ->
                    Sale.editSale();
                case 8 ->
                    Sale.deleteSale();
                case 0 ->
                    System.out.println("Exiting the system.");
                default ->
                    System.out.println("Invalid option. Please try again.");
            }
        } while (agendaOption != 0);
    }

    
}