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
        System.out.println("  "+P.getName() + " takes " + name);
        owner = P;
    }

    public String getOwner(){
        return owner.getName();
    }

    public void landOn(Player P) throws BankruptException{
        System.out.println(" " + P.getName() + " moves to " + name);
        if (owner.getName() == "")
        {

            if (P.money() < getPrice()){
                throw new BankruptException(" went bankrupt");
            }
            P.pay(price);
            System.out.println(" " + name + " is not owned; " + P.getName() + " purchased " + name + " for $" + getPrice());
            owner = P;
            P.purchesProperty();
        }
        else if (owner == P){
            System.out.println(" " + P.getName() + " has already owned " + name);
        }

        else{
            if (P.money() < getPrice()){
                throw new BankruptException(" went bankrupt");
            }
            P.pay(price);
            System.out.println(" " + name + " is owned by " + owner.getName() );
            System.out.println(" " + P.getName() + " paid $" + getPrice());
            owner.earn(price);
            System.out.println(" " + owner.getName() + " earned $" + getPrice());
        }


        P.endTurn();
    }
}
