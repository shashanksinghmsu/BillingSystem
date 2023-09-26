

package com.view;

import com.controller.CustomerController;
import com.controller.InvoiceController;
import com.controller.ProductController;
import com.controller.UserController;
import com.model.Customer;
import com.model.Invoice;
import com.model.InvoiceProduct;
import com.model.Product;
import com.model.User;
import com.util.EmailValidator;
import com.util.PasswordEncryption;
import java.util.ArrayList;
import java.util.List;

public class Main {
    
    public static void main(String args[]){
        
//         ProductController ps = new ProductController();
//        
//         List<Product> allProducts = ps.getAllProducts();
//         System.out.println(allProducts);
//         System.out.println(ps.getProductById(2));
//     
//         Product p = ps.getProductById(3);
//   
        
//        CustomerController cs = new CustomerController();
        
        Customer c = new Customer();
        c.setCustomer_Name("Shashank");
        c.setCustomer_Email("shashank12811@gmail.com");
        c.setCustomer_Address("Vadodara Gujarat");
        c.setCustomer_Phone("7878787878");
        c.setCustomer_Type("Retailer");

        
        //System.out.println(cs.addCustomer(c));
        
        Product p = new Product();
        p.setProduct_Name("Parle-G");
        p.setProduct_Category("Common goods");
        p.setProduct_Price(25);
        p.setProduct_StockQuantity(60);
        p.setProduct_RecorderLevel(25);
        
        ProductController ps = new ProductController();
        
        //System.out.println(ps.addProduct(p));
        
//        UserController us = new UserController();
        
//        System.out.println(us.getAllUser());
        
        //.out.println(us.getUserById(4)); // if no data is there then this function will return null
//        System.out.println(us.getUserById(3));

        InvoiceController in = new InvoiceController();
        
        List<InvoiceProduct> lisOfProducts = new ArrayList<>();
        
        Invoice i = new Invoice();
        
        i.setInvoice_id(6);
        i.setPayment_Method("ONLINE");
        i.setCreated_By(2);
        i.setCustomer_id(5);
        i.setGrand_Total(20000.23);
        
        for(int j=7;j<9;j++){
         InvoiceProduct ip = new InvoiceProduct();
//         ip.setInvoice_id(j);
            ip.setProduct_id(j);
            ip.setProduct_Quantity(2);
            ip.setTotal(800.2);
            ip.setUnit_Price(400.1);
            lisOfProducts.add(ip);
        
        
        }
        
//        in.addInvoice(i, lisOfProducts);

        
      
        
//        System.out.println(PasswordEncryption.encryptPassword("1234"));
        User u = new User();
        u.setUser_id(3);
        u.setUser_name("HA..HA");
        u.setUser_Designation("user");
        u.setEmail("bb123@gmail.com");
        
        UserController uc = new UserController();
        
        System.out.println(uc.updateUser(u));
        
        ProductController pc = new ProductController();
        CustomerController cc = new CustomerController();
        
        System.out.println("Invoice : "+in.getMaxId());
        System.out.println("Product : "+pc.getMaxId());
        System.out.println("customer : "+cc.getMaxId());
        
        EmailValidator em = new EmailValidator();
        System.out.println("Validate: "+em.validate("abc123gmail.com"));

    }
    
}
