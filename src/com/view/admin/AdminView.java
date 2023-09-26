package com.view.admin;

import com.controller.CustomerController;
import com.controller.InvoiceController;
import com.controller.ProductController;
import com.controller.UserController;
import com.itextpdf.text.Document;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.model.Customer;
import com.model.Invoice;
import com.model.Product;
import com.model.User;
import com.util.CheckValue;
import com.view.user.Profile;
import java.awt.Font;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class AdminView extends javax.swing.JFrame {

    CustomerController customerController;
    ProductController productController;
    InvoiceController invoiceController;
    UserController userController;
    CheckValue checkValue;
    User loggedUser;

    public AdminView(int loggedUserId) {
        initComponents();

        // as in constructor of these three controller we had  created connection
        customerController = new CustomerController();
        productController = new ProductController();
        invoiceController = new InvoiceController();
        userController = new UserController();
        checkValue = new CheckValue();

        // setting logged user Id so that we can use for profile and other uses
        System.out.println("Logged user id is : " + loggedUserId);

        loggedUser = userController.getUserById(loggedUserId);

        if (loggedUser == null) {
            JOptionPane.showMessageDialog(null, "Invalid USER !!");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField11 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        userId = new javax.swing.JTextField();
        userName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        getUser = new javax.swing.JButton();
        getCustomer = new javax.swing.JButton();
        customerId = new javax.swing.JTextField();
        customerName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        productId = new javax.swing.JTextField();
        productName = new javax.swing.JTextField();
        productCategory = new javax.swing.JTextField();
        productQuantity = new javax.swing.JTextField();
        recorderLevel = new javax.swing.JTextField();
        productPrice = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextField13 = new javax.swing.JTextField();
        getAllUsers = new javax.swing.JButton();
        allCustomerBtn = new javax.swing.JButton();
        allProductsBtn = new javax.swing.JButton();
        allInvoices = new javax.swing.JButton();
        addProduct = new javax.swing.JButton();
        updateProduct = new javax.swing.JButton();
        deleteProduct = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        paymentMethod = new javax.swing.JComboBox<>();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        logout = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 255, 255));

        jLabel1.setText("User Id");
        jLabel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setText("User Name");
        jLabel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        userId.setAutoscrolls(false);
        userId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userIdActionPerformed(evt);
            }
        });
        userId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                userIdKeyTyped(evt);
            }
        });

        userName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userNameActionPerformed(evt);
            }
        });

        jLabel3.setText("Customer Id");
        jLabel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel4.setText("Customer Name");
        jLabel4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        getUser.setText("Get User");
        getUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getUserActionPerformed(evt);
            }
        });

        getCustomer.setText("Get Customer");
        getCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getCustomerActionPerformed(evt);
            }
        });

        customerId.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        customerId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerIdActionPerformed(evt);
            }
        });
        customerId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                customerIdKeyTyped(evt);
            }
        });

        customerName.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel5.setText("Product ID");
        jLabel5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel6.setText("Product Name");
        jLabel6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel7.setText("Price");
        jLabel7.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel8.setText("Category");
        jLabel8.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel9.setText("Quantity");
        jLabel9.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel10.setText("Reorder Level");
        jLabel10.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        productId.setEnabled(false);

        productQuantity.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                productQuantityKeyTyped(evt);
            }
        });

        recorderLevel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                recorderLevelKeyTyped(evt);
            }
        });

        productPrice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                productPriceKeyTyped(evt);
            }
        });

        jLabel11.setText("Invoice Date");
        jLabel11.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel12.setText("Payment Method");
        jLabel12.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jScrollPane2.setAutoscrolls(true);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        jTable1.setGridColor(new java.awt.Color(0, 102, 102));
        jTable1.setOpaque(false);
        jTable1.setRowHeight(30);
        jTable1.setRowMargin(1);
        jTable1.setShowGrid(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        getAllUsers.setText("All  Users");
        getAllUsers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getAllUsersActionPerformed(evt);
            }
        });

        allCustomerBtn.setText("All Customers");
        allCustomerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                allCustomerBtnActionPerformed(evt);
            }
        });

        allProductsBtn.setText("All Products");
        allProductsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                allProductsBtnActionPerformed(evt);
            }
        });

        allInvoices.setText("All Invoice");
        allInvoices.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                allInvoicesActionPerformed(evt);
            }
        });

        addProduct.setText("Add Product");
        addProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addProductActionPerformed(evt);
            }
        });

        updateProduct.setText("Update Product");
        updateProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateProductActionPerformed(evt);
            }
        });

        deleteProduct.setText("Delete Product");
        deleteProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteProductActionPerformed(evt);
            }
        });

        jButton14.setText("Get Invoice");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel13.setText("Admin Panel");

        paymentMethod.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CASH", "ONLINE", " " }));

        jMenu1.setText("Profile");

        logout.setText("Account");
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });
        jMenu1.add(logout);

        jMenuItem2.setText("Logout");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(31, 31, 31)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(userId, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(userName, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(customerId, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(getUser, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addComponent(getAllUsers, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(allCustomerBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(getCustomer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(customerName, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 110, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(allProductsBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(recorderLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(productQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(productCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(productId, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(productPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(productName, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton14)
                                    .addComponent(paymentMethod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(62, 62, 62))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(allInvoices, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(102, 102, 102))))
            .addGroup(layout.createSequentialGroup()
                .addGap(339, 339, 339)
                .addComponent(addProduct)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(updateProduct)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(deleteProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(userId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5)
                                .addComponent(productId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(userName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(productName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(getUser)
                            .addComponent(jLabel7)
                            .addComponent(productPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)
                            .addComponent(paymentMethod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(productCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(getAllUsers)))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(customerId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(customerName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9)
                                    .addComponent(productQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel10)
                                    .addComponent(recorderLevel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(getCustomer)
                                .addGap(40, 40, 40)
                                .addComponent(allCustomerBtn))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(addProduct)
                                    .addComponent(updateProduct)
                                    .addComponent(deleteProduct))
                                .addGap(29, 29, 29)
                                .addComponent(allProductsBtn))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(jButton14)
                        .addGap(18, 18, 18)
                        .addComponent(allInvoices)))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void userNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userNameActionPerformed

    private void userIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userIdActionPerformed

    private void getUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getUserActionPerformed
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

        // clearing table for displaying new records..
        int rc = model.getRowCount();
        while (rc-- != 0) {
            model.removeRow(0);
        }

        String[] columnNames = {"User ID", "User Name", "Email", "Password", "Designation"};
        model.setColumnIdentifiers(columnNames);
        jTable1.getTableHeader().repaint();

        String userIdText = userId.getText();
        String userNameText = userName.getText().trim();

        // note that for string we need to use equals method . == is not worked well !!
        if (!userIdText.equals("")) {

            // adding user by finding based on Id
            User u = userController.getUserById(Integer.parseInt(userIdText));

            if (u == null) {
                JOptionPane.showMessageDialog(null, "NO Such user is exists !!!");
            } else if (!userNameText.equals("") && !u.getUser_name().equals(userNameText)) {
                JOptionPane.showMessageDialog(null, "NO Such user is exists !!!");
            } else {
                Object o[] = {u.getUser_id(), u.getUser_name(), u.getEmail(), u.getPassword(), u.getUser_Designation()};
                model.addRow(o);
            }
        } else if (!userNameText.equals("")) {

            System.out.println(userNameText);

            List<User> allUsers = userController.getAllUserByName(userNameText);
            if (allUsers == null) {
                JOptionPane.showMessageDialog(null, "NO Such user is exists !!!");
            } else {

                for (int i = 0; i < allUsers.size(); i++) {

                    User u = allUsers.get(i);
                    Object o[] = {u.getUser_id(), u.getUser_name(), u.getEmail(), u.getPassword(), u.getUser_Designation()};
                    model.addRow(o);

                }
            }

        }


    }//GEN-LAST:event_getUserActionPerformed

    private void customerIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_customerIdActionPerformed

    private void getAllUsersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getAllUsersActionPerformed
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

        // clearing table for displaying new records..
        int rc = model.getRowCount();
        while (rc-- != 0) {
            model.removeRow(0);
        }

        String[] columnNames = {"User ID", "User Name", "Email", "Password", "Designation"};
        model.setColumnIdentifiers(columnNames);
        jTable1.getTableHeader().repaint();

        List<User> allUsers = userController.getAllUser();

        for (int i = 0; i < allUsers.size(); i++) {

            User u = allUsers.get(i);
            Object o[] = {u.getUser_id(), u.getUser_name(), u.getEmail(), u.getPassword(), u.getUser_Designation()};
            model.addRow(o);

        }


    }//GEN-LAST:event_getAllUsersActionPerformed

    private void allCustomerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_allCustomerBtnActionPerformed
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

        // clearing table for displaying new records..
        int rc = model.getRowCount();
        while (rc-- != 0) {
            model.removeRow(0);
        }

        String[] columnNames = {"Customer ID", "Customer Name", "Designation", "Phone number", "Email", "Address"};
        model.setColumnIdentifiers(columnNames);
        jTable1.getTableHeader().repaint();

        List<Customer> allCustomers = customerController.getAllCustomers();
//        System.out.println(allCustomers);
//        model.addRow(allCustomers.toArray());

        for (int i = 0; i < allCustomers.size(); i++) {
            Customer c = allCustomers.get(i);

            Object o[] = {c.getCustomer_id(), c.getCustomer_Name(), c.getCustomer_Type(), c.getCustomer_Phone(), c.getCustomer_Email(), c.getCustomer_Address()};
            model.addRow(o);
        }


    }//GEN-LAST:event_allCustomerBtnActionPerformed

    private void allProductsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_allProductsBtnActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

        // clearing table for displaying new records..
        int rc = model.getRowCount();
        while (rc-- != 0) {
            model.removeRow(0);
        }

        String[] columnNames = {"Product ID", "Product Name", "Category", "Quantity", "Reorder Level", "Unit Price"};
        model.setColumnIdentifiers(columnNames);
        jTable1.getTableHeader().repaint();

        List<Product> allProducts = productController.getAllProducts();

//        model.addRow(allCustomers.toArray());
        for (int i = 0; i < allProducts.size(); i++) {
            Product p = allProducts.get(i);

            Object o[] = {p.getProduct_id(), p.getProduct_Name(), p.getProduct_Category(), p.getProduct_StockQuantity(), p.getProduct_RecorderLevel(), p.getProduct_Price()};
            model.addRow(o);
        }

    }//GEN-LAST:event_allProductsBtnActionPerformed

    private void allInvoicesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_allInvoicesActionPerformed
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        String[] columnNames = {"Invoice ID", "Payment Method", "Grand Total", "Customer Id", "CreatedBy Id", "Date Of Issue"};
        model.setColumnIdentifiers(columnNames);

        // clearing table for displaying new records..
        int rc = model.getRowCount();
        while (rc-- != 0) {
            model.removeRow(0);
        }

        List<Invoice> listOfInvoices = invoiceController.getAllInvoices();

        for (int i = 0; i < listOfInvoices.size(); i++) {
            Invoice currentInvoice = listOfInvoices.get(i);
            Object o[] = {currentInvoice.getInvoice_id(), currentInvoice.getPayment_Method(), currentInvoice.getGrand_Total(), currentInvoice.getCustomer_id(), currentInvoice.getCreated_By(), currentInvoice.getDate()};
            model.addRow(o);
        }

        jTable1.getTableHeader().repaint();
    }//GEN-LAST:event_allInvoicesActionPerformed

    private void userIdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_userIdKeyTyped

        char ch = evt.getKeyChar();

        // if character is not digit then consume it...
        if (!Character.isDigit(ch)) {
            evt.consume();
        }
    }//GEN-LAST:event_userIdKeyTyped

    private void addProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addProductActionPerformed
        Product p = new Product();

        String pname = productName.getText();
        String pcategory = productCategory.getText();
        String pprice = productPrice.getText();
        String pqty = productQuantity.getText();
        String precordlevel = recorderLevel.getText();

        if (!checkValue.isStringDouble(pprice) || !checkValue.isStringInt(pqty) || !checkValue.isStringInt(precordlevel)) {
            JOptionPane.showMessageDialog(null, "Please Enter appropriate values !!");
        } else {

            if (Integer.parseInt(pqty) < Integer.parseInt(precordlevel)) {
                JOptionPane.showMessageDialog(null, "Product Quantity should be greater than recorder level !");
            } else {
                p.setProduct_Name(pname);
                p.setProduct_Category(pcategory);
                p.setProduct_Price(Double.parseDouble(pprice));
                p.setProduct_StockQuantity(Integer.parseInt(pqty));
                p.setProduct_RecorderLevel(Integer.parseInt(precordlevel));

                ProductController ps = new ProductController();
                if (ps.addProduct(p)) {
                    JOptionPane.showMessageDialog(null, "Product Added sucessfully !!");
                } else {
                    JOptionPane.showMessageDialog(null, "Some Problem occured at time of adding product!!");
                }

                productName.setText("");
                productCategory.setText("");
                productPrice.setText("");
                productQuantity.setText("");
                recorderLevel.setText("");
            }
        }

    }//GEN-LAST:event_addProductActionPerformed

    private void getCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getCustomerActionPerformed

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

        // clearing table for displaying new records..
        int rc = model.getRowCount();
        while (rc-- != 0) {
            model.removeRow(0);
        }

        String[] columnNames = {"Customer ID", "Customer Name", "Type", "Phone number", "Email", "Address"};
        model.setColumnIdentifiers(columnNames);
        jTable1.getTableHeader().repaint();

        String customerIdText = customerId.getText();
        String customerNameText = customerName.getText().trim();

        // note that for string we need to use equals method . == is not worked well !!
        if (!customerIdText.equals("")) {

            // adding customer by finding based on Id
//            User u = userController.getUserById(Integer.parseInt(userIdText));
            Customer c = customerController.getCustomerById(Integer.parseInt(customerIdText));

            if (c == null) {
                JOptionPane.showMessageDialog(null, "NO Such Customer is exists !!!");
            } else if (!customerNameText.equals("") && !c.getCustomer_Name().equals(customerNameText)) {
                JOptionPane.showMessageDialog(null, "NO Such customer is exists !!!");
            } else {
                Object o[] = {c.getCustomer_id(), c.getCustomer_Name(), c.getCustomer_Type(), c.getCustomer_Phone(), c.getCustomer_Email(), c.getCustomer_Address()};
                model.addRow(o);
            }
        } else if (!customerNameText.equals("")) {

            System.out.println(customerNameText);

            List<Customer> allCustomers = customerController.getAllCustomers(customerNameText);

            if (allCustomers == null) {
                JOptionPane.showMessageDialog(null, "NO Such customer is exists !!!");
            } else {

                for (int i = 0; i < allCustomers.size(); i++) {
                    Customer c = allCustomers.get(i);

                    Object o[] = {c.getCustomer_id(), c.getCustomer_Name(), c.getCustomer_Type(), c.getCustomer_Phone(), c.getCustomer_Email(), c.getCustomer_Address()};
                    model.addRow(o);
                }
            }

        }


    }//GEN-LAST:event_getCustomerActionPerformed

    private void customerIdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_customerIdKeyTyped

        char ch = evt.getKeyChar();

        // if character is not digit then consume it...
        if (!Character.isDigit(ch)) {
            evt.consume();
        }
    }//GEN-LAST:event_customerIdKeyTyped

    private void productPriceKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_productPriceKeyTyped
        char ch = evt.getKeyChar();

        // if character is not digit then consume it...
        if (ch != '.') {
            if (!Character.isDigit(ch)) {
                evt.consume();
            }
        }

    }//GEN-LAST:event_productPriceKeyTyped

    private void productQuantityKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_productQuantityKeyTyped
        char ch = evt.getKeyChar();

        // if character is not digit then consume it...
        if (!Character.isDigit(ch)) {
            evt.consume();
        }
    }//GEN-LAST:event_productQuantityKeyTyped

    private void recorderLevelKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_recorderLevelKeyTyped
        char ch = evt.getKeyChar();

        // if character is not digit then consume it...
        if (!Character.isDigit(ch)) {
            evt.consume();
        }
    }//GEN-LAST:event_recorderLevelKeyTyped

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int selectedRow = jTable1.getSelectedRow();
        productId.setText(jTable1.getValueAt(selectedRow, 0).toString());
        productName.setText(jTable1.getValueAt(selectedRow, 1).toString());
        productPrice.setText(jTable1.getValueAt(selectedRow, 5).toString());
        productCategory.setText(jTable1.getValueAt(selectedRow, 2).toString());
        productQuantity.setText(jTable1.getValueAt(selectedRow, 3).toString());
        recorderLevel.setText(jTable1.getValueAt(selectedRow, 4).toString());

    }//GEN-LAST:event_jTable1MouseClicked

    private void updateProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateProductActionPerformed
        Product p = new Product();

        String pname = productName.getText();
        String pcategory = productCategory.getText();
        String pprice = productPrice.getText();
        String pqty = productQuantity.getText();
        String precordlevel = recorderLevel.getText();
        String pid = productId.getText();

        if (!checkValue.isStringDouble(pprice) || !checkValue.isStringInt(pqty) || !checkValue.isStringInt(precordlevel)) {
            JOptionPane.showMessageDialog(null, "Please select a product row !!");
        } else {

            if (Integer.parseInt(pqty) < Integer.parseInt(precordlevel)) {
                JOptionPane.showMessageDialog(null, "Product Quantity should be greater than recorder level !");
            } else if (Double.parseDouble(pprice) <= 0.0) {
                JOptionPane.showMessageDialog(null, "Product Price should be greater than 0 !");
            } else {
                p.setProduct_Name(pname);
                p.setProduct_Category(pcategory);
                p.setProduct_Price(Double.parseDouble(pprice));
                p.setProduct_StockQuantity(Integer.parseInt(pqty));
                p.setProduct_RecorderLevel(Integer.parseInt(precordlevel));
                p.setProduct_id(Integer.parseInt(pid));

                ProductController ps = new ProductController();
                if (ps.updateProduct(p)) {
                    JOptionPane.showMessageDialog(null, "Product updated sucessfully !!");
                } else {
                    JOptionPane.showMessageDialog(null, "Some Problem occured at time of updating product!!");
                }

                productName.setText("");
                productCategory.setText("");
                productPrice.setText("");
                productQuantity.setText("");
                recorderLevel.setText("");
            }
        }
    }//GEN-LAST:event_updateProductActionPerformed

    private void deleteProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteProductActionPerformed

        if (!productId.getText().equals("")) {
            if (productController.deleteProductById(Integer.parseInt(productId.getText()))) {
                JOptionPane.showMessageDialog(null, "Product Has been deleted Sucessfully !");
                deleteProduct.setText("Delete Product");
                productId.setText("");
                productName.setText("");
                productCategory.setText("");
                productPrice.setText("");
                productQuantity.setText("");
                recorderLevel.setText("");
            } else {
                JOptionPane.showMessageDialog(null, "Some problem occured at time of deleting product !");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Select any row for perform delete opration ");
        }

        /*
        
        if (deleteProduct.getText().equals("Delete Product")) {
            deleteProduct.setText("Do Delete");
            JOptionPane.showMessageDialog(null, "Enter Product Id for Delete product ");
            productId.setEnabled(true);
            productName.setEnabled(false);
            productCategory.setEnabled(false);
            productPrice.setEnabled(false);
            productQuantity.setEnabled(false);
            recorderLevel.setEnabled(false);

        } else if(deleteProduct.getText().equals("Do Delete")) {
            
            int deleteProductId = Integer.parseInt(productId.getText());
            productId.setText("");
            productId.setEnabled(false);
            productName.setEnabled(true);
            productCategory.setEnabled(true);
            productPrice.setEnabled(true);
            productQuantity.setEnabled(true);
            recorderLevel.setEnabled(true);
            deleteProduct.setText("Do Delete");

            if (productController.deleteProductById(deleteProductId)) {
                JOptionPane.showMessageDialog(null, "Product Has been deleted Sucessfully !");
                deleteProduct.setText("Delete Product");
            } else {
                JOptionPane.showMessageDialog(null, "Some problem occured at time of deleting product !");
            }
        }
        
         */
    }//GEN-LAST:event_deleteProductActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
