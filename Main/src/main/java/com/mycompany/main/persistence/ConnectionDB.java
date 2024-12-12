package com.mycompany.main.persistence;

import java.sql.*;

public class ConnectionDB {
    
    private static String url = "jdbc:mysql://localhost:3306/MyLittlePetShop";
    private static String user = "Employee";
    private static String password = "MyLittlePetShop22#";
    
    public static Connection getConnection(){
        Connection connection = null;
        try{
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Successful connection");
        }catch (SQLException e){
            System.out.println("Error connecting");
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



//Connection connection = null;
//        
//        try{
//            connection = ConnectionDB.getConnection();
//            
//            String sql = "SELECT * FROM Species";
//            
//            try (PreparedStatement prepareStatement = connection.prepareStatement(sql)) {
//                ResultSet resultset = prepareStatement.executeQuery();
//                
//                while (resultset.next()) {
//                    int id = resultset.getInt("id_species");
//                    String nombre = resultset.getString("name");
//                    String description = resultset.getString("description");
//                    System.out.println("ID: "+ id +" Nombre "+ nombre +" Descripcion "+ description);
//                }
//                resultset.close();
//            }
//        }catch(SQLException e){
//            e.printStackTrace();
//        }finally {
//            ConnectionDB.closeConnection(connection);
//        }