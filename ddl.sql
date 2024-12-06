DROP DATABASE IF EXISTS MyLittlePetShop;
CREATE DATABASE MyLittlePetShop;
USE MyLittlePetShop;

CREATE TABLE Species (
    id_species INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    description TEXT
);

CREATE TABLE TypeSickness (
    id_type_sickness INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(65) NOT NULL,
    description TEXT
);

CREATE TABLE Sickness (
    id_sickness INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    type_sickness_id INT,
    description TEXT,
    FOREIGN KEY (type_sickness_id) REFERENCES TypeSickness(id_type_sickness)
);

CREATE TABLE Identity (
    id_identity INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(65) NOT NULL,
    photo BLOB
);

CREATE TABLE Employees (
    id_employee INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(65) NOT NULL,
    identity_type ENUM('CC', 'CE', 'Passport') NOT NULL,
    identification_number VARCHAR(15) NOT NULL UNIQUE,
    wage DECIMAL(10,2) NOT NULL,
    position_type ENUM('Assistant', 'Veterinarian', 'Groomer', 'Trainer', 'Admin') NOT NULL,
    hire_date DATE NOT NULL,
    email VARCHAR(100) UNIQUE,
    phone VARCHAR(15)
);

CREATE TABLE Owner (
    id_owner INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(65) NOT NULL,
    identity_type ENUM('CC', 'CE', 'Passport') NOT NULL,
    identification_number VARCHAR(15) NOT NULL UNIQUE,
    rut VARCHAR(65),
    phone VARCHAR(15) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    emergency_contact_name VARCHAR(100),
    emergency_contact_phone VARCHAR(15)
);

CREATE TABLE Address (
    id_address INT PRIMARY KEY AUTO_INCREMENT,
    id_owner INT NOT NULL UNIQUE,
    type_via ENUM('Street', 'Avenue', 'Diagonal', 'Transversal', 'Circle'),
    address VARCHAR(100) NOT NULL,
    indications TEXT,
    FOREIGN KEY (id_owner) REFERENCES Owner(id_owner)
);

CREATE TABLE PharmaceuticalProduct (
    id_pharmaceutical_product INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    description TEXT,
    price DECIMAL(10,2) NOT NULL,
    stock_quantity INT NOT NULL,
    expiration_date DATE,
    manufacturer VARCHAR(100),
    product_type ENUM('Medicine', 'Vaccine', 'Supply') NOT NULL
);

CREATE TABLE Medicines (
    id_medicine INT PRIMARY KEY AUTO_INCREMENT,
    type ENUM('Antibiotic', 'Anti-inflammatory', 'Antiparasitic') NOT NULL,
    manufacturer VARCHAR(65) NOT NULL,
    due_date DATE NOT NULL,
    pharmaceutical_product_id INT,
    dosage TEXT,
    FOREIGN KEY (pharmaceutical_product_id) REFERENCES PharmaceuticalProduct(id_pharmaceutical_product)
);

CREATE TABLE Vaccines (
    id_vaccine INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    type VARCHAR(65) NOT NULL,
    date_entry DATE NOT NULL,
    due_date DATE NOT NULL,
    pharmaceutical_product_id INT,
    species_id INT,
    batch_number VARCHAR(50),
    FOREIGN KEY (pharmaceutical_product_id) REFERENCES PharmaceuticalProduct(id_pharmaceutical_product),
    FOREIGN KEY (species_id) REFERENCES Species(id_species)
);

CREATE TABLE Pets (
    id_pet INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    species_id INT,
    breed VARCHAR(65) NOT NULL,
    date_birth DATE NOT NULL,
    gender ENUM('Female', 'Male', 'Non-binary') NOT NULL,
    weight DECIMAL(5,2) NOT NULL,
    height DECIMAL(5,2) NOT NULL,
    microchip_number VARCHAR(50) UNIQUE,
    allergies TEXT,
    chronic_conditions TEXT,
    last_veterinary_visit DATETIME,
    owner_id INT NOT NULL,
    identity_id INT,
    sickness_id INT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (species_id) REFERENCES Species(id_species),
    FOREIGN KEY (owner_id) REFERENCES Owner(id_owner),
    FOREIGN KEY (identity_id) REFERENCES Identity(id_identity),
    FOREIGN KEY (sickness_id) REFERENCES Sickness(id_sickness)
);

CREATE TABLE MedicalProcedure (
    id_medical_procedure INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(65) NOT NULL,
    used_inputs TEXT NOT NULL,
    type_surgery ENUM('Surgery', 'Sterilization', 'Radiography'),
    exam_analysis BOOLEAN NOT NULL,
    date_procedure DATETIME NOT NULL,
    price DECIMAL(10,2) NOT NULL,
    pet_id INT,
    employee_id INT,
    FOREIGN KEY (pet_id) REFERENCES Pets(id_pet),
    FOREIGN KEY (employee_id) REFERENCES Employees(id_employee)
);