// Generate Invoice       

/*
        JFileChooser jfc = new JFileChooser();
        String customerNameText = customerName.getText().trim();
        jfc.setSelectedFile(new File(customerNameText + " - Invoice" + ".pdf"));
        int dialogresult = jfc.showSaveDialog(null);
        if (dialogresult == JFileChooser.APPROVE_OPTION) {
            String filePath = jfc.getSelectedFile().getPath();
            try {
                Document myDocument = new Document();
                PdfWriter pdf = PdfWriter.getInstance(myDocument, new FileOutputStream(filePath));
                myDocument.open();
                myDocument.add(new Paragraph(customerNameText, FontFactory.getFont(FontFactory.TIMES_BOLD, 32, Font.BOLD)));
                myDocument.add(new Paragraph("Total Amount: 500", FontFactory.getFont(FontFactory.TIMES_BOLD, 32, Font.BOLD)));
                myDocument.close();
                JOptionPane.showMessageDialog(null, "Invoice Generated Successfully");
            } catch (Exception e) {
            }
        }
*/

DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

        // clearing table for displaying new records..
        int rc = model.getRowCount();
        while (rc-- != 0) {
            model.removeRow(0);
        }

        String[] columnNames = {"Invoice ID", "Payment Method", "Grand Total", "Customer Id", "CreatedBy Id", "Date Of Issue"};
        model.setColumnIdentifiers(columnNames);
        jTable1.getTableHeader().repaint();

        String payMethod = paymentMethod.getSelectedItem().toString();

        // note that for string we need to use equals method . == is not worked well !!
        if (!payMethod.equals("")) {

            // adding user by finding based on Id
            List<Invoice> allInvoice = invoiceController.getInvoiceBypaymentMethod(payMethod);
           
            if (allInvoice == null) {
                JOptionPane.showMessageDialog(null, "NO Such invoice is exists !!!");
            } 
            else {
                for (int i = 0; i < allInvoice.size(); i++) {
                Invoice in = allInvoice.get(i);
                Object o[] = {in.getInvoice_id(), in.getPayment_Method(), in.getGrand_Total(), in.getCustomer_id(), in.getCreated_By(),in.getDate()};
                model.addRow(o);
                }
            }
        } 

    }//GEN-LAST:event_jButton14ActionPerformed

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed

        Profile p = new Profile(loggedUser.getUser_id());
        p.setVisible(true);


    }//GEN-LAST:event_logoutActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AdminView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminView(1).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addProduct;
    private javax.swing.JButton allCustomerBtn;
    private javax.swing.JButton allInvoices;
    private javax.swing.JButton allProductsBtn;
    private javax.swing.JTextField customerId;
    private javax.swing.JTextField customerName;
    private javax.swing.JButton deleteProduct;
    private javax.swing.JButton getAllUsers;
    private javax.swing.JButton getCustomer;
    private javax.swing.JButton getUser;
    private javax.swing.JButton jButton14;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JMenuItem logout;
    private javax.swing.JComboBox<String> paymentMethod;
    private javax.swing.JTextField productCategory;
    private javax.swing.JTextField productId;
    private javax.swing.JTextField productName;
    private javax.swing.JTextField productPrice;
    private javax.swing.JTextField productQuantity;
    private javax.swing.JTextField recorderLevel;
    private javax.swing.JButton updateProduct;
    private javax.swing.JTextField userId;
    private javax.swing.JTextField userName;
    // End of variables declaration//GEN-END:variables
}
