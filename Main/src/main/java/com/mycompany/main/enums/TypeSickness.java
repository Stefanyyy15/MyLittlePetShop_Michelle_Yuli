
package com.mycompany.main.enums;

public class TypeSickness {
    private int id_type_sickness;
    private String name;
    private String description;

    public TypeSickness(int id_type_sickness, String name, String description) {
        this.id_type_sickness = id_type_sickness;
        this.name = name;
        this.description = description;
    }

    public int getId_type_sickness() {
        return id_type_sickness;
    }

    public void setId_type_sickness(int id_type_sickness) {
        this.id_type_sickness = id_type_sickness;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
