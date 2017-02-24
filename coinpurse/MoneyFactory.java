package coinpurse;

public abstract class MoneyFactory {
	private static MoneyFactory factory = null ;
	public MoneyFactory(){}
	static MoneyFactory getInstance()
	{
		if (factory == null) factory = new ThaiMoneyFactory();
		return factory;
	}
	public abstract Valuable createMoney(double valuable);
	
	public static  void setMoney(MoneyFactory difference)
	{
		if (factory == null) factory = new ThaiMoneyFactory();
		factory = difference ;
	}

	public Valuable createMoney(String value)
	{
		Valuable valuable ;
		try {
		    valuable = createMoney(Double.parseDouble( value));
		} catch (NumberFormatException | NullPointerException ex) {
		    throw new IllegalArgumentException("Sorry, it's is not a valid amount.");
		}
		return valuable ;
	}
	
	
}
