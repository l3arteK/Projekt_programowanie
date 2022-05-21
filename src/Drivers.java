public class Drivers
{
    int id_dr;
    int fuel;
    int tires;
    int x_cord;
    int y_cord;

    public Drivers(int id_dr, int fuel, int tires, int x_cord, int y_cord){
        this.id_dr = id_dr;
        this.fuel = fuel;
        this.tires = tires;
        this.x_cord = x_cord;
        this.y_cord = y_cord;
    }

    public Drifter drifter;
    public Common_driver common_driver;
    public Police police;
    public Good_boys good_boys;
}
