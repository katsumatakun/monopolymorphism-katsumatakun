
/*
    Chance Card Class which has some subclass that is actual chance card
*/
public abstract class ChanceCard{

    private String color;
    private  int num;
    private String name;
    public ChanceCard(String name, String color, int num){
        this.name = name;
        this.color = color;
        this.num = num;
    }

    public abstract void chanceCardImplement(Player p, ChanceDeck cDeck) throws BankruptException;

    public int getNum(){ return num;}

    public String getColor(){ return color;}

    public String getName(){return name;}

    /*
        it will return No.1 location for a specific color
    */
    protected int colorLoc(String color) {
        switch (color) {
            case "purple":
                return 2;
            case "white":
                return 6;
            case "magenta":
                return 11;
            case "orange":
                return 14;
            case "red":
                return 18;
            case "yellow":
                return 22;
            case "green":
                return 27;
            case "blue":
                return 30;
            default:
                return 0;
        }

    }



}
