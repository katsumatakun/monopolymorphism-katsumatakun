public class LooseChange {

	private int balance;

	public LooseChange(){
		balance = 0;
	}

	/*Add some methods here*/
	// This is how my brother always cheated -- snitching money from the
	// loose change.   I'm not bitter.

	private int taken(){
		int money = balance;
		balance = 0;
		return money;
	}

	private void add (int amount ){

		balance += amount;
	}

}