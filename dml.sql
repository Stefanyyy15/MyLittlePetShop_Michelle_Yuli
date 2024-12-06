USE MyLittlePetShop;

INSERT INTO Species (name, description) VALUES 
('Dog', 'Domestic canine species'),
('Cat', 'Domestic feline species'),
('Bird', 'Domestic bird species'),
('Hamster', 'Small rodent pet'),
('Rabbit', 'Domesticated rabbit'),
('Fish', 'Aquarium fish species'),
('Turtle', 'Reptilian pet species'),
('Guinea Pig', 'Small rodent companion'),
('Ferret', 'Domesticated mustelid'),
('Snake', 'Non-venomous pet snake');

INSERT INTO TypeSickness (name, description) VALUES
('Infectious', 'Diseases transmitted between animals'),
('Genetic', 'Inherited health conditions'),
('Nutritional', 'Health issues related to diet'),
('Parasitic', 'Illnesses caused by parasites'),
('Chronic', 'Long-term health conditions'),
('Seasonal', 'Health problems related to environmental changes'),
('Respiratory', 'Diseases affecting breathing'),
('Skin', 'Dermatological health issues'),
('Dental', 'Mouth and teeth related problems'),
('Neurological', 'Conditions affecting nervous system');

INSERT INTO Sickness (name, id_type_sickness, description) VALUES
('Parvovirus', 1, 'Highly contagious viral illness in dogs'),
('Feline Leukemia', 1, 'Infectious disease in cats'),
('Hip Dysplasia', 2, 'Genetic joint condition in large breeds'),
('Distemper', 1, 'Viral disease affecting multiple species'),
('Heartworm', 4, 'Parasitic infection in dogs and cats'),
('Obesity', 3, 'Weight-related health problem'),
('Arthritis', 5, 'Chronic joint inflammation'),
('Allergic Dermatitis', 8, 'Skin inflammation due to allergies'),
('Dental Decay', 9, 'Tooth and gum deterioration'),
('Epilepsy', 10, 'Neurological seizure disorder');

INSERT INTO Identity (name, photo) VALUES
('Collar', NULL),
('Tag', NULL),
('Microchip', NULL),
('Medical Record', NULL),
('Vaccination Certificate', NULL),
('Pedigree Document', NULL),
('Adoption Papers', NULL),
('Tracking Chip', NULL),
('Medical Implant', NULL),
('Tracking Device', NULL);

INSERT INTO Employees (first_name, last_name, identity_type, identification_number, wage, position_type, hire_date, email, phone) VALUES
('María', 'González', 'CC', '1085678901', 2500.00, 'Veterinarian', '2022-03-15', 'maria.gonzalez@petshop.com', '+573001234567'),
('Carlos', 'Rodríguez', 'CC', '1087654321', 2200.00, 'Assistant', '2022-06-01', 'carlos.rodriguez@petshop.com', '+573009876543'),
('Laura', 'Martínez', 'CC', '1023456789', 2800.00, 'Veterinarian', '2021-11-20', 'laura.martinez@petshop.com', '+573002345678'),
('Juan', 'Pérez', 'CC', '1056789012', 2000.00, 'Groomer', '2023-01-10', 'juan.perez@petshop.com', '+573007654321'),
('Sofía', 'López', 'CC', '1034567890', 2300.00, 'Trainer', '2022-09-05', 'sofia.lopez@petshop.com', '+573003456789'),
('Andrés', 'Sánchez', 'CC', '1078978234', 2100.00, 'Assistant', '2023-02-15', 'andres.sanchez@petshop.com', '+573006543210'),
('Valentina', 'Ramírez', 'CC', '1045678907', 2600.00, 'Veterinarian', '2021-07-30', 'valentina.ramirez@petshop.com', '+573001122334'),
('Diego', 'Torres', 'CC', '1089012345', 2400.00, 'Admin', '2022-05-12', 'diego.torres@petshop.com', '+573004455667'),
('Camila', 'Herrera', 'CC', '1056789045', 2700.00, 'Veterinarian', '2022-01-25', 'camila.herrera@petshop.com', '+573005566778'),
('Miguel', 'Díaz', 'CC', '1023456779', 2150.00, 'Groomer', '2023-04-01', 'miguel.diaz@petshop.com', '+573008899001');

