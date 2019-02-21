import java.util.Random;

public class MonopolyGame {
	private MonopolySquare[] board;
	private Random dice;
	private LooseChange lc;
	private ChanceDeck chanceCardDeck;

	public MonopolyGame(){

		board = new MonopolySquare[32];
		dice = new Random();
		lc = new LooseChange();
		chanceCardDeck = new ChanceDeck();

		Property pup1 = new Property("pup1");
		pup1.AddSpeciality("purple", 1, 1);
		Property pup2 = new Property("pup2");
		pup2.AddSpeciality("purple", 2, 1);
		Property wh1 = new Property("wh1");
		wh1.AddSpeciality("white", 1, 2);
		Property wh2 = new Property("wh2");
		wh2.AddSpeciality("white", 2, 2);
		Property mag1 = new Property("mag1");
		mag1.AddSpeciality("magenta", 1, 2);
		Property mag2 = new Property("mag2");
		mag2.AddSpeciality("magenta", 2, 2);
		Property ora1 = new Property("ora1");
		ora1.AddSpeciality("orange", 1, 3);
		Property ora2 = new Property("ora2");
		ora2.AddSpeciality("orange", 2, 3);


		Property rd1 = new Property("rd1");
		rd1.AddSpeciality("red", 1, 3);
		Property rd2 = new Property("rd2");
		rd2.AddSpeciality("red", 2, 3);
		Property ye1 = new Property("ye1");
		ye1.AddSpeciality("yellow", 1, 4);
		Property ye2 = new Property("ye2");
		ye2.AddSpeciality("yellow", 2, 4);
		Property gre1 = new Property("gre1");
		gre1.AddSpeciality("green", 1, 4);
		Property gre2 = new Property("gre2");
		gre2.AddSpeciality("green", 2, 4);
		Property bl1 = new Property("bl1");
		bl1.AddSpeciality("blue", 1, 5);
		Property bl2 = new Property("bl2");
		bl2.AddSpeciality("blue", 2, 5);

		Tax fire = new Tax("fire works");
		fire.setPrice(2);
		Tax water = new Tax("water show");
		water.setPrice(2);


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
		board[16] = new Loose("Loose");
		board[17] = new ChanceSpot("c4");
		board[18] = rd1;
		board[19] = rd2;
		board[20] = new ChanceSpot("c5");
		board[21] = new RailRoad("RR3");
		board[22] = ye1;
		board[23] = ye2;
		board[24] = water;
		board[25] = new ChanceSpot("c6");
		board[26] = new GoToRestroom("GTR");
		board[27] = gre1;
		board[28] = gre2;
		board[29] = new RailRoad("RR4");
		board[30] = bl1;
		board[31] = bl2;



	}
	public void play() {

		Player p1 = new Player("Player 1");
		Player p2 = new Player("Player 2");

		p1.flipTurn();
		while (true) {
			while (p1.isMyTurn()) {
				int num = dice.nextInt(6) + 1;
				p1.move(num);
				board[p1.checkPlace()].landOn(p1);
				if(isLoose(p1.checkPlace())){
					p1.earn(lc.taken());
				}
				else if(isChanceSpot(p1.checkPlace())){
					ChanceCard cc = chanceCardDeck.drew();
					if(isGoToColor(cc)){
						p1.jumpLocation(cc.getNum(), cc.getColor());
					}
					else
					{

					}

				}

				else if (isGoToRestroom(p1.checkPlace())){
					lc.add(3);
					p1.goToRestroom();
				}

			}
		}


	}

	private boolean isLoose(int index){
		return board[index] instanceof Loose;
	}

	private boolean isChanceSpot(int index){
		return board[index] instanceof ChanceSpot;
	}

	private  boolean isGoToColor(ChanceCard cc){
		return cc instanceof GoToColor;
	}

	private  boolean isFreeChicketBooth(ChanceCard cc){
		return cc instanceof FreeTicketBooth;
	}

	private boolean isGoToRestroom(int index){
		return board[index] instanceof GoToRestroom;
	}
}
