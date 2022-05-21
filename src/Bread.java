public class Bread {
    private int amount = 30;

    public void increase_amount_bread() {
        this.amount += 2;
    }
    // zamysl byl taki, ze przy metodzie kolizji bedzie po prostu wywolywana ta metoda
    // bo ona ma na celu zwiekszenia ilosci chleba na mapie
}