INSERT INTO Owner (first_name, last_name, identity_type, identification_number, rut, phone, email, emergency_contact_name, emergency_contact_phone) VALUES
('Ana', 'García', 'CC', '1045678901', '1045678901-7', '+573001234567', 'ana.garcia@email.com', 'Juan García', '+573009876543'),
('Pedro', 'Morales', 'CC', '1087654321', '1087654321-4', '+573009876543', 'pedro.morales@email.com', 'María Morales', '+573001234567'),
('Luisa', 'Fernández', 'CC', '1023456789', '1023456789-5', '+573002345678', 'luisa.fernandez@email.com', 'Carlos Fernández', '+573007654321'),
('Roberto', 'Jiménez', 'CC', '1056789012', '1056789012-2', '+573007654321', 'roberto.jimenez@email.com', 'Sofía Jiménez', '+573003456789'),
('Carolina', 'Navarro', 'CC', '1034567890', '1034567890-1', '+573003456789', 'carolina.navarro@email.com', 'Andrés Navarro', '+573006543210'),
('Javier', 'Ruiz', 'CC', '1078901234', '1078901234-6', '+573006543210', 'javier.ruiz@email.com', 'Laura Ruiz', '+573001122334'),
('Valentina', 'Mendoza', 'CC', '1045678902', '1045678902-7', '+573001122334', 'valentina.mendoza@email.com', 'Diego Mendoza', '+573004455667'),
('Daniel', 'Castro', 'CC', '1089012345', '1089012345-8', '+573004455667', 'daniel.castro@email.com', 'Camila Castro', '+573005566778'),
('Mariana', 'Silva', 'CC', '1056789013', '1056789013-9', '+573005566778', 'mariana.silva@email.com', 'Miguel Silva', '+573008899001'),
('Gustavo', 'Ortiz', 'CC', '1023456790', '1023456790-1', '+573008899001', 'gustavo.ortiz@email.com', 'Ana Ortiz', '+573002345678');

INSERT INTO Address (id_owner, type_via, address, indications) VALUES
(1, 'Street', '72nd Street #10-15', 'White house with a green door'),
(2, 'Avenue', '45th Avenue #23-30', 'Blue building, apartment 302'),
(3, 'Diagonal', '65th Diagonal #12-45', 'Torres del Parque residential complex'),
(4, 'Street', '100th Street #15-20', 'Corner house, black gate'),
(5, 'Transversal', '80th Transversal #25-35', 'Yellow building, third floor'),
(6, 'Avenue', '15th Avenue #50-60', 'House with a large garden'),
(7, 'Circle', '30th Circle #40-50', 'Gated community, house number 7'),
(8, 'Street', '55th Street #20-25', 'House with a brown gate'),
(9, 'Avenue', '70th Avenue #30-40', 'Modern building, apartment 504'),
(10, 'Diagonal', '90th Diagonal #15-30', 'House with a terrace');

