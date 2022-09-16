package coffee;


public class Cappuccino extends CoffeeMachine {
    public Cappuccino(int[] SUPPLY) {
        int[] ONE_CUP = new int[]{200, 100, 12, 1, 6};
        buy(SUPPLY, ONE_CUP);
    }
}
