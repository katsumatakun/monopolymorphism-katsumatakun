public class Go extends MonopolySquare {

    public Go(String name){

        super(name);
    }

    @Override
    public String toString() {
        return name;
    }

    public void landOn(Player P) {
        System.out.println(P.getName() + " land on Go");
        System.out.println(P.getName() + " has $" + P.money());
        P.endTurn();
    }
    public void setOwner(Player P){}
    public String getOwner(){return "";}


}
