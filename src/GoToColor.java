/*
  This is another actual chance card class
    */

public class GoToColor extends ChanceCard {

    private MonopolySquare[] board;

    public void setBoard(MonopolySquare[] board) {
        this.board = board;
    }

    public GoToColor(String name, String color, int num){
        super(name, color, num);

    }

    @Override
    /*
        This class has its own implementation which is simpler than the other
    */
    public void chanceCardImplement(Player p, ChanceDeck cDeck) throws BankruptException {
        System.out.println(" " +p.getName() + " got Go To " + getName());
        p.jumpLocation(getNum(), getColor());

        board[p.checkPlace()].landOn(p);
    }

}
