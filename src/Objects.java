import java.awt.*;

public class Objects {
    private int amount;
    protected int id_ob;
    protected int x_cord;
    protected int y_cord;

    City_map map;
    Color color;

//    public Objects(int amount, int id_ob, int x_cord, int y_cord) {
//        this.amount = amount;
//        this.id_ob = id_ob;
//        this.x_cord = x_cord;
//        this.y_cord = y_cord;
//    }


    public Objects(City_map map) {

        this.map = map;
    }

    void respawn() {
        map.panels[x_cord][y_cord].setBackground(color);
    }
}
