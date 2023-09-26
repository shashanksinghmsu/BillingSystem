package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Customer {

 
       private int customer_id;
       private String customer_Name;
       private String customer_Email;
       private String customer_Phone;
       private String customer_Address;
       private String customer_Type;

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getCustomer_Name() {
        return customer_Name;
    }

    public void setCustomer_Name(String customer_Name) {
        this.customer_Name = customer_Name;
    }

    public String getCustomer_Email() {
        return customer_Email;
    }

    public void setCustomer_Email(String customer_Email) {
        this.customer_Email = customer_Email;
    }

    public String getCustomer_Phone() {
        return customer_Phone;
    }

    public void setCustomer_Phone(String customer_Phone) {
        this.customer_Phone = customer_Phone;
    }

    public String getCustomer_Address() {
        return customer_Address;
    }

    public void setCustomer_Address(String customer_Address) {
        this.customer_Address = customer_Address;
    }

    public String getCustomer_Type() {
        return customer_Type;
    }

    public void setCustomer_Type(String customer_Type) {
        this.customer_Type = customer_Type;
    }
       
    @Override
    public String toString() {
        return "Customer{" + "customer_id=" + customer_id + ", customer_Name=" + customer_Name + ", customer_Email=" + customer_Email + ", customer_Phone=" + customer_Phone + ", customer_Address=" + customer_Address + ", customer_Type=" + customer_Type + '}';
    }
	
       
	

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
  
	}

}
