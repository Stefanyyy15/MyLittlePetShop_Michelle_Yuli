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

INSERT INTO Sickness (name, type_sickness_id, description) VALUES
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
('María', 'González', 'CC', '1045678901', 2500.00, 'Veterinarian', '2022-03-15', 'maria.gonzalez@petshop.com', '+573001234567'),
('Carlos', 'Rodríguez', 'CC', '1087654321', 2200.00, 'Assistant', '2022-06-01', 'carlos.rodriguez@petshop.com', '+573009876543'),
('Laura', 'Martínez', 'CC', '1023456789', 2800.00, 'Veterinarian', '2021-11-20', 'laura.martinez@petshop.com', '+573002345678'),
('Juan', 'Pérez', 'CC', '1056789012', 2000.00, 'Groomer', '2023-01-10', 'juan.perez@petshop.com', '+573007654321'),
('Sofía', 'López', 'CC', '1034567890', 2300.00, 'Trainer', '2022-09-05', 'sofia.lopez@petshop.com', '+573003456789'),
('Andrés', 'Sánchez', 'CC', '1078901234', 2100.00, 'Assistant', '2023-02-15', 'andres.sanchez@petshop.com', '+573006543210'),
('Valentina', 'Ramírez', 'CC', '1045678901', 2600.00, 'Veterinarian', '2021-07-30', 'valentina.ramirez@petshop.com', '+573001122334'),
('Diego', 'Torres', 'CC', '1089012345', 2400.00, 'Admin', '2022-05-12', 'diego.torres@petshop.com', '+573004455667'),
('Camila', 'Herrera', 'CC', '1056789012', 2700.00, 'Veterinarian', '2022-01-25', 'camila.herrera@petshop.com', '+573005566778'),
('Miguel', 'Díaz', 'CC', '1023456789', 2150.00, 'Groomer', '2023-04-01', 'miguel.diaz@petshop.com', '+573008899001');

INSERT INTO Owner (first_name, last_name, identity_type, identification_number, rut, phone, email, emergency_contact_name, emergency_contact_phone) VALUES
('Ana', 'García', 'CC', '1045678901', 'RUT-001', '+573001234567', 'ana.garcia@email.com', 'Juan García', '+573009876543'),
('Pedro', 'Morales', 'CC', '1087654321', 'RUT-002', '+573009876543', 'pedro.morales@email.com', 'María Morales', '+573001234567'),
('Luisa', 'Fernández', 'CC', '1023456789', 'RUT-003', '+573002345678', 'luisa.fernandez@email.com', 'Carlos Fernández', '+573007654321'),
('Roberto', 'Jiménez', 'CC', '1056789012', 'RUT-004', '+573007654321', 'roberto.jimenez@email.com', 'Sofía Jiménez', '+573003456789'),
('Carolina', 'Navarro', 'CC', '1034567890', 'RUT-005', '+573003456789', 'carolina.navarro@email.com', 'Andrés Navarro', '+573006543210'),
('Javier', 'Ruiz', 'CC', '1078901234', 'RUT-006', '+573006543210', 'javier.ruiz@email.com', 'Laura Ruiz', '+573001122334'),
('Valentina', 'Mendoza', 'CC', '1045678902', 'RUT-007', '+573001122334', 'valentina.mendoza@email.com', 'Diego Mendoza', '+573004455667'),
('Daniel', 'Castro', 'CC', '1089012345', 'RUT-008', '+573004455667', 'daniel.castro@email.com', 'Camila Castro', '+573005566778'),
('Mariana', 'Silva', 'CC', '1056789013', 'RUT-009', '+573005566778', 'mariana.silva@email.com', 'Miguel Silva', '+573008899001'),
('Gustavo', 'Ortiz', 'CC', '1023456790', 'RUT-010', '+573008899001', 'gustavo.ortiz@email.com', 'Ana Ortiz', '+573002345678');

