package com.view.user;

import com.controller.UserController;
import com.model.User;
import com.util.EmailValidator;
import com.util.PasswordEncryption;
import com.view.admin.AdminView;
import com.view.user.RegisterUI;
import com.view.user.userUI;
import java.awt.Color;
import javax.swing.JOptionPane;

public class LoginUI extends javax.swing.JFrame {

    UserController userController;
    EmailValidator emailValidator;

    public LoginUI() {
        System.out.println("I am from LOGIN UI constructor");
        initComponents();

        userController = new UserController();

        
        emailValidator = new EmailValidator();
        
        login.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        emailInput = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        passwordInput = new javax.swing.JPasswordField();
        login = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        register = new javax.swing.JButton();
        showPassword = new javax.swing.JCheckBox();
        emailValidateLable = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 255, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        emailInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailInputActionPerformed(evt);
            }
        });
        emailInput.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                emailInputKeyTyped(evt);
            }
        });
        getContentPane().add(emailInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 100, 230, 40));

        jLabel1.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 18)); // NOI18N
        jLabel1.setText("Email:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, -1, -1));

        jLabel2.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 24)); // NOI18N
        jLabel2.setText("LOGIN");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 30, -1, -1));

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 100, 230, 40));

        jLabel4.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 18)); // NOI18N
        jLabel4.setText("Password:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 170, -1, -1));

        passwordInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordInputActionPerformed(evt);
            }
        });
        getContentPane().add(passwordInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 160, 230, 40));

        login.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 14)); // NOI18N
        login.setText("LOGIN");
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });
        getContentPane().add(login, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 250, 120, 40));

        jLabel5.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 18)); // NOI18N
        jLabel5.setText("Dont't have account ? ");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 340, -1, -1));

        register.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 14)); // NOI18N
        register.setText("Register");
        register.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerActionPerformed(evt);
            }
        });
        getContentPane().add(register, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 330, 140, 30));

        showPassword.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 18)); // NOI18N
        showPassword.setText("Show");
        showPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showPasswordActionPerformed(evt);
            }
        });
        getContentPane().add(showPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 170, -1, -1));
        getContentPane().add(emailValidateLable, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 390, 490, 50));

        setSize(new java.awt.Dimension(664, 476));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void emailInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailInputActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void passwordInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordInputActionPerformed

    private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed

        String email = emailInput.getText();
        String password = PasswordEncryption.encryptPassword(new String(passwordInput.getPassword()));

        
        
        if (!email.equals("")&& !password.equals("")) {

            User u = userController.getUserByEmail(email);
            

            if (u != null) {

                if (u.getEmail().equals(email) && u.getPassword().equals(password)) {
                    switch (u.getUser_Designation()) {
                        case "admin" -> {
                            this.setVisible(false);
                            AdminView adminViewFrame = new AdminView(u.getUser_id());
                            adminViewFrame.setVisible(true);
                        }
                        case "user" -> {
                            this.setVisible(false);
                            System.out.println("UserId from login UI is : "+u.getUser_id());
                            userUI userUIFrame = new userUI(u.getUser_id());
                            userUIFrame.setVisible(true);
                        }
                        default -> JOptionPane.showMessageDialog(null, "Invalid Designation . sorry you can't login !!");
                    }
                } else {

                    JOptionPane.showMessageDialog(null, "Authentication Failed !!");
                    emailInput.setText("");
                    passwordInput.setText("");
                }

            } else {
                JOptionPane.showMessageDialog(null, "No such User exists ! please register !!");
                emailInput.setText("");
                passwordInput.setText("");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please Enter valid details !!");
            emailInput.setText("");
            passwordInput.setText("");
        }


    }//GEN-LAST:event_loginActionPerformed

    private void registerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerActionPerformed

        this.setVisible(false);

        RegisterUI registerFrame = new RegisterUI();
        registerFrame.setVisible(true);

    }//GEN-LAST:event_registerActionPerformed

    private void showPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showPasswordActionPerformed
        if (showPassword.isSelected()) {
            passwordInput.setEchoChar((char) 0);
        } else {
            passwordInput.setEchoChar('*');
        }
    }//GEN-LAST:event_showPasswordActionPerformed

    private void emailInputKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_emailInputKeyTyped

        if (!emailValidator.validate(emailInput.getText())) {
            emailValidateLable.setText("Email Must  3 elements: local-part, @ symbol, and domain name. The local-part is placed before the @ symbol, and the domain name is placed after the @ symbol.");
            emailValidateLable.setForeground(Color.RED);
            login.setEnabled(false);
        } else {
            emailValidateLable.setText("Email validated sucessfully !!");
            emailValidateLable.setForeground(Color.BLUE);
            login.setEnabled(true);
        }      
        
        
    }//GEN-LAST:event_emailInputKeyTyped

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
            java.util.logging.Logger.getLogger(LoginUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField emailInput;
    private javax.swing.JLabel emailValidateLable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JButton login;
    private javax.swing.JPasswordField passwordInput;
    private javax.swing.JButton register;
    private javax.swing.JCheckBox showPassword;
    // End of variables declaration//GEN-END:variables
}
