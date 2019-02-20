import java.util.ArrayList;

public class GoToColor extends ChanceCard {

    private int num;
    private String color;

    public GoToColor(String color, int num){

        this.num = num;
        this.color = color;
    }

    public void setNum(int num ){
        this.num = num;
    }
    public int getNum(){
        return num;
    }

}