INSERT INTO Address (id_owner, type_via, address, indications) VALUES
(1, 'Street', 'Calle 72 #10-15', 'Casa blanca con puerta verde'),
(2, 'Avenue', 'Carrera 45 #23-30', 'Edificio azul, apartamento 302'),
(3, 'Diagonal', 'Diagonal 65 #12-45', 'Conjunto residencial Torres del Parque'),
(4, 'Street', 'Calle 100 #15-20', 'Casa esquinera, reja negra'),
(5, 'Transversal', 'Transversal 80 #25-35', 'Edificio amarillo, tercer piso'),
(6, 'Avenue', 'Carrera 15 #50-60', 'Casa con jardín grande'),
(7, 'Circle', 'Circular 30 #40-50', 'Conjunto cerrado, casa número 7'),
(8, 'Street', 'Calle 55 #20-25', 'Casa con portón café'),
(9, 'Avenue', 'Carrera 70 #30-40', 'Edificio moderno, apartamento 504'),
(10, 'Diagonal', 'Diagonal 90 #15-30', 'Casa con terraza');

INSERT INTO PharmaceuticalProduct (name, description, price, stock_quantity, expiration_date, manufacturer, product_type) VALUES
('Amoxicilina', 'Antibiótico de amplio espectro', 25.50, 100, '2025-06-30', 'Pharma Plus', 'Medicine'),
('Vacuna Quintuple Canina', 'Vacuna para perros', 45.00, 50, '2024-12-31', 'VetCare', 'Vaccine'),
('Desparasitante', 'Antiparasitario para mascotas', 15.75, 200, '2025-03-15', 'PetHealth', 'Medicine'),
('Ibuprofeno Veterinario', 'Antiinflamatorio', 20.25, 75, '2024-09-30', 'MediVet', 'Medicine'),
('Vacuna Felina Triple', 'Vacuna para gatos', 38.50, 60, '2024-11-15', 'FelineProtect', 'Vaccine'),
('Vendas Adhesivas', 'Suministro médico para mascotas', 5.99, 150, '2026-01-20', 'VetSupplies', 'Supply'),
('Jeringa Desechable', 'Jeringa estéril', 2.50, 500, '2025-07-10', 'MedEq', 'Supply'),
('Pipetas Antiparasitarias', 'Control de pulgas y garrapatas', 18.75, 100, '2024-10-25', 'PetGuard', 'Medicine'),
('Solución Salina', 'Limpieza de heridas', 7.25, 200, '2025-05-15', 'CleanCare', 'Supply'),
('Vacuna Antirábica', 'Vacuna contra la rabia', 30.00, 80, '2024-08-30', 'RabieStop', 'Vaccine');

INSERT INTO Medicines (type, manufacturer, due_date, pharmaceutical_product_id, dosage) VALUES
('Antibiotic', 'Pharma Plus', '2025-06-30', 1, '1 ml por cada 10 kg de peso, cada 12 horas'),
('Antiparasitic', 'PetHealth', '2025-03-15', 3, '1 tableta por cada 5 kg de peso, una vez al mes'),
('Anti-inflammatory', 'MediVet', '2024-09-30', 4, '0.5 ml por cada 5 kg de peso, cada 24 horas'),
('Antibiotic', 'VetCare', '2024-12-31', 2, '2 ml por cada 15 kg de peso, cada 8 horas'),
('Antiparasitic', 'PetGuard', '2024-10-25', 8, '1 pipeta por mascota, aplicación mensual'),
('Antibiotic', 'LabVet', '2025-02-15', 5, '1.5 ml por cada 10 kg de peso, cada 12 horas'),
('Anti-inflammatory', 'PainRelief', '2024-11-20', 6, '0.7 ml por cada 7 kg de peso, cada 24 horas'),
('Antiparasitic', 'ParasiteControl', '2025-01-10', 7, '1 tableta por cada 8 kg de peso, cada 3 meses'),
('Antibiotic', 'InfectionStop', '2024-08-25', 9, '1 ml por cada 12 kg de peso, cada 8 horas'),
('Anti-inflammatory', 'InflamCare', '2024-12-15', 10, '0.4 ml por cada 6 kg de peso, cada 24 horas');

