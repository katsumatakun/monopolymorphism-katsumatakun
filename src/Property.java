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

    public int getNumber() {
        return number;
    }

    public String getColor(){
        return color;
    }

    public void addOwner(Player P){
        owner = P;
    }

    public String getOwner(){
        return owner.getName();
    }

    public void landOn(Player P){
        if (owner.getName() == "")
        {
            P.pay(price);
            owner = P;
        }
        else if (owner == P){

        }

        else{
            P.pay(price);
            owner.earn(price);
        }
    }
}
