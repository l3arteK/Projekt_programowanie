import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Sweets extends Objects{

    ArrayList<Objects> objects;
    ArrayList<Drivers> drivers;
    Random rand = new Random();

    public Sweets(City_map map, ArrayList <Drivers> drivers, ArrayList<Objects> objects) {
        super(map);

        this.color = Color.yellow;
        this.x_cord = rand.nextInt(map.size_x);
        this.y_cord = rand.nextInt(map.size_x);
        this.drivers = drivers;
        this.objects = objects;
    }

    int good_boys_amount;
    boolean are_good_boys;

    void respawn () {

//        if (drivers.size() != 0) {
//
//            good_boys_amount = 0;
//
//            for (int i = 0; i < drivers.size(); i++) {
//                if (drivers.get(i) instanceof Good_boys) {
//                    good_boys_amount++;
//                    are_good_boys = true;
//                }
//            }
//
//            System.out.println("dobre chlopaki: " + good_boys_amount);
//
//            if (are_good_boys && good_boys_amount < 5) {
//                objects.add(new Sweets(map, drivers, objects));
//                //map.panels[x_cord][y_cord].setBackground(color);
//            } else if (are_good_boys && good_boys_amount >= 5 && good_boys_amount < 10) {
//                objects.add(new Sweets(map, drivers, objects));
//                //map.panels[x_cord][y_cord].setBackground(color);
//                objects.add(new Sweets(map, drivers, objects));
//                //map.panels[x_cord][y_cord].setBackground(color);
//            } else if (are_good_boys && good_boys_amount >= 10) {
//                objects.add(new Sweets(map, drivers, objects));
//                //map.panels[x_cord][y_cord].setBackground(color);
//                objects.add(new Sweets(map, drivers, objects));
//                //map.panels[x_cord][y_cord].setBackground(color);
//                objects.add(new Sweets(map, drivers, objects));
//                //map.panels[x_cord][y_cord].setBackground(color);
//            }
//        }

        map.panels[x_cord][y_cord].setBackground(color);
    }
}
