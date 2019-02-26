/*
    One of the most important classes
*/


public class Property extends MonopolySquare {

    /*
        It has specialities that allow program to distinguish one from another
    */
    private String color;
    private int price;
    private Player owner;
    private int index;

    public Property(String name){
        super(name);
        owner = new Player("");
    }


    public void AddSpeciality(String color, int price){
        this.color = color;
        this.price = price;}

    public String getColor(){
        return color;
    }

    public int getIndex(){
        return index;
    }

    public void setIndex(int index){
        this.index = index;
    }
    /*
        It someone has owned the property, the owner will change
    */
    public void setOwner(Player P){
        System.out.println("  "+P.getName() + " takes " + name);
        if(!owner.getName().equals("")) {
            System.out.println("  " + owner.getName() + " lost " + name);
            owner.looseProperty(this);
        }
        P.purchesProperty(this);
        owner = P;

    }

    public String getOwner(){
        return owner.getName();
    }

    public void landOn(Player P) throws BankruptException{
        System.out.println(" " + P.getName() + " moves to " + name);
        if (owner.getName().equals(""))
        {

            if (P.money() < price){
                throw new BankruptException(" went bankrupt");
            }
            P.pay(price);
            System.out.println(" " + name + " is not owned; " + P.getName() + " purchased " + name + " for $" + price);
            owner = P;
            P.purchesProperty(this);
        }
        else if (owner == P){
            System.out.println(" " + P.getName() + " has already owned " + name);
        }

        else{
            int new_price;
            if(P.isMonopoly(color)){
                new_price = price * 2;
                System.out.println(" Monopoly! all of the " + color + " properties are owned by " + owner.getName() );
            }
            else {
                System.out.println(" " + name + " is owned by " + owner.getName() );
                new_price = price;
            }
            if (P.money() < price){
                throw new BankruptException(" went bankrupt");
            }
            P.pay(new_price);
            System.out.println(" " + P.getName() + " paid $" + new_price);
            owner.earn(new_price);
            System.out.println(" " + owner.getName() + " earned $" + new_price);
        }


        P.endTurn();
    }
    public void resetOwner(){
        owner = new Player("");
    }

}
