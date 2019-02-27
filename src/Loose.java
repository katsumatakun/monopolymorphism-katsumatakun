/*
    actual place object for Loose Change
*/

public class Loose extends MonopolySquare {

    private LooseChange lc;
    public Loose(String n, LooseChange lc){

        super(n);
        this.lc = lc;
    }

    @Override
    public void landOn(Player P) {

        System.out.println(" " + P.getName() + " moves to " + name);
        if(lc.checkBalance() > 0) {
            System.out.println(" " + P.getName() + " earned $" + lc.checkBalance());
            P.earn(lc.taken());
        }
        else{
            System.out.println("No Money on LooseChange ");
        }
        P.endTurn();
    }
}
