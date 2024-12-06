// package com.mycompany.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    
    private static String url = "jdbc:mysql://localhost:3306/MyLittlePetShop";
    private static String user = "Empleado";
    private static String password = "MyLittlePetShop22#";
    
    private static Connection getConnection(){
        Connection conexion = null;
        try{
            conexion = DriverManager.getConnection(url, user, password);
            System.out.println("Conexion Establecida");
        }catch (SQLException e){
            System.out.println("Error al conectar");
        }
        return conexion;
   }
}
