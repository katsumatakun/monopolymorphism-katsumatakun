public class RailRoad extends MonopolySquare {


        public RailRoad(String name){
            super(name);
        }

        public void landOn(Player P){
        System.out.println(P.getName() + "land on RailRoad");
        }
        public void setOwner(Player P){}
        public String getOwner(){return "";}
    }

