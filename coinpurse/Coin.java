package coinpurse;

/**
* An application that can insert and remove coin.
* @author Theeruth Borisuth
*/
public class Coin implements Comparable<Coin>{
	//variables 
	private double value ;
	private String currency = "Baht" ;
	/**
	 * A constructor that can receive value 
	 * @param value
	 */
	public  Coin(double value){
		this.value = value ;
	}
	/**
	 * A constructor that can receive both value and currency 
	 * @param value and currency
	 */
	public Coin(double value,String curr){
		this.value = value ;
		this.currency = curr;
	}
	/**
	 * Return the value
	 * @return value
	 */
	public double getValue(){
		return this.value ;
	}
	/**
	 * Return the currency
	 * @return currency
	 */
	public String getCurrency(){
		return this.currency;
	}
	public boolean equals(Object arg){
			// ( verify that obj is not null
			if (arg == null) return false;
			//  test that obj is the same class as "this" object
			if ( arg.getClass() != this.getClass())return false;
			//  cast obj to this class's type
			Coin other = (Coin) arg;
			//  compare whatever values determine "equal"
			if ( arg == other ) 
				return true;
			return false; 
	}
	/**Check the currency 
	 * @return
	 */
	@Override
	public int compareTo(Coin other) {
		if(other==null)
            throw new IllegalArgumentException("null");
        if(!this.currency.equalsIgnoreCase(other.currency))
            throw new IllegalArgumentException("different currency!");
        return (int)((this.value-other.value)*100);
	}
	/**
	 * Display the purse money.
	 */
	public String toString(){
		return String.format("%.1f %s", value,currency);
	}	
}
