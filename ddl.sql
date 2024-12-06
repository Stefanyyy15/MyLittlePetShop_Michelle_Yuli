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
    id_type_sickness INT,
    description TEXT,
    FOREIGN KEY (id_type_sickness) REFERENCES TypeSickness(id_type_sickness)
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
    second_last_name VARCHAR(65) NOT NULL,
    identity_type ENUM('CC', 'CE', 'Passport') NOT NULL,
    identification_number VARCHAR(15) NOT NULL UNIQUE,
    wage DECIMAL(10,2) NOT NULL,
    position_type ENUM('Assistant', 'Veterinarian', 'Groomer', 'Trainer', 'Admin') NOT NULL,
    hire_date DATE NOT NULL,
    email VARCHAR(100) UNIQUE,
    phone VARCHAR(15),
    shift ENUM('M', 'A', 'E') 
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
    id_pharmaceutical_product INT,
    dosage TEXT,
    FOREIGN KEY (id_pharmaceutical_product) REFERENCES PharmaceuticalProduct(id_pharmaceutical_product)
);

CREATE TABLE Vaccines (
    id_vaccine INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    type VARCHAR(65) NOT NULL,
    date_entry DATE NOT NULL,
    due_date DATE NOT NULL,
    id_pharmaceutical_product INT,
    id_species INT,
    batch_number VARCHAR(50),
    FOREIGN KEY (id_pharmaceutical_product) REFERENCES PharmaceuticalProduct(id_pharmaceutical_product),
    FOREIGN KEY (id_species) REFERENCES Species(id_species)
);

CREATE TABLE Pets (
    id_pet INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    id_species INT,
    breed VARCHAR(65) NOT NULL,
    date_birth DATE NOT NULL,
    gender ENUM('Female', 'Male', 'Non-binary') NOT NULL,
    weight DECIMAL(5,2) NOT NULL,
    height DECIMAL(5,2) NOT NULL,
    microchip_number VARCHAR(50) UNIQUE,
    allergies TEXT,
    chronic_conditions TEXT,
    dryfood VARCHAR(100) NOT NULL,
    wetfood VARCHAR(100) NOT NULL,
    schedule_amount TEXT NOT NULL,
    last_veterinary_visit DATETIME,
    id_owner INT NOT NULL,
    id_identity INT,
    id_sickness INT,
    FOREIGN KEY (id_species) REFERENCES Species(id_species),
    FOREIGN KEY (id_owner) REFERENCES Owner(id_owner),
    FOREIGN KEY (id_identity) REFERENCES Identity(id_identity),
    FOREIGN KEY (id_sickness) REFERENCES Sickness(id_sickness)
);

CREATE TABLE MedicalProcedure (
    id_medical_procedure INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(65) NOT NULL,
    used_inputs TEXT NOT NULL,
    type_surgery ENUM('Surgery', 'Sterilization', 'Radiography'),
    exam_analysis BOOLEAN NOT NULL,
    date_procedure DATETIME NOT NULL,
    price DECIMAL(10,2) NOT NULL,
    id_pet INT,
    id_employee INT,
    FOREIGN KEY (id_pet) REFERENCES Pets(id_pet),
    FOREIGN KEY (id_employee) REFERENCES Employees(id_employee)
);

CREATE TABLE Appointments (
    id_appointment INT PRIMARY KEY AUTO_INCREMENT,
    date_appointment DATETIME NOT NULL,
    query_type VARCHAR(100) NOT NULL,
	diagnostic TEXT NOT NULL,
	treatment TEXT NOT NULL,
    reason_visit TEXT NOT NULL,
    recommendations TEXT NOT NULL,
    id_owner INT,
    id_employee INT,
    id_pet INT,
    status ENUM('Scheduled', 'In Progress', 'Completed', 'Cancelled'),
    FOREIGN KEY (id_owner) REFERENCES Owner(id_owner),
    FOREIGN KEY (id_employee) REFERENCES Employees(id_employee),
    FOREIGN KEY (id_pet) REFERENCES Pets(id_pet)
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
    id_supplier INT,
    total_amount DECIMAL(10,2),
    FOREIGN KEY (id_supplier) REFERENCES Suppliers(id_supplier)
);

CREATE TABLE PaymentMethod (
    id_payment_method INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(65) NOT NULL,
    description TEXT
);

CREATE TABLE if not exists DetailsPurchaseOrder (
	id_detail_purchase_order INT PRIMARY KEY AUTO_INCREMENT,
    id_pharmaceutical_product INT,
    id_purchase_order INT,
    amount INT NOT NULL,
    FOREIGN KEY (id_pharmaceutical_product) REFERENCES PharmaCeuticalProduct(id_pharmaceutical_product),
    FOREIGN KEY (id_purchase_order) REFERENCES PurchaseOrders(id_purchase_order)
 );   

