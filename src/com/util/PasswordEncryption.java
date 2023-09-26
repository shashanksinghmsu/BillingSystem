
package com.util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PasswordEncryption {
    
    public static String encryptPassword(String password){
        
        try {
            MessageDigest encryptedPassword = MessageDigest.getInstance("SHA-256");
            
            byte[] hash  = encryptedPassword.digest(password.getBytes(StandardCharsets.UTF_8));
            
            return Base64.getEncoder().encodeToString(hash);
            
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(PasswordEncryption.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
}
