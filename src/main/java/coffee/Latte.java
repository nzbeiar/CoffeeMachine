package coffee;


public class Latte extends CoffeeMachine {
    public Latte(int[] SUPPLY) {
        int[] ONE_CUP = new int[]{350, 75, 20, 1, 7};
        buy(SUPPLY, ONE_CUP);
    }
}
