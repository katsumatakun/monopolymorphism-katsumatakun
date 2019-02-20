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

    public void landOn(Player P){
        P.pay(price);
    }
}
