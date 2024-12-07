//package com.mycompany.main;

import java.sql.*;

public class ConnectionDB {
    
    private static String url = "jdbc:mysql://localhost:3306/MyLittlePetShop";
    private static String user = "Empleado";
    private static String password = "MyLittlePetShop22#";
    
    public static Connection getConnection(){
        Connection connection = null;
        try{
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Conexion Establecida");
        }catch (SQLException e){
            System.out.println("Error al conectar");
            e.printStackTrace();
        }
        return connection;
   }
    public static void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
