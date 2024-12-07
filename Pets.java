// package com.mycompany.main.entity;

import java.sql.Date;

public class Pets {
//    id_pet INT PRIMARY KEY AUTO_INCREMENT,
//    name VARCHAR(100) NOT NULL,
//    id_species INT,
//    breed VARCHAR(65) NOT NULL,
//    date_birth DATE NOT NULL,
//    gender ENUM('Female', 'Male', 'Non-binary') NOT NULL,
//    weight DECIMAL(5,2) NOT NULL,
//    height DECIMAL(5,2) NOT NULL,
//    microchip_number VARCHAR(50) UNIQUE,
//    dryfood VARCHAR(100) NOT NULL,
//    numberTimes INT NOT NULL,
//    allergies TEXT,
//    chronic_conditions TEXT,
//    last_veterinary_visit DATETIME,
//    id_owner INT NOT NULL,
//    id_identity INT,
//    id_sickness INT,
    private int id_pet;
    private String name;
    private Specie specie;
    private String breed;
    private Date date_birth; // para el formato de fecha 
}
