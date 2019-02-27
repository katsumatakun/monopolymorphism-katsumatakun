/*
    End turn method will no be called
    in landOn method
*/

public class RailRoad extends MonopolySquare {


    public RailRoad(String name){
            super(name);
    }

    @Override
    public void landOn(Player P){ System.out.println( " " + P.getName() + " moves to " +  name); }
}

