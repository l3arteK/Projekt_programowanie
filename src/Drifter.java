import java.awt.*;

public class Drifter extends Drivers
{
    public Drifter(City_map map) {
        super(map);
        this.color = Color.BLACK;
    }

    int i;

    void move() {
        map.panels[x][y].setBackground(Color.gray);

        if (i%2==0)
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
        }

        map.panels[x][y].setBackground(color);
        i++;
    }
}
