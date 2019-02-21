public class LooseChange {

	private int balance;

	public LooseChange(){
		balance = 0;
	}

	/*Add some methods here*/
	// This is how my brother always cheated -- snitching money from the
	// loose change.   I'm not bitter.

	public int taken(){
		int money = balance;
		balance = 0;
		return money;
	}

	public void add (int amount ){

		balance += amount;
	}




}