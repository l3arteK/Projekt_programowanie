
/*import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.concurrent.TimeUnit;*/

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Simulation {

    static int[] dane_do_zapisu = new int[10];
    static int n;
    static int object_max_amount;
    static boolean drifter_searched;
    static boolean was_colission;
    static int moves_without_colisson;
    static boolean are_good_boys = false;
    //static boolean more_sweets = true;
    static int good_boys_amount;
    static int moves_left_to_production = 3;
    static int amount_tires;
    static int amount_fuel;
    static int amount_bread;
    static int amount_sweets;

   static Date data = new Date();


   static void liczenie(ArrayList<Drivers> kierowcy, ArrayList<Objects> objekty){
       for(int i=0;i<8;i++){dane_do_zapisu[i]=0;}
       for(Drivers kierowca:kierowcy){
           if(kierowca instanceof Drifter)
               dane_do_zapisu[0]+=1;
           if(kierowca instanceof Police)
               dane_do_zapisu[1]+=1;
           if(kierowca instanceof Good_boys)
               dane_do_zapisu[2]+=1;
           if(kierowca instanceof Common_driver)
               dane_do_zapisu[3]+=1;}
       for(Objects obiekt:objekty){
           if(obiekt instanceof Tires)
               dane_do_zapisu[4]+=1;
           if(obiekt instanceof Fuel)
               dane_do_zapisu[5]+=1;
           if(obiekt instanceof Speed_camera)
               dane_do_zapisu[6]+=1;
           if(obiekt instanceof Sweets)
               dane_do_zapisu[7]+=1;}
   }
        public static void main(String[] args) throws InterruptedException, IOException {

            City_map map = new City_map();
            int x=2;

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-mm-dd_HH_mm_ss");
            PrintWriter zapis = new PrintWriter(simpleDateFormat.format(data)+".txt");
            zapis.format("%-7s %15s %15s %15s %15s %15s %15s %15s %15s %15s %15s %25s %35s \n","Krok","Kierowcy","Obiekty","Policjanci","Zwykli_kierowcy","Drifterzy","Dobre ch??opaki","Opony","Kanistry","Fotoradary","Cukierki","Kolizje_mi??dzy_kierowcami","Kolizje_kierowcow_mi??dzy_obiektami");

            boolean przygotowanie = false;
            Random rand = new Random();
            int chance;
            ArrayList<Drivers> drivers = new ArrayList<Drivers>();
            ArrayList<Objects> objects = new ArrayList<Objects>();

    for(;;) {
        if (map.run && !przygotowanie) {
            for (int i = 0; i < map.dane[3]; i++) {
                drivers.add(new Drifter(map));
            }
            for (int i = 0; i < map.dane[2]; i++) {
                drivers.add(new Police(map, drivers));
            }
            for (int i = 0; i < map.dane[4]; i++) {
                drivers.add(new Common_driver(map));
            }
            for (int i = 0; i < map.dane[5]; i++) {
                objects.add(new Fuel(map));
            }
            for (int i = 0; i < map.dane[7]; i++) {
                objects.add(new Tires(map));
            }
            for (int i = 0; i < map.dane[9]; i++) {
                objects.add(new Bread(map));
            }
            for (int i = 0; i < map.dane[12]; i++) {
                objects.add(new Speed_camera(map));
            }
            przygotowanie = true;

        }else if(map.run){
            while(map.run){
                n+=1;

                liczenie(drivers,objects);

                zapis.format("%-7d %15d %15d %15d %15d %15d %15d %15d %15d %15d %15d %25d %35d\n",n,drivers.size(),objects.size(),dane_do_zapisu[1],dane_do_zapisu[3],dane_do_zapisu[0],dane_do_zapisu[2],dane_do_zapisu[4],dane_do_zapisu[5],dane_do_zapisu[6],dane_do_zapisu[7],dane_do_zapisu[8],dane_do_zapisu[9]);
                for(int i=0; i<map.size_x; i++){
                    for(int j=0; j<map.size_y; j++){
                        map.panels[i][j].setBackground(Color.gray);
                    }
                }
                for (Drivers driver : drivers) {
                    driver.move();
                }
                for (Objects object : objects) {
                    object.respawn();
                }



                //check_colision

                was_colission = false;

                for(int i=0; i<drivers.size()-1; i++){
                    for(int j=i+1; j<drivers.size(); j++){
                        if((drivers.get(i).x == drivers.get(j).x) &&(drivers.get(i).y==drivers.get(j).y)){
                          //  System.out.println("kolizja" + " x:"+drivers.get(i).x+" y: "+drivers.get(i).y+" Klasa: "+drivers.get(i).getClass()+" Klasa2: "+drivers.get(j).getClass());
                            was_colission = true;
                            moves_without_colisson = 0;
                            dane_do_zapisu[8]+=1;

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
//                            System.out.println("liczba kierowcow " + drivers.size());
                        }
                    }
                }

                for (int i = 0; i < drivers.size(); i++) {
                    for (int j = 0; j < objects.size(); j++) {
                        if ((drivers.get(i).x == objects.get(j).x_cord) && (drivers.get(i).y == objects.get(j).y_cord)) {


                           // System.out.println("kolizja z obiektem x: " + drivers.get(i).x + " y: " + drivers.get(i).y + " Klasa: " + drivers.get(i).getClass() + " Klasa2: " + objects.get(j).getClass());
                            was_colission = true;
                            moves_without_colisson = 0;
                            dane_do_zapisu[9]+=1;

                            if (drivers.get(i) instanceof Drifter) {
                                if (objects.get(j) instanceof Tires) {
                                    objects.remove(j);
                                    drivers.get(i).moves_tires += 10;
                                    //System.out.println("Drifter pozostale ruchy na oponach: " + drivers.get(i).moves_tires);
                                }
                                else if (objects.get(j) instanceof Fuel) {
                                    objects.remove(j);
                                    drivers.get(i).moves_fuel += 5;
                                    //System.out.println("Drifter pozostale ruchy na paliwie: " + drivers.get(i).moves_fuel);
                                }
                                else if (objects.get(j) instanceof Speed_camera) {
                                    drivers.remove(i);
                                }
                            }
                            else if (drivers.get(i) instanceof Common_driver) {
                                if (objects.get(j) instanceof Bread) {
                                    objects.remove(j);
                                    drivers.get(i).bread += 1;
                                    //System.out.println("Zwykly kierowca podnisione chleby: " + drivers.get(i).bread);
                                }
                                else if (objects.get(j) instanceof Fuel) {
                                    objects.remove(j);
                                    drivers.get(i).moves_fuel += 15;
                                    //System.out.println("Zwykly kierowca pozostale ruchy na paliwie: " + drivers.get(i).moves_fuel);
                                }
                            }
                            else if (drivers.get(i) instanceof Good_boys) {
                                if (objects.get(j) instanceof Sweets) {
                                    objects.remove(j);
                                }
                            }
                        }
//                        System.out.println("liczba obiektow " + objects.size());
                    }
                }

                if (objects.size() != 0) {

                    amount_tires = 0;
                    amount_fuel = 0;
                    amount_bread = 0;
                    amount_sweets = 0;

                    for (int i=0; i<objects.size(); i++) {

                        if (objects.get(i) instanceof Tires) {
                            amount_tires++;
                        }

                        if (objects.get(i) instanceof Fuel) {
                            amount_fuel++;
                        }

                        if (objects.get(i) instanceof Bread) {
                            amount_bread++;
                        }

                        if (objects.get(i) instanceof Sweets) {
                            amount_sweets++;
                        }
                    }

//                    for (int i=0; i<objects.size(); i++) {

//                    }

                }

//                System.out.println("amount of tires " + amount_tires);
//                System.out.println("amount of fuel " + amount_fuel);
//                System.out.println("amount of bread " + amount_bread);
//                System.out.println("amount of sweets " + amount_sweets);
//
//                System.out.println("map.dane[5]" + map.dane[5]);
//                System.out.println("map.dane[6]" + map.dane[6]);

                if (amount_fuel >= City_map.dane[5] && amount_fuel < City_map.dane[6]) {
                    objects.add(new Fuel(map));
                }

                if (amount_tires >= City_map.dane[7] && amount_tires < City_map.dane[8]) {
                    objects.add(new Tires(map));
                }

                if (amount_bread >= City_map.dane[9] && amount_bread < City_map.dane[10]) {
                    objects.add(new Bread(map));
                }


                if (drivers.size() != 0) {

                    for (int i = 0; i < drivers.size(); i++) {

                        if (drivers.get(i) instanceof Drifter) {
                            if (drivers.get(i).moves_fuel == 0 || drivers.get(i).moves_tires == 0) {
                                drivers.remove(i);
                            }
                        }
                        else if (drivers.get(i) instanceof Common_driver) {
                            if (drivers.get(i).moves_fuel == 0) {
                                drivers.remove(i);
                            }
                        }
                    }

                    good_boys_amount = 0;

                    for (int i=0; i<drivers.size(); i++) {

                        if (drivers.get(i) instanceof Good_boys) {
                            are_good_boys = true;
                            good_boys_amount++;
                        }
                    }
                }


                if (moves_left_to_production <= 0 && amount_sweets < City_map.dane[11]) {

                    if (are_good_boys && good_boys_amount < 5) {
                        objects.add(new Sweets(map,drivers,objects));
                        moves_left_to_production = 3;
                    }
                    else if (are_good_boys && good_boys_amount >= 5 && good_boys_amount < 10) {
                        objects.add(new Sweets(map,drivers,objects));
                        objects.add(new Sweets(map,drivers,objects));
                        moves_left_to_production = 3;
                    }
                    else if (are_good_boys && good_boys_amount > 10) {
                        objects.add(new Sweets(map,drivers,objects));
                        objects.add(new Sweets(map,drivers,objects));
                        objects.add(new Sweets(map,drivers,objects));
                        moves_left_to_production = 3;
                    }
                }
                else {
                    moves_left_to_production--;
                }

                //#Warunki zako??czenia symulacji

                if (dane_do_zapisu[0]<1) {
                    System.out.println("Koniec symulacji - brak drifterow na mapie");
                    zapis.close();
                    return;
                }

                if (!was_colission) {
                    moves_without_colisson++;
                }

                if (moves_without_colisson == 30) {
                    System.out.println("Koniec symulacji - zbyt wiele ruchow bez kolizji pomiedzy obiektami");
                    zapis.close();
                    return;
                }

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

        }
}