
package com.dbconnection;
import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;



public class DBConnection {
    
    private static Connection connection=null;
    private static String username;
    private static String password;
    private static String databaseName = "billingsystem";
    private static String url;
    
    
    private  DBConnection(){
        
    }
    
    public static Connection getConnection(){
        try {
            if(connection==null){
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            FileInputStream fin = new FileInputStream("src\\com\\dbconnection\\db.properties");
            
            Properties p = new Properties();
           
            p.load(fin);
           
            username = (String) p.get("username");
            password = (String)p.get("password");
            url = (String)p.get("url");
         
            connection = DriverManager.getConnection(url,username,password);
            System.out.println("Connection done sucessfully !!");
            }
            
        } catch (Exception ex) {
           System.out.println("Exception occured from DBConection constructor : "+ex);
        }
        return connection;
    }
    
    
    
}
