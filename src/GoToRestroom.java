/*
    actual place object
*/

public class GoToRestroom extends MonopolySquare {
    public GoToRestroom(String name){
        super(name);
    }

    private LooseChange lc;

    public void setLc(LooseChange lc){
        this.lc = lc;
    }

        @Override
        public String toString() {
            return name;
        }

        public void landOn(Player P) throws BankruptException {

        System.out.println(" " + P.getName() + " moves to Go to restroom");
        P.pay(3);

        if (P.money() < 3){
            throw new BankruptException("bankrupt");
        }
        System.out.println(" " + P.getName() + " paid $3");
        System.out.println(P.getName() + " has $" + P.money());
        lc.add(3);
        P.goToRestroom();
        P.endTurn();


    }
    /*
       Since these are abstract, we have to override, but they will not be called
       and will not do anything
   */
    public void resetOwner(){}
    public void setOwner(Player P){}
    public String getOwner(){return "";}
}
