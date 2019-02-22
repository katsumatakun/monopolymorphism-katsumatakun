public class GoToRestroom extends MonopolySquare {
    public GoToRestroom(String name){
        super(name);
    }

        @Override
        public String toString() {
            return name;
        }

        public void landOn(Player P) throws BankruptException {

        System.out.println(P.getName() + "Go to restroom");
        P.pay(3);
        System.out.println(P.getName() + " paid $3");
        if (P.money() < 0){
            throw new BankruptException("bankrupt");
        }
        System.out.println(P.getName() + " has $" + P.money());


    }

    public void setOwner(Player P){}
    public String getOwner(){return "";}
}
