import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Sweets extends Objects{

    ArrayList<Objects> objects;
    ArrayList<Drivers> drivers;
    Random rand = new Random();

    public Sweets(City_map map) {
        super(map);

        this.color = Color.yellow;
        this.x_cord = rand.nextInt(map.size_x);
        this.y_cord = rand.nextInt(map.size_x);
    }

//    int good_boys_amount;
//
//    void respawn () {
//
//        good_boys_amount = 0;
//
//        for (int i = 0; i < drivers.size(); i++) {
//            if(drivers.get(i) instanceof Good_boys) {
//                good_boys_amount++;
//            }
//        }
//
//        System.out.println("dobre chlopaki: " + good_boys_amount);
//
//        if(good_boys_amount < 5) {
//            objects.add(new Sweets(map));
//            map.panels[x_cord][y_cord].setBackground(color);
//        }
//        else if (good_boys_amount >= 5 && good_boys_amount < 10) {
//            objects.add(new Sweets(map));
//            map.panels[x_cord][y_cord].setBackground(color);
//            objects.add(new Sweets(map));
//            map.panels[x_cord][y_cord].setBackground(color);
//        }
//        else {
//            objects.add(new Sweets(map));
//            map.panels[x_cord][y_cord].setBackground(color);
//            objects.add(new Sweets(map));
//            map.panels[x_cord][y_cord].setBackground(color);
//            objects.add(new Sweets(map));
//            map.panels[x_cord][y_cord].setBackground(color);
//        }
//    }
}
