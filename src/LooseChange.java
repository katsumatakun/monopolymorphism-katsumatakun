/*
	Loose Change Object
*/

public class LooseChange {

	private int balance;


	public LooseChange(){
		balance = 0;
	}

	/*Add some methods here*/
	// This is how my brother always cheated -- snitching money from the
	// loose change.   I'm not bitter.

	/*
		return current balance and reset the balance
	*/
	public int taken(){
		int money = balance;
		reset();
        System.out.println(" All of the money at LooseChange was taken");
		System.out.println(" There is no money at LooseChange now");
		return money;
	}
	/*
		just return balance, but not reset
	*/
	public int checkBalance (){
		return balance;
	}

	public void add (int amount ){

		balance += amount;
		System.out.println(" $" + amount + " is added to LooseChange.");
        System.out.println(" There is $" + balance + " on LooseChange now.");
	}

	public void reset(){
		balance = 0;
	}




}