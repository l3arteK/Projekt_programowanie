
/*import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.concurrent.TimeUnit;*/

import java.awt.*;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Simulation {
        public static void main(String[] args) throws InterruptedException {

               City_map map = new City_map();
            ArrayList<Drivers> drivers = new ArrayList<Drivers>();
               drivers.add(new Common_driver(map, Color.green));
               drivers.add(new Police(map, Color.blue));
               drivers.add(new Drifter(map, Color.black));
               drivers.add(new Good_boys(map, Color.red));

               for(;;){
                   for(int i=0;i<4;i++) {
                       drivers.get(i).move();
                   }
                   TimeUnit.SECONDS.sleep(1);
               }

        }

}