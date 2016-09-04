
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Anagram {
    
    private final String originalWord ;
    private final String originalWordSorted ;

    public Anagram(String originalWord) {
        this.originalWord = originalWord;        
        this.originalWordSorted = sort(originalWord.toLowerCase());        
    }
    
    public List<String> match(List<String> candidates){
        List<String> anagrams = new ArrayList<>();
        if(candidates!=null && candidates.isEmpty()==false){
            for(String candidate : candidates){
                // if we sort two anagrams, the result should be the same ?
                if(originalWordSorted.equals(sort(candidate))){
                    //  the same word is not an anagram
                    if(originalWord.equalsIgnoreCase(candidate)==false){
                        anagrams.add(candidate);
                    }
                }
            }
        }
        return anagrams ;        
    }
    
    /**
     * Sort a String : sort("jeremy") = "eejmry"
     * @param s the input string
     * @return the sorted string
     */
    public final String sort(String s){                
        if(s!=null){
            char[] chars = s.toLowerCase().toCharArray();
            Arrays.sort(chars);
            String res = new String(chars);            
            return res ;
        }else{
            return null ;
        }
    }
    
}
