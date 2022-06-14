import java.awt.*;
import java.util.Random;

public class Objects {
    protected int x_cord;
    protected int y_cord;

    City_map map;
    Color color;
    Random rand = new Random();

    public Objects(City_map map) {
        int i=0;
        this.map = map;
        this.x_cord = rand.nextInt(map.size_x);
        this.y_cord = rand.nextInt(map.size_y);
        while(map.panels[x_cord][y_cord].getBackground()!=Color.gray){
            this.x_cord = rand.nextInt(map.size_x);
            this.y_cord = rand.nextInt(map.size_y);
            i+=1;
            if(i>(map.size_x*map.size_y)){
                map.run = false;
                break;
            }
        }
        map.panels[x_cord][y_cord].setBackground(color);
    }

    void respawn() {
        map.panels[x_cord][y_cord].setBackground(color);
    }
}
