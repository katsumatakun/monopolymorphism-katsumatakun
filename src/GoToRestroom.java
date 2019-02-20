public class GoToRestroom extends MonopolySquare {
    public GoToRestroom(String name){
        super(name);
    }

        @Override
        public String toString() {
            return name;
        }

        public void landOn(Player P) {
        P.goToRestroom();
    }
}
