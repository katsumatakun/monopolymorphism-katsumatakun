public class Player {
	private int bankAccount;
	private String name;
	private boolean isTurn;
	private int location;
	private int num_propaties;

	public Player(String n){
		name = n;
		bankAccount = 31;
	}

	/* you will add several methods to this class as needed.*/

	/* Whenever you adjust the location, don't forget to check
	to see if you passed "Go".   The instructions explicitly said
	that this was the responsiblity of the player, so this
	functionality belongs here.

	(unless you are told to go "directly" to location, i.e. jail/restroom)
	 */
	public int getPropaty(){
		return num_propaties;
	}

	public void changePropaty(int num){
		num_propaties += num;
	}

	public void pay(int amount){
		bankAccount -= amount;
	}

	public void earn(int amount){
		bankAccount += amount;
	}

	public int money(){
		return bankAccount;
	}

	/*public int gettickets(){
		return tickets;
	}*/

	public String getName(){
		return name;
	}

	public boolean isAlive(){
		if (bankAccount < 0){
			return false;
		}

		else
			return true;
	}
	public void move (int dice){
		int previous = location;
		location = (location + dice) % 32;
		if (previous > location){
			bankAccount += 2;
		}
	}


	public void goToRestroom(){
		location = 5;
	}

	public int checkPlace(){
		return location;
	}


	/*public void drewChanceCard(){
		chanceCard = true;
	}

	public void setChanceCardFalse(){
		chanceCard = false;
	}

	public int checkPlace(){
		return location;
	}

	public int roll(){
		return d.roll();
	}*/
}
