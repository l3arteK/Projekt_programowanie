
/*import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.concurrent.TimeUnit;*/

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Simulation {
        public static void main(String[] args) throws InterruptedException {

               City_map map = new City_map();
                Random rand = new Random();
                int chance;
            ArrayList<Drivers> drivers = new ArrayList<Drivers>();
               drivers.add(new Drifter(map));
               drivers.add(new Police(map));
               //drivers.add(new Common_driver(map));

            int n=0;
               for(;;){
                   n+=1;
                   for(int i=0;i<map.size_x;i++){
                       for(int j=0;j<map.size_y;j++){
                           map.panels[i][j].setBackground(Color.gray);
                       }
                   }
                   //System.out.println("Clean");
                   //TimeUnit.SECONDS.sleep(2);
                   for(int i=0;i<drivers.size();i++) {
                       drivers.get(i).move();
                       System.out.println(drivers.get(i).x);
                       System.out.println(drivers.get(i).y);

                   }
                   System.out.println("ruch: "+n);
                   System.out.println("");
                   //check_colision
                   for(int i=0;i<drivers.size()-1;i++){
                       for(int j=i+1;j<drivers.size();j++){
                           if((drivers.get(i).x == drivers.get(j).x) &&(drivers.get(i).y==drivers.get(j).y)){
                               System.out.println("kolizja" + " x:"+drivers.get(i).x+" y: "+drivers.get(i).y+" Klasa: "+drivers.get(i).getClass()+" Klasa2: "+drivers.get(j).getClass());
                               System.out.println(drivers.size());
                                if(drivers.get(i) instanceof Drifter){
                                    if(drivers.get(j) instanceof Drifter){
                                    drivers.remove(i);
                                    }
                                    else if(drivers.get(j) instanceof Common_driver){
                                         chance = rand.nextInt(100);
                                         if(chance<25){
                                             int pom_x = drivers.get(i).x;
                                             int pom_y = drivers.get(i).y;
                                             drivers.set(i,new Good_boys(map));
                                             drivers.get(i).x = pom_x;
                                             drivers.get(i).y = pom_y;
                                             drivers.set(j,new Good_boys(map));
                                             drivers.get(j).y = pom_y;}
                                    }
                                    else if(drivers.get(j) instanceof Police){
                                        chance = rand.nextInt(2);
                                        if(chance ==1){
                                            drivers.remove(i);
                                        }
                                    }
                                }else if(drivers.get(i) instanceof Good_boys){
                                    if(drivers.get(j) instanceof Police){
                                        drivers.remove(i);
                                    }
                                    else if(drivers.get(j) instanceof Good_boys){
                                        drivers.add(new Good_boys(map));
                                    }
                                }
                                System.out.println(drivers.size());
                           }
                       }
                   }
                   TimeUnit.SECONDS.sleep(2);

               }

        }

}