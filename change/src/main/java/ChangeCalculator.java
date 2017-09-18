
import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author jpasseron
 */
class ChangeCalculator {

	private final List<Integer> COINS = new ArrayList();
	
	public ChangeCalculator(List<Integer> coins) {
		coins.stream().forEach(c -> this.COINS.add(0,c));
	}

	public List<Integer> computeMostEfficientChange(int money) {
		List<Integer> coinsToGive = new ArrayList<>();
		int indexCoin = 0 ;
		System.out.println("\n------------------");
		System.out.println("money = "+money);
		while(money>0){
			Integer nextCoin = COINS.get(indexCoin);
			while(doesItFeed(nextCoin, money)){
				System.out.println("je donne "+nextCoin+"");
				coinsToGive.add(0, nextCoin);
				money = money - nextCoin ;
				System.out.println("il reste a payer "+money);
			}
			indexCoin++ ;
		}
		return coinsToGive ;
	}
	
	public boolean doesItFeed(int coin, int moneyToChange){
		return coin <= moneyToChange ;
	}
	
	public List<List<Integer>> getAllSolutions(int money){
		List<List<Integer>> results = new ArrayList<>();
		
		List<Integer> coinCollection = new ArrayList<>();
		coinCollection.addAll(COINS);
		
		while(coinCollection.isEmpty()==false){
		}
		
		return results ;		
	}
	
}
