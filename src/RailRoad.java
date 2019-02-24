/*
    End turn method will no be called
    in landOn method
*/

public class RailRoad extends MonopolySquare {


        public RailRoad(String name){
            super(name);
        }

        public void landOn(Player P){
        System.out.println( " " + P.getName() + " moves to " +  name);
        }

    /*
   Since these are abstract, we have to override, but they will not be called
   and will not do anything
*/
        public void setOwner(Player P){}
        public void resetOwner(){}
        public String getOwner(){return "";}
    }

