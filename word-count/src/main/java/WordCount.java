
import java.util.HashMap;
import java.util.Map;

public class WordCount {
            
    public Map<String, Integer> phrase(String phrase){
        Map<String, Integer> map = new HashMap<>();
        String[] words = phrase.replaceAll("[^a-zA-Z0-9 ]", "").toLowerCase().split("\\s+");
        for(String word : words){
            if(map.containsKey(word)){
                map.put(word, map.get(word)+1);
            }else{
                map.put(word, 1);
            }
        }
        return map ;
    }
    
    
}
