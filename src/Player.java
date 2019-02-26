import java.util.ArrayList;
import java.util.Map;

public class Player {
	private int bankAccount;
	private String name;
	private boolean isTurn;
	private int location;
	private int num_properties;
	private ArrayList<Property> properties;
	private Map<String, Integer> propertyMap;

	public Player(String n){
		name = n;
		bankAccount = 31;
		isTurn = false;
		properties = new ArrayList<>();
	}

	/* you will add several methods to this class as needed.*/

	/* Whenever you adjust the location, don't forget to check
	to see if you passed "Go".   The instructions explicitly said
	that this was the responsibility of the player, so this
	functionality belongs here.

	(unless you are told to go "directly" to location, i.e. jail/restroom)
	 */

	public void setPropertyMap(Map<String, Integer> propertyMap) {
		this.propertyMap = propertyMap;
	}

	public void looseProperty(Property property){
		num_properties -=1;
		properties.remove(property);
	}

	public void purchesProperty(Property property){
		num_properties += 1;
		properties.add(property);
		String color = property.getColor();
		Integer num  = propertyMap.get(color);

		for (Property p : properties){
			if(p.getColor().equals(color)){
				num--;
			}
		}
		if(num == 0){
			propertyMap.put(color, 0);
			System.out.println("===================MONOPOLY==========================");
		}


	}

	public boolean isMonopoly(String color) {
		return (propertyMap.get(color) == 0);
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

	public void moveTo(int index){
		if (location > index){
			System.out.println(" " + name + " passed Go and earned $2");
			bankAccount += 2;
		}
		location = index;
	}


	public void goToRestroom(){
		location = 5;
	}

	public int checkPlace(){
		return location;
	}

	public void endTurn (){
			isTurn  = false;
			System.out.println(name+ " Ends turn with " + num_properties + " properties " + properties + " and $" + bankAccount );
	}

	public void startTurn (){
		isTurn = true;
	}

	public boolean isMyTurn(){
		return isTurn;
	}

}
