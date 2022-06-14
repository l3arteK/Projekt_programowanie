import java.awt.*;

public class Common_driver extends Drivers{

    //public static int bread = 0;

    public Common_driver(City_map map) {
        super(map);
        this.color = Color.cyan;
        this.moves_fuel = 20;
    }

    void move(){
        //map.panels[x][y].setBackground(Color.gray);
        switch (rand.nextInt(4)){
            case 0:
                if(x<max_x - 1){
                    x=x+1;
                    moves_fuel -= 1;
                }
                else{
                    x=x-1;
                    moves_fuel -= 1;
                }
                break;
            case 1:
                if(y<max_y - 1){
                    y=y+1;
                    moves_fuel -= 1;
                }
                else{
                    y=y-1;
                    moves_fuel -= 1;
                }
                break;
            case 2:
                if(y>1){
                    y=y-1;
                    moves_fuel -= 1;
                }
                else{
                    y=y+1;
                    moves_fuel -= 1;
                }
                break;
            case 3:
                if(x>1){
                    x=x-1;
                    moves_fuel -= 1;
                }
                else{
                    x=x+1;
                    moves_fuel -= 1;
                }
                break;
        }
        map.panels[x][y].setBackground(color);
    }
}
