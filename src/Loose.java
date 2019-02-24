public class Loose extends MonopolySquare {

    public Loose(String n){
        super(n);
    }

    @Override
    public String toString() {
        return name;
    }

    public void landOn(Player P) {
        System.out.println(" " + P.getName() + " moves to " + name);

    }
    public void setOwner(Player P){}
    public String getOwner(){return "";}
}
