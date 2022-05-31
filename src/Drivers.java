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
    int max_x;
    int max_y;
    Random rand = new Random();
    public Drivers(City_map map){

        this.map = map;
        this.max_x = map.size_x;
        this.max_y = map.size_y;
        this.x = rand.nextInt(max_x);
        this.y = rand.nextInt(max_y);

    }

    void move(){
        //map.panels[x][y].setBackground(Color.gray);
        switch (rand.nextInt(4)){
            case 0:
                if(x<max_x - 1){x=x+1;}
                else{x=x-1;}
                break;
            case 1:
                if(y<max_y - 1){y=y+1;}
                else{y=y-1;}
                break;
            case 2:
                if(y>1){y=y-1;}
                else{y=y+1;}
                break;
            case 3:
                if(x>1){x=x-1;}
                else{x=x+1;}
                break;
        }
        map.panels[x][y].setBackground(color);
    }
}
