package coinpurse;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
/**
 * Some Coin utility methods for practice using Lists and Comparator.
 */
public class CoinUtil {

	/**
	 * Method that examines all the coins in a List and returns
	 * only the coins that have a currency that matches the parameter value.
	 * @param coinlist is a List of Coin objects. This list is not modified.
	 * @param currency is the currency we want. Must not be null.
         * @throws IllegalArgumentException if currency is null.
	 * @return a new List containing only the elements from coinlist
	 *     that have the requested currency.  
	 */
	public static List<Valuable> filterByCurrency(final List<Valuable> coinlist, String currency) {
		if(currency==null){
                    throw new IllegalArgumentException("Currency cannot be null");
                }
                List<Valuable> temp = new ArrayList<>();
                for(Valuable c : coinlist){
                    if(c.getCurrency().equalsIgnoreCase(currency)){
                        temp.add(c);
                    }
                }
		return Collections.unmodifiableList(temp); // return a list of coin references copied from coinlist
	}
	

	/**
	 * Method to sort a list of coins by currency.
	 * On return, the list (coins) will be ordered by currency.
	 * @param coins is a List of Coin objects we want to sort. 
	 */
	public static void sortByCurrency(List<Valuable> coins) {
		coins.sort(new CompareByCurrency());
	}
	
	/**
	 * Sum coins by currency and print the sum for each currency.
	 * Print one line for the sum of each currency.
	 * For example: 
	 * coins = { Coin(1,"Baht"), Coin(20,"Ringgit"), Coin(10,"Baht"), Coin(0.5,"Ringgit") }
	 * then sumByCurrency(coins) would print:
	 * 
	 * 11.00 Baht
	 * 20.50 Ringgit
	 * 
	 * Hint: this is easy if you sort the coins by currency first. :-)
	 */
	public static void sumByCurrency(List<Valuable> coins) {
		Map<String, Double> map = new HashMap<>();
		for (Valuable money : coins) {
			if (map.containsKey(money.getCurrency())) {
				map.put(money.getCurrency(), map.get(money.getCurrency() + money.getValue()));
			} else
				map.put(money.getCurrency(), map.get(money.getValue()));
		}
		for (String key : map.keySet()) {
			System.out.println(key + " : " + map.get(key));
		}
	}
	
	/**
	 * This method contains some code to test the above methods.
	 * @param args not used
	 */
	public static void main(String[] args) {
		String currency = "Rupee";
		System.out.println("Filter coins by currency of "+currency);
		List<Valuable> coins = makeInternationalCoins();
		int size = coins.size();
		System.out.print(" INPUT: "); printList(coins," ");
		List<Valuable> rupees = filterByCurrency(coins, currency);
		System.out.print("RESULT: "); printList(rupees," ");
		if (coins.size() != size) System.out.println("Error: you changed the original list.");
		
		System.out.println("\nSort coins by currency");
		coins = makeInternationalCoins();
		System.out.print(" INPUT: "); printList(coins," ");
		sortByCurrency(coins);
		System.out.print("RESULT: "); printList(coins," ");
		
		System.out.println("\nSum coins by currency");
		coins = makeInternationalCoins();
		System.out.print("coins= "); printList(coins," ");
		sumByCurrency(coins);
		
	}
	
	/** Make a list of coins containing different currencies. */
	public static List<Valuable> makeInternationalCoins( ) {
		List<Valuable> money = new ArrayList<Valuable>();
		money.addAll( makeCoins("Baht", 0.25, 1.0, 2.0, 5.0, 10.0, 10.0) );
		money.addAll( makeCoins("Ringgit", 2.0, 50.0, 1.0, 5.0) );
		money.addAll( makeCoins("Rupee", 0.5, 0.5, 10.0, 1.0) );
		// randomize the elements
		Collections.shuffle(money);
		return money;
	}
	
	/** Make a list of coins using given values. */ 
	public static List<Valuable> makeCoins(String currency, double ... values) {
		List<Valuable> list = new ArrayList<Valuable>();
		for(double value : values) list.add(new Coin(value,currency));
		return list;
	}
	
	/** Print the list on the console, on one line. */
	public static void printList(List items, String separator) {
		Iterator iter = items.iterator();
		while( iter.hasNext() ) { 
			System.out.print(iter.next());
			if (iter.hasNext()) System.out.print(separator);
			
		}
		System.out.println(); // end the line
	}
}

/**
 * Class for comparing two Coins by currency.
 */
class CompareByCurrency implements Comparator<Valuable>{
    /** an empty constructor */
    public CompareByCurrency(){}
    /**
     * Compare two coins by currency.
     * @param c1 is the first Coin.
     * @param c2 is the second Coin.
     * @return positive integer if c1 is greater than c2, negative if less than, else zero.
     */
    @Override
    public int compare(Valuable c1,Valuable c2){
        return c1.getCurrency().compareToIgnoreCase(c2.getCurrency());
    }
}