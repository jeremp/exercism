import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Etl {
    
    
   public Map<String, Integer> transform(Map<Integer, List<String>> old) {
       Map<String, Integer> map = new HashMap<>();
       for(Integer points : old.keySet()){
           List<String> letters = old.get(points);
           for(String letter : letters){
               map.put(letter.toLowerCase(), points);
           }
       }
       return map ;
   }
}
