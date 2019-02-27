import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MonopolyGame {

	private MonopolySquare[] board;
	private Random dice;
	private LooseChange lc;
	private ChanceDeck chanceCardDeck;
	private Map<String, Integer> propertyMap; //keep track on color and the number of properties of each color
												//and each color property is monopoly or not
	public MonopolyGame(){

		board = new MonopolySquare[32];
		dice = new Random();
		lc = new LooseChange();
		propertyMap = new HashMap<>();
		chanceCardDeck = new ChanceDeck();
		board[0] = new Go("Go");
		board[1] = new ChanceSpot("c1", chanceCardDeck);
		board[2] = new Property("pup1", "purple", 1);
		board[3] = new Property("pup2", "purple", 1);
		board[4] = new ChanceSpot("c2",chanceCardDeck);
		board[5] = new RailRoad("RR1");
		board[6] = new Property("wh1", "white", 2);
		board[7] = new Property("whi", "white", 2);
		board[8] = new Tax("fire works", lc, 2);
		board[9] = new ChanceSpot("c3",chanceCardDeck);
		board[10] = new RestRoom("restroom");
		board[11] = new Property("mag1", "magenta", 2);
		board[12] = new Property("mag2", "magenta", 2);
		board[13] = new RailRoad("RR2");
		board[14] = new Property("ora1", "orange", 3);
		board[15] = new Property("ora2", "orange", 3);
		board[16] = new Loose("Loose", lc);
		board[17] = new ChanceSpot("c4",chanceCardDeck);
		board[18] = new Property("rd1", "red", 3);
		board[19] = new Property("rd2", "red", 3);
		board[20] = new ChanceSpot("c5",chanceCardDeck);
		board[21] = new RailRoad("RR3");
		board[22] = new Property("ye1", "yellow", 4);
		board[23] = new Property("ye2", "yellow", 4);
		board[24] = new Tax("water show", lc, 2);
		board[25] = new ChanceSpot("c6",chanceCardDeck);
		board[26] = new GoToRestroom("GTR", lc);
		board[27] = new Property("gre1", "green", 4);
		board[28] = new Property("gre2", "green", 4);
		board[29] = new RailRoad("RR4");
		board[30] = new Property("bl1", "blue", 5);
		board[31] = new Property("bl1", "blue", 5);

		for (int i = 0; i < board.length; i++){
			MonopolySquare square = board[i];
			if (square instanceof Property){
				((Property) square).setIndex(i);
				chanceCardDeck.addCard((Property) square);
				addPropertyMap( ((Property) square).getColor());
			}
		}
		chanceCardDeck.shuffleDeck();
	}
	/*
	    This function implements game
	*/
	public void play() {
		System.out.println("Play Game");
		Player p1 = new Player("Player 1");
		Player p2 = new Player("Player 2");
		p1.setPropertyMap(propertyMap);
		p2.setPropertyMap(propertyMap);

		p1.startTurn();
		label: while (true) {
			while (p1.isMyTurn()) {
				try {
					playerTurn(p1);
				}
				catch (BankruptException e){
					System.out.println(p1.getName() + e.getMessage());
                    System.out.println("Winner is " + p2.getName());
					resetGame();
                    break label;
					//System.exit(0);
				}
			}
			p2.startTurn();
			while (p2.isMyTurn()) {
				try {
					playerTurn(p2);
				}
				catch (BankruptException e){
					System.out.println(p2.getName() + e.getMessage());
                    System.out.println("Winner is " + p1.getName());
                    resetGame();
                    break label;
					//System.exit(0);
				}
			}
			p1.startTurn();
		}
	}

    /*
        This function implement a player's turn
    */
    private void playerTurn(Player p) throws BankruptException{
        int num = dice.nextInt(6) + 1;
        System.out.println(p.getName() +" Rolls: "+num);
        p.move(num);
        board[p.checkPlace()].landOn(p);
    }

	private void resetGame() {
		lc.reset();
		chanceCardDeck.resetIndex();
		chanceCardDeck.shuffleDeck();
		propertyMap.clear();
		for (MonopolySquare square : board) {
			if (square instanceof Property) {
				addPropertyMap(((Property) square).getColor());
				((Property)square).resetOwner();
			}
		}
	}

	private void addPropertyMap(String color){
		Integer count = propertyMap.get(color);
		if (count == null || count == 0) {
			propertyMap.put(color, 1);
		}
		else {
			propertyMap.put(color, count + 1);
		}
	}

}
