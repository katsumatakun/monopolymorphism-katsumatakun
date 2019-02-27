/* class for chance spot*/

public class ChanceSpot extends MonopolySquare {

    private ChanceDeck cDeck;

    public ChanceSpot(String n, ChanceDeck cDeck){
        super(n);
        this.cDeck = cDeck;
    }

    @Override
    public void landOn(Player P) throws BankruptException{
        System.out.println(" " + P.getName() + " moves to Chance");
        ChanceCard cc = cDeck.drew();
        cc.chanceCardImplement(P, cDeck);
    }
}
