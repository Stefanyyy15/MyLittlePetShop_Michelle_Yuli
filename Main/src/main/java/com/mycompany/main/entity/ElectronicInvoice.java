
package com.mycompany.main.entity;

public class ElectronicInvoice {
    private int id_electronic_invoice;
    private String invoice_number;
    private Owner id_customer;
    private Employee id_veterinarian;
    private String service_details;
    private double total_amount;
    private double tax_amount;
    private String cufe;
    private double qr_code;
    private double digital_signature;

    public ElectronicInvoice(int id_electronic_invoice, String invoice_number, Owner id_customer, Employee id_veterinarian, String service_details, double total_amount, double tax_amount, String cufe, double qr_code, double digital_signature) {
        this.id_electronic_invoice = id_electronic_invoice;
        this.invoice_number = invoice_number;
        this.id_customer = id_customer;
        this.id_veterinarian = id_veterinarian;
        this.service_details = service_details;
        this.total_amount = total_amount;
        this.tax_amount = tax_amount;
        this.cufe = cufe;
        this.qr_code = qr_code;
        this.digital_signature = digital_signature;
    }

    public int getId_electronic_invoice() {
        return id_electronic_invoice;
    }

    public void setId_electronic_invoice(int id_electronic_invoice) {
        this.id_electronic_invoice = id_electronic_invoice;
    }

    public String getInvoice_number() {
        return invoice_number;
    }

    public void setInvoice_number(String invoice_number) {
        this.invoice_number = invoice_number;
    }

    public Owner getId_customer() {
        return id_customer;
    }

    public void setId_customer(Owner id_customer) {
        this.id_customer = id_customer;
    }

    public Employee getId_veterinarian() {
        return id_veterinarian;
    }

    public void setId_veterinarian(Employee id_veterinarian) {
        this.id_veterinarian = id_veterinarian;
    }

    public String getService_details() {
        return service_details;
    }

    public void setService_details(String service_details) {
        this.service_details = service_details;
    }

    public double getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(double total_amount) {
        this.total_amount = total_amount;
    }

    public double getTax_amount() {
        return tax_amount;
    }

    public void setTax_amount(double tax_amount) {
        this.tax_amount = tax_amount;
    }

    public String getCufe() {
        return cufe;
    }

    public void setCufe(String cufe) {
        this.cufe = cufe;
    }

    public double getQr_code() {
        return qr_code;
    }

    public void setQr_code(double qr_code) {
        this.qr_code = qr_code;
    }

    public double getDigital_signature() {
        return digital_signature;
    }

    public void setDigital_signature(double digital_signature) {
        this.digital_signature = digital_signature;
    }
    
    
}
