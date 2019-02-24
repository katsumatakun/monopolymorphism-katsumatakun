import java.util.Random;

import static java.lang.Math.*;

public class MonopolyGame {

	private MonopolySquare[] board;
	private static Random dice;
	private LooseChange lc;
	private ChanceDeck chanceCardDeck;

	public MonopolyGame(){

		board = new MonopolySquare[32];
		dice = new Random();
		lc = new LooseChange();
		chanceCardDeck = new ChanceDeck();
		chanceCardDeck.passBoard(board);

		/*
		    from here a bunch of initialization
		    I decide to keep track on properties by number and color as well as name
		*/
		Property pup1 = new Property("pup1");
		pup1.AddSpeciality("purple", 1, 1);
		chanceCardDeck.addCard(pup1);
		Property pup2 = new Property("pup2");
		pup2.AddSpeciality("purple", 2, 1);
		chanceCardDeck.addCard(pup2);
		Property wh1 = new Property("wh1");
		wh1.AddSpeciality("white", 1, 2);
		chanceCardDeck.addCard(wh1);
		Property wh2 = new Property("wh2");
		wh2.AddSpeciality("white", 2, 2);
		chanceCardDeck.addCard(wh2);
		Property mag1 = new Property("mag1");
		mag1.AddSpeciality("magenta", 1, 2);
		chanceCardDeck.addCard(mag1);
		Property mag2 = new Property("mag2");
		mag2.AddSpeciality("magenta", 2, 2);
		chanceCardDeck.addCard(mag2);
		Property ora1 = new Property("ora1");
		ora1.AddSpeciality("orange", 1, 3);
		chanceCardDeck.addCard(ora1);
		Property ora2 = new Property("ora2");
		ora2.AddSpeciality("orange", 2, 3);
		chanceCardDeck.addCard(ora2);
		Property rd1 = new Property("rd1");
		rd1.AddSpeciality("red", 1, 3);
		chanceCardDeck.addCard(rd1);
		Property rd2 = new Property("rd2");
		rd2.AddSpeciality("red", 2, 3);
		chanceCardDeck.addCard(rd2);
		Property ye1 = new Property("ye1");
		ye1.AddSpeciality("yellow", 1, 4);
		chanceCardDeck.addCard(ye1);
		Property ye2 = new Property("ye2");
		ye2.AddSpeciality("yellow", 2, 4);
		chanceCardDeck.addCard(ye2);
		Property gre1 = new Property("gre1");
		gre1.AddSpeciality("green", 1, 4);
		chanceCardDeck.addCard(gre1);
		Property gre2 = new Property("gre2");
		gre2.AddSpeciality("green", 2, 4);
		chanceCardDeck.addCard(gre2);
		Property bl1 = new Property("bl1");
		bl1.AddSpeciality("blue", 1, 5);
		chanceCardDeck.addCard(bl1);
		Property bl2 = new Property("bl2");
		bl2.AddSpeciality("blue", 2, 5);
		chanceCardDeck.addCard(bl2);

		chanceCardDeck.shuffleDeck();
		Tax fire = new Tax("fire works");
		fire.setPrice(2);
		fire.setLc(lc);
		Tax water = new Tax("water show");
		water.setPrice(2);
		water.setLc(lc);

		Loose loose = new Loose("Loose");
		loose.addLc(lc);

		GoToRestroom gtr = new GoToRestroom("GTR");
		gtr.setLc(lc);

		ChanceSpot cc1 = new ChanceSpot("c1");
		cc1.setCD(chanceCardDeck);

		ChanceSpot cc2 = new ChanceSpot("c2");
		cc2.setCD(chanceCardDeck);

		ChanceSpot cc3 = new ChanceSpot("c3");
		cc3.setCD(chanceCardDeck);

		ChanceSpot cc4 = new ChanceSpot("c4");
		cc4.setCD(chanceCardDeck);

		ChanceSpot cc5 = new ChanceSpot("c5");
		cc5.setCD(chanceCardDeck);

		ChanceSpot cc6 = new ChanceSpot("c6");
		cc6.setCD(chanceCardDeck);


		board[0] = new Go("Go");
		board[1] = cc1;
		board[2] = pup1;
		board[3] = pup2;
		board[4] = cc2;
		board[5] = new RailRoad("RR1");
		board[6] = wh1;
		board[7] = wh2;
		board[8] = fire;
		board[9] = cc3;
		board[10] = new RestRoom("restroom");
		board[11] = mag1;
		board[12] = mag2;
		board[13] = new RailRoad("RR2");
		board[14] = ora1;
		board[15] = ora2;
		board[16] = loose;
		board[17] = cc4;
		board[18] = rd1;
		board[19] = rd2;
		board[20] = cc5;
		board[21] = new RailRoad("RR3");
		board[22] = ye1;
		board[23] = ye2;
		board[24] = water;
		board[25] = cc6;
		board[26] = gtr;
		board[27] = gre1;
		board[28] = gre2;
		board[29] = new RailRoad("RR4");
		board[30] = bl1;
		board[31] = bl2;

	}
	/*
	    This function implements game
	*/
	public void play() {
		System.out.println("Play Game");
		Player p1 = new Player("Player 1");
		Player p2 = new Player("Player 2");

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

    private void resetOwners(){
    	for (int i = 0; i < board.length; i++){
			board[i].resetOwner();
		}
	}

	private void resetGame(){
		lc.reset();
		chanceCardDeck.resetIndex();
		chanceCardDeck.shuffleDeck();
		resetOwners();
	}

}
