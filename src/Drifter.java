import java.awt.*;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class Drifter extends Drivers
{
    public Drifter(City_map map) {
        super(map);
        this.color = Color.BLACK;
    }

    boolean move;

    void move() {
        //map.panels[x][y].setBackground(Color.gray);

        if (move)
        {
            switch (rand.nextInt(2)){
                case 0:
                    if(x<max_x - 1){x=x+1;}
                    else{x=x-1;}
                    break;
                case 1:
                    if(x>1){x=x-1;}
                    else{x=x+1;}
                    break;
            }
            move = FALSE;
        }
        else
        {
            switch (rand.nextInt(2)){
                case 0:
                    if(y<max_y - 1){y=y+1;}
                    else{y=y-1;}
                    break;
                case 1:
                    if(y>1){y=y-1;}
                    else{y=y+1;}
                    break;
            }
            move = TRUE;
        }

        map.panels[x][y].setBackground(color);
    }
}
