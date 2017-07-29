
import java.util.HashMap;
import java.util.Map;



/**
 *
 * @author jeremp
 */
class RotationalCipher {

    private static final char[] ALPHABET = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    private char[] rotatedAlphabet = new char[26];
    private Map<Character,Character> map = new HashMap<>();

    public RotationalCipher(int rotation) {        
        if(rotation==0){
            rotatedAlphabet = ALPHABET;
        }else{
            if(rotation>=ALPHABET.length){
                rotation = rotation % ALPHABET.length ;
            }
            int index = rotation ;
            for(int i=0 ; i<ALPHABET.length ; i++){
                rotatedAlphabet[i] = ALPHABET[index];
                index++ ;
                if(index>=ALPHABET.length){
                    index = 0 ;
                }
            }            
        }
        System.out.println("rotatedAlphabet="+new String(rotatedAlphabet));
        map = buildTransalationMap(ALPHABET, rotatedAlphabet);
    }
    
    
    private Map<Character,Character> buildTransalationMap(char[] input, char[] output){
        Map<Character,Character> res = new HashMap<>();
        for(int i=0 ; i<input.length ; i++){
            res.put(input[i], output[i]);
        }
        return res ;
    }
    

    public String rotate(String a) {        
        char[] charArray = a.toCharArray();
        StringBuilder builder = new StringBuilder();
        for(char c : charArray){
            Character translatedChar = map.get(c);
            if(translatedChar!=null){
                builder.append(translatedChar);
            }else{
                builder.append(c);
            }
        }
        String res = builder.toString();
        System.out.println("["+a+"] gives ["+res+"]");
        return res;
       
    }
    
}
