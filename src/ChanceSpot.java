public class ChanceSpot extends MonopolySquare {

    public ChanceSpot(String n){
        super(n);
    }

    @Override
    public String toString() {
        return name;
    }

    public void landOn(Player P) {
        System.out.println(P.getName() + " land on ChanceSpot");
    }
    public void setOwner(Player P){}
    public String getOwner(){return "";}
}
