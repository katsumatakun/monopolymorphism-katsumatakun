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

		/*
		    from here a bunch of initialization
		    I decide to keep track on properties by number and color as well as name
		*/
		Property pup1 = new Property("pup1");
		pup1.AddSpeciality("purple", 1);
		Property pup2 = new Property("pup2");
		pup2.AddSpeciality("purple",  1);
		Property wh1 = new Property("wh1");
		wh1.AddSpeciality("white",2);
		Property wh2 = new Property("wh2");
		wh2.AddSpeciality("white",2);
		Property mag1 = new Property("mag1");
		mag1.AddSpeciality("magenta",2);
		Property mag2 = new Property("mag2");
		mag2.AddSpeciality("magenta",2);
		Property ora1 = new Property("ora1");
		ora1.AddSpeciality("orange",3);
		Property ora2 = new Property("ora2");
		ora2.AddSpeciality("orange",3);
		Property rd1 = new Property("rd1");
		rd1.AddSpeciality("red", 3);
		Property rd2 = new Property("rd2");
		rd2.AddSpeciality("red",3);
		Property ye1 = new Property("ye1");
		ye1.AddSpeciality("yellow",4);
		Property ye2 = new Property("ye2");
		ye2.AddSpeciality("yellow",4);
		Property gre1 = new Property("gre1");
		gre1.AddSpeciality("green",4);
		Property gre2 = new Property("gre2");
		gre2.AddSpeciality("green",4);
		Property bl1 = new Property("bl1");
		bl1.AddSpeciality("blue", 5);
		Property bl2 = new Property("bl2");
		bl2.AddSpeciality("blue", 5);


		Tax fire = new Tax("fire works");
		fire.setPrice(2);
		Tax water = new Tax("water show");
		water.setPrice(2);

		Loose loose = new Loose("Loose");
		loose.addLc(lc);

		GoToRestroom gtr = new GoToRestroom("GTR");
		gtr.setLc(lc);

		board[0] = new Go("Go");
		board[1] = new ChanceSpot("c1");
		board[2] = pup1;
		board[3] = pup2;
		board[4] = new ChanceSpot("c2");
		board[5] = new RailRoad("RR1");
		board[6] = wh1;
		board[7] = wh2;
		board[8] = fire;
		board[9] = new ChanceSpot("c3");
		board[10] = new RestRoom("restroom");
		board[11] = mag1;
		board[12] = mag2;
		board[13] = new RailRoad("RR2");
		board[14] = ora1;
		board[15] = ora2;
		board[16] = loose;
		board[17] = new ChanceSpot("c4");
		board[18] = rd1;
		board[19] = rd2;
		board[20] = new ChanceSpot("c5");
		board[21] = new RailRoad("RR3");
		board[22] = ye1;
		board[23] = ye2;
		board[24] = water;
		board[25] = new ChanceSpot("c6");
		board[26] = gtr;
		board[27] = gre1;
		board[28] = gre2;
		board[29] = new RailRoad("RR4");
		board[30] = bl1;
		board[31] = bl2;

		for (int i = 0; i < board.length; i++){
			MonopolySquare square = board[i];
			if (square instanceof Property){
				((Property) square).setIndex(i);
				chanceCardDeck.addCard((Property) square);
				addPropertyMap( ((Property) square).getColor());
			}
			else if(square instanceof ChanceSpot){
				((ChanceSpot) square).setCD(chanceCardDeck);
			}
			else if(square instanceof Tax){
				((Tax) square).setLc(lc);
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
					System.out.println(p1.getName() + " " + e.getMessage());
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
					System.out.println(p2.getName() + " " + e.getMessage());
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
				square.resetOwner();
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
