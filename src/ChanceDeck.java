import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

public class ChanceDeck {

	/* Be careful, this may be more complex than you originally thought
	- There are different *kinds* of chance cards; each has its own action
	- What do you do if you have used all the cards?
	- How does the deck get populated?
	 */

	/*
		Use array list for a deck
		Instead of popping element each time, just keep track on the next card that should be
		drown.
		It follows the rule for reusing.
	*/
	private ArrayList<ChanceCard> deck;
	private MonopolySquare[] board;
	private int next_index;

	public ChanceDeck(){
		// Needs code
		deck = new ArrayList<ChanceCard>();
		next_index = 0;

	}

	public void passBoard(MonopolySquare[] board){
		this.board = board;
	}

	public ChanceCard drew() {
		if (next_index == deck.size()) {
			next_index = 0;}
		int temp_index = next_index;
		next_index++;
		return deck.get(temp_index);

	}
	/*
		This method will implement adding card to a deck.
		If there is no free ticket of the color that the input property has,
		Free Ticket Booth card for the color will be automatically added
		to the deck.
	*/

	public void addCard(Property p){
	    int ind = 0;
	    if(deck.size() != 0) {
            while (ind != deck.size() && deck.get(ind).getColor() != p.getColor()) {
                ind++;
            }
            if(ind == deck.size() && deck.get(ind-1).getColor() != p.getColor()){
            	FreeTicketBooth ftb = new FreeTicketBooth(p.getColor(), 0, p.getColor());
            	ftb.setBoard(board);
                deck.add(ftb);
            }
        }
	    else {
			FreeTicketBooth ftb = new FreeTicketBooth(p.getColor(), 0, p.getColor());
			ftb.setBoard(board);
			deck.add(ftb);
        }

	    GoToColor gtc = new GoToColor(p.toString(), p.getColor(), p.getNumber());
	    gtc.setBoard(board);
        deck.add(gtc);
    }

    /*just shuffleDeck*/
    public void shuffleDeck() {
        Collections.shuffle(deck);
    }

    public void resetIndex(){
    	next_index = 0;
	}
}
