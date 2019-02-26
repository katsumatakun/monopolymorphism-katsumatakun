/*
  This is another actual chance card class
    */

public class GoToColor extends ChanceCard {

    private MonopolySquare[] board;

    public void setBoard(MonopolySquare[] board) {
        this.board = board;
    }

    public GoToColor(String name, String color){
        super(name, color);

    }

    @Override
    /*
        This class has its own implementation which is simpler than the other
    */
    public void chanceCardImplement(Player p, ChanceDeck cDeck) throws BankruptException {
        System.out.println(" " +p.getName() + " got Go To " + getName());
        while (!(board[p.checkPlace()].toString().equals(getName()))){
            p.move(1);
        }
        board[p.checkPlace()].landOn(p);

    }

}
