
package com.mycompany.main.entity;

import com.mycompany.main.enums.TypeSickness;

public class Sickness {
    private int id_sickness;
    private String name;
    private String description;
    private TypeSickness id_type_sickness;

    public Sickness(int id_sickness, String name) {
        this.id_sickness = id_sickness;
        this.name = name;
    }
    
    

    public Sickness(String name, String description, TypeSickness id_type_sickness) {
        this.name = name;
        this.description = description;
        this.id_type_sickness = id_type_sickness;
    }

    public int getId_sickness() {
        return id_sickness;
    }

    public void setId_sickness(int id_sickness) {
        this.id_sickness = id_sickness;
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

    public TypeSickness getId_type_sickness() {
        return id_type_sickness;
    }

    public void setId_type_sickness(TypeSickness id_type_sickness) {
        this.id_type_sickness = id_type_sickness;
    }

}
