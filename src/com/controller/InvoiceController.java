package com.controller;

import com.dbconnection.DBConnection;
import com.model.Invoice;
import com.model.InvoiceProduct;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class InvoiceController {

    ResultSet rs;
    PreparedStatement statement;
    DBConnection db;
    Connection connection;

    Properties props;
    FileInputStream fin;

    public InvoiceController() {

        try {
            
            connection = DBConnection.getConnection();
            
              fin = new FileInputStream("src\\com\\dbconnection\\db.properties");
              props = new Properties();
              props.load(fin);
        } catch (Exception ex) {
            System.out.println(ex);
        }

    }

    public boolean addInvoice(Invoice i, List<InvoiceProduct> listOfProducts) {

        try {
            int customerId = i.getCustomer_id();
            int userId = i.getCreated_By();
            int invoice_id = i.getInvoice_id();

            CustomerController cs = new CustomerController();
            if (cs.getCustomerById(customerId) == null) {

                System.out.println("customer with given Id not exists in customer table !");
                return false;

            }
            UserController us = new UserController();
            if (us.getUserById(userId) == null) {
                System.out.println("User is invalid !! only authenticated user allowed to generate invoice");
                return false;
            }

            String query = props.getProperty("INSERT_INVOICE");

            statement = connection.prepareStatement(query);
            statement.setInt(1, i.getInvoice_id());
            statement.setString(2, i.getPayment_Method());
            statement.setTimestamp(3, new java.sql.Timestamp(new java.util.Date().getTime()));
            statement.setDouble(4, i.getGrand_Total());
            statement.setInt(5, i.getCustomer_id());
            statement.setInt(6, i.getCreated_By());

            int noOfRowsAffected = statement.executeUpdate();
            if (noOfRowsAffected == 1) {
                System.out.println("one Invoice record has been inserted sucessfully !");
//                 return true;
                try {

                    // now we are going to add list of products related to one invoice
                    for (InvoiceProduct ip : listOfProducts) {
                        String queryInvoiceProduct = props.getProperty("INSERT_INVOICE_PRODUCT");
                        statement = connection.prepareStatement(queryInvoiceProduct);
                        statement.setInt(1, invoice_id);
                        statement.setInt(2, ip.getProduct_id());
                        statement.setInt(3, ip.getProduct_Quantity());
                        statement.setDouble(4, ip.getUnit_Price());
                        statement.setDouble(5, ip.getTotal());
                        statement.executeUpdate();
                    }

                } catch (Exception e) {
                    System.out.println("Exception occured at time of adding no of products in product_inovoice table : " + e);
                    return false;
                }
                return true;
            } else {
                System.out.println("some problem occured at time of adding Invoice : rows affected : " + noOfRowsAffected);
                return false;
            }

        } catch (SQLException ex) {
            System.out.println("Erro occured from addInvoice function : " + ex);
            return false;
        }
    }

    public List<Invoice> getAllInvoices() {
        try {
            List<Invoice> list = new ArrayList<>();

            statement = connection.prepareStatement(props.getProperty("SELECT_ALL_INVOICES"));

            rs = statement.executeQuery();

            while (rs.next()) {
                Invoice p = new Invoice();
                p.setInvoice_id(rs.getInt(1));
                p.setPayment_Method(rs.getString(2));
                p.setDate(rs.getTimestamp(3));
                p.setGrand_Total(rs.getDouble(4));
                p.setCustomer_id(rs.getInt(5));
                p.setCreated_By(rs.getInt(6));
                list.add(p);
            }

            return list;
        } catch (SQLException ex) {
            System.out.println("Exception from Invoice conroller getAllInvoices method : " + ex);
            return null;
        }

    }

    
    public int  getMaxId(){
          try {
            statement = connection.prepareStatement(props.getProperty("GET_MAX_INVOICE_ID"));
            rs = statement.executeQuery();

            // this condition will check if not any user is there then it returns null
            if (!rs.isBeforeFirst()) {
                System.out.println("No data");
                return -1;
            }
            int maxId=-1;
            while (rs.next()) {
                maxId = rs.getInt(1);
            }

            return maxId;
        } catch (SQLException ex) {

            System.out.println("Error occured from Invoice getMaxID");
            return -1;
        }
        
    }

    public List<Invoice> getInvoiceBypaymentMethod(String paymentMethod) {
        

        try {
            List<Invoice> list = new ArrayList<>();
            
            statement = connection.prepareStatement(props.getProperty("SELECT_ALL_INVOICES_BY_PAYMENT_METHOD"));
            statement.setString(1, paymentMethod);

            rs = statement.executeQuery();

            // this condition will check if not any user is there then it returns null
            if (!rs.isBeforeFirst()) {
                System.out.println("No data");
                return null;
            }

            while (rs.next()) {
                Invoice i = new Invoice();
                i.setInvoice_id(rs.getInt(1));
                i.setPayment_Method(rs.getString(2));
                i.setDate(rs.getTimestamp(3));
                i.setGrand_Total(rs.getFloat(4));
                i.setCustomer_id(rs.getInt(5));
                i.setCreated_By(rs.getInt(6));
                list.add(i);
            }
            return list;
        } catch (SQLException ex) {
            System.out.println("Exception from invoice conroller getUserById method : " + ex);
            return null;
        }

    }

}
