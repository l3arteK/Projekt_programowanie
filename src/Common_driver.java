public class Common_driver {
    private int id_dr = 2;
    private int fuel = 25;
    private int tires = 30;
    private int x_cord = 5;
    private int y_cord = 5;

    public void increase_fuel_common_driver() {
        this.fuel += 10;
        this.tires += 15;
    }
    // zamysl byl taki, ze przy metodzie kolizji bedzie po prostu wywolywana ta metoda
    // bo ona ma na celu zwiekszenie obecnego stanu paliwa i opon
}
