
package com.mycompany.main.entity;

import java.util.Date;

public class Invoice {
    private int id_invoice;
    private Date date_invoice;
    private Double price;

    public Invoice(int id_invoice, Date date_invoice, Double price) {
        this.id_invoice = id_invoice;
        this.date_invoice = date_invoice;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Invoice{" + "id_invoice=" + 
                id_invoice + ", date_invoice=" + 
                date_invoice + ", price=" + 
                price + '}';
    }

    public int getId_invoice() {
        return id_invoice;
    }

    public void setId_invoice(int id_invoice) {
        this.id_invoice = id_invoice;
    }

    public Date getDate_invoice() {
        return date_invoice;
    }

    public void setDate_invoice(Date date_invoice) {
        this.date_invoice = date_invoice;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
