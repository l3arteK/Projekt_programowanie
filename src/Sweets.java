import java.awt.*;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Sweets extends Objects{

    Objects objects;
    Random rand = new Random();

    public Sweets(City_map map) {
        super(map);

        this.color = Color.yellow;
        this.x_cord = rand.nextInt(map.size_x);
        this.y_cord = rand.nextInt(map.size_x);
    }
}
