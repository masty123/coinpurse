package coinpurse;
/**
*	This is a class that is an abstract of the class called Valuable
* @author Theeruth Borisuth
*/
public abstract class  AbstractValuable implements Valuable {
	/** Default currency of money**/
	public static final String DEFAULT_CURRENCY = "Baht";
	/** value of money**/
	double value ;
	/**String of currency**/
	String currency ;
	/**
    * Constructor that use to initialize value and currency.
    * @param value is the value of valuable object.
    * @param currency is the currency of valuable object.
    */
	public AbstractValuable(double value)
	{
		this.value = value;
		this.currency = DEFAULT_CURRENCY;
	}
	/**
     *  Constructor to initialize value and currency to DEFAULT_CURRENCY.
     * @param value is the value of valuable object.
     */
	public AbstractValuable(double value, String currency)
	{
		this.value = value ;
		this.currency = currency ;
	}
	/**
	 * Compare the value of 2 Valuable.
	 * @return int of compareTo method.
	 */
	@Override
	public int compareTo(Valuable other) {
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
	 * Get the value of valuable
	 * @return  Get the value of valuable
	 */
	@Override
	public double getValue() {
		return this.value ;
	}
	/**
	 * Get the currency of valuable
	 * @return  Get the currency of valuable
	 */
	@Override
	public String getCurrency() {
		return this.currency ;
	}

}
