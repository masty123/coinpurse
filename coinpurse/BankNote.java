package coinpurse;
/**
* An application that can insert and remove banknote.
* @author Theeruth Borisuth
*/
public class BankNote implements Valuable {
	//The initiate of the first serial number.
	private static long nextSerialNumber = 1000000 ;
	//Value of the money.
	private double value ;
	//Value of serial number.
	private  long serialNumber ;
	//Default of the curreny
	private String currency = "Baht";
	/**
	 * A banknote with given value using the default currency.
	 * @param value
	 */
	public BankNote(double value){
		this.value = value ;
		serialNumber = nextSerialNumber++;
	}
	/**
	 * A banknote with given value and currency.
	 * @param value
	 * @param currency
	 */
	public BankNote(double value, String currency){
		this.value = value ;
		this.currency = currency ;
		serialNumber = nextSerialNumber++;
	}
	/**
	 * @return value of the banknote.
	 */
	public double getValue(){
		return this.value ;
	}
	/**
	 * @return currency of the banknote
	 */
	public String getCurrency(){
		return this.currency ;
	}
	/**
	 * @return serialnumber of the banknote
	 */
	public long SerialNumber(){
		return this.serialNumber;
	}
	/**
	 * Check if the value of the banknote are equal.
	 * @return true if the object are equal.
	 * @return false if the object are not equal.
	 */
	public boolean equals( Object obj ) {
		if(obj.getClass() != this.getClass() || obj == null){
			return false;
		}
		BankNote other = (BankNote) obj;
		return this.value == other.getValue() && this.currency == other.getCurrency();
	}
	/**
	 * Convert banknote to string.
	 * @return BankNote as a string.
	 */
	public String toString(){
		return value+"---"+currency+" ["+serialNumber+"]";
	}
	/**
	 * Compare the value of 2 banknote.
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
	
}
