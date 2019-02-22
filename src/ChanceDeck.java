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
		GoToColor p1 = new GoToColor("purple", 1);
		deck.add(p1);
		deck.add(new GoToColor("purple", 2));
		deck.add(new GoToColor("white", 1));
		deck.add(new GoToColor("white", 2));
		deck.add(new GoToColor("magenta", 1));
		deck.add(new GoToColor("magenta", 2));
		deck.add(new GoToColor("orange", 1));
		deck.add(new GoToColor("orange", 2));
		deck.add(new GoToColor("red", 1));
		deck.add(new GoToColor("red", 2));
		deck.add(new GoToColor("yellow", 1));
		deck.add(new GoToColor("yellow", 2));
		deck.add(new GoToColor("green", 1));
		deck.add(new GoToColor("green", 2));
		deck.add(new GoToColor("blue", 1));
		deck.add(new GoToColor("blue", 2));

		deck.add(new FreeTicketBooth(0,"purple"));
		deck.add(new FreeTicketBooth(0,"white"));
		deck.add(new FreeTicketBooth(0,"magenta"));
		deck.add(new FreeTicketBooth(0,"orange"));
		deck.add(new FreeTicketBooth(0,"red"));
		deck.add(new FreeTicketBooth(0,"yellow"));
		deck.add(new FreeTicketBooth(0,"green"));
		deck.add(new FreeTicketBooth(0,"blue"));
		Collections.shuffle(deck);

	}

	public ChanceCard drew() {
		if (next_index == deck.size()) {
			next_index = 0;}
		int temp_index = next_index;
		next_index++;
		return deck.get(temp_index);

	}



	//Needs extra Methods.
}
