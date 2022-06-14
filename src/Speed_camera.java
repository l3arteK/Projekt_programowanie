import java.awt.*;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Speed_camera extends Objects {


    public Speed_camera(City_map map) {
        super(map);
        this.color = Color.magenta;

    }

//    void respawn() {
//        this.x_cord = rand.nextInt(10);
//        this.y_cord = rand.nextInt(10);
//
//        map.panels[x_cord][y_cord].setBackground(color);
//    }
}
