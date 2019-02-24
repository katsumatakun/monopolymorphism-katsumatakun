/*
  This is another actual chance card class
    */

public class GoToColor extends ChanceCard {


    public GoToColor(String name, String color, int num){
        super(name, color, num);

    }

    @Override
    /*
        This class has its own implementation which is simpler than the other
    */
    public void chanceCardImplement(Player p) throws BankruptException {
        System.out.println(" " +p.getName() + " got Go To " + getName());
        p.jumpLocation(getNum(), getColor());

        MonopolyGame.getBoard()[p.checkPlace()].landOn(p);
    }

}
