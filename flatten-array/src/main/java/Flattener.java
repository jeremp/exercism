
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author jpasseron
 */
class Flattener {

	public List flatten(List<Object> input){
		return extractFromList(input);
	}
	
	private List<Object> extractFromList(List<Object> input){
		List<Object> res = new ArrayList<>();
		for(Object o : input){
			if(o!=null){
				if(o instanceof List){
					res.addAll(extractFromList((List)o));
				}else{
					res.add(o);
				}
			}
		}
		return res ;
	}
	
	
	
}
