public class Player {
	private int bankAccount;
	private String name;
	private boolean isTurn;
	private int location;
	private int num_propaties;

	public Player(String n){
		name = n;
		bankAccount = 31;
		isTurn = false;
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

	public void move (int dice){
		int previous = location;
		location = (location + dice) % 32;
		if (previous > location){
			System.out.println(name + " passed Go and earned $2");
			bankAccount += 2;
		}
	}


	public void goToRestroom(){
		location = 5;
	}

	public int checkPlace(){
		return location;
	}

	public void endTurn (){
			isTurn  = false;
			System.out.println(name+ "'s turn finish" );
	}

	public void startTurn (){
		isTurn = true;
	}

	public boolean isMyTurn(){
		return isTurn;
	}

	public void jumpLocation(int num, String color){
		int next_location = 0;
		switch (color){
			case "purple": next_location = 2;
			break;
			case "white": next_location = 6;
			break;
			case "magenta": next_location = 11;
			break;
			case "orange": next_location = 14;
			break;
			case "red": next_location = 18;
			break;
			case "yellow": next_location = 22;
			break;
			case "green": next_location = 27;
			break;
			case "blue": next_location = 30;
			break;
			default:break;
		}

		if (num == 2){
			next_location++;
		}
		if (next_location < location){
			System.out.println( name + " passed Go");
			System.out.println(name + " earned $2");
			earn(2);
		}
		location = next_location;
		String n = Integer.toString(num);
		System.out.println(name + " moved " + color + n);
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
