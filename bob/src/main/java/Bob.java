
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jeremp
 */
public class Bob {
    
    private static final String CHILL_OUT = "Whoa, chill out!"; 
    private static final String SURE = "Sure."; 
    private static final String FINE = "Fine. Be that way!" ;
    private static final String WHATEVER = "Whatever." ;
    
    
    
    public String hey(String message){
        String res = "";
        if(message!=null){
           if(message.trim().length()==0){
               res = FINE ;
           }else{
               if(message.toUpperCase().equals(message) && ((message.endsWith("?")==true || message.endsWith("!")==true)) && questionWithOnlyNumber(message)==false){
                   res = CHILL_OUT ;
               }else{
                   if(message.endsWith("?")){
                       res = SURE ; 
                   }else{
                       res = WHATEVER ;
                   }
               }
           } 
        }        
        return res ;
    }
    
    private boolean questionWithOnlyNumber(String s){
        if(s.endsWith("?")){
            if(removeLetters(s).equals(s)){
                return true ;
            }
        }
        return false ;
    }
    
    private String removeLetters(String s){
        return s.replaceAll("[^\\d.]", "");
    }
    
}
