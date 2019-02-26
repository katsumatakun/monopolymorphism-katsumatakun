/*
  This is another actual chance card class
    */

public class GoToColor extends ChanceCard {

    private Property prop;

    public GoToColor(String name, String color){
        super(name, color);

    }

    public void setProp(Property prop) {
        this.prop = prop;
    }

    @Override
    /*
        This class has its own implementation which is simpler than the other
    */
    public void chanceCardImplement(Player p, ChanceDeck cDeck) throws BankruptException {
        System.out.println(" " +p.getName() + " got Go To " + getName());
        p.moveTo(prop.getIndex());
        prop.landOn(p);

    }

}
