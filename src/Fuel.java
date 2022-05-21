public class Fuel {
    private int amount = 30;

    public void increase_amount_fuel() {
        this.amount += 1;
    }
    // zamysl byl taki, ze przy metodzie kolizji bedzie po prostu wywolywana ta metoda
    // bo ona ma na celu zwiekszenia ilosci paliwa na mapie
}
