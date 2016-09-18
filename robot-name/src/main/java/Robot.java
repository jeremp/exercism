
import java.util.HashMap;
import java.util.Map;
import java.util.Random;


/**
 *
 * @author jeremp
 */
public final class Robot {

    private static final Map<String, Robot> ROBOT_COLLECTION = new HashMap<>();
    
    private String name ;
    
    public Robot() {
        reset();
    }
    
    public void reset(){
        if(this.name!=null){
            ROBOT_COLLECTION.remove(this.name);
        }
        generateName();
        ROBOT_COLLECTION.put(name, this);        
    }
    
    private void generateName(){
        
        String newName = null ; 
        while (newName==null || ROBOT_COLLECTION.get(newName)!=null) {
            newName = getLetterString(2) + getNumberString(3);                       
        }
        this.name = newName ;
        
    }
    
    protected String getLetterString(int length) {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < length) {
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;
    }
    
    protected String getNumberString(int length) {
        String SALTCHARS = "1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < length) {
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;
    }

    public String getName() {
        return name;
    }
    
    
    
    
}