CREATE TABLE Appointments (
    id_appointment INT PRIMARY KEY AUTO_INCREMENT,
    date_appointment DATETIME NOT NULL,
    reason_visit TEXT NOT NULL,
    recommendations TEXT NOT NULL,
    employee_id INT,
    pet_id INT,
    status ENUM('Scheduled', 'In Progress', 'Completed', 'Cancelled'),
    FOREIGN KEY (employee_id) REFERENCES Employees(id_employee),
    FOREIGN KEY (pet_id) REFERENCES Pets(id_pet)
);

CREATE TABLE Suppliers (
    id_supplier INT PRIMARY KEY AUTO_INCREMENT, 
    company_name VARCHAR(100) NOT NULL,
    contact VARCHAR(10) NOT NULL,
    email VARCHAR(65) NOT NULL,
    address TEXT
);

CREATE TABLE PurchaseOrders (
    id_purchase_order INT PRIMARY KEY AUTO_INCREMENT,
    purchase_date DATETIME NOT NULL,
    status ENUM('Delivered', 'Pending'),
    supplier_id INT,
    total_amount DECIMAL(10,2),
    FOREIGN KEY (supplier_id) REFERENCES Suppliers(id_supplier)
);

CREATE TABLE PaymentMethod (
    id_payment_method INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(65) NOT NULL,
    description TEXT
);

CREATE TABLE Sales (
    id_sale INT PRIMARY KEY AUTO_INCREMENT,
    date_sale DATE NOT NULL,
    total DECIMAL(10,2) NOT NULL,
    owner_id INT,
    employee_id INT,
    FOREIGN KEY (owner_id) REFERENCES Owner(id_owner),
    FOREIGN KEY (employee_id) REFERENCES Employees(id_employee)
);

CREATE TABLE Invoice (
    id_invoice INT PRIMARY KEY AUTO_INCREMENT,
    sale_id INT,
    date_invoice DATE NOT NULL,
    total DECIMAL(10,2) NOT NULL,
    FOREIGN KEY (sale_id) REFERENCES Sales(id_sale)
);

CREATE TABLE Transactions (
    id_transaction INT PRIMARY KEY AUTO_INCREMENT,
    status ENUM('Accepted', 'Pending', 'Rejected') NOT NULL,
    date DATETIME NOT NULL,
    amount DECIMAL(10,2) NOT NULL,
    payment_method_id INT,
    invoice_id INT,
    customer_id INT,
    notes TEXT,
    FOREIGN KEY (payment_method_id) REFERENCES PaymentMethod(id_payment_method),
    FOREIGN KEY (invoice_id) REFERENCES Invoice(id_invoice),
    FOREIGN KEY (customer_id) REFERENCES Owner(id_owner)
);

CREATE TABLE Adoption (
    id_adoption INT PRIMARY KEY AUTO_INCREMENT,
    pet_id INT UNIQUE,
    new_owner_id INT,
    previous_owner_id INT,
    contract_status ENUM('Pending', 'Approved', 'Completed') NOT NULL,
    entry_date DATE NOT NULL,
    adoption_date DATE,
    follow_up_date DATE,
    follow_up_notes TEXT,
    FOREIGN KEY (pet_id) REFERENCES Pets(id_pet),
    FOREIGN KEY (new_owner_id) REFERENCES Owner(id_owner),
    FOREIGN KEY (previous_owner_id) REFERENCES Owner(id_owner)
);

CREATE TABLE Services (
    id_service INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(65) NOT NULL,
    date_service DATE NOT NULL,
    price DECIMAL(10,2),
    details TEXT,
    category ENUM('Grooming', 'Medical', 'Training', 'Boarding')
);

CREATE TABLE SpecialActivities (
    id_special_activity INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(65) NOT NULL,
    description TEXT,
    date_special_activity DATE NOT NULL,
    place TEXT,
    type ENUM('Vaccination', 'Adoption', 'Training', 'Health Check')
);

CREATE TABLE TypeExpense (
    id_type_expense INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(65) NOT NULL,
    description TEXT
);

CREATE TABLE Expenses (
    id_expense INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(65) NOT NULL,
    payment_day DATE NOT NULL,
    amount DECIMAL(10,2),
    type_expense_id INT,
    description TEXT,
    FOREIGN KEY (type_expense_id) REFERENCES TypeExpense(id_type_expense)
);

CREATE TABLE MedicalSupplies (
    id_medical_supplies INT PRIMARY KEY AUTO_INCREMENT,
    type VARCHAR(65) NOT NULL,
    supplies TEXT NOT NULL,
    pharmaceutical_product_id INT,
    FOREIGN KEY (pharmaceutical_product_id) REFERENCES PharmaceuticalProduct(id_pharmaceutical_product)
);