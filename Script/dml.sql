USE MyLittlePetShop;

INSERT INTO Species (name, description) VALUES 
('Dog', 'Domestic canine species'),
('Cat', 'Domestic feline species'),
('Bird', 'Domestic bird species'),
('Hamster', 'Small rodent pet'),
('Rabbit', 'Domesticated rabbit'),
('Fish', 'Aquarium fish species'),
('Turtle', 'Reptilian pet species');

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

INSERT INTO Employees (first_name, last_name, second_last_name, identity_type, identification_number, wage, position_type, hire_date, email, phone, shift) VALUES
('María', 'González', 'Perez', 'CC', '1085678901', 2500.00, 'Veterinarian', '2022-03-15', 'maria.gonzalez@petshop.com', '+573001234567', 'M'),
('Carlos', 'Rodríguez', 'Sanchez', 'CC', '1087654321', 2200.00, 'Assistant', '2022-06-01', 'carlos.rodriguez@petshop.com', '+573009876543', 'A'),
('Laura', 'Martínez', 'Calderon', 'CC', '1023456789', 2800.00, 'Veterinarian', '2021-11-20', 'laura.martinez@petshop.com', '+573002345678','M'),
('Juan', 'Pérez', 'Fandiño' , 'CC', '1056789012', 2000.00, 'Groomer', '2023-01-10', 'juan.perez@petshop.com', '+573007654321', 'E'),
('Sofía', 'López', 'Robles', 'CC', '1034567890', 2300.00, 'Trainer', '2022-09-05', 'sofia.lopez@petshop.com', '+573003456789', 'M'),
('Andrés', 'Sánchez', 'Torres', 'CC', '1078978234', 2100.00, 'Assistant', '2023-02-15', 'andres.sanchez@petshop.com', '+573006543210', 'A'),
('Valentina', 'Ramírez', 'Hernandez', 'CC', '1045678907', 2600.00, 'Veterinarian', '2021-07-30', 'valentina.ramirez@petshop.com', '+573001122334', 'A'),
('Diego', 'Torres', 'Fernandez', 'CC', '1089012345', 2400.00, 'Admin', '2022-05-12', 'diego.torres@petshop.com', '+573004455667', 'A'),
('Camila', 'Herrera', 'Santacruz', 'CC', '1056789045', 2700.00, 'Veterinarian', '2022-01-25', 'camila.herrera@petshop.com', '+573005566778', 'M');

INSERT INTO Owner (first_name, last_name, identity_type, identification_number, rut, phone, email, address, emergency_contact_name, emergency_contact_phone) VALUES
('Ana', 'García', 'CC', '1045678901', '1045678901-7', '+573001234567', 'ana.garcia@email.com', '72nd Street #10-15', 'Juan García', '+573009876543'),
('Pedro', 'Morales', 'CC', '1087654321', '1087654321-4', '+573009876543', 'pedro.morales@email.com', '45th Avenue #20-30', 'María Morales', '+573001234567'),
('Luisa', 'Fernández', 'CC', '1023456789', '1023456789-5', '+573002345678', 'luisa.fernandez@email.com', '23rd Avenue #65-89', 'Carlos Fernández', '+573007654321'),
('Roberto', 'Jiménez', 'CC', '1056789012', '1056789012-2', '+573007654321', 'roberto.jimenez@email.com', '56th Street #45-67', 'Sofía Jiménez', '+573003456789'),
('Carolina', 'Navarro', 'CC', '1034567890', '1034567890-1', '+573003456789', 'carolina.navarro@email.com', '78th Street #11-33', 'Andrés Navarro', '+573006543210'),
('Javier', 'Ruiz', 'CC', '1078901234', '1078901234-6', '+573006543210', 'javier.ruiz@email.com', '89th Avenue #78-90', 'Laura Ruiz', '+573001122334'),
('Valentina', 'Mendoza', 'CC', '1045678902', '1045678902-7', '+573001122334', 'valentina.mendoza@email.com', '34th Street #23-56', 'Diego Mendoza', '+573004455667'),
('Daniel', 'Castro', 'CC', '1089012345', '1089012345-8', '+573004455667', 'daniel.castro@email.com', '12th Avenue #65-78', 'Camila Castro', '+573005566778'),
('Mariana', 'Silva', 'CC', '1056789013', '1056789013-9', '+573005566778', 'mariana.silva@email.com', '34th Street #34-56', 'Miguel Silva', '+573008899001'),
('Gustavo', 'Ortiz', 'CC', '1023456790', '1023456790-1', '+573008899001', 'gustavo.ortiz@email.com', '50th Avenue #20-40', 'Ana Ortiz', '+573002345678');

