package com.controller;

import com.dbconnection.DBConnection;
import com.model.Customer;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class CustomerController {

    ResultSet rs;
    PreparedStatement statement;
    DBConnection db;
    Connection connection;

    Properties props;
    FileInputStream fin;

    public CustomerController() {
        try {

            connection = DBConnection.getConnection();

            fin = new FileInputStream("src\\com\\dbconnection\\db.properties");
            props = new Properties();
            props.load(fin);

        } catch (Exception ex) {
            System.out.println(ex);
        }

    }

    public List<Customer> getAllCustomers() {

        try {
            List<Customer> list = new ArrayList<>();

            statement = connection.prepareStatement(props.getProperty("SELECT_ALL_CUSTOMERS"));

            rs = statement.executeQuery();

            // this condition will check if not any user is there then it returns null
            if (!rs.isBeforeFirst()) {
                System.out.println("No data");
                return null;
            }

            while (rs.next()) {
                Customer c = new Customer();
                c.setCustomer_id(rs.getInt(1));
                c.setCustomer_Name(rs.getString(2));
                c.setCustomer_Email(rs.getString(3));
                c.setCustomer_Phone(rs.getString(4));
                c.setCustomer_Address(rs.getString(5));
                c.setCustomer_Type(rs.getString(6));

                list.add(c);
            }

            return list;
        } catch (SQLException ex) {
            System.out.println("Exception from customer conroller getAllCustomers method : " + ex);
            return null;
        }
    }

    public Customer getCustomerById(int i) {

        Customer c = new Customer();

        try {
            statement = connection.prepareStatement(props.getProperty("SELECT_CUSTOMER_BY_ID"));
            statement.setInt(1, i);

            rs = statement.executeQuery();
            // this condition will check if not any user is there then it returns null
            if (!rs.isBeforeFirst()) {
                System.out.println("No data");
                return null;
            }

            while (rs.next()) {
                c.setCustomer_id(rs.getInt(1));
                c.setCustomer_Name(rs.getString(2));
                c.setCustomer_Email(rs.getString(3));
                c.setCustomer_Phone(rs.getString(4));
                c.setCustomer_Address(rs.getString(5));
                c.setCustomer_Type(rs.getString(6));
            }
            return c;
        } catch (SQLException ex) {
            System.out.println("Exception from customer conroller getaCustomerById method : " + ex);
            return null;
        }

    }

    public Customer getCustomerByName(String name) {

        Customer c = new Customer();

        try {
            statement = connection.prepareStatement(props.getProperty("SELECT_CUSTOMER_BY_NAME"));
            statement.setString(1, name);

            rs = statement.executeQuery();
            // this condition will check if not any user is there then it returns null
            if (!rs.isBeforeFirst()) {
                System.out.println("No data");
                return null;
            }

            while (rs.next()) {
                c.setCustomer_id(rs.getInt(1));
                c.setCustomer_Name(rs.getString(2));
                c.setCustomer_Email(rs.getString(3));
                c.setCustomer_Phone(rs.getString(4));
                c.setCustomer_Address(rs.getString(5));
                c.setCustomer_Type(rs.getString(6));
            }
            return c;
        } catch (SQLException ex) {
            System.out.println("Exception from customer conroller getaCustomerById method : " + ex);
            return null;
        }

    }

    public boolean addCustomer(Customer c) {

        try {

            String query = props.getProperty("INSERT_CUSTOMER");

            System.out.println(query);

            statement = connection.prepareStatement(query);

            statement.setString(1, c.getCustomer_Name());
            statement.setString(2, c.getCustomer_Email());
            statement.setString(3, c.getCustomer_Phone());
            statement.setString(4, c.getCustomer_Address());
            statement.setString(5, c.getCustomer_Type());

            int noOfRowsAffected = statement.executeUpdate();

            if (noOfRowsAffected == 1) {
                System.out.println("one customer record has been inserted sucessfully !");
                return true;
            } else {
                System.out.println("some problem occured at time of adding customer : rows affected : " + noOfRowsAffected);

            }
            return false;

        } catch (SQLException ex) {
            System.out.println("Error has been occured from add customer method : " + ex);
            return false;
        }
    }

    public List<Customer> getAllCustomers(String name) {

        try {
            List<Customer> list = new ArrayList<>();

            statement = connection.prepareStatement(props.getProperty("SELECT_ALL_CUSTOMER_BY_NAME"));
            statement.setString(1, name);

            rs = statement.executeQuery();

            // this condition will check if not any user is there then it returns null
            if (!rs.isBeforeFirst()) {
                System.out.println("No data");
                return null;
            }

            while (rs.next()) {
                Customer c = new Customer();
                c.setCustomer_id(rs.getInt(1));
                c.setCustomer_Name(rs.getString(2));
                c.setCustomer_Email(rs.getString(3));
                c.setCustomer_Phone(rs.getString(4));
                c.setCustomer_Address(rs.getString(5));
                c.setCustomer_Type(rs.getString(6));

                list.add(c);
            }

            return list;
        } catch (SQLException ex) {
            System.out.println("Exception from customer conroller getAllCustomers(String name) method : " + ex);
            return null;
        }

    }

    public int getMaxId() {
        try {
            statement = connection.prepareStatement(props.getProperty("GET_MAX_CUSTOMER_ID"));
            rs = statement.executeQuery();

            // this condition will check if not any user is there then it returns null
            if (!rs.isBeforeFirst()) {
                System.out.println("No data");
                return -1;
            }
            int maxId = -1;
            while (rs.next()) {
                maxId = rs.getInt(1);
            }

            return maxId;
        } catch (SQLException ex) {

            System.out.println("Error occured from customer getMaxID");
            return -1;
        }

    }
}