INSERT INTO PharmaceuticalProduct (name, description, price, stock_quantity, expiration_date, manufacturer, product_type) VALUES
('Amoxicillin', 'Broad-spectrum antibiotic', 25.50, 100, '2025-06-30', 'Pharma Plus', 'Medicine'),
('Canine Quintuple Vaccine', 'Vaccine for dogs', 45.00, 50, '2024-12-31', 'VetCare', 'Vaccine'),
('Dewormer', 'Antiparasitic for pets', 15.75, 200, '2025-03-15', 'PetHealth', 'Medicine'),
('Veterinary Ibuprofen', 'Anti-inflammatory', 20.25, 75, '2024-09-30', 'MediVet', 'Medicine'),
('Feline Triple Vaccine', 'Vaccine for cats', 38.50, 60, '2024-11-15', 'FelineProtect', 'Vaccine'),
('Adhesive Bandages', 'Medical supply for pets', 5.99, 150, '2026-01-20', 'VetSupplies', 'Supply'),
('Disposable Syringe', 'Sterile syringe', 2.50, 500, '2025-07-10', 'MedEq', 'Supply'),
('Antiparasitic Pipettes', 'Flea and tick control', 18.75, 100, '2024-10-25', 'PetGuard', 'Medicine'),
('Saline Solution', 'Wound cleaning', 7.25, 200, '2025-05-15', 'CleanCare', 'Supply'),
('Rabies Vaccine', 'Vaccine against rabies', 30.00, 80, '2024-08-30', 'RabieStop', 'Vaccine');

INSERT INTO Medicines (type, manufacturer, due_date, id_pharmaceutical_product, dosage) VALUES
('Antibiotic', 'Pharma Plus', '2025-06-30', 1, '1 ml per 10 kg of weight, every 12 hours'),
('Antiparasitic', 'PetHealth', '2025-03-15', 3, '1 tablet per 5 kg of weight, once a month'),
('Anti-inflammatory', 'MediVet', '2024-09-30', 4, '0.5 ml per 5 kg of weight, every 24 hours'),
('Antibiotic', 'VetCare', '2024-12-31', 2, '2 ml per 15 kg of weight, every 8 hours'),
('Antiparasitic', 'PetGuard', '2024-10-25', 8, '1 pipette per pet, monthly application'),
('Antibiotic', 'LabVet', '2025-02-15', 5, '1.5 ml per 10 kg of weight, every 12 hours'),
('Anti-inflammatory', 'PainRelief', '2024-11-20', 6, '0.7 ml per 7 kg of weight, every 24 hours'),
('Antiparasitic', 'ParasiteControl', '2025-01-10', 7, '1 tablet per 8 kg of weight, every 3 months'),
('Antibiotic', 'InfectionStop', '2024-08-25', 9, '1 ml per 12 kg of weight, every 8 hours'),
('Anti-inflammatory', 'InflamCare', '2024-12-15', 10, '0.4 ml per 6 kg of weight, every 24 hours');

INSERT INTO Vaccines (name, type, date_entry, due_date, id_pharmaceutical_product, id_species, batch_number) VALUES
('Quintuple Canina', 'Viral Preventive', '2024-01-15', '2024-12-31', 2, 1, 'BATCH-DOG-001'),
('Triple Felina', 'Viral Preventive', '2024-02-20', '2024-11-15', 5, 2, 'BATCH-CAT-001'),
('Antirrábica', 'Viral Preventive', '2024-03-10', '2024-08-30', 10, 1, 'BATCH-RABIES-001'),
('Mixomatosis', 'Viral Preventive', '2024-04-05', '2025-01-20', 6, 5, 'BATCH-RABBIT-001'),
('Parainfluenza Canina', 'Viral Preventive', '2024-05-12', '2024-10-25', 8, 1, 'BATCH-DOG-002'),
('Parvovirus', 'Viral Preventive', '2024-06-18', '2024-09-30', 4, 1, 'BATCH-DOG-003'),
('Viral Felina', 'Viral Preventive', '2024-07-22', '2025-02-15', 1, 2, 'BATCH-CAT-002'),
('Guayaba', 'Viral Preventive', '2024-08-07', '2024-11-20', 3, 4, 'BATCH-HAMSTER-001'),
('Neutering', 'Hormonal Control', '2024-09-14', '2025-03-15', 7, 3, 'BATCH-BIRD-001'),
('West Nile', 'Viral Preventive', '2024-10-25', '2024-12-15', 9, 6, 'BATCH-FISH-001');

