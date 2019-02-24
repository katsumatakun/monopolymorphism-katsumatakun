/*Actual chance card object*/

public class FreeTicketBooth extends ChanceCard {

    public FreeTicketBooth(String name, int num, String color) {
        super(name, color, num);
    }

    public void chanceCardImplement(Player p, ChanceDeck cDeck) throws BankruptException{
        System.out.println(" FREE TICKET BOOTH: "+getColor() );
        //if property numbered 1 has not been owned
        if (MonopolyGame.getBoard()[colorLoc(getColor())].getOwner() == ""){
            MonopolyGame.getBoard()[colorLoc(getColor())].setOwner(p);
            p.endTurn();
        }
        //if property numbered 2 has not been owned
        else if ((MonopolyGame.getBoard()[colorLoc(getColor())+1].getOwner() == "")){
            MonopolyGame.getBoard()[colorLoc(getColor())].setOwner(p);
            p.endTurn();
        }

        else{
            //if property numbered 1 has already been owned by another player and the owner also has the No.
            // 2 property, drew chance card again
            if (MonopolyGame.getBoard()[colorLoc(getColor())].getOwner() != p.getName()&& MonopolyGame.getBoard()[colorLoc(getColor())].getOwner() == MonopolyGame.getBoard()[colorLoc(getColor())+1].getOwner()){

                System.out.println("  " + p.getName() + " has no place to put a Ticket Booth");
                System.out.println("  " + p.getName() + " will drew again");
                ChanceCard cc1 = cDeck.drew();
                //call the itself recursively
                //Turn not end
                cc1.chanceCardImplement(p, cDeck);
            }
            //there are 3 cases left

            //Player has No.1 and another player has No.2
            else if (MonopolyGame.getBoard()[colorLoc(getColor())].getOwner() == p.getName())
            {
                MonopolyGame.getBoard()[colorLoc(getColor())+1].setOwner(p);
                p.endTurn();
            }
            //Player has No.2 and another player has No.1
            else if (MonopolyGame.getBoard()[colorLoc(getColor())+1].getOwner() == p.getName()){
                MonopolyGame.getBoard()[colorLoc(getColor())].setOwner(p);
                p.endTurn();
            }
            //Player has already had two properties
            else{
                System.out.println("  " + p.getName() + " has already owned "+ getColor() + "1 and 2");
                p.endTurn();
            }

        }
    }



}