INSERT INTO PharmaceuticalProduct (name, description, price, stock_quantity, expiration_date, manufacturer) VALUES
('Amoxicillin', 'Broad-spectrum antibiotic', 25.50, 100, '2025-06-30', 'Pharma Plus'),
('Canine Quintuple Vaccine', 'Vaccine for dogs', 45.00, 50, '2024-12-31', 'VetCare'),
('Dewormer', 'Antiparasitic for pets', 15.75, 200, '2025-03-15', 'PetHealth'),
('Veterinary Ibuprofen', 'Anti-inflammatory', 20.25, 75, '2024-09-30', 'MediVet'),
('Feline Triple Vaccine', 'Vaccine for cats', 38.50, 60, '2024-11-15', 'FelineProtect'),
('Adhesive Bandages', 'Medical supply for pets', 5.99, 150, '2026-01-20', 'VetSupplies'),
('Disposable Syringe', 'Sterile syringe', 2.50, 500, '2025-07-10', 'MedEq'),
('Antiparasitic Pipettes', 'Flea and tick control', 18.75, 100, '2024-10-25', 'PetGuard'),
('Saline Solution', 'Wound cleaning', 7.25, 200, '2025-05-15', 'CleanCare'),
('Rabies Vaccine', 'Vaccine against rabies', 30.00, 80, '2024-08-30', 'RabieStop');

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

INSERT INTO Pets (name, id_species, breed, date_birth, gender, weight, height, microchip_number, tatto, dryfood, numberTimes, allergies, chronic_conditions, last_veterinary_visit, adoption_status, id_owner, id_sickness) VALUES
('Luna', 1, 'Labrador Retriever', '2020-05-15', 'Female', 25.5, 55.0, 'CHIP-001', TRUE, 'Pedigree', 3, 'Pollen', NULL, '2024-01-10 10:30:00', NULL, 1, 1),
('Milo', 2, 'Siamese', '2021-03-22', 'Male', 4.2, 25.0, 'CHIP-002', FALSE, 'Whiskas', 2, 'Fish', 'Feline asthma', '2024-02-15 14:45:00', NULL, 2, 2),
('Oreo', 5, 'Holland Lop', '2022-07-10', 'Male', 2.0, 30.0, 'CHIP-003', TRUE, 'Hay', 2, NULL, NULL, '2024-03-20 11:15:00', NULL, 3, 3),
('Rocky', 1, 'German Shepherd', '2019-11-05', 'Male', 35.0, 65.0, 'CHIP-004', FALSE, 'Dog Chow', 4, 'Latex', 'Hip dysplasia', '2024-04-05 09:00:00', NULL, 4, 4),
('Whiskers', 2, 'Persian', '2022-01-30', 'Female', 3.8, 20.0, 'CHIP-005', TRUE, 'Don Cat', 3, 'Feathers', NULL, '2024-05-12 16:20:00', NULL, 5, 5),
('Pepper', 4, 'Syrian', '2023-02-14', 'Female', 0.1, 10.0, 'CHIP-006', FALSE, 'Seeds', 2, NULL, NULL, '2024-06-18 13:40:00', NULL, 6, 6),
('Max', 1, 'Golden Retriever', '2020-09-20', 'Male', 30.0, 60.0, 'CHIP-007', TRUE, 'Ringo', 3, 'Grass', 'Seasonal allergies', '2024-07-22 10:10:00', NULL, 7, 7),
('Nala', 6, 'Betta', '2022-06-05', 'Female', 0.05, 5.0, 'CHIP-008', FALSE, 'BettaPallets', 1, NULL, NULL, '2024-08-07 15:30:00', NULL, 8, 8),
('Sonic', 3, 'Canary', '2021-12-12', 'Male', 0.2, 20.0, 'CHIP-009', TRUE, 'VitalKraft', 2, 'Seeds', NULL, '2024-09-14 11:50:00', NULL, 9, 9),
('Rex', 7, 'Red-Eared Slider', '2019-08-25', 'Male', 0.5, 15.0, 'CHIP-010', FALSE, 'ReptoMin', 2, NULL, 'Shell problems', '2024-10-25 14:00:00', NULL, 10, 10);

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

