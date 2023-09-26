package com.view.user;

import com.controller.CustomerController;
import com.controller.InvoiceController;
import com.controller.ProductController;
import com.controller.UserController;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import javax.swing.JFileChooser;
import com.model.Customer;
import com.model.Invoice;
import com.model.InvoiceProduct;
import com.model.Product;
import com.model.User;
import com.util.CheckValue;
import com.util.EmailValidator;
import com.util.PhoneValidator;
import java.awt.Font;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Timestamp;
import javax.swing.DefaultComboBoxModel;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class userUI extends javax.swing.JFrame {

    CustomerController customerController;
    ProductController productController;
    InvoiceController invoiceController;
    UserController userController;

    List<Customer> allCustomers;
    List<Product> allProduct;
    List<Invoice> allInvoice;
    List<InvoiceProduct> invoiceProducts = new ArrayList<>();
    ArrayList productList = new ArrayList<>();
//    int autoIncrementIdValue=0;
    int invoiceNumber = 0;
    DefaultComboBoxModel<String> productNameModel;
    CheckValue check;
    User loggedUser;

    // for phone and email validation
    PhoneValidator phoneValidator;
    EmailValidator emailValidator;

    public userUI(int loggedUserId) {

        // intialize all controllers 
        productController = new ProductController();
        customerController = new CustomerController();
        invoiceController = new InvoiceController();
        userController = new UserController();

        allProduct = productController.getAllProducts();
        for (Product product : allProduct) {
            productList.add(product.getProduct_Name());
        }
        String[] products = new String[productList.size()];

        for (int i = 0; i < productList.size(); i++) {
            products[i] = (String) productList.get(i);
        }
        productNameModel = new DefaultComboBoxModel<>(products);
        initComponents();
        customerController = new CustomerController();

        // intially all customerList is stored in allCustomers variable
        allCustomers = customerController.getAllCustomers();
//        autoIncrementIdValue = allCustomers.get(allCustomers.size()-1).getCustomer_id();

//        System.out.println(autoIncrementIdValue);
//        autoIncrementIdValue++;
//        customerId.setText(""+(autoIncrementIdValue));
        total.setText("" + 0);
        customerType.setSelectedIndex(5);

        allInvoice = invoiceController.getAllInvoices();
        invoiceNumber = allInvoice.size();

        // setting Invoice ID and Customer ID
        invoiceNo.setText("" + (invoiceController.getMaxId() + 1));
        customerId.setText("" + (customerController.getMaxId() + 1));

        check = new CheckValue();

        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String formattedDate = currentDate.format(formatter);
        date.setText("" + formattedDate);

        // setting logged user Id so that we can use for profile and other uses
        System.out.println("Logged user id is : " + loggedUserId);

        loggedUser = userController.getUserById(loggedUserId);

        if (loggedUser == null) {
            JOptionPane.showMessageDialog(null, "Invalid USER !!");
        }

        // Email and phone validation intialize 
        emailValidator = new EmailValidator();
        phoneValidator = new PhoneValidator();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        date = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        customerId = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        customerName = new javax.swing.JTextField();
        customerPhoneNo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        customerEmail = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        customerAddress = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        customerType = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        productId = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        productCatagory = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        productQuantity = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        productName = new javax.swing.JComboBox<>();
        addProduct = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        quantityAvailable = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        unitPrice = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        invoiceNo = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        total = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        genarateButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        checkCustomer = new javax.swing.JButton();
        paymentMethod = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        logout = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Generate Invoice");
        setResizable(false);

        date.setEditable(false);
        date.setFocusable(false);

        jLabel1.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 10)); // NOI18N
        jLabel1.setText("Date:");

        jLabel2.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Customer Details");

        jLabel3.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("ID :");

        customerId.setEditable(false);
        customerId.setFocusable(false);
        customerId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerIdActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Name :");

        customerName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerNameActionPerformed(evt);
            }
        });
        customerName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                customerNameKeyPressed(evt);
            }
        });

        customerPhoneNo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                customerPhoneNoKeyTyped(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 12)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Phone :");

        jLabel6.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 12)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Email :");

        jLabel17.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 12)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel17.setText("Address :");

        jLabel18.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 12)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel18.setText("Type :");

        customerType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Retailer", "Wholesaler", "Distributor", "Manufacturer", "Agency", "Individual" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(customerPhoneNo, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
                    .addComponent(customerEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
                    .addComponent(customerAddress)
                    .addComponent(customerName, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(customerId, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(customerType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {customerAddress, customerEmail, customerName, customerPhoneNo, customerType});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(customerId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(customerName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(customerPhoneNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(customerEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addComponent(customerAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(customerType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Product Details");

        jLabel8.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 12)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("ID :");

        productId.setEditable(false);
        productId.setFocusable(false);
        productId.setPreferredSize(null);
        productId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                productIdKeyReleased(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 12)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Name :");

        productCatagory.setEditable(false);
        productCatagory.setFocusable(false);
        productCatagory.setPreferredSize(null);

        jLabel10.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 12)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Catagory :");

        productQuantity.setPreferredSize(null);
        productQuantity.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                productQuantityKeyTyped(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 12)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Quantity :");

        productName.setMaximumRowCount(10);
        productName.setModel(productNameModel);
        productName.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                productNameItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(productQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(productName, 0, 93, Short.MAX_VALUE)
                            .addComponent(productCatagory, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(productId, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 31, Short.MAX_VALUE))
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(productId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(productName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(productCatagory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(productQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        addProduct.setText("Add");
        addProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addProductMouseClicked(evt);
            }
        });
        addProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addProductActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 12)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("Quantity Available :");

        quantityAvailable.setEditable(false);
        quantityAvailable.setFocusable(false);
        quantityAvailable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quantityAvailableActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 12)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("Unit Price :");

        unitPrice.setEditable(false);
        unitPrice.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        unitPrice.setFocusable(false);
        unitPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unitPriceActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(unitPrice, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
                    .addComponent(quantityAvailable, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE))
                .addContainerGap(79, Short.MAX_VALUE))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {quantityAvailable, unitPrice});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(quantityAvailable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(unitPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(83, Short.MAX_VALUE))
        );

        jTable.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 14)); // NOI18N
        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No.", "Product Name", "Quantity", "Unit_Price", "SubTotal"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Float.class, java.lang.Float.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable.setFocusable(false);
        jTable.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                jTableInputMethodTextChanged(evt);
            }
        });
        jTable.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jTablePropertyChange(evt);
            }
        });
        jScrollPane1.setViewportView(jTable);
        if (jTable.getColumnModel().getColumnCount() > 0) {
            jTable.getColumnModel().getColumn(0).setMinWidth(50);
            jTable.getColumnModel().getColumn(0).setMaxWidth(50);
        }

        invoiceNo.setEditable(false);
        invoiceNo.setFocusable(false);

        jLabel14.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 10)); // NOI18N
        jLabel14.setText("Invoice No :");

        total.setEditable(false);
        total.setFocusable(false);

        jLabel15.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 10)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel15.setText("Total :");

        jLabel16.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 24)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Invoice Generator");

        genarateButton.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 10)); // NOI18N
        genarateButton.setText("Genarate");
        genarateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                genarateButtonActionPerformed(evt);
            }
        });

        cancelButton.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 10)); // NOI18N
        cancelButton.setText("Cancel");
        cancelButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cancelButtonMouseClicked(evt);
            }
        });
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        checkCustomer.setText("Check Customer");
        checkCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkCustomerActionPerformed(evt);
            }
        });

        paymentMethod.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CASH", "ONLINE" }));
        paymentMethod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paymentMethodActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 10)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel19.setText("Method :");

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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(invoiceNo, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(87, 87, 87)
                                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(checkCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(addProduct)
                                        .addGap(19, 19, 19)))))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(genarateButton)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(paymentMethod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cancelButton))
                        .addGap(29, 29, 29))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(invoiceNo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel1)
                                .addComponent(jLabel14))))
                    .addComponent(jLabel16))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addProduct)
                            .addComponent(checkCustomer))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(paymentMethod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelButton)
                    .addComponent(genarateButton))
                .addContainerGap(53, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void customerNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_customerNameActionPerformed

    private void addProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addProductActionPerformed
        String productQty = productQuantity.getText();
        String availableQty = quantityAvailable.getText();

        if (productQty.equals("")) {
            JOptionPane.showMessageDialog(null, "Please Enter Required Quantity !!");
        } else {
            if (check.isStringInt(productQty)) {

                if (Integer.parseInt(productQty) < Integer.parseInt(availableQty)) {
                    DefaultTableModel model = (DefaultTableModel) jTable.getModel();
                    int rows = model.getRowCount() + 1;
                    String productNameStr = (String) productName.getSelectedItem();
                    String quantityStr = productQuantity.getText();
                    String unitPriceStr = unitPrice.getText();
                    if (!productNameStr.isEmpty() && !quantityStr.isEmpty() && !unitPriceStr.isEmpty()) {
                        Float subTotal = Integer.parseInt(quantityStr) * Float.parseFloat(unitPriceStr);
                        Object[] o = {rows, productNameStr, Integer.valueOf(quantityStr), Float.valueOf(unitPriceStr), subTotal};
                        model.addRow(o);
                        float tt = Float.valueOf(total.getText()) + subTotal;
                        total.setText("" + tt);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Sorry not enough quantity available !!");
                }

            }
        }


    }//GEN-LAST:event_addProductActionPerformed

    private void quantityAvailableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quantityAvailableActionPerformed
// TODO add your handling code here:
    }//GEN-LAST:event_quantityAvailableActionPerformed

    private void unitPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unitPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_unitPriceActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void customerIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_customerIdActionPerformed

    private void checkCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkCustomerActionPerformed
        Customer c = customerController.getCustomerByName(customerName.getText());
        if (c != null) {
            customerId.setText("" + c.getCustomer_id());
            customerEmail.setText("" + c.getCustomer_Email());
            customerEmail.setEditable(false);
            customerEmail.setFocusable(false);
            customerAddress.setText("" + c.getCustomer_Address());
            customerAddress.setEditable(false);
            customerAddress.setFocusable(false);

            customerType.setSelectedItem(c.getCustomer_Type());
            customerPhoneNo.setText("" + c.getCustomer_Phone());
            customerPhoneNo.setEditable(false);
            customerPhoneNo.setFocusable(false);

        } else {
            customerId.setText("" + (customerController.getMaxId() + 1));
            customerPhoneNo.setText("");
            customerPhoneNo.setFocusable(true);
            customerPhoneNo.setEditable(true);
            customerEmail.setText("");
            customerEmail.setEditable(true);
            customerEmail.setFocusable(true);
            customerAddress.setText("");
            customerAddress.setEditable(true);
            customerAddress.setFocusable(true);

        }

    }//GEN-LAST:event_checkCustomerActionPerformed

    private void productNameItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_productNameItemStateChanged
        // TODO add your handling code here:
//        System.out.println(productName.getSelectedItem());
        Product p = productController.getProductByName((String) productName.getSelectedItem());
        productId.setText("" + p.getProduct_id());
        productCatagory.setText("" + p.getProduct_Category());
        quantityAvailable.setText("" + p.getProduct_StockQuantity());
        unitPrice.setText("" + p.getProduct_Price());


    }//GEN-LAST:event_productNameItemStateChanged

    private void cancelButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelButtonMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_cancelButtonMouseClicked

    private void productIdKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_productIdKeyReleased
        // TODO add your handling code here:
        String str = productId.getText();
        int id;
        if (str.equals("")) {
            return;
        } else {
            id = Integer.parseInt(str);
        }
        Product p = productController.getProductById(id);
        if (p != null) {
            productCatagory.setText("" + p.getProduct_Category());
            quantityAvailable.setText("" + p.getProduct_StockQuantity());
            unitPrice.setText("" + p.getProduct_Price());
            productName.setSelectedItem(p.getProduct_Name());
        } else {
            productCatagory.setText("");
            quantityAvailable.setText("");
            unitPrice.setText("");
        }
    }//GEN-LAST:event_productIdKeyReleased

    private void customerNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_customerNameKeyPressed
        // TODO add your handling code here:

//        Customer c = customerController.getCustomerByName(customerName.getText());
//        if (c != null) {
//            customerId.setText("" + c.getCustomer_id());
//            customerEmail.setText("" + c.getCustomer_Email());
//            customerAddress.setText("" + c.getCustomer_Address());
//            customerType.setSelectedItem(c.getCustomer_Type());
//            customerPhoneNo.setText("" + c.getCustomer_Phone());
//        } else {
//            customerEmail.setText("");
//            customerAddress.setText("");
//            customerPhoneNo.setText("");
//        }
    }//GEN-LAST:event_customerNameKeyPressed

    private void addProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addProductMouseClicked
        // TODO add your handling code here:

