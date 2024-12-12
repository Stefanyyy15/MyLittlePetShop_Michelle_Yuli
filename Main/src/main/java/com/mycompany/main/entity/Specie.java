
package com.mycompany.main.entity;

import com.mycompany.main.persistence.ConnectionDB;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Specie {
    private int id_specie;
    private String name;
    private String description;

    public Specie(int id_specie, String name, String description) {
        this.id_specie = id_specie;
        this.name = name;
        this.description = description;
    }

    public Specie() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int getId_specie() {
        return id_specie;
    }

    public void setId_specie(int id_specie) {
        this.id_specie = id_specie;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public List<Specie> seeSpecie() throws SQLException{
        List<Specie> specie = new ArrayList<>();
        String sql = "SELECT * FROM Species";
        
        try(Connection con = ConnectionDB.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()){
            
            while (rs.next()) {
                int id_specie = rs.getInt("id_species");
                String name = rs.getString("name");
                String description = rs.getString("description");

                specie.add(new Specie(id_specie, name, description));
            
        }
        return specie;
    }
    
}}
