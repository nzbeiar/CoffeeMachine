package coffee;


public class Espresso extends CoffeeMachine {
    public Espresso(int[] SUPPLY) {
        int[] ONE_CUP = new int[]{250, 0, 16, 1, 4};
        buy(SUPPLY, ONE_CUP);
    }
}
