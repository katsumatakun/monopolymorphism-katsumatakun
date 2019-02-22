public class RestRoom extends MonopolySquare {

    public RestRoom(String n){
        super(n);
    }

    public void landOn(Player P){
        System.out.println(P.getName() + " landed Restroom");
        System.out.println(P.getName() + " has $" + P.money());
        P.endTurn();
    }
    public void setOwner(Player P){}
    public String getOwner(){return "";}
}


