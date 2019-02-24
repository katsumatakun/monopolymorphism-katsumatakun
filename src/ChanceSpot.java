/* class for chance spot*/

public class ChanceSpot extends MonopolySquare {

    public ChanceSpot(String n){
        super(n);
    }

    @Override
    public String toString() {
        return name;
    }

    public void landOn(Player P) throws BankruptException{
        System.out.println(" " + P.getName() + " moves to Chance");
        ChanceCard cc = MonopolyGame.getChanceCardDeck().drew();
        cc.chanceCardImplement(P);
    }

    /*
       Since these are abstract, we have to override, but they will not be called
       and will not do anything
   */
    public void setOwner(Player P){}
    public String getOwner(){return "";}
}
