package coinpurse;
/**
 * Factory class to create malay money object.
 * @author Theeruth Borisuth
 *
 */
public class MalayMoneyFactory extends MoneyFactory {
	/** attribute for assigns banknote serial number */
	private static long nextSerialNumber = 1000000 ;
	/** attribute for Malay currency */
	private final String CURRENCY = "Ringgit";
	/**
	 * Create a malay money.
	 * @param value - value of a malay money
	 * @return Valuable object of malay money
	 */
	@Override
	public Valuable createMoney(double value) {
		Valuable malaymoney =  null ;
		if(isCoin(value))
		{
			malaymoney = new Coin(value,CURRENCY,"Sen",100);
		}
		else if (isBanknote(value))
		{
			malaymoney = new BankNote(value,CURRENCY,nextSerialNumber++);
		}
		else new IllegalArgumentException();
		return malaymoney;
	}
	/**
	 * Check if value can be consider as malay coin.
	 * @param value - value that you want to check
	 * @return true if it is malay coin, false if it is not
	 */
	public boolean isCoin(double value)
	{	
		
		if (value == 0.05 || value == 0.5 || value == 0.1 || value == 0.20 ) return true ;
		return false;	
	}
	/**
	 * Check if value can be consider as malay banknote.
	 * @param value - value that we want to check
	 * @return true if it is malay banknote, false if it is not
	 */
	public boolean isBanknote(double value)
	{
		if (value == 1 || value == 2 || value == 5  || value == 10 || value == 20 || value == 50 || value == 100) return true ;
		return false;	
	}


}
