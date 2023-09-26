
package com.model;

import java.util.Date;
import java.sql.Timestamp;

public class Invoice {
    private int invoice_id;
    private String payment_Method;
    private Timestamp date;
    private double grand_Total;
    private int customer_id;
    private int created_By;

    public int getInvoice_id() {
        return invoice_id;
    }

    public void setInvoice_id(int invoice_id) {
        this.invoice_id = invoice_id;
    }

    public String getPayment_Method() {
        return payment_Method;
    }

    public void setPayment_Method(String payment_Method) {
        this.payment_Method = payment_Method;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public double getGrand_Total() {
        return grand_Total;
    }

    public void setGrand_Total(double grand_Total) {
        this.grand_Total = grand_Total;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getCreated_By() {
        return created_By;
    }

    public void setCreated_By(int created_By) {
        this.created_By = created_By;
    }

  
   
    
}