INSERT INTO Pets (name, id_species, breed, date_birth, gender, weight, height, microchip_number, allergies, chronic_conditions, last_veterinary_visit, id_owner, id_identity, id_sickness) VALUES
('Luna', 1, 'Labrador Retriever', '2020-05-15', 'Female', 25.5, 55.0, 'CHIP-001', 'Pollen', NULL, '2024-01-10 10:30:00', 1, 1, 1),
('Milo', 2, 'Siamese', '2021-03-22', 'Male', 4.2, 25.0, 'CHIP-002', 'Fish', 'Feline asthma', '2024-02-15 14:45:00', 2, 2, 5),
('Oreo', 5, 'Holland Lop', '2022-07-10', 'Male', 2.0, 30.0, 'CHIP-003', NULL, NULL, '2024-03-20 11:15:00', 3, 3, 6),
('Rocky', 1, 'German Shepherd', '2019-11-05', 'Male', 35.0, 65.0, 'CHIP-004', 'Latex', 'Hip dysplasia', '2024-04-05 09:00:00', 4, 4, 3),
('Whiskers', 2, 'Persian', '2022-01-30', 'Female', 3.8, 20.0, 'CHIP-005', 'Feathers', NULL, '2024-05-12 16:20:00', 5, 5, 2),
('Pepper', 4, 'Syrian', '2023-02-14', 'Female', 0.1, 10.0, 'CHIP-006', NULL, NULL, '2024-06-18 13:40:00', 6, 6, 7),
('Max', 1, 'Golden Retriever', '2020-09-20', 'Male', 30.0, 60.0, 'CHIP-007', 'Grass', 'Seasonal allergies', '2024-07-22 10:10:00', 7, 7, 4),
('Nala', 6, 'Betta', '2022-06-05', 'Female', 0.05, 5.0, 'CHIP-008', NULL, NULL, '2024-08-07 15:30:00', 8, 8, 8),
('Sonic', 3, 'Canary', '2021-12-12', 'Male', 0.2, 20.0, 'CHIP-009', 'Seeds', NULL, '2024-09-14 11:50:00', 9, 9, 9),
('Rex', 7, 'Red-Eared Slider', '2019-08-25', 'Male', 0.5, 15.0, 'CHIP-010', NULL, 'Shell problems', '2024-10-25 14:00:00', 10, 10, 10);

INSERT INTO MedicalProcedure (name, used_inputs, type_surgery, exam_analysis, date_procedure, price, id_pet, id_employee) VALUES
('Hip Surgery', 'Anesthesia, Scalpel, Bandages', 'Surgery', false, '2024-01-15 10:00:00', 500.00, 4, 1),
('Spaying/Neutering', 'Anesthesia, Surgical Equipment', 'Sterilization', false, '2024-02-20 14:30:00', 250.00, 3, 3),
('Chest X-ray', 'Plates, X-ray Equipment', 'Radiography', true, '2024-03-10 11:15:00', 150.00, 1, 7),
('Tooth Extraction', 'Anesthesia, Dental Tools', 'Surgery', false, '2024-04-05 09:45:00', 300.00, 2, 2),
('Skin Biopsy', 'Biopsy Kit, Local Anesthesia', 'Surgery', true, '2024-05-12 16:20:00', 200.00, 5, 9),
('General Check-up', 'Stethoscope, Thermometer', 'Radiography', true, '2024-06-18 13:40:00', 100.00, 6, 5),
('Preventive Surgery', 'Anesthesia, Surgical Equipment', 'Surgery', false, '2024-07-22 10:10:00', 400.00, 7, 1),
('Blood Test', 'Tubes, Needles, Reagents', 'Radiography', true, '2024-08-07 15:30:00', 120.00, 8, 3),
('Wound Treatment', 'Bandages, Antiseptic', 'Surgery', false, '2024-09-14 11:50:00', 180.00, 9, 6),
('Ultrasound', 'Ultrasound Equipment', 'Radiography', true, '2024-10-25 14:00:00', 250.00, 10, 4);

