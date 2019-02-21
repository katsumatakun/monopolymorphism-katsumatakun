import java.util.ArrayList;

public class ChanceCard {

    protected int num;
    protected String color;

    public ChanceCard(int num, String color){

        this.num = num;
        this.color = color;
    }
    public void setNum(int num ){
        this.num = num;
    }
    public int getNum(){return num; }
    public void setColor(String color ){
        this.color = color;
    }
    public String getColor(){return color; }


}