INSERT INTO Appointments (date_appointment, query_type, diagnostic, treatment, reason_visit, recommendations, id_employee, id_pet, status) VALUES
('2024-01-15 10:00:00', 'Surgery', 'Hip joint issues', 'Surgical procedure', 'Hip Surgery', 'Complete rest for 2 weeks', 1, 4, 'Completed'),
('2024-02-20 14:30:00', 'Surgery', 'Reproductive control', 'Spay/Neuter procedure', 'Spaying/Neutering', 'Avoid intense exercise for 10 days', 3, 3, 'Completed'),
('2024-03-10 11:15:00', 'Checkup', 'General health review', 'Vaccination', 'Routine Checkup', 'Administer annual vaccine', 7, 1, 'Completed'),
('2024-04-05 09:45:00', 'Dental', 'Tooth decay', 'Tooth cleaning', 'Dental Issue', 'Daily tooth brushing', 2, 2, 'Completed'),
('2024-05-12 16:20:00', 'Examination', 'Skin mole inspection', 'Observation', 'Mole Examination', 'Follow-up in 3 months', 9, 5, 'Completed'),
('2024-06-18 13:40:00', 'Checkup', 'Healthy weight check', 'Dietary advice', 'General Checkup', 'Balanced diet', 5, 6, 'Completed'),
('2024-07-22 10:10:00', 'Consultation', 'Preventive care', 'Lifestyle adjustment', 'Preventive Consultation', 'Moderate exercise', 1, 7, 'Completed'),
('2024-08-07 15:30:00', 'Follow-up', 'Ongoing treatment evaluation', 'Medication review', 'Medical Follow-up', 'Continue medication', 3, 8, 'Completed'),
('2024-09-14 11:50:00', 'Examination', 'Injury recovery', 'Wound care', 'Wound Examination', 'Daily bandage change', 6, 9, 'Completed'),
('2024-10-25 14:00:00', 'Monitoring', 'Condition tracking', 'Observation', 'Specialized Monitoring', 'Semi-annual monitoring', 4, 10, 'Completed');

INSERT INTO Suppliers (company_name, contact, email) VALUES
('PetCare Supplies', '3001234567', 'sales@petcaresupplies.com'),
('Veterinary Solutions', '3009876543', 'contact@veterinarysolutions.com'),
('Animal Health Distributors', '3002345678', 'info@animalhealthdist.com'),
('Pet Nutrition Inc', '3007654321', 'sales@petnutrition.com'),
('Veterinary Equipment Pro', '3003456789', 'contact@vetequippro.com'),
('Pet Pharma Solutions', '3006543210', 'info@petpharmasolutions.com'),
('Animal Care Supplies', '3001122334', 'sales@animalcaresupplies.com'),
('Vet Clinic Distributors', '3004455667', 'contact@vetclinicdist.com'),
('Pet Medical Supplies', '3005566778', 'info@petmedicalsupplies.com'),
('Veterinary Wellness Co', '3008899001', 'sales@veterwellness.com');

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

INSERT INTO Sales (name, date_sale, total, id_owner, id_employee, id_appointment) VALUES
('Product Purchase', '2024-01-15', 150.50, 1, 2, 1),
('Surgery Payment', '2024-02-20', 250.75, 2, 5, 2),
('Routine Checkup', '2024-03-10', 100.25, 3, 7, 3),
('Dental Cleaning', '2024-04-05', 300.00, 4, 1, 4),
('Skin Treatment', '2024-05-12', 200.60, 5, 9, 5),
('Vaccination', '2024-06-18', 180.30, 6, 3, 6),
('Preventive Care', '2024-07-22', 220.45, 7, 6, 7),
('Follow-Up Visit', '2024-08-07', 175.90, 8, 4, 8),
('Injury Recovery', '2024-09-14', 260.75, 9, 8, 9),
('Special Monitoring', '2024-10-25', 190.25, 10, 5, 10);

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

INSERT INTO SpecialActivities (name, description, date_special_activity, place, type) VALUES
('Annual Pet Vaccination Day', 'Mass vaccination event for pets in the community', '2024-03-15', 'City Central Park', 'Vaccination'),
('Adoption Weekend', 'Special weekend for pet adoptions with reduced fees', '2024-04-20', 'Pet Shop Main Location', 'Adoption'),
('Puppy Training Workshop', 'Intensive training program for new dog owners', '2024-05-10', 'Pet Shop Training Center', 'Training'),
('Senior Pet Health Check', 'Free health screenings for older pets', '2024-06-25', 'City Veterinary Clinic', 'Health Check'),
('Summer Pet Wellness Fair', 'Community event with multiple veterinary services', '2024-07-12', 'Community Sports Center', 'Vaccination'),
('Rescue Pet Adoption Drive', 'Special event to find homes for rescued animals', '2024-08-18', 'Local Animal Shelter', 'Adoption'),
('Advanced Dog Training Seminar', 'Professional training techniques for dog owners', '2024-09-05', 'Conference Hall', 'Training'),
('Pediatric Pet Health Day', 'Specialized health checks for young animals', '2024-10-03', 'Pet Shop Main Location', 'Health Check'),
('Winter Vaccination Campaign', 'Preventive vaccination event for multiple species', '2024-11-16', 'City Community Center', 'Vaccination'),
('Holiday Pet Socialization Workshop', 'Group training and socialization for pets', '2024-12-07', 'Pet Shop Training Center', 'Training');

INSERT INTO TypeExpense (name, description) VALUES
('Operational Costs', 'Daily running expenses of the pet shop'),
('Medical Supplies', 'Costs related to medical equipment and pharmaceuticals'),
('Staff Salaries', 'Monthly wages and compensation for employees'),
('Maintenance', 'Repair and upkeep of facilities and equipment'),
('Marketing', 'Advertising and promotional expenses'),
('Utilities', 'Electricity, water, internet, and other service bills'),
('Training', 'Costs associated with staff and pet training programs'),
('Inventory Restocking', 'Purchasing new products for sale'),
('Insurance', 'Business and liability insurance premiums'),
('Professional Services', 'External consultant and professional fees');

INSERT INTO Expenses (name, payment_day, amount, id_type_expense, description) VALUES
('Monthly Electricity Bill', '2024-01-15', 1200.50, 6, 'Electricity expenses for the pet shop and clinic'),
('Staff Salaries - January', '2024-01-30', 45000.75, 3, 'Monthly wages for all employees'),
('Medical Equipment Repair', '2024-02-05', 3500.25, 2, 'Maintenance and repair of veterinary equipment'),
('Advertising Campaign', '2024-02-15', 5000.00, 5, 'Social media and local advertising promotions'),
('Inventory Restock - Pet Food', '2024-03-10', 8750.60, 8, 'Purchasing new stock of pet food and supplies'),
('Annual Insurance Premium', '2024-03-25', 12000.00, 9, 'Comprehensive business insurance coverage'),
('Training Workshop Expenses', '2024-04-05', 2500.30, 7, 'Costs for organizing staff and pet training programs'),
('Office Maintenance', '2024-04-15', 4200.45, 4, 'Repairs and maintenance of office and clinic spaces'),
('Consultant Fees', '2024-05-01', 7500.75, 10, 'Payment for external business consultancy services'),
('Water and Internet Bill', '2024-05-15', 950.25, 6, 'Monthly utility expenses');

INSERT INTO MedicalSupplies (type, supplies, id_pharmaceutical_product) VALUES
('Surgical Kit', 'Sterile scalpels, surgical scissors, forceps, needle holders', 2),
('Diagnostic Tools', 'Digital thermometer, otoscope, ophthalmoscope', 5),
('Wound Care', 'Sterile gauze, wound dressings, medical tape, antiseptic solution', 6),
('Laboratory Supplies', 'Blood collection tubes, slides, microscope slides, pipettes', 1),
('Anesthesia Equipment', 'Anesthesia machine, oxygen mask, breathing circuit', 4),
('Dental Care', 'Dental probes, scalers, dental mirrors, tooth extraction forceps', 3),
('Vaccination Supplies', 'Sterile syringes, vaccine storage containers, cooling packs', 10),
('Emergency Kit', 'Defibrillator pads, emergency medications, intubation equipment', 8),
('Radiology Supplies', 'X-ray film, protective aprons, positioning blocks', 7),
('Intensive Care Supplies', 'IV sets, central line kits, monitoring leads', 9);

INSERT INTO ProductSalesDetails (id_pharmaceutical_product, id_sale, amount) VALUES
(1, 1, 5),
(2, 2, 3),
(3, 3, 7),
(4, 4, 10),
(5, 5, 2),
(6, 6, 8),
(7, 7, 1),
(8, 8, 4),
(9, 9, 6),
(10, 10, 9);

INSERT INTO DetailsSalesServices (id_service, id_sale, amount) VALUES
(1, 1, 2),
(2, 2, 1),
(3, 3, 4),
(4, 4, 3),
(5, 5, 5),
(6, 6, 2),
(7, 7, 6),
(8, 8, 1),
(9, 9, 3),
(10, 10, 7);

INSERT INTO ProcedureSalesDetails (id_medical_procedure, id_sale, amount) VALUES
(1, 1, 1),
(2, 2, 3),
(3, 3, 2),
(4, 4, 4),
(5, 5, 5),
(6, 6, 6),
(7, 7, 1),
(8, 8, 3),
(9, 9, 7),
(10, 10, 9);

INSERT INTO DetailsPurchaseOrder (id_pharmaceutical_product, id_purchase_order, amount) VALUES
(1, 1, 10),
(2, 2, 5),
(3, 3, 7),
(4, 4, 3),
(5, 5, 8),
(6, 6, 4),
(7, 7, 2),
(8, 8, 9),
(9, 9, 6),
(10, 10, 1);