INSERT INTO Vaccines (name, type, date_entry, due_date, pharmaceutical_product_id, species_id, batch_number) VALUES
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

INSERT INTO Pets (name, species_id, breed, date_birth, gender, weight, height, microchip_number, allergies, chronic_conditions, last_veterinary_visit, owner_id, identity_id, sickness_id) VALUES
('Luna', 1, 'Labrador Retriever', '2020-05-15', 'Female', 25.5, 55.0, 'CHIP-001', 'Polen', NULL, '2024-01-10 10:30:00', 1, 1, 1),
('Milo', 2, 'Siamese', '2021-03-22', 'Male', 4.2, 25.0, 'CHIP-002', 'Pescado', 'Asma felino', '2024-02-15 14:45:00', 2, 2, 5),
('Oreo', 5, 'Holland Lop', '2022-07-10', 'Male', 2.0, 30.0, 'CHIP-003', NULL, NULL, '2024-03-20 11:15:00', 3, 3, 6),
('Rocky', 1, 'German Shepherd', '2019-11-05', 'Male', 35.0, 65.0, 'CHIP-004', 'Latex', 'Displasia de cadera', '2024-04-05 09:00:00', 4, 4, 3),
('Whiskers', 2, 'Persian', '2022-01-30', 'Female', 3.8, 20.0, 'CHIP-005', 'Plumas', NULL, '2024-05-12 16:20:00', 5, 5, 2),
('Pepper', 4, 'Syrian', '2023-02-14', 'Female', 0.1, 10.0, 'CHIP-006', NULL, NULL, '2024-06-18 13:40:00', 6, 6, 7),
('Max', 1, 'Golden Retriever', '2020-09-20', 'Male', 30.0, 60.0, 'CHIP-007', 'Césped', 'Alergias estacionales', '2024-07-22 10:10:00', 7, 7, 4),
('Nala', 6, 'Betta', '2022-06-05', 'Female', 0.05, 5.0, 'CHIP-008', NULL, NULL, '2024-08-07 15:30:00', 8, 8, 8),
('Sonic', 3, 'Canario', '2021-12-12', 'Male', 0.2, 20.0, 'CHIP-009', 'Semillas', NULL, '2024-09-14 11:50:00', 9, 9, 9),
('Rex', 7, 'Red-Eared Slider', '2019-08-25', 'Male', 0.5, 15.0, 'CHIP-010', NULL, 'Problemas de caparazón', '2024-10-25 14:00:00', 10, 10, 10);

INSERT INTO MedicalProcedure (name, used_inputs, type_surgery, exam_analysis, date_procedure, price, pet_id, employee_id) VALUES
('Cirugía de Cadera', 'Anestesia, Bisturí, Vendas', 'Surgery', false, '2024-01-15 10:00:00', 500.00, 4, 1),
('Esterilización', 'Anestesia, Equipo Quirúrgico', 'Sterilization', false, '2024-02-20 14:30:00', 250.00, 3, 3),
('Radiografía de Tórax', 'Placas, Equipo de Rayos X', 'Radiography', true, '2024-03-10 11:15:00', 150.00, 1, 7),
('Extracción Dental', 'Anestesia, Instrumental Dental', 'Surgery', false, '2024-04-05 09:45:00', 300.00, 2, 2),
('Biopsia de Piel', 'Kit de Biopsia, Anestesia Local', 'Surgery', true, '2024-05-12 16:20:00', 200.00, 5, 9),
('Chequeo General', 'Estetoscopio, Termómetro', 'Radiography', true, '2024-06-18 13:40:00', 100.00, 6, 5),
('Cirugía Preventiva', 'Anestesia, Equipo Quirúrgico', 'Surgery', false, '2024-07-22 10:10:00', 400.00, 7, 1),
('Análisis de Sangre', 'Tubos, Agujas, Reactivos', 'Radiography', true, '2024-08-07 15:30:00', 120.00, 8, 3),
('Tratamiento de Herida', 'Vendas, Antiséptico', 'Surgery', false, '2024-09-14 11:50:00', 180.00, 9, 6),
('Ecografía', 'Equipo de Ultrasonido', 'Radiography', true, '2024-10-25 14:00:00', 250.00, 10, 4);

