/*
    Tax class
    Each instance can have different prices
*/

public class Tax extends MonopolySquare {

    private int price;
    private LooseChange lc;

    public Tax(String n){
        super(n);
    }

    public void setPrice(int price){

        this.price = price;
    }
    public void setLc(LooseChange lc){
        this.lc = lc;
    }

    public int getPrice(){
        return price;
    }

    @Override
    public void landOn(Player P) throws BankruptException{
        System.out.println(" " + P.getName() + " moves to " + super.toString());

        if (P.money() < getPrice()){
            throw new BankruptException("went bankrupt");
        }
        System.out.println(" " + P.getName() + " Paid " + getPrice() + " for " + super.toString());
        P.pay(price);
        lc.add(2);
        P.endTurn();
    }

    /*
        Since these are abstract, we have to override, but they will not be called
        and will not do anything
    */
    public void setOwner(Player P){}
    public void resetOwner(){
    }
    public String getOwner(){return "";}
}
