
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

    static int liczba_drifterow = 0;
   static int liczba_dobrych_chlopakow = 0;
   static int liczba_policjantow = 0;
    static int liczba_zwyklych_kierowcow = 0;
    static int liczba_opon=0;
    static int liczba_kanistrow=0;
    static int liczba_fotoradarow=0;
    static int liczba_cukierkow=0;
    static int liczba_kolizj=0;
    static int n;
   static Date data = new Date();


   static void liczenie(ArrayList<Drivers> kierowcy, ArrayList<Objects> objekty){
       for(Drivers kierowca:kierowcy){
           if(kierowca instanceof Drifter)
               liczba_drifterow+=1;
           if(kierowca instanceof Police)
               liczba_policjantow+=1;
           if(kierowca instanceof Good_boys)
               liczba_dobrych_chlopakow+=1;
           if(kierowca instanceof Common_driver)
               liczba_zwyklych_kierowcow+=1;}
       for(Objects obiekt:objekty){
           if(obiekt instanceof Tires)
               liczba_opon+=1;
           if(obiekt instanceof Fuel)
               liczba_kanistrow+=1;
           if(obiekt instanceof Speed_camera)
               liczba_fotoradarow +=1;
           if(obiekt instanceof Sweets)
               liczba_cukierkow+=1;}
   }
        public static void main(String[] args) throws InterruptedException, FileNotFoundException {

            City_map map = new City_map();
            int x=2;

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-mm-dd_HH_mm_ss");
            PrintWriter zapis = new PrintWriter(simpleDateFormat.format(data)+".txt");
            zapis.format("%-7s %15s %15s %15s %15s %15s %15s %15s %15s %15s %15s %15s\n","Krok","Kolizja","Kierowcy","Obiekty","Policjanci","Zwykli_kierowcy","Drifterzy","Dobre chłopaki","Opony","Kanistry","Cukierki","Fotoradary");

            boolean przygotowanie = false;
            Random rand = new Random();
            int chance;
            ArrayList<Drivers> drivers = new ArrayList<Drivers>();
            ArrayList<Objects> objects = new ArrayList<Objects>();

    for(;;) {
        if (map.run && !przygotowanie) {
            for (int i = 0; i < map.dane[1]; i++) {
                System.out.println(i + "P");
                drivers.add(new Drifter(map));
            }
            for (int i = 0; i < map.dane[0]; i++) {
                drivers.add(new Police(map, drivers));
            }
            for (int i = 0; i < map.dane[2]; i++) {
                drivers.add(new Common_driver(map));
            }
            for (int i = 0; i < map.dane[3]; i++) {
                objects.add(new Fuel(map));
            }
            for (int i = 0; i < map.dane[5]; i++) {
                objects.add(new Tires(map));
            }
            for (int i = 0; i < map.dane[7]; i++) {
                objects.add(new Bread(map));
            }
            for (int i = 0; i < map.dane[11]; i++) {
                objects.add(new Speed_camera(map));
            }
            przygotowanie = true;
        }else if(map.run){
            while(map.run){
                n+=1;

                liczenie(drivers,objects);

                zapis.format("%-7d %15d %15d %15d %15d %15d %15d %15d %15d %15d %15d\n",n,drivers.size(),objects.size(),liczba_policjantow,liczba_zwyklych_kierowcow,liczba_drifterow,liczba_dobrych_chlopakow,liczba_opon,liczba_kanistrow,liczba_cukierkow,liczba_fotoradarow);
                for(int i=0; i<map.size_x; i++){
                    for(int j=0; j<map.size_y; j++){
                        map.panels[i][j].setBackground(Color.gray);
                    }
                }
                for (Drivers driver : drivers) {
                    driver.move();
                    System.out.println(driver.x);
                    System.out.println(driver.y);
                }
                for (Objects object : objects) {
                    object.respawn();
                }


                System.out.println("ruch: "+n);
                System.out.println("");
                //check_colision

                for(int i=0; i<drivers.size()-1; i++){
                    for(int j=i+1; j<drivers.size(); j++){
                        if((drivers.get(i).x == drivers.get(j).x) &&(drivers.get(i).y==drivers.get(j).y)){
                            System.out.println("kolizja" + " x:"+drivers.get(i).x+" y: "+drivers.get(i).y+" Klasa: "+drivers.get(i).getClass()+" Klasa2: "+drivers.get(j).getClass());


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
                                        drivers.get(j).y = pom_y;
                                        drivers.get(j).x = pom_x;
                                    }
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

                for (int i = 0; i < drivers.size(); i++) {
                    for (int j = 0; j < objects.size(); j++) {
                        if ((drivers.get(i).x == objects.get(j).x_cord) && (drivers.get(i).y == objects.get(j).y_cord)) {


                            System.out.println("kolizja z obiektem x: " + drivers.get(i).x + " y: " + drivers.get(i).y + " Klasa: " + drivers.get(i).getClass() + " Klasa2: " + objects.get(j).getClass());
                            //System.out.println(drivers.size());

                            if (drivers.get(i) instanceof Drifter) {
                                if (objects.get(j) instanceof Tires) {
                                    objects.remove(j);
                                }
                                else if (objects.get(j) instanceof Fuel) {
                                    objects.remove(j);
                                }
                                else if (objects.get(j) instanceof Speed_camera) {
                                    drivers.remove(i);
                                }
                            }
                            else if (drivers.get(i) instanceof Common_driver) {
                                if (objects.get(j) instanceof Bread) {
                                    objects.remove(j);
                                }
                                else if (objects.get(j) instanceof Fuel) {
                                    objects.remove(j);
                                }
                            }
                            else if (drivers.get(i) instanceof Good_boys) {
                                if (objects.get(j) instanceof Sweets) {
                                    objects.remove(j);
                                }
                            }

                        }
                    }
                }

                System.out.println("liczba obiektow: " + objects.size());
                System.out.println("liczba kierowcow: " + drivers.size());

                TimeUnit.SECONDS.sleep(1);

            }

        }else if(!map.run && przygotowanie){
            zapis.close();
            przygotowanie = false;
            zapis = new PrintWriter(simpleDateFormat.format(data)+"_v"+x+".txt");
            zapis.format("%-7s %10s %10s %10s %10s\n","Krok","Kierowcy","Obiekty","Policjanci","Zwykli kierowcy");
            x+=1;
        }else{
            System.out.println("waiting");
        }
    }

/*
            System.out.println("liczba obiektow " + drivers.size());
            System.out.println("policja " + map.dane[0]);
            System.out.println("drifterzy " + map.dane[1]);
            System.out.println("zwykli kierowcy " + map.dane[2]);
            System.out.println("paliwo " + map.dane[3]);
            System.out.println("opony " + map.dane[5]);
            System.out.println("chleb " + map.dane[7]);
            System.out.println("fotoradar " + map.dane[10]);


               zapis.close();

 */
        }
}