INSERT INTO Appointments (date_appointment, reason_visit, recommendations, employee_id, pet_id, status) VALUES
('2024-01-15 10:00:00', 'Cirugía de Cadera', 'Reposo absoluto por 2 semanas', 1, 4, 'Completed'),
('2024-02-20 14:30:00', 'Esterilización', 'Evitar ejercicios intensos por 10 días', 3, 3, 'Completed'),
('2024-03-10 11:15:00', 'Chequeo Rutinario', 'Realizar vacuna anual', 7, 1, 'Completed'),
('2024-04-05 09:45:00', 'Problema Dental', 'Cepillado diario de dientes', 2, 2, 'Completed'),
('2024-05-12 16:20:00', 'Revisión de Lunar', 'Control en 3 meses', 9, 5, 'Completed'),
('2024-06-18 13:40:00', 'Chequeo General', 'Dieta balanceada', 5, 6, 'Completed'),
('2024-07-22 10:10:00', 'Consulta Preventiva', 'Ejercicio moderado', 1, 7, 'Completed'),
('2024-08-07 15:30:00', 'Seguimiento Médico', 'Continuar medicamento', 3, 8, 'Completed'),
('2024-09-14 11:50:00', 'Revisión de Herida', 'Cambio de vendaje diario', 6, 9, 'Completed'),
('2024-10-25 14:00:00', 'Control Especializado', 'Monitoreo semestral', 4, 10, 'Completed');

INSERT INTO Suppliers (company_name, contact, email, address) VALUES
('PetCare Supplies', '3001234567', 'ventas@petcaresupplies.com', 'Calle 72 #10-15, Bogotá'),
('Veterinary Solutions', '3009876543', 'contacto@veterinarysolutions.com', 'Carrera 45 #23-30, Medellín'),
('Animal Health Distributors', '3002345678', 'info@animalhealthdist.com', 'Diagonal 65 #12-45, Cali'),
('Pet Nutrition Inc', '3007654321', 'ventas@petnutrition.com', 'Calle 100 #15-20, Barranquilla'),
('Veterinary Equipment Pro', '3003456789', 'contacto@vetequippro.com', 'Transversal 80 #25-35, Cartagena'),
('Pet Pharma Solutions', '3006543210', 'info@petpharmasolutions.com', 'Carrera 15 #50-60, Pereira'),
('Animal Care Supplies', '3001122334', 'ventas@animalcaresupplies.com', 'Circular 30 #40-50, Ibagué'),
('Vet Clinic Distributors', '3004455667', 'contacto@vetclinicdist.com', 'Calle 55 #20-25, Manizales'),
('Pet Medical Supplies', '3005566778', 'info@petmedicalsupplies.com', 'Carrera 70 #30-40, Armenia'),
('Veterinary Wellness Co', '3008899001', 'ventas@veterwellness.com', 'Diagonal 90 #15-30, Bucaramanga');

INSERT INTO PurchaseOrders (purchase_date, status, supplier_id, total_amount) VALUES
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
('Efectivo', 'Pago en dinero en efectivo'),
('Tarjeta de Crédito', 'Pago mediante tarjeta de crédito'),
('Tarjeta de Débito', 'Pago mediante tarjeta de débito'),
('Transferencia Bancaria', 'Pago por transferencia electrónica'),
('PayPal', 'Pago mediante plataforma PayPal'),
('Mercado Pago', 'Pago mediante plataforma Mercado Pago'),
('Cryptocurrency', 'Pago mediante criptomonedas'),
('Cheque', 'Pago mediante cheque'),
('Pago Móvil', 'Pago a través de aplicaciones móviles'),
('Crédito en Tienda', 'Crédito acumulado en la tienda');

INSERT INTO Sales (date_sale, total, owner_id, employee_id) VALUES
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

INSERT INTO Invoice (sale_id, date_invoice, total) VALUES
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