INSERT INTO Appointments (date_appointment, reason_visit, recommendations, id_employee, id_pet, status) VALUES
('2024-01-15 10:00:00', 'Hip Surgery', 'Complete rest for 2 weeks', 1, 4, 'Completed'),
('2024-02-20 14:30:00', 'Spaying/Neutering', 'Avoid intense exercise for 10 days', 3, 3, 'Completed'),
('2024-03-10 11:15:00', 'Routine Checkup', 'Administer annual vaccine', 7, 1, 'Completed'),
('2024-04-05 09:45:00', 'Dental Issue', 'Daily tooth brushing', 2, 2, 'Completed'),
('2024-05-12 16:20:00', 'Mole Examination', 'Follow-up in 3 months', 9, 5, 'Completed'),
('2024-06-18 13:40:00', 'General Checkup', 'Balanced diet', 5, 6, 'Completed'),
('2024-07-22 10:10:00', 'Preventive Consultation', 'Moderate exercise', 1, 7, 'Completed'),
('2024-08-07 15:30:00', 'Medical Follow-up', 'Continue medication', 3, 8, 'Completed'),
('2024-09-14 11:50:00', 'Wound Examination', 'Daily bandage change', 6, 9, 'Completed'),
('2024-10-25 14:00:00', 'Specialized Monitoring', 'Semi-annual monitoring', 4, 10, 'Completed');

INSERT INTO Suppliers (company_name, contact, email, address) VALUES
('PetCare Supplies', '3001234567', 'sales@petcaresupplies.com', '72nd Street #10-15, Bogotá'),
('Veterinary Solutions', '3009876543', 'contact@veterinarysolutions.com', '45th Avenue #23-30, Medellín'),
('Animal Health Distributors', '3002345678', 'info@animalhealthdist.com', '65th Diagonal #12-45, Cali'),
('Pet Nutrition Inc', '3007654321', 'sales@petnutrition.com', '100th Street #15-20, Barranquilla'),
('Veterinary Equipment Pro', '3003456789', 'contact@vetequippro.com', '80th Transversal #25-35, Cartagena'),
('Pet Pharma Solutions', '3006543210', 'info@petpharmasolutions.com', '15th Avenue #50-60, Pereira'),
('Animal Care Supplies', '3001122334', 'sales@animalcaresupplies.com', '30th Circular #40-50, Ibagué'),
('Vet Clinic Distributors', '3004455667', 'contact@vetclinicdist.com', '55th Street #20-25, Manizales'),
('Pet Medical Supplies', '3005566778', 'info@petmedicalsupplies.com', '70th Avenue #30-40, Armenia'),
('Veterinary Wellness Co', '3008899001', 'sales@veterwellness.com', '90th Diagonal #15-30, Bucaramanga');

INSERT INTO PurchaseOrders (purchase_date, status, id_supplier, total_amount) VALUES
('2024-01-15 10:00:00', 'Delivered', 1, 5000.50),
('2024-02-20 14:30:00', 'Delivered', 2, 7500.75),
('2024-03-10 11:15:00', 'Delivered', 3, 3200.25),
('2024-04-05 09:45:00', 'Delivered', 4, 6800.00),
('2024-05-12 16:20:00', 'Delivered', 5, 4500.60),
('2024-06-18 13:40:00', 'Delivered', 6, 2900.30),
('2024-07-22 10:10:00', 'Delivered', 7, 5600.45),
('2024-08-07 15:30:00', 'Delivered', 8, 3800.90),
('2024-09-14 11:50:00', 'Delivered', 9, 6200.75),
('2024-10-25 14:00:00', 'Delivered', 10, 4100.25);

INSERT INTO PaymentMethod (name, description) VALUES
('Cash', 'Payment in cash'),
('Credit Card', 'Payment via credit card'),
('Debit Card', 'Payment via debit card'),
('Bank Transfer', 'Payment via electronic transfer'),
('PayPal', 'Payment via PayPal platform'),
('Mercado Pago', 'Payment via Mercado Pago platform'),
('Cryptocurrency', 'Payment via cryptocurrencies'),
('Check', 'Payment via check'),
('Mobile Payment', 'Payment through mobile apps'),
('Store Credit', 'Credit accumulated in the store');

INSERT INTO Sales (date_sale, total, id_owner, id_employee) VALUES
('2024-01-15', 150.50, 1, 2),
('2024-02-20', 250.75, 2, 5),
('2024-03-10', 100.25, 3, 7),
('2024-04-05', 300.00, 4, 1),
('2024-05-12', 200.60, 5, 9),
('2024-06-18', 180.30, 6, 3),
('2024-07-22', 220.45, 7, 6),
('2024-08-07', 175.90, 8, 4),
('2024-09-14', 260.75, 9, 8),
('2024-10-25', 190.25, 10, 5);

INSERT INTO Invoice (id_sale, date_invoice, total) VALUES
(1, '2024-01-15', 150.50),
(2, '2024-02-20', 250.75),
(3, '2024-03-10', 100.25),
(4, '2024-04-05', 300.00),
(5, '2024-05-12', 200.60),
(6, '2024-06-18', 180.30),
(7, '2024-07-22', 220.45),
(8, '2024-08-07', 175.90),
(9, '2024-09-14', 260.75),
(10, '2024-10-25', 190.25);

INSERT INTO Transactions (status, date, amount, id_payment_method, id_invoice, id_owner, notes) VALUES
('Accepted', '2024-01-15 10:30:00', 150.50, 1, 1, 1, 'Cash payment'),
('Accepted', '2024-02-20 14:45:00', 250.75, 2, 2, 2, 'Payment with credit card'),
('Accepted', '2024-03-10 11:15:00', 100.25, 3, 3, 3, 'Payment with debit card'),
('Accepted', '2024-04-05 09:45:00', 300.00, 4, 4, 4, 'Bank transfer'),
('Accepted', '2024-05-12 16:20:00', 200.60, 5, 5, 5, 'Payment via PayPal'),
('Accepted', '2024-06-18 13:40:00', 180.30, 6, 6, 6, 'Payment via Mercado Pago'),
('Accepted', '2024-07-22 10:10:00', 220.45, 7, 7, 7, 'Payment with cryptocurrency'),
('Accepted', '2024-08-07 15:30:00', 175.90, 8, 8, 8, 'Payment with check'),
('Accepted', '2024-09-14 11:50:00', 260.75, 9, 9, 9, 'Mobile payment'),
('Accepted', '2024-10-25 14:00:00', 190.25, 10, 10, 10, 'Store credit');

INSERT INTO Adoption (id_pet, new_owner_id, previous_owner_id, contract_status, entry_date, adoption_date, follow_up_date, follow_up_notes) VALUES
(3, 5, 1, 'Completed', '2024-01-15', '2024-02-01', '2024-05-15', 'Satisfactory adaptation'),
(6, 2, 7, 'Completed', '2024-02-20', '2024-03-10', '2024-06-20', 'Positive follow-up'),
(9, 8, 4, 'Completed', '2024-03-10', '2024-04-05', '2024-07-10', 'Successful family integration'),
(1, 10, 6, 'Completed', '2024-04-05', '2024-05-12', '2024-08-05', 'Good relationship with the new family'),
(7, 3, 9, 'Completed', '2024-05-12', '2024-06-18', '2024-09-12', 'Happy pet in a new home'),
(4, 1, 5, 'Completed', '2024-06-18', '2024-07-22', '2024-10-18', 'Adaptation without problems'),
(2, 6, 8, 'Completed', '2024-07-22', '2024-08-07', '2024-11-22', 'Favorable follow-up'),
(5, 4, 2, 'Completed', '2024-08-07', '2024-09-14', '2024-12-07', 'Complete integration'),
(8, 7, 3, 'Completed', '2024-09-14', '2024-10-25', '2025-01-14', 'Delighted family'),
(10, 9, 5, 'Completed', '2024-10-25', '2024-11-15', '2025-02-25', 'Successful adoption');

