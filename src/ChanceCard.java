

public class ChanceCard {

    private String color;
    private  int num;
    private String name;
    public ChanceCard(String name, String color, int num){
        this.name = name;
        this.color = color;
        this.num = num;
    }

    public int getNum(){ return num;}

    public String getColor(){ return color;}

    public String getName(){return name;}



}
