import java.util.ArrayList;

public class Objects {
    private int amount;
    protected int id_ob;
    protected int x_cord;
    protected int y_cord;

    public Objects(int amount, int id_ob, int x_cord, int y_cord) {
        this.amount = amount;
        this.id_ob = id_ob;
        this.x_cord = x_cord;
        this.y_cord = y_cord;
    }

    /*public ArrayList<Fuel> fuel = new ArrayList<>();
    public ArrayList<Tires> tires = new ArrayList<>();
    public ArrayList<Bread> bread = new ArrayList<>();
    ArrayList<Sweets> sweets = new ArrayList<>();*/

    Speed_camera speed_camera = new Speed_camera(15,5,1,1);
}
