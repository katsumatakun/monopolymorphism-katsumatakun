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
        System.out.println(P.getName() + " landed " + super.toString());
        System.out.println(P.getName() + " paid " + getPrice());
        P.pay(price);
        if (P.money() < 0){
            throw new BankruptException("bankrupt");
        }
        System.out.println(P.getName() + " has $" + P.money());
        P.endTurn();
    }

    public void setOwner(Player P){}
    public String getOwner(){return "";}
}
