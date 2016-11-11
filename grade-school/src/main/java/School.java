
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



/**
 *
 * @author jeremp
 */
class School {

    private Map<Integer, List<String>> map ;

    public School() {
        map = new HashMap<>();
    }

    public void add(String aimee, int i) {
        List<String> graduated = grade(i);
        graduated.add(aimee);
        map.put(i, graduated);
    }

    public Map<Integer, List<String>> db() {
        return map ;
    }
    
    public List<String> grade(int i){
        List<String> res = map.get(i);
        if(res==null){
            res = new ArrayList<>();
            map.put(i, res);
        }
        return res ;
    }
    
    public Map<Integer, List<String>> sort(){
        return map ;
    }
    
    
    
    
    
    
    
}
