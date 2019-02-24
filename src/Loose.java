/*
    actual place object for Loose Change
*/

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
        System.out.println(" " + P.getName() + " earned $" + MonopolyGame.getLc().checkBalance());
        P.earn(MonopolyGame.getLc().taken());
        P.endTurn();

    }

    /*
       Since these are abstract, we have to override, but they will not be called
       and will not do anything
   */
    public void setOwner(Player P){}
    public String getOwner(){return "";}
}
