
package com.mycompany.main.entity;

import com.mycompany.main.enums.StatusPurchaseOrder;
import java.util.Date;

public class PurchaseOrder {
    private int id_purchase_order;
    private Date purchase_date;
    private Supplier id_supplier;
    private StatusPurchaseOrder status;
    private Double total_amount;

    public PurchaseOrder(int id_purchase_order, Date purchase_date, Supplier id_supplier, StatusPurchaseOrder status_purchase_order, Double total_amount) {
        this.id_purchase_order = id_purchase_order;
        this.purchase_date = purchase_date;
        this.id_supplier = id_supplier;
        this.status = status_purchase_order;
        this.total_amount = total_amount;
    }

    public StatusPurchaseOrder getStatus() {
        return status;
    }

    public void setStatus(StatusPurchaseOrder status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "PurchaseOrders{" + "id_purchase_order=" + id_purchase_order + ", purchase_date=" + purchase_date + ", id_supplier=" + id_supplier + ", total_amount=" + total_amount + '}';
    }

    public int getId_purchase_order() {
        return id_purchase_order;
    }

    public void setId_purchase_order(int id_purchase_order) {
        this.id_purchase_order = id_purchase_order;
    }

    public Date getPurchase_date() {
        return purchase_date;
    }

    public void setPurchase_date(Date purchase_date) {
        this.purchase_date = purchase_date;
    }

    public Supplier getId_supplier() {
        return id_supplier;
    }

    public void setId_supplier(Supplier id_supplier) {
        this.id_supplier = id_supplier;
    }

    public Double getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(Double total_amount) {
        this.total_amount = total_amount;
    }
    
}