CREATE TABLE Sales (
    id_sale INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    date_sale DATE NOT NULL,
    total DECIMAL(10,2) NOT NULL,
    id_owner INT,
    id_employee INT,
    id_appoiment INT,
    FOREIGN KEY (id_owner) REFERENCES Owner(id_owner),
    FOREIGN KEY (id_employee) REFERENCES Employees(id_employee),
    FOREIGN KEY (id_appointment) REFERENCES Appointments(id_appointment)

);

CREATE TABLE ProductSalesDetails (
	id_product_sales_details INT PRIMARY KEY AUTO_INCREMENT,
    id_pharmaceutical_product INT,
    id_sale INT,
    amount INT NOT NULL,
    FOREIGN KEY (id_pharmaceutical_product) REFERENCES PharmaCeuticalProduct(id_pharmaceutical_product),
    FOREIGN KEY (id_sale) REFERENCES Sales(id_sale)
);

CREATE TABLE DetailsSalesServices (
	id_details_sales_service INT PRIMARY KEY AUTO_INCREMENT,
    id_service INT,
    id_sale INT,
    amount INT NOT NULL,
    FOREIGN KEY (id_service) REFERENCES Services(id_service),
    FOREIGN KEY (id_sale) REFERENCES Sales(id_sale)
);

CREATE TABLE ProcedureSalesDetails (
	id_procedure_sale_detail INT PRIMARY KEY AUTO_INCREMENT,
    id_medical_procedure INT,
    id_sale INT,
    amount INT NOT NULL,
    FOREIGN KEY (id_medical_procedure) REFERENCES MedicalProcedure(id_medical_procedure),
    FOREIGN KEY (id_sale) REFERENCES Sales(id_sale)
);

CREATE TABLE Invoice (
    id_invoice INT PRIMARY KEY AUTO_INCREMENT,
    id_sale INT,
    date_invoice DATE NOT NULL,
    total DECIMAL(10,2) NOT NULL,
    FOREIGN KEY (id_sale) REFERENCES Sales(id_sale)
);

CREATE TABLE Transactions (
    id_transaction INT PRIMARY KEY AUTO_INCREMENT,
    status ENUM('Accepted', 'Pending', 'Rejected') NOT NULL,
    date DATETIME NOT NULL,
    amount DECIMAL(10,2) NOT NULL,
    id_payment_method INT,
    id_invoice INT,
    id_owner INT,
    notes TEXT,
    FOREIGN KEY (id_payment_method) REFERENCES PaymentMethod(id_payment_method),
    FOREIGN KEY (id_invoice) REFERENCES Invoice(id_invoice),
    FOREIGN KEY (id_owner) REFERENCES Owner(id_owner)
);

CREATE TABLE Adoption (
    id_adoption INT PRIMARY KEY AUTO_INCREMENT,
    id_pet INT,
    new_owner_id INT,
    previous_owner_id INT,
    contract_status ENUM('Pending', 'Approved', 'Completed') NOT NULL,
    entry_date DATE NOT NULL,
    adoption_date DATE,
    follow_up_date DATE,
    follow_up_notes TEXT,
    FOREIGN KEY (id_pet) REFERENCES Pets(id_pet),
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
    id_type_expense INT,
    description TEXT,
    FOREIGN KEY (id_type_expense) REFERENCES TypeExpense(id_type_expense)
);

CREATE TABLE MedicalSupplies (
    id_medical_supplies INT PRIMARY KEY AUTO_INCREMENT,
    type VARCHAR(65) NOT NULL,
    supplies TEXT NOT NULL,
    id_pharmaceutical_product INT,
    FOREIGN KEY (id_pharmaceutical_product) REFERENCES PharmaceuticalProduct(id_pharmaceutical_product)
);

CREATE TABLE ElectronicInvoice (
    id_electronic_invoice INT PRIMARY KEY AUTO_INCREMENT,
    invoice_number VARCHAR(50) NOT NULL UNIQUE, 
    invoice_date DATETIME NOT NULL, 
    customer_id INT NOT NULL,
    veterinarian_id INT,
    service_details TEXT, 
    total_amount DECIMAL(10,2) NOT NULL, 
    tax_amount DECIMAL(10,2) NOT NULL,
    cufe VARCHAR(100) NOT NULL UNIQUE,
    qr_code BLOB, 
    digital_signature BLOB, 
    FOREIGN KEY (customer_id) REFERENCES Owner(id_owner),
    FOREIGN KEY (veterinarian_id) REFERENCES Employees(id_employee)
);
