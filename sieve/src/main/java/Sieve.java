import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Sieve {
	
	private Map<Integer, Boolean> integersMap = new HashMap<>();
	private final int maxPrime ;
	
    public Sieve(int maxPrime) {
        for(int i=2 ; i<=maxPrime ; i++){
			integersMap.put(i, Boolean.TRUE);
		}
		this.maxPrime = maxPrime ;
    }

    public List<Integer> getPrimes() {
		
		for(int i=2 ; i<=this.maxPrime ; i++){
			List<Integer> multiples = multiples(i, maxPrime);
			for(Integer key : multiples){
				integersMap.put(key, Boolean.FALSE);
			}
		}
		
        List<Integer> result = new ArrayList<>();
		integersMap.forEach((t, u) -> {
			if(u!=null && u==true){
				result.add(t);
			}
		});
		return result ;
    }
	
	/**
	 * Gives the multiple of a number 'till a max number
	 * @param i 
	 * @param max
	 * @return 
	 */
	public List<Integer> multiples(int i, int max){
		List<Integer> multiples = new ArrayList<>();
		int multiple = 2 ;
		while(multiple<=max){
			multiples.add(i * multiple);
			multiple++ ;
		}
		return multiples ;
	}
}
