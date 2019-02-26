/*
    Actual class for Restroom
    nothing will happen in the landOn method
*/
public class RestRoom extends MonopolySquare {

    public RestRoom(String n){
        super(n);
    }

    @Override
    public void landOn(Player P){
        System.out.println(" " + P.getName() + " moves to Restroom");
        P.endTurn();
    }

    /*
       Since these are abstract, we have to override, but they will not be called
       and will not do anything
   */
    public void setOwner(Player P){}
    public void resetOwner(){}
    public String getOwner(){return "";}
}


