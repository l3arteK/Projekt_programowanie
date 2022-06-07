import java.awt.*;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Fuel extends Objects{

    Objects objects;
    Random rand = new Random();

    public Fuel(City_map map) {
        super(map);

        this.color = Color.red;
        this.x_cord = rand.nextInt(map.size_x);
        this.y_cord = rand.nextInt(map.size_x);
    }
}
