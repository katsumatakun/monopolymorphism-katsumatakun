/*
    Place for Go
    but there is almost nothing happening here
    since whether players pass go is watched
    by player class
*/

public class Go extends MonopolySquare {

    public Go(String name){
        super(name);
    }

    @Override
    public String toString() {
        return name;
    }

    /*

    */
    public void landOn(Player P) {
        System.out.println(" " + P.getName() + " moves to Go");
        P.endTurn();
    }

    /*
       Since these are abstract, we have to override, but they will not be called
       and will not do anything
   */
    public void setOwner(Player P){}
    public String getOwner(){return "";}


}
