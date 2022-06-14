import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

 abstract public class Drivers
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
    int moves_tires;
    int moves_fuel;
    int bread;
    Random rand = new Random();
    public Drivers(City_map map){

        int i=0;
        this.map = map;
        this.max_x = map.size_x;
        this.max_y = map.size_y;
        this.x = rand.nextInt(max_x);
        this.y = rand.nextInt(max_y);
        while(map.panels[x][y].getBackground()!=Color.gray){
            this.x = rand.nextInt(max_x);
            this.y = rand.nextInt(max_y);
            i+=1;
            if(i>(max_y*max_y)){
                map.run = false;
                break;
            }
        }
        map.panels[x][y].setBackground(color);

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
