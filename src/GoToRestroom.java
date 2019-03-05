/*
    actual place object
*/

public class GoToRestroom extends MonopolySquare {

    private LooseChange lc;

    public GoToRestroom(String name, LooseChange lc){
        super(name);
        this.lc = lc;
    }

    @Override

    public void landOn(Player P) throws BankruptException {
        System.out.println(" " + P.getName() + " moves to Go to restroom");
        P.pay(3);

        if (P.money() < 3){
            throw new BankruptException(" bankrupt");
        }
        System.out.println(" " + P.getName() + " paid $3");
        System.out.println(P.getName() + " has $" + P.money());
        lc.add(3);
        P.goToRestroom();
        P.endTurn();
    }
}
