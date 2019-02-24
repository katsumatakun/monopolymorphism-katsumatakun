/* class for chance spot*/

public class ChanceSpot extends MonopolySquare {

    private ChanceDeck cDeck;

    public void setCD(ChanceDeck cDeck){
        this.cDeck = cDeck;
    }

    public ChanceSpot(String n){
        super(n);
    }

    @Override
    public String toString() {
        return name;
    }

    public void landOn(Player P) throws BankruptException{
        System.out.println(" " + P.getName() + " moves to Chance");
        ChanceCard cc = cDeck.drew();
        cc.chanceCardImplement(P, cDeck);
    }

    /*
       Since these are abstract, we have to override, but they will not be called
       and will not do anything
   */
    public void setOwner(Player P){}
    public void resetOwner(){}
    public String getOwner(){return "";}
}
