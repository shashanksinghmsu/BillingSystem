package com.view.user;

import com.controller.UserController;
import com.model.User;
import com.util.EmailValidator;
import com.util.PasswordEncryption;
import java.awt.Color;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class RegisterUI extends javax.swing.JFrame {

    UserController userController;
    EmailValidator emailValidator;
    FileInputStream fin;
    Properties p;
    private String KEY;
    LoginUI loginUI;

    public RegisterUI() {
        initComponents();
        userController = new UserController();
        emailValidator = new EmailValidator();

        keyLable.setVisible(false);
        keyInput.setVisible(false);
        register.setEnabled(false);
        
        loginUI = new LoginUI();
        
        try{
         fin = new FileInputStream("src\\com\\dbconnection\\db.properties");
            
         p = new Properties();
           
         p.load(fin);
         
         KEY = p.getProperty("KEY");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        userEmailInput = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        register = new javax.swing.JButton();
        userNameInput = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        passwordInput = new javax.swing.JPasswordField();
        userEmailInput1 = new javax.swing.JTextField();
        designationInput = new javax.swing.JComboBox<>();
        emailValidateLable = new javax.swing.JLabel();
        keyLable = new javax.swing.JLabel();
        keyInput = new javax.swing.JPasswordField();
        showPass = new javax.swing.JCheckBox();
        back = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 255, 255));
        setForeground(new java.awt.Color(51, 51, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 18)); // NOI18N
        jLabel1.setText("Email:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, -1, -1));

        jLabel2.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 24)); // NOI18N
        jLabel2.setText("REGISTER");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 30, -1, -1));

        userEmailInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userEmailInputActionPerformed(evt);
            }
        });
        userEmailInput.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                userEmailInputKeyTyped(evt);
            }
        });
        getContentPane().add(userEmailInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 140, 230, 40));

        jLabel4.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 18)); // NOI18N
        jLabel4.setText("Designation : ");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 270, -1, -1));

        register.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 18)); // NOI18N
        register.setText("REGISTER");
        register.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerActionPerformed(evt);
            }
        });
        getContentPane().add(register, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 380, 140, 40));

        userNameInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userNameInputActionPerformed(evt);
            }
        });
        getContentPane().add(userNameInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 80, 230, 40));

        jLabel5.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 18)); // NOI18N
        jLabel5.setText("Name:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, -1, -1));

        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 80, 230, 40));

        jLabel7.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 18)); // NOI18N
        jLabel7.setText("Password:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 210, -1, -1));

        passwordInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordInputActionPerformed(evt);
            }
        });
        getContentPane().add(passwordInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 200, 230, 40));

        userEmailInput1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userEmailInput1ActionPerformed(evt);
            }
        });
        getContentPane().add(userEmailInput1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 140, 230, 40));

        designationInput.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "user", "admin" }));
        designationInput.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                designationInputItemStateChanged(evt);
            }
        });
        getContentPane().add(designationInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 260, 180, 30));

        emailValidateLable.setText(" ");
        getContentPane().add(emailValidateLable, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 420, 520, 50));

        keyLable.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 18)); // NOI18N
        keyLable.setText("Key :  ");
        getContentPane().add(keyLable, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 320, 80, 30));

        keyInput.setText("jPasswordField1");
        getContentPane().add(keyInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 310, 200, 40));

        showPass.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 12)); // NOI18N
        showPass.setText("Show");
        showPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showPassActionPerformed(evt);
            }
        });
        getContentPane().add(showPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 210, 80, 20));

        back.setText("Back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        getContentPane().add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        setSize(new java.awt.Dimension(749, 553));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void userEmailInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userEmailInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userEmailInputActionPerformed

    private void registerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerActionPerformed
        System.out.println("Hii from register action");
        String userName = userNameInput.getText();
        String email = userEmailInput.getText();
        String password = PasswordEncryption.encryptPassword(new String(passwordInput.getPassword()));
        String designation = (String) designationInput.getSelectedItem();

        if (!userName.equals("") && !email.equals("") && !password.equals("")) {

            if(designation.equals("admin"))
            {
                if(!new String(keyInput.getPassword()).equals(KEY))
                {
                    System.out.println(KEY);
                    JOptionPane.showMessageDialog(null, "KEY is invalid !!!");
                    return;
                }
            }
            
            System.out.println(userName + " " + email + " " + password + " " + designation);
            User u = new User();
            u.setEmail(email);
            u.setPassword(password);
            u.setUser_name(userName);
            u.setUser_Designation(designation);

            if (userController.addUser(u)) {
                this.setVisible(false);
                JOptionPane.showMessageDialog(null, "Now you can use you credentials for login !");
                loginUI.setVisible(true);
            }
            userNameInput.setText("");
          
            
        } else {

            userNameInput.setText("");
            userEmailInput.setText("");
            passwordInput.setText("");
            JOptionPane.showMessageDialog(null, "Please fill all the fields !!");
        }


    }//GEN-LAST:event_registerActionPerformed

    private void userNameInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userNameInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userNameInputActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void passwordInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordInputActionPerformed

    private void userEmailInput1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userEmailInput1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userEmailInput1ActionPerformed

    private void showPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void userEmailInputKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_userEmailInputKeyTyped

        if (!emailValidator.validate(userEmailInput.getText())) {
            emailValidateLable.setText("Email Must  3 elements: local-part, @ symbol, and domain name. The local-part is placed before the @ symbol, and the domain name is placed after the @ symbol.");
            emailValidateLable.setForeground(Color.RED);
            register.setEnabled(false);
        } else {
            emailValidateLable.setText("Email validated sucessfully !!");
            emailValidateLable.setForeground(Color.BLUE);
            register.setEnabled(true);
        }

    }//GEN-LAST:event_userEmailInputKeyTyped

    private void designationInputItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_designationInputItemStateChanged

        if (((String) designationInput.getSelectedItem()).equals("user")) {
            keyLable.setVisible(false);
            keyInput.setVisible(false);
        } else {

            keyLable.setVisible(true);
            keyInput.setVisible(true);
        }

    }//GEN-LAST:event_designationInputItemStateChanged

    private void showPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showPassActionPerformed
       if (showPass.isSelected()) {
            passwordInput.setEchoChar((char) 0);
        } else {
            passwordInput.setEchoChar('*');
        }
    }//GEN-LAST:event_showPassActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        this.setVisible(false);
        loginUI.setVisible(true);
    }//GEN-LAST:event_backActionPerformed

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
            java.util.logging.Logger.getLogger(RegisterUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegisterUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegisterUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegisterUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegisterUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JComboBox<String> designationInput;
    private javax.swing.JLabel emailValidateLable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JPasswordField keyInput;
    private javax.swing.JLabel keyLable;
    private javax.swing.JPasswordField passwordInput;
    private javax.swing.JButton register;
    private javax.swing.JCheckBox showPass;
    private javax.swing.JTextField userEmailInput;
    private javax.swing.JTextField userEmailInput1;
    private javax.swing.JTextField userNameInput;
    // End of variables declaration//GEN-END:variables
}
