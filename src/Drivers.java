import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Drivers
{
    /*
    protected int id_dr;
    private int fuel;
    private int tires;
    protected int x_cord;
    protected int y_cord;
     */


    City_map map;
    Color color;
    int x;
    int y;
    Random rand = new Random();
    public Drivers(City_map map, Color color){

        this.map = map;
        this.color = color;
        this.x = rand.nextInt(30);
        this.y = rand.nextInt(30);

    }

    void move(){
        map.panels[x][y].setBackground(Color.gray);
        switch (rand.nextInt(4)){
            case 0:
                if(x<29){x=x+1;}
                break;
            case 1:
                if(y<29){y=y+1;}
                break;
            case 2:
                if(y>1){y=y-1;}
                break;
            case 3:
                if(x>1){x=x-1;}
                break;
        }
        map.panels[x][y].setBackground(color);


    }
}
