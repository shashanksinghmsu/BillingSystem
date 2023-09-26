package com.controller;

import com.dbconnection.DBConnection;
import com.model.Product;
import java.io.FileInputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ProductController {

    ResultSet rs;
    PreparedStatement statement;
    DBConnection db;
    Connection connection;
    
    Properties props;
    FileInputStream fin;

    public ProductController() {

        try {
            connection = DBConnection.getConnection();
            
              fin = new FileInputStream("src\\com\\dbconnection\\db.properties");
              props = new Properties();
              props.load(fin);
            
        } catch (Exception ex) {
            System.out.println(ex);
        }

    }

    public static void main(String[] args) {
    }

    public List<Product> getAllProducts() {

        try {
            List<Product> list = new ArrayList<>();

            statement = connection.prepareStatement(props.getProperty("SELECT_ALL_PRODUCTS"));
            System.out.println(props.get("SELECT_ALL_PRODUCTS"));
            
            

            rs = statement.executeQuery();

            while (rs.next()) {
                Product p = new Product();
                p.setProduct_id(rs.getInt(1));
                p.setProduct_Name(rs.getString(2));
                p.setProduct_Price(rs.getDouble(3));
                p.setProduct_Category(rs.getString(4));
                p.setProduct_StockQuantity(rs.getInt(5));
                p.setProduct_RecorderLevel(rs.getInt(6));

                list.add(p);
            }

            return list;
        } catch (SQLException ex) {
            System.out.println("Exception from product conroller getAllProducts method : " + ex);
            return null;
        }
    }

    public Product getProductById(int i) {

        Product p = new Product();

        try {
            statement = connection.prepareStatement(props.getProperty("SELECT_PRODUCT_BY_ID"));
            statement.setInt(1, i);

            rs = statement.executeQuery();
            // this condition will check if not any user is there then it returns null
            if (!rs.isBeforeFirst()) {
                System.out.println("No data");
                return null;
            }
            while (rs.next()) {
                p.setProduct_id(rs.getInt(1));
                p.setProduct_Name(rs.getString(2));
                p.setProduct_Price(rs.getDouble(3));
                p.setProduct_Category(rs.getString(4));
                p.setProduct_StockQuantity(rs.getInt(5));
                p.setProduct_RecorderLevel(rs.getInt(6));
            }
            return p;
        } catch (SQLException ex) {
            System.out.println("Exception from product conroller getProductById method : " + ex);
            return null;
        }

    }

    public Product getProductByName(String name) {

        Product p = new Product();

        try {
            statement = connection.prepareStatement(props.getProperty("SELECT_PRODUCT_BY_NAME"));
            statement.setString(1, name);

            rs = statement.executeQuery();
            // this condition will check if not any user is there then it returns null
            if (!rs.isBeforeFirst()) {
                System.out.println("No data");
                return null;
            }
            while (rs.next()) {
                p.setProduct_id(rs.getInt(1));
                p.setProduct_Name(rs.getString(2));
                p.setProduct_Price(rs.getDouble(3));
                p.setProduct_Category(rs.getString(4));
                p.setProduct_StockQuantity(rs.getInt(5));
                p.setProduct_RecorderLevel(rs.getInt(6));
            }
            return p;
        } catch (SQLException ex) {
            System.out.println("Exception from product conroller getProductById method : " + ex);
            return null;
        }

    }

    public boolean addProduct(Product p) {

        try {

            String query = props.getProperty("INSERT_PRODUCT");

            System.out.println(query);

            statement = connection.prepareStatement(query);

            statement.setString(1, p.getProduct_Name());
            statement.setDouble(2, p.getProduct_Price());
            statement.setString(3, p.getProduct_Category());
            statement.setInt(4, p.getProduct_StockQuantity());
            statement.setInt(5, p.getProduct_RecorderLevel());

            int noOfRowsAffected = statement.executeUpdate();

            if (noOfRowsAffected == 1) {
                System.out.println("one prdoct record has been inserted sucessfully !");
                return true;
            } else {
                System.out.println("some problem occured at time of adding product : rows affected : " + noOfRowsAffected);

            }
            return false;

        } catch (SQLException ex) {
            System.out.println("Error has been occured from add product method : " + ex);
            return false;
        }
    }

    public boolean updateProduct(Product p) {

        try {

            String query = props.getProperty("UPDATE_PRODUCT");

            System.out.println(query);

            statement = connection.prepareStatement(query);

            statement.setString(1, p.getProduct_Name());
            statement.setDouble(2, p.getProduct_Price());
            statement.setString(3, p.getProduct_Category());
            statement.setInt(4, p.getProduct_StockQuantity());
            statement.setInt(5, p.getProduct_RecorderLevel());
            statement.setInt(6, p.getProduct_id());

            int noOfRowsAffected = statement.executeUpdate();

            if (noOfRowsAffected == 1) {
                System.out.println("one prdoct record has been updated sucessfully !");
                return true;
            } else {
                System.out.println("some problem occured at time of updating product : rows affected : " + noOfRowsAffected);

            }
            return false;

        } catch (SQLException ex) {
            System.out.println("Error has been occured from update product method : " + ex);
            return false;
        }
    }
    public boolean updateProductStock(Product p,int order) {

        try {

            String query = props.getProperty("UPDATE_PRODUCT_STOCK");

            System.out.println(query);

            statement = connection.prepareStatement(query);

            
            statement.setInt(1, p.getProduct_StockQuantity()-order);
            statement.setInt(2, p.getProduct_id());

            int noOfRowsAffected = statement.executeUpdate();

            if (noOfRowsAffected == 1) {
                System.out.println("one product record has been updated sucessfully !");
                return true;
            } else {
                System.out.println("some problem occured at time of updating product stock : rows affected : " + noOfRowsAffected);

            }
            return false;

        } catch (SQLException ex) {
            System.out.println("Error has been occured from update product method : " + ex);
            return false;
        }
    }

    public boolean deleteProductById(int productId) {

        try {
            String query = props.getProperty("DELETE_PRODUCT_BY_ID");

            statement = connection.prepareStatement(query);

            statement.setInt(1, productId);

            int noOfRowsAffected = statement.executeUpdate();

            if (noOfRowsAffected == 1) {
                System.out.println("one product record has been deleted sucessfully !");
                return true;
            } else {
                System.out.println("some problem occured at time of deleting product : rows affected : " + noOfRowsAffected);

            }
            return false;

        } catch (SQLException ex) {
            System.out.println("Error has been occured from delete product method : " + ex);
            return false;
        }
    }

    public int  getMaxId(){
          try {
            statement = connection.prepareStatement(props.getProperty("GET_MAX_PRODUCT_ID"));
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

            System.out.println("Error occured from product getMaxID");
            return -1;
        }
        
    }
}
