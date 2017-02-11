package coinpurse;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 *  Coin purse cotain coin.
 *  You can insert coin, withdraw the money and check the balance 
 * @author Theeruth Borisuth
 *
 */
public class Purse {
	 /** Collection of objects in the purse. */
	private List<Coin> money = new ArrayList<>();
	/** Capacity is maximum number of coins the purse can hold.*/
	private int capacity;
	/** 
     *  Create a purse with a specified capacity.
     *  @param capacity is maximum number of coins you can put in purse.
     */
	public Purse(int capacity){
		this.capacity = capacity ;
	}

    /**
     * Count and return the number of coins in the purse.
     * This is the number of coins, not their value.
     * @return the number of coins in the purse
     */
	public int count(){
		return this.money.size();
	}
	/** 
     *  Get the total value of all items in the purse.
     *  @return the total value of items in the purse.
     */
	public double getBalance(){
		double balance = 0.0 ;
		for (int i = 0 ; i < money.size();i++){
			if (money.get(i).getValue() != 0)
			{
				balance += money.get(i).getValue();
			}
		}
		return balance ;
	}
	/**
     * Return the capacity of the coin purse.
     * @return the capacity
     */
	public int getCapacity(){
	return this.capacity;
	}
	/** 
     *  Test whether the purse is full.
     *  The purse is full if number of items in purse equals
     *  or greater than the purse capacity.
     *  @return true if purse is full.
     */
	public boolean isFull(){
		if (capacity == money.size()) return true ;
		return false ;
	}
	/** 
     * Insert a coin into the purse.
     * The coin is only inserted if the purse has space for it
     * and the coin has positive value.  No worthless coins!
     * @param coin is a Coin object to insert into purse
     * @return true if coin inserted, false if can't insert
     */
	public boolean insert(Coin coin){
		if(count()!=0){
			if(!coin.getCurrency().equalsIgnoreCase(money.get(0).getCurrency())){
				throw new IllegalArgumentException("Different currency!!");
			}
		}
		if(isFull()||coin.getValue()<=0)
			return false ;
		money.add(coin);
		return true;		
	}
	 /**  
     *  Withdraw the requested amount of money.
     *  Return an array of Coins withdrawn from purse,
     *  or return null if cannot withdraw the amount requested.
     *  @param amount is the amount to withdraw
     *  @return array of Coin objects for money withdrawn, 
	 *    or null if cannot withdraw requested amount.
     */
	public Coin[]withdraw(double amount){
		 if(amount<=0)
	            return null;
	        Collections.sort(money);
	        Collections.reverse(money);
	        List<Coin> returnList  = new ArrayList<>();
	        for(Coin c : money){
	            double value = c.getValue();
	            if(amount-value>=0){
	                amount -= value;
	                returnList.add(c);
	                if(amount==0)
	                    break;
	            }
	        }
	        if(amount==0.0){
	            for(Coin c : returnList){
	                money.remove(c);
	            }
	            Coin[] array = new Coin[returnList.size()];
	            return returnList.toArray(array);
		}
	        return null;
	    }
	/**
     * Get the purse currency.
     * @return currency of the first coin in the purse.
     */
	public String getCurrency(){
        if(getCapacity()==0){
            return null;
        }
        return money.get(0).getCurrency();
	}
	/** 
     * toString returns a string description of the purse contents.
     * It can return whatever is a useful description.
     */
public String toString(){
	return count()+" coin(s) with value "+getBalance();
}
}

