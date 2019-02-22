public class Property extends MonopolySquare {

    private String color;
    private int number;
    private int price;
    private Player owner;

    public Property(String name){
        super(name);
    }

    public void AddSpeciality(String color, int number, int price){
        this.color = color;
        this.number = number;
        this.price = price;
        owner = new Player("");
    }

    public int getPrice(){return price;}

    public int getNumber() {
        return number;
    }

    public String getColor(){
        return color;
    }

    public void setOwner(Player P){
        owner = P;
    }

    public String getOwner(){
        return owner.getName();
    }

    public void landOn(Player P) throws BankruptException{
        System.out.println(P.getName() + " land on " + getColor()+getNumber());
        if (owner.getName() == "")
        {
            P.pay(price);
            System.out.println(P.getName() + " paid $" + getPrice());
            owner = P;
            System.out.println(P.getName() + " become the owner");
        }
        else if (owner == P){

        }

        else{
            P.pay(price);
            System.out.println(P.getName() + " paid $" + getPrice());
            owner.earn(price);
            System.out.println(owner.getName() + " earned $" + getPrice());
        }
        System.out.println(P.getName() + " has $" + P.money());
        P.endTurn();
        if (P.money() <= 0){
            throw new BankruptException("bankrupt");
        }
    }
}
