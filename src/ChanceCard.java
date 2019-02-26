
/*
    Chance Card Class which has some subclass that is actual chance card
*/
public abstract class ChanceCard{

    private String color;
    private String name;
    public ChanceCard(String name, String color){
        this.name = name;
        this.color = color;
    }

    public abstract void chanceCardImplement(Player p, ChanceDeck cDeck) throws BankruptException;

    public String getColor(){ return color;}

    public String getName(){return name;}

}