//        total.setText(""+grandTotal());

    }//GEN-LAST:event_addProductMouseClicked

    private void genarateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_genarateButtonActionPerformed
        String customerEmailStr = customerEmail.getText();
        String customerNameStr = customerName.getText();
        String customerPhoneNoStr = customerPhoneNo.getText();
        String customerAddressStr = customerAddress.getText();
        String customerNameText = customerName.getText().trim();
        String email = customerEmail.getText().trim();
        String phone = customerPhoneNo.getText().trim();
        String address = customerAddress.getText().trim();

        if (customerEmailStr.isBlank() || customerNameStr.isBlank() || customerPhoneNoStr.isBlank() || customerAddressStr.isBlank()) {
            JOptionPane.showMessageDialog(null, "Please fill all fields !!");
        } else {

//            **********************
            if (Integer.parseInt(customerId.getText()) == customerController.getMaxId() + 1) {
                Customer newCustomer = new Customer();
                newCustomer.setCustomer_Address(customerAddressStr);
                newCustomer.setCustomer_Email(customerEmailStr);
                newCustomer.setCustomer_Name(customerNameStr);
                newCustomer.setCustomer_Type((String) customerType.getSelectedItem());
                newCustomer.setCustomer_Phone(customerPhoneNoStr);

                // validate all email and phone of customer
                if (!emailValidator.validate(customerEmailStr)) {
                    JOptionPane.showMessageDialog(null, "Please Enter appropriate Email address !!");
                    return;
                }

                if (!phoneValidator.validate(phone)) {
                    JOptionPane.showMessageDialog(null, "Please Enter Appropriate Phone Number !!");
                    return;
                }

                if (customerController.addCustomer(newCustomer)) {
                    System.out.println("Customer added sucessFully !");
                    //            autoIncrementIdValue++;
                    //             customerId.setText(""+autoIncrementIdValue);
                    customerEmail.setText("");
                    customerName.setText("");
                    customerAddress.setText("");
                    customerPhoneNo.setText("");
                } else {
                    System.out.println("Error while adding customer in userUI.java");
                }

            }
//            **********************
//            newCustomer.setCustomer_Address(customerAddressStr);
//            newCustomer.setCustomer_Email(customerEmailStr);
//            newCustomer.setCustomer_Name(customerNameStr);
//            newCustomer.setCustomer_Type((String) customerType.getSelectedItem());
//            newCustomer.setCustomer_Phone(customerPhoneNoStr);

            DefaultTableModel model = (DefaultTableModel) jTable.getModel();
            int rows = model.getRowCount();
            int cols = model.getColumnCount();

            Invoice invoice = new Invoice();

            invoice.setInvoice_id(Integer.parseInt(invoiceNo.getText()));  // set invoice ID
            invoice.setCreated_By(loggedUser.getUser_id());
            invoice.setCustomer_id(Integer.parseInt(customerId.getText()));
            invoice.setGrand_Total(Double.parseDouble(total.getText()));
            invoice.setPayment_Method((String) paymentMethod.getSelectedItem());
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            invoice.setDate(timestamp);

            for (int j = 0; j < rows; j++) {
                InvoiceProduct invoiceProduct = new InvoiceProduct();
                invoiceProduct.setInvoice_id(invoice.getInvoice_id());
                invoiceProduct.setProduct_id(productController.getProductByName(model.getValueAt(j, 1).toString()).getProduct_id());
                invoiceProduct.setProduct_Quantity(Integer.parseInt(model.getValueAt(j, 2).toString()));
                invoiceProduct.setUnit_Price(Double.parseDouble(model.getValueAt(j, 3).toString()));
                invoiceProduct.setTotal(Double.parseDouble(model.getValueAt(j, 4).toString()));
                invoiceProducts.add(invoiceProduct);
            }
            invoiceController = new InvoiceController();
            if (invoiceController.addInvoice(invoice, invoiceProducts)) {
                for (InvoiceProduct invoiceProduct : invoiceProducts) {
                    Product p = productController.getProductById(invoiceProduct.getProduct_id());
                    if (!productController.updateProductStock(p, invoiceProduct.getProduct_Quantity())) {
                        System.out.println("Error while updating Product Stocks");
                    }
                }
            }

//                ******PDF******
            Object[][] data = new Object[rows][cols];

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    data[i][j] = jTable.getValueAt(i, j);
                }
            }
            String ivc[];

            JFileChooser jfc = new JFileChooser();

            LocalDate currentDate = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            String formattedDate = currentDate.format(formatter);

            jfc.setSelectedFile(new File(customerNameText + " - Invoice" + ".pdf"));
            int dialogresult = jfc.showSaveDialog(null);
            if (dialogresult == JFileChooser.APPROVE_OPTION) {
                String filePath = jfc.getSelectedFile().getPath();
                try {

//                font.setColor(Color.WHITE);
                    Document myDocument = new Document();
                    PdfWriter pdf = PdfWriter.getInstance(myDocument, new FileOutputStream(filePath));
                    myDocument.open();
                    PdfPTable tb1 = new PdfPTable(5);
                    tb1.setWidthPercentage(100);
//               tb1.setWidths(new int[]{300,300});
                    PdfPCell cell1 = new PdfPCell(new Phrase("No", FontFactory.getFont(FontFactory.COURIER_BOLD, 18, BaseColor.WHITE)));
                    PdfPCell cell2 = new PdfPCell(new Phrase("Product", FontFactory.getFont(FontFactory.COURIER_BOLD, 18, BaseColor.WHITE)));
                    PdfPCell cell3 = new PdfPCell(new Phrase("Quantity", FontFactory.getFont(FontFactory.COURIER_BOLD, 18, BaseColor.WHITE)));
                    PdfPCell cell4 = new PdfPCell(new Phrase("Price", FontFactory.getFont(FontFactory.COURIER_BOLD, 18, BaseColor.WHITE)));
                    PdfPCell cell5 = new PdfPCell(new Phrase("Subtotal", FontFactory.getFont(FontFactory.COURIER_BOLD, 18, BaseColor.WHITE)));

                    cell1.setBorder(Rectangle.NO_BORDER);
                    cell2.setBorder(Rectangle.NO_BORDER);
                    cell3.setBorder(Rectangle.NO_BORDER);
                    cell4.setBorder(Rectangle.NO_BORDER);
                    cell5.setBorder(Rectangle.NO_BORDER);

                    cell1.setPaddingBottom(12);

                    cell2.setPaddingBottom(12);
                    cell3.setPaddingBottom(12);
                    cell4.setPaddingBottom(12);
                    cell5.setPaddingBottom(12);

                    cell1.setBackgroundColor(BaseColor.BLACK);
                    cell2.setBackgroundColor(BaseColor.BLACK);
                    cell3.setBackgroundColor(BaseColor.BLACK);
                    cell4.setBackgroundColor(BaseColor.BLACK);
                    cell5.setBackgroundColor(BaseColor.BLACK);

                    tb1.addCell(cell1);
                    tb1.addCell(cell2);
                    tb1.addCell(cell3);
                    tb1.addCell(cell4);
                    tb1.addCell(cell5);

                    for (int i = 0; i < rows; i++) {
                        PdfPCell cell12 = new PdfPCell(new Phrase(model.getValueAt(i, 0).toString(), FontFactory.getFont(FontFactory.COURIER_BOLD, 15)));
                        PdfPCell cell22 = new PdfPCell(new Phrase(model.getValueAt(i, 1).toString(), FontFactory.getFont(FontFactory.COURIER_BOLD, 15)));
                        PdfPCell cell33 = new PdfPCell(new Phrase(model.getValueAt(i, 2).toString(), FontFactory.getFont(FontFactory.COURIER_BOLD, 15)));
                        PdfPCell cell44 = new PdfPCell(new Phrase(model.getValueAt(i, 3).toString(), FontFactory.getFont(FontFactory.COURIER_BOLD, 15)));
                        PdfPCell cell55 = new PdfPCell(new Phrase(model.getValueAt(i, 4).toString(), FontFactory.getFont(FontFactory.COURIER_BOLD, 15)));

                        cell12.setBorder(Rectangle.BOTTOM);
                        cell22.setBorder(Rectangle.BOTTOM);
                        cell33.setBorder(Rectangle.BOTTOM);
                        cell44.setBorder(Rectangle.BOTTOM);
                        cell55.setBorder(Rectangle.BOTTOM);

                        cell12.setPaddingBottom(18);

                        cell22.setPaddingBottom(18);
                        cell33.setPaddingBottom(18);
                        cell44.setPaddingBottom(18);
                        cell55.setPaddingBottom(18);

                        tb1.addCell(cell12);
                        tb1.addCell(cell22);
                        tb1.addCell(cell33);
                        tb1.addCell(cell44);
                        tb1.addCell(cell55);
                    }

                    PdfPTable tb2 = new PdfPTable(1);
                    tb2.setWidthPercentage(100);
                    PdfPCell cellk = new PdfPCell(new Phrase("Grocery Shop - Invoice", FontFactory.getFont(FontFactory.COURIER_BOLD, 26, Font.BOLD, BaseColor.WHITE)));
                    cellk.setBorder(Rectangle.NO_BORDER);
                    cellk.setPaddingTop(16);
                    cellk.setPaddingBottom(18);
                    cellk.setBackgroundColor(BaseColor.BLACK);
                    tb2.addCell(cellk);
                    myDocument.add(tb2);
                    myDocument.add(new Paragraph("Billing To: ", FontFactory.getFont(FontFactory.COURIER_BOLD, 20, Font.BOLD)));
                    myDocument.add(new Paragraph("Name: " + customerNameText, FontFactory.getFont(FontFactory.COURIER_BOLD, 15)));
                    myDocument.add(new Paragraph("Phone No: " + phone, FontFactory.getFont(FontFactory.COURIER_BOLD, 15)));
                    myDocument.add(new Paragraph("Email: " + email, FontFactory.getFont(FontFactory.COURIER_BOLD, 15)));
                    myDocument.add(new Paragraph("Address: " + address, FontFactory.getFont(FontFactory.COURIER_BOLD, 15)));
                    myDocument.add(new Paragraph("Date: " + formattedDate, FontFactory.getFont(FontFactory.COURIER_BOLD, 15)));
                    myDocument.add(new Paragraph("\n"));
                    myDocument.add(tb1);
                    myDocument.add(new Paragraph("\n"));
                    Paragraph p = new Paragraph("Total Amount: " + total.getText(), FontFactory.getFont(FontFactory.COURIER_BOLD, 20));
                    p.setAlignment(Element.ALIGN_RIGHT);
                    myDocument.add(p);

                    myDocument.add(new Paragraph("TERMS AND CONDITIONS:", FontFactory.getFont(FontFactory.COURIER_BOLD, 26, Font.BOLD)));
                    myDocument.add(new Paragraph("Lorem Ipsum Dolor amit constructor. Lorem Ipsum Dolor amit constructor. Lorem Ipsum Dolor amit constructor. Lorem Ipsum Dolor amit constructor. Lorem Ipsum Dolor amit constructor.Lorem Ipsum Dolor amit constructor..Lorem Ipsum Dolor amit constructor..Lorem Ipsum Dolor amit constructor.", FontFactory.getFont(FontFactory.COURIER_BOLD, 12, Font.BOLD)));
                    myDocument.close();
                    JOptionPane.showMessageDialog(null, "Invoice Generated Successfully");
                } catch (Exception e) {
                    System.out.println(e);
                }
            }

            // lastly it set for new invoice 
            for (int i = 0; i < rows; i++) {
//                model.removeRow(i);
            }

            total.setText("" + 0);
            quantityAvailable.setText("");
            productQuantity.setText("");
            unitPrice.setText("");
            productCatagory.setText("");
            productId.setText("");
            customerPhoneNo.setText("");
            customerPhoneNo.setFocusable(true);
            customerPhoneNo.setEditable(true);
            customerEmail.setText("");
            customerEmail.setEditable(true);
            customerEmail.setFocusable(true);
            customerAddress.setText("");
            customerAddress.setEditable(true);
            customerAddress.setFocusable(true);
            customerName.setText("");
            customerType.setSelectedIndex(5);
            invoiceNo.setText("" + (invoiceController.getMaxId() + 1));
            customerId.setText("" + (customerController.getMaxId() + 1));

        }

    }//GEN-LAST:event_genarateButtonActionPerformed

    private void jTablePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jTablePropertyChange
        // TODO add your handling code here:

    }//GEN-LAST:event_jTablePropertyChange

    private void jTableInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jTableInputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jTableInputMethodTextChanged

    private void paymentMethodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paymentMethodActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_paymentMethodActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed

        Profile p = new Profile(loggedUser.getUser_id());
        p.setVisible(true);

    }//GEN-LAST:event_logoutActionPerformed

    private void productQuantityKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_productQuantityKeyTyped
        char ch = evt.getKeyChar();

        // if character is not digit then consume it...
        if (!Character.isDigit(ch)) {
            evt.consume();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_productQuantityKeyTyped

    private void customerPhoneNoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_customerPhoneNoKeyTyped
        char ch = evt.getKeyChar();

        // if character is not digit then consume it...
        if (!Character.isDigit(ch)) {
            evt.consume();
        }        // TODO add your handling code here:     

    }//GEN-LAST:event_customerPhoneNoKeyTyped

    double grandTotal() {
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        int rows = model.getRowCount() + 1;
        double s = 0;

        for (int i = 0; i < rows; i++) {
            s = s + (double) model.getValueAt(i, 5);
        }
        return s;

    }

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
            java.util.logging.Logger.getLogger(userUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(userUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(userUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(userUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new userUI(1).setVisible(true);   // just temporry passed as this userUI will never ever called from main method
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addProduct;
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton checkCustomer;
    private javax.swing.JTextField customerAddress;
    private javax.swing.JTextField customerEmail;
    private javax.swing.JTextField customerId;
    private javax.swing.JTextField customerName;
    private javax.swing.JTextField customerPhoneNo;
    private javax.swing.JComboBox<String> customerType;
    private javax.swing.JTextField date;
    private javax.swing.JButton genarateButton;
    private javax.swing.JTextField invoiceNo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable;
    private javax.swing.JMenuItem logout;
    private javax.swing.JComboBox<String> paymentMethod;
    private javax.swing.JTextField productCatagory;
    private javax.swing.JTextField productId;
    protected javax.swing.JComboBox<String> productName;
    private javax.swing.JTextField productQuantity;
    private javax.swing.JTextField quantityAvailable;
    private javax.swing.JTextField total;
    private javax.swing.JTextField unitPrice;
    // End of variables declaration//GEN-END:variables
}
