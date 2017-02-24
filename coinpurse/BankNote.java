package coinpurse;
/**
* An application that can insert and remove banknote.
* @author Theeruth Borisuth
*/
public class BankNote extends AbstractValuable {
	
	//Value of serial number.
	private  long serialNumber ;
	/**
	 * A banknote with given value and serialNumber.
	 * @param value
	 * @param serialNumber
	 */
	public BankNote(double value, long serialNumber){
		super(value,"Baht");
		this.serialNumber = serialNumber;
	}
	/**
	 * Initialize a bank note with a currency.
	 * @param value - initial value of bank note
	 * @param currency - currency of bank note
	 */
	public BankNote(double value, String currency, long serialNumer)
	{
		super(value,currency);
		this.serialNumber = serialNumber;
	}
	/**
	 * Get bank note's serial number
	 * @return serial number of bank note
	 */
	public	long getSerial()
	{
		return this.serialNumber;
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
