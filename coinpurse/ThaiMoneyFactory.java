package coinpurse;
/**
 * Factory class to create thai money object.
 * @author Theeruth Borisuth
 *
 */
public class ThaiMoneyFactory extends MoneyFactory {
	/** attribute for assigns banknote serial number */
	private static long nextSerialNumber = 10000001L;
	/** attribute for Thai currency */
	private final String CURRENCY = "Baht";

	/**
	 * Create a baht money.
	 * @param value - value of a baht money
	 * @return Valuable object of a baht money
	 */
	@Override
	public Valuable createMoney(double value) {
		Valuable thaimoney =  null ;
		if(isCoin(value))
		{
			thaimoney = new Coin(value);
		}
		else if (isBanknote(value))
		{
			thaimoney = new BankNote(value, nextSerialNumber++);
		}
		else new IllegalArgumentException();
		return thaimoney;
	}
	/**
	 * Return Thai currency.
	 * @return thai currency
	 */
	public String getCurrency() {
		return CURRENCY;
	}
	/**
	 * Check if value can be consider as baht coin.
	 * @param value - value that you want to check
	 * @return true if it is baht coin, false if it is not
	 */
	public boolean isCoin(double value)
	{	
		
		if (value == 1 || value == 2 || value == 5 || value == 10 ) return true ;
		return false;	
	}
	/**
	 * Check if value can be consider as baht banknote.
	 * @param value - value that we want to check
	 * @return true if it is baht banknote, false if it is not
	 */
	public boolean isBanknote(double value)
	{
		if (value == 20 || value == 50 || value == 100  || value == 500 || value == 1000) return true ;
		return false;	
	}

}