INSERT INTO Transactions (status, date, amount, payment_method_id, invoice_id, customer_id, notes) VALUES
('Accepted', '2024-01-15 10:30:00', 150.50, 1, 1, 1, 'Pago en efectivo'),
('Accepted', '2024-02-20 14:45:00', 250.75, 2, 2, 2, 'Pago con tarjeta de crédito'),
('Accepted', '2024-03-10 11:15:00', 100.25, 3, 3, 3, 'Pago con tarjeta de débito'),
('Accepted', '2024-04-05 09:45:00', 300.00, 4, 4, 4, 'Transferencia bancaria'),
('Accepted', '2024-05-12 16:20:00', 200.60, 5, 5, 5, 'Pago por PayPal'),
('Accepted', '2024-06-18 13:40:00', 180.30, 6, 6, 6, 'Pago por Mercado Pago'),
('Accepted', '2024-07-22 10:10:00', 220.45, 7, 7, 7, 'Pago con criptomoneda'),
('Accepted', '2024-08-07 15:30:00', 175.90, 8, 8, 8, 'Pago con cheque'),
('Accepted', '2024-09-14 11:50:00', 260.75, 9, 9, 9, 'Pago móvil'),
('Accepted', '2024-10-25 14:00:00', 190.25, 10, 10, 10, 'Crédito en tienda');

INSERT INTO Adoption (pet_id, new_owner_id, previous_owner_id, contract_status, entry_date, adoption_date, follow_up_date, follow_up_notes) VALUES
(3, 5, 1, 'Completed', '2024-01-15', '2024-02-01', '2024-05-15', 'Adaptación satisfactoria'),
(6, 2, 7, 'Completed', '2024-02-20', '2024-03-10', '2024-06-20', 'Seguimiento positivo'),
(9, 8, 4, 'Completed', '2024-03-10', '2024-04-05', '2024-07-10', 'Integración familiar exitosa'),
(1, 10, 6, 'Completed', '2024-04-05', '2024-05-12', '2024-08-05', 'Buena relación con nueva familia'),
(7, 3, 9, 'Completed', '2024-05-12', '2024-06-18', '2024-09-12', 'Mascota feliz en nuevo hogar'),
(4, 1, 5, 'Completed', '2024-06-18', '2024-07-22', '2024-10-18', 'Adaptación sin problemas'),
(2, 6, 8, 'Completed', '2024-07-22', '2024-08-07', '2024-11-22', 'Seguimiento favorable'),
(5, 4, 2, 'Completed', '2024-08-07', '2024-09-14', '2024-12-07', 'Integración completa'),
(8, 7, 3, 'Completed', '2024-09-14', '2024-10-25', '2025-01-14', 'Familia encantada'),
(10, 9, 5, 'Completed', '2024-10-25', '2024-11-15', '2025-02-25', 'Adopción exitosa');

INSERT INTO Services (name, date_service, price, details, category) VALUES
('Baño Completo', '2024-01-15', 50.00, 'Baño con shampoo especializado', 'Grooming'),
('Consulta Veterinaria', '2024-02-20', 80.00, 'Chequeo general de salud', 'Medical'),
('Adiestramiento Básico', '2024-03-10', 120.00, 'Entrenamiento de comportamiento', 'Training'),
('Peluquería Canina', '2024-04-05', 45.00, 'Corte de pelo y arreglo', 'Grooming'),
('Vacunación', '2024-05-12', 70.00, 'Aplicación de vacunas', 'Medical'),
('Hospedaje', '2024-06-18', 35.00, 'Cuidado diario de mascota', 'Boarding'),
('Entrenamiento Avanzado', '2024-07-22', 150.00, 'Entrenamiento especializado', 'Training'),
('Consulta Especializada', '2024-08-07', 100.00, 'Consulta con especialista', 'Medical'),
('Spa Felino', '2024-09-14', 60.00, 'Tratamiento de belleza para gatos', 'Grooming'),
('Guardería Diurna', '2024-10-25', 40.00, 'Cuidado durante el día', 'Boarding');