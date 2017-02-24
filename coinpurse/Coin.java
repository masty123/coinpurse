package coinpurse;

import java.text.DecimalFormat;

/**
* An application that can insert and remove coin.
* @author Theeruth Borisuth
*/
public class Coin extends AbstractValuable {
    String denominator;
    double exchange ;

	/**
	 * A coin with given value using the default currency.
	 * @param value
	 */
	public Coin( double value ) {
		super(value, "Baht");
	}

	/**
	 * A coin with given value and currency.
	 * @param value
	 * @param currency
	 */
	public Coin( double value, String currency ) {
		super(value,currency);
	}
	/**
     * Create a coin with denomination
     * @param value - value of a c	oin with currency
     * @param currency - currency of a coin
     * @param denomination - currenct's different denomination of a coin
     * @param exchange - ratio to exchange from main currency to different denomination
     */
    public Coin(double value, String currency, String denomination, double exchange) {
    	super( value, currency);
    	this.denominator = denomination;
    	this.exchange = exchange;
    }
	/**
	 * @return value of the coin.
	 */
	public double getValue( ) {
		return value;
	} 

	/**
	 * @return currency of the coin
	 */
	public String getCurrency() {
		return currency;
	}

	/**
	 * Check if the value of the coins are equal.
	 * @return true if the object are equal.
	 * @return false if the object are not equal.
	 */
	public boolean equals( Object obj ) {
		if(obj.getClass() != this.getClass() || obj == null){
			return false;
		}
		Valuable objCoin = ( Valuable ) obj;
		return this.value == objCoin.getValue() && this.currency == objCoin.getCurrency();
	}

	/**
	 * Compare the value of 2 coins.
	 * @return int of compareTo method.
	 */
	public int compareTo( Valuable other ){
		if(this.value < other.getValue()){
			return -1;
		}
		else if(this.value > other.getValue()){
			return 1;
		}
		else{
			return 0;
		}
	}
	 /**
     * Return String representation of the coin.
     * @return String representation of the coin
     */
    @Override
    public String toString(){
    	String showCurrency="";
    	if ( denominator==null ) {
    		showCurrency = currency;
    	} else {
    		showCurrency = denominator;
    	}
    	DecimalFormat numFormat = new DecimalFormat("0.##");
    	return String.format("%s %s",numFormat.format(value),showCurrency);
    }

	
	}

