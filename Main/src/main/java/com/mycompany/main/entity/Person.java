
package com.mycompany.main.entity;

import com.mycompany.main.enums.IdentityType;

public abstract class Person {
    private String first_name;
    private String last_name;
    private IdentityType identity_type;
    private String identification_number;
    private String rut;
    private String phone;
    private String email;
    
    private String emergency_contact_name;
    private String emergency_contact_phone;

    public Person(String first_name, String last_name) {
        this.first_name = first_name;
        this.last_name = last_name;
    }

    public Person() {
    }

    public Person(String first_name, String last_name, IdentityType identity_type, String identification_number, String rut, String phone, String email, String emergency_contact_name, String emergency_contact_phone) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.identity_type = identity_type;
        this.identification_number = identification_number;
        this.rut = rut;
        this.phone = phone;
        this.email = email;
        this.emergency_contact_name = emergency_contact_name;
        this.emergency_contact_phone = emergency_contact_phone;
    }
   

    public String getFirst_name() {
        return first_name;
    }
    
    public String getName() {
    return first_name + " " + last_name;
}

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public IdentityType getIdentify_type() {
        return identity_type;
    }

    public void setIdentify_type(IdentityType identify_type) {
        this.identity_type = identify_type;
    }

    public String getIdentification_number() {
        return identification_number;
    }

    public void setIdentification_number(String identification_number) {
        this.identification_number = identification_number;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmergency_contact_name() {
        return emergency_contact_name;
    }

    public void setEmergency_contact_name(String emergency_contact_name) {
        this.emergency_contact_name = emergency_contact_name;
    }

    public String getEmergency_contact_phone() {
        return emergency_contact_phone;
    }

    public void setEmergency_contact_phone(String emergency_contact_phone) {
        this.emergency_contact_phone = emergency_contact_phone;
    }
    
    
}
