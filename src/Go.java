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
    public void landOn(Player P) {
        System.out.println(" " + P.getName() + " moves to Go");
        P.endTurn();
    }
}
