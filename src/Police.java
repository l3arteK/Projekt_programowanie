import java.awt.*;
import java.util.ArrayList;

import static java.lang.Math.abs;

public class Police extends Drivers{
    private int id_dr = 3;
//    private int x_cord;
//    private int y_cord;

    public Police(City_map map, ArrayList <Drivers> drivers) {
        super(map);
        this.color = Color.blue;
        this.drivers = drivers;
    }

    ArrayList<Drivers> drivers;

    int distance_x;
    int distance_y;
    int distance_min_x;
    int distance_min_y;

    //boolean drifter_searched;
    int drifter_searched;

    //@Override
    void move() {

//        for(int i = 0; i < drivers.size(); i++) {
//            if (drivers.get(i) instanceof Drifter) {
//                //drifter_searched = true;
//                drifter_searched = 1;
//            }
//        }

        //drifter_searched = false;

        drifter_searched = 0;

        for (int i = 0; i < drivers.size(); i++) {

            if (drivers.get(i) instanceof Drifter) {

                drifter_searched = 1;

                distance_min_x = map.size_x;
                distance_min_y = map.size_y;

                distance_x = drivers.get(i).x - x;
                distance_y = drivers.get(i).y - y;

                if (abs(distance_x) < distance_min_x) {
                    distance_min_x = distance_x;
                }
                if (abs(distance_y) < distance_min_y) {
                    distance_min_y = distance_y;
                }

//            System.out.println("dystans x: " + distance_x);
//            System.out.println("dystans y: " + distance_x);
//            System.out.println("dystans min x: " + distance_min_x);
//            System.out.println("dystans min y: " + distance_min_y);

                if (distance_min_x < 0 && distance_min_y < 0) {
                    if (abs(distance_min_x) < abs(distance_min_y)) {

                        x -= 1;
                        break;
                    } else {
                        y -= 1;
                        break;
                    }
                } else if (distance_min_x > 0 && distance_min_y < 0) {
                    if (abs(distance_min_x) < abs(distance_min_y)) {

                        x += 1;
                        break;
                    } else {
                        y -= 1;
                        break;
                    }
                }
                else if (distance_min_x < 0 && distance_min_y > 0) {
                    if (abs(distance_min_x) < abs(distance_min_y)) {

                        x -= 1;
                        break;
                    } else {
                        y += 1;
                        break;
                    }
                }
                else if (distance_min_x > 0 && distance_min_y > 0) {
                    if (abs(distance_min_x) < abs(distance_min_y)) {

                        x += 1;
                        break;
                    } else {
                        y += 1;
                        break;
                    }
                }
                else if (distance_min_x == 0 && distance_min_y > 0) {
                    y += 1;
                    break;
                }
                else if (distance_min_x == 0 && distance_min_y < 0) {
                    y -= 1;
                    break;
                }
                else if (distance_min_y == 0 && distance_min_x > 0) {
                    x += 1;
                    break;
                }
                else {
                    x -= 1;
                    break;
                }
            }
        }

        //drifter_searched = true;

        if (drifter_searched == 0) {

            switch (rand.nextInt(4)){
                case 0:
                    if(x < max_x - 1){x += 1;}
                    else{x -= 1;}
                    break;
                case 1:
                    if(y < max_y - 1){y += 1;}
                    else{y -= 1;}
                    break;
                case 2:
                    if(y > 1){y -= 1;}
                    else{y += 1;}
                    break;
                case 3:
                    if(x > 1){x -= 1;}
                    else{x += 1;}
                    break;
            }
        }

        map.panels[x][y].setBackground(color);
    }

}
