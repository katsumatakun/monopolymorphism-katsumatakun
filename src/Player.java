public class Player {
	private int bankAccount;
	private String name;
	private boolean isTurn;
	private int location;
	private int num_properties;

	public Player(String n){
		name = n;
		bankAccount = 31;
		isTurn = false;
	}

	/* you will add several methods to this class as needed.*/

	/* Whenever you adjust the location, don't forget to check
	to see if you passed "Go".   The instructions explicitly said
	that this was the responsibility of the player, so this
	functionality belongs here.

	(unless you are told to go "directly" to location, i.e. jail/restroom)
	 */

	public void looseProperty(){num_properties -=1;}

	public void purchesProperty(){
		num_properties += 1;
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

	public String getName(){
		return name;
	}


	/*
		This method will check if the player passed Go
	*/
	public void move (int dice){
		int previous = location;
		location = (location + dice) % 32;
		if (previous > location){
			System.out.println(" " + name + " passed Go and earned $2");
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
			System.out.println(name+ " Ends turn with " +num_properties + " properties and $" + bankAccount );
	}

	public void startTurn (){
		isTurn = true;
	}

	public boolean isMyTurn(){
		return isTurn;
	}
	/*
	 	This method is associated with chance card.
	 	It allows the player to jump the location, but
	 	it will still check if the player passes Go
	*/
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
			System.out.println( " " + name + " passed Go");
			System.out.println(" " + name + " earned $2");
			earn(2);
		}
		location = next_location;
	}

}
