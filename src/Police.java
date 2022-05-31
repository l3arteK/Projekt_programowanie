import java.awt.*;

public class Police extends Drivers{
    private int id_dr = 3;
    private int x_cord;
    private int y_cord;

    public Police(City_map map) {
        super(map);
        this.color = Color.blue;
    }
}
