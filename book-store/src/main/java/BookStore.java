
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/**
 *
 * @author jpasseron
 */
class BookStore {

	private static final Map<Integer, Integer> DISCOUNT_BY_BOOKS_NUMBER = new HashMap<>() ;
	
	private static final double SINGLE_BOOK_PRICE = 8.0;
	
	static {
		DISCOUNT_BY_BOOKS_NUMBER.put(0, 0);
		DISCOUNT_BY_BOOKS_NUMBER.put(1, 0);
		DISCOUNT_BY_BOOKS_NUMBER.put(2, 5);
		DISCOUNT_BY_BOOKS_NUMBER.put(3, 10);
		DISCOUNT_BY_BOOKS_NUMBER.put(4, 20);
		DISCOUNT_BY_BOOKS_NUMBER.put(5, 25);
	}
	
	public double calculateBasketCost(List<Integer> books) {
		
		ArrayList<Integer> buuks = new ArrayList<>(books);
		
		List<List<Integer>> subsets = SubsetOfBooks.buildSetOfDifferentBooks(buuks);		
		double finalPrice = 0.0 ;
		for(List<Integer> currentBooks : subsets){
			double priceWithoutDiscount = priceWithoutDiscount(currentBooks.size());
		    double discountedPrice = getDiscount(priceWithoutDiscount, currentBooks.size()); 
			finalPrice += discountedPrice ;
		}
		
		return finalPrice ;
	}
	
	private int getDisctinctNumberOfBooks(List<Integer> books){
		return books.stream().distinct().collect(Collectors.toList()).size();
	}
	
	private double priceWithoutDiscount(int numberOfBooks){
		return numberOfBooks * SINGLE_BOOK_PRICE ;
	}
	
	private double getDiscount(double totalPrice, int numberOfBooks){
		Integer discountPercentage = DISCOUNT_BY_BOOKS_NUMBER.get(numberOfBooks);
		if(discountPercentage==null){
			return DISCOUNT_BY_BOOKS_NUMBER.get(5);
		}
		
		double discountPrice = totalPrice * ((double)discountPercentage / 100);
		return totalPrice - discountPrice ;
	}
	
}
