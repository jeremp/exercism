
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 *
 * @author jpasseron
 */
public class SubsetOfBooks {

	public static List<List<Integer>> buildSetOfDifferentBooks(List<Integer> books){
		List<List<Integer>> res = new ArrayList<>();
		
		while(books.isEmpty()==false){
			List<Integer> uniqueBooks = extractUniques(books);
			res.add(uniqueBooks);
			
			for(Integer b : uniqueBooks){
				books.remove(books.indexOf(b));
			}
		}
		
		return res ;
	}
	
	private static List<Integer> extractUniques(List<Integer> books){
		return books.stream().distinct().collect(Collectors.toList());
	}
	
}
