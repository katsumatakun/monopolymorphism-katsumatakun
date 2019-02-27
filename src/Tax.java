/*
    Tax class
    Each instance can have different prices
*/

public class Tax extends MonopolySquare {

    private int price;
    private LooseChange lc;

    public Tax(String n, LooseChange lc,int price)
    {
        super(n);
        this.lc = lc;
        this.price = price;
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
}
