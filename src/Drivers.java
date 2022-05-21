import java.util.ArrayList;

public class Drivers
{
    protected int id_dr;
    private int fuel;
    private int tires;
    protected int x_cord;
    protected int y_cord;

    public Drivers(int id_dr, int fuel, int tires, int x_cord, int y_cord){
        this.id_dr = id_dr;
        this.fuel = fuel;
        this.tires = tires;
        this.x_cord = x_cord;
        this.y_cord = y_cord;
    }

    /*Drifter drifter = new Drifter(1,25,30,5,5);
    Common_driver common_driver = new Common_driver(2, 50,50,2,4);
    Police police = new Police(3,0,0,8,6);*/
}
