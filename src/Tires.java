import java.awt.*;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Tires extends Objects{

    Random rand = new Random();

    public Tires(City_map map) {
        super(map);

        this.color = Color.darkGray;
        this.x_cord = rand.nextInt(map.size_x);
        this.y_cord = rand.nextInt(map.size_y);
    }
}