INSERT INTO Services (name, date_service, price, details, category) VALUES
('Full Bath', '2024-01-15', 50.00, 'Bath with specialized shampoo', 'Grooming'),
('Veterinary Consultation', '2024-02-20', 80.00, 'General health check-up', 'Medical'),
('Basic Training', '2024-03-10', 120.00, 'Behavioral training', 'Training'),
('Dog Grooming', '2024-04-05', 45.00, 'Haircut and styling', 'Grooming'),
('Vaccination', '2024-05-12', 70.00, 'Administration of vaccines', 'Medical'),
('Boarding', '2024-06-18', 35.00, 'Daily pet care', 'Boarding'),
('Advanced Training', '2024-07-22', 150.00, 'Specialized training', 'Training'),
('Specialized Consultation', '2024-08-07', 100.00, 'Consultation with a specialist', 'Medical'),
('Cat Spa', '2024-09-14', 60.00, 'Beauty treatment for cats', 'Grooming'),
('Daycare', '2024-10-25', 40.00, 'Daytime care', 'Boarding');

INSERT INTO ElectronicInvoice (invoice_number, invoice_date, customer_id, veterinarian_id, service_details, 
total_amount, tax_amount, cufe, qr_code, digital_signature) VALUES
('INV001-2024', '2024-12-06 10:15:00', 1, 3, 'Vaccination: Rabies vaccine; Deworming treatment', 
 50000.00, 9000.00, '3e84fa12c9d14e67a8d2f8a1b0c12345', NULL, NULL),

('INV002-2024', '2024-12-06 11:00:00', 2, 4, 'Consultation: General health check; Prescription for antibiotics', 
 80000.00, 14400.00, '7bfa3c9a2d714f908d6b1234efa78523', NULL, NULL),

('INV003-2024', '2024-12-06 14:30:00', 3, 2, 'Surgery: Sterilization; Post-op care', 
 300000.00, 54000.00, 'af78291c30a24938b7ef9d5c1b345678', NULL, NULL),

('INV004-2024', '2024-12-06 15:45:00', 4, NULL, 'Purchase: Flea shampoo (1); Dog food (5kg)', 
 120000.00, 21600.00, '9c4f3176e5b14a60b8f2a3d1efca5678', NULL, NULL),

('INV005-2024', '2024-12-07 09:00:00', 5, 1, 'Training: Basic obedience course, first session', 
 60000.00, 10800.00, 'c89a1f02d12340e5f9b3a87efa4c5678', NULL, NULL),

('INV006-2024', '2024-12-07 10:30:00', 6, 2, 'Grooming: Full grooming session (bath, haircut, nail trimming)', 
 70000.00, 12600.00, 'b67d01234a5c980123f4e9f56abc7890', NULL, NULL),

('INV007-2024', '2024-12-07 12:00:00', 7, 3, 'Medical procedure: X-ray examination; Sedation included', 
 150000.00, 27000.00, 'd0123456fa8c9b7e123f4a0efbc56789', NULL, NULL),

('INV008-2024', '2024-12-07 13:45:00', 8, 1, 'Vaccination: Distemper and parvovirus combo vaccine', 
 90000.00, 16200.00, '4f9e123abcd5fa6789012b3c7890ef45', NULL, NULL),

('INV009-2024', '2024-12-07 15:00:00', 9, NULL, 'Adoption fee: Adult cat; Includes vaccinations and sterilization', 
 200000.00, 36000.00, '123fa8d9b4c5670e9f01abc234ef5678', NULL, NULL),

('INV010-2024', '2024-12-07 16:30:00', 10, 2, 'Boarding: 3-day stay with medication administration', 
 250000.00, 45000.00, 'a0c9b3f12d345678e901abc4ef56789a', NULL, NULL);
