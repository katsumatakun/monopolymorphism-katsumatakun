/*Actual chance card object*/

import java.util.ArrayList;

public class FreeTicketBooth extends ChanceCard {
    private ArrayList<Property> pList;

    public FreeTicketBooth(String name,String color) {
        super(name, color);
        pList = new ArrayList<>();
    }

    public void addProperty(Property p){
        pList.add(p);
    }

    public void chanceCardImplement(Player p, ChanceDeck cDeck) throws BankruptException{
        System.out.println(" FREE TICKET BOOTH: "+getColor() );
        if (p.isMonopoly(getColor())){
            System.out.println("  Monopoly! " + p.getName() + " has no place to put a Ticket Booth");
            System.out.println("  " + p.getName() + " will drew again");
            ChanceCard cc1 = cDeck.drew();
            //call itself recursively
            //Turn not end
            cc1.chanceCardImplement(p, cDeck);
        }

        else {
            for(Property pro: pList){
              if (pro.getOwner() == null || !(pro.getOwner().equals(p))){
                    pro.setOwner(p);
                    break;
                }
            }
        }
    }



}
