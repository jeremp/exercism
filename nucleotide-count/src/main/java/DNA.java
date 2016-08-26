
import java.util.HashMap;
import java.util.Map;

public class DNA {
    
    private static final char[] DNA_CHARS = new char[]{'A', 'C', 'G', 'T'} ;
    
    private final String data ;
    private Map<Character, Integer> countMap ;
    

    public DNA(String data) {
        this.data = data;
        countMap = new HashMap<>();
        for(char c : DNA_CHARS){
            countMap.put(c, 0);
        }
    }
    
    public Integer count(char c){
        if(countMap.containsKey(c)==false){
            throw new IllegalArgumentException("'"+c+ "' is not a DNA valid character");
        }
        if(data==null || data.isEmpty()){
            return 0 ;
        }else{
            // let's use regexp to remove all chars who are not c and count the result
            String exp = "[^"+c+"]";
            return data.replaceAll(exp, "").trim().length();
            /*
            //The oldfashionned String traversal            
            int total = 0 ;            
            char[] charArray = data.toCharArray();
            for (int i = 0; i < charArray.length; i++) {
                if(charArray[i] == c){
                    total ++ ;
                }
            }            
            return total ;
            */
        }
    }
    
    public Map<Character, Integer> nucleotideCounts() {        
        char[] charArray = data.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (countMap.get(charArray[i]) == null || countMap.get(charArray[i])==0) {
                countMap.put(charArray[i], count(charArray[i]));
            }
        }
        return countMap;

    }

}
