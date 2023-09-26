
package com.util;


public class CheckValue {
    
    
    public boolean isStringInt(String s){
        try{
         Integer.parseInt(s);
         return true;
        }
        catch(NumberFormatException ne){
        return false;
        }
                    
    }
    public boolean isStringDouble(String s){
        try{
         Double.parseDouble(s);
         return true;
        }
        catch(NumberFormatException ne){
        return false;
        }
        
    }
}
