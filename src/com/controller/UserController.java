package com.controller;

import com.dbconnection.DBConnection;
import com.model.User;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserController {

    ResultSet rs;
    PreparedStatement statement;
    DBConnection db;
    static Connection connection;
    
    Properties props;
    FileInputStream fin;


    public UserController() {

        try {
            connection = DBConnection.getConnection(); 
            
              fin = new FileInputStream("src\\com\\dbconnection\\db.properties");
              props = new Properties();
              props.load(fin);
        } catch (Exception ex) {
            System.out.println("Exception occured from userController constructor : "+ex);
        }

    }

    public List<User> getAllUser() {

        List<User> li = new ArrayList<>();

        try {
            statement = connection.prepareStatement(props.getProperty("SELECT_ALL_USERS"));
            rs = statement.executeQuery();

            // this condition will check if not any user is there then it returns null
            if (!rs.isBeforeFirst()) {
                System.out.println("No data");
                return null;
            }

            while (rs.next()) {
                User u = new User();
                u.setUser_id(rs.getInt(1));
                u.setUser_name(rs.getString(2));
                u.setUser_Designation(rs.getString(3));
                u.setPassword(rs.getString(4));
                u.setEmail(rs.getString(5));

                li.add(u);

            }

            return li;
        } catch (SQLException ex) {

            System.out.println("Error occured from user controller getAllUser method");
            return null;
        }

    }

    public User getUserById(int i) {

        User u = new User();

        try {
            statement = connection.prepareStatement(props.getProperty("SELECT_USER_BY_ID"));
            statement.setInt(1, i);

            rs = statement.executeQuery();

            // this condition will check if not any user is there then it returns null
            if (!rs.isBeforeFirst()) {
                System.out.println("No data");
                return null;
            }

            while (rs.next()) {
                u.setUser_id(rs.getInt(1));
                u.setUser_name(rs.getString(2));
                u.setUser_Designation(rs.getString(3));
                u.setPassword(rs.getString(4));
                u.setEmail(rs.getString(5));

            }
            return u;
        } catch (SQLException ex) {
            System.out.println("Exception from user conroller getUserById method : " + ex);
            return null;
        }

    }

    public List<User> getAllUserByName(String name) {

        List<User> li = new ArrayList<>();

        try {
            statement = connection.prepareStatement(props.getProperty("SELECT_USER_NAME"));
            statement.setString(1, name);

            rs = statement.executeQuery();

            // this condition will check if not any user is there then it returns null
            if (!rs.isBeforeFirst()) {
                System.out.println("No data");
                return null;
            }

            while (rs.next()) {
                User u = new User();
                u.setUser_id(rs.getInt(1));
                u.setUser_name(rs.getString(2));
                u.setUser_Designation(rs.getString(3));
                u.setPassword(rs.getString(4));
                u.setEmail(rs.getString(5));

                li.add(u);

            }

            return li;
        } catch (SQLException ex) {

            System.out.println("Error occured from user controller getAllUserByName method");
            return null;
        }

    }

    public boolean addUser(User u) {

        try {
            String query = props.getProperty("INSERT_USER");

            statement = connection.prepareStatement(query);
            statement.setString(1, u.getUser_name());
            statement.setString(2, u.getUser_Designation());
            statement.setString(3, u.getPassword());
            statement.setString(4, u.getEmail());

            int noOfRowsAffected = statement.executeUpdate();

            if (noOfRowsAffected == 1) {
                System.out.println("one User record has been inserted sucessfully !");
                return true;
            } else {
                System.out.println("some problem occured at time of adding User : rows affected : " + noOfRowsAffected);

            }
            return false;
        } catch (SQLException ex) {
            System.out.println("Error has been occured from add user method : " + ex);
            return false;
        }
    }

    public User getUserByEmail(String email) {
        User u = new User();

        try {
            statement = connection.prepareStatement(props.getProperty("GET_USER_BY_EMAIL"));
            statement.setString(1, email);

            rs = statement.executeQuery();

            // this condition will check if not any user is there then it returns null
            if (!rs.isBeforeFirst()) {
                System.out.println("No data");
                return null;
            }

            while (rs.next()) {
                u.setUser_id(rs.getInt(1));
                u.setUser_name(rs.getString(2));
                u.setUser_Designation(rs.getString(3));
                u.setPassword(rs.getString(4));
                u.setEmail(rs.getString(5));

            }
            return u;
        } catch (SQLException ex) {
            System.out.println("Exception from user conroller getUserByMail method : " + ex);
            return null;
        }

    }

    
    public boolean updateUser(User u){
      

        try {
            int userId = u.getUser_id();
           String query = props.getProperty("UPDATE_USER");
           statement = connection.prepareStatement(query);
           
           statement.setString(1, u.getUser_name());
           statement.setString(2, u.getEmail());
           statement.setInt(3, userId);
           
            int noOfRowsAffected = statement.executeUpdate();

            if (noOfRowsAffected == 1) {
                System.out.println("one User record has been updated sucessfully !");
                return true;
            } else {
                System.out.println("some problem occured at time of Update User : rows affected : " + noOfRowsAffected);

            }
            return false;
           
        } catch (SQLException ex) {
            System.out.println("Exception from user conroller Update User method: " + ex);
            return false;
        }
        
    }
    
    public boolean updateUserPassword(User u){
         try {
           int userId = u.getUser_id();
           String query = props.getProperty("UPDATE_USER_PASSWORD");
           
           statement = connection.prepareStatement(query);  
           statement.setString(1, u.getPassword());
      
           statement.setInt(2, userId);
           
            int noOfRowsAffected = statement.executeUpdate();

            if (noOfRowsAffected == 1) {
                System.out.println("one User record has been updated password sucessfully !");
                return true;
            } else {
                System.out.println("some problem occured at time of Update User : rows affected : " + noOfRowsAffected);

            }
            return false;
           
        } catch (SQLException ex) {
            System.out.println("Exception from user conroller Update password User method: " + ex);
            return false;
        }
        
    }
}
