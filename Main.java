// package com.mycompany.main;

import java.sql.*;

public class Main {

    public static void main(String[] args) throws SQLException {
        Connection connection = null;
        
        try{
            connection = ConnectionDB.getConnection();
            
            String sql = "SELECT * FROM Species";
            
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            
            ResultSet resultset = prepareStatement.executeQuery();
            
            while (resultset.next()) {
                int id = resultset.getInt("id_species");
                String nombre = resultset.getString("name");
                String description = resultset.getString("description");
                System.out.println("ID: "+ id +" Nombre "+ nombre +" Descripcion "+ description);
            }
            resultset.close();
            prepareStatement.close();
        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(connection);
        }
    } 
}
