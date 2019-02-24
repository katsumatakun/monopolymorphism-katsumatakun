public class Tax extends MonopolySquare {

    private int price;

    public Tax(String n){
        super(n);
    }

    public void setPrice(int price){

        this.price = price;
    }

    public int getPrice(){
        return price;}

    public void landOn(Player P) throws BankruptException{
        System.out.println(" " + P.getName() + " moves to " + super.toString());

        if (P.money() < getPrice()){
            throw new BankruptException("went bankrupt");
        }
        System.out.println(" " + P.getName() + " Paid " + getPrice() + " for " + super.toString());
        P.pay(price);
        P.endTurn();
    }

    public void setOwner(Player P){}
    public String getOwner(){return "";}
}
