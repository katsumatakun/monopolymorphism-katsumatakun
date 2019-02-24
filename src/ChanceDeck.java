import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

public class ChanceDeck {

	/* Be careful, this may be more complex than you originally thought
	- There are different *kinds* of chance cards; each has its own action
	- What do you do if you have used all the cards?
	- How does the deck get populated?
	 */
	private ArrayList<ChanceCard> deck;
	private int next_index;

	public ChanceDeck(){
		// Needs code
		deck = new ArrayList<ChanceCard>();
		next_index = 0;

	}

	public ChanceCard drew() {
		if (next_index == deck.size()) {
			next_index = 0;}
		int temp_index = next_index;
		next_index++;
		return deck.get(temp_index);

	}

	public void addCard(Property p){
	    int ind = 0;
	    if(deck.size() != 0) {
            while (ind != deck.size() && deck.get(ind).getColor() != p.getColor()) {
                ind++;
            }
            if(ind == deck.size() && deck.get(ind-1).getColor() != p.getColor()){
                deck.add(new FreeTicketBooth(p.getColor(), 0, p.getColor()));
            }
        }
	    else {
            deck.add(new FreeTicketBooth(p.getColor(), 0, p.getColor()));
        }



        deck.add(new GoToColor(p.toString(), p.getColor(), p.getNumber()));
    }

    public void shuffleDeck() {
        Collections.shuffle(deck);
    }
}
