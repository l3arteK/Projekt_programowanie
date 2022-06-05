
/*import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.concurrent.TimeUnit;*/

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Simulation {
        public static void main(String[] args) throws InterruptedException, FileNotFoundException {

               City_map map = new City_map();
            Date data = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-mm-dd_HH_mm_ss");
            System.out.println(simpleDateFormat.format(data));
            PrintWriter zapis = new PrintWriter(simpleDateFormat.format(data)+".txt");
            zapis.format("%-7s %10s\n","Krok","Liczba driverów");

               boolean przygotowanie = false;
                Random rand = new Random();
                int chance;
            ArrayList<Drivers> drivers = new ArrayList<Drivers>();


            while(map.run == false || przygotowanie == false) {
                System.out.println(map.dane[0]);
                if (map.run == true) {
                    System.out.println(map.dane[0]);
                    for (int i = 0; i < map.dane[0]; i++) {
                        System.out.println(i + "P");
                        drivers.add(new Police(map));
                    }
                    for (int i = 0; i < map.dane[1]; i++) {
                        drivers.add(new Drifter(map));
                    }
                    for (int i = 0; i < map.dane[2]; i++) {
                        drivers.add(new Common_driver(map));
                    }
                    przygotowanie = true;
                }
            }

            System.out.println("liczba obiektow"+drivers.size());
            System.out.println(map.dane[0]);
            System.out.println(map.dane[1]);
            System.out.println(map.dane[2]);
            int n=0;
               while(map.run){

                   System.out.println(map.run);
                   n+=1;
                   zapis.format("%-7d %10d\n",n,drivers.size());
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
                   TimeUnit.SECONDS.sleep(1);

               }
               zapis.close();


        }

}