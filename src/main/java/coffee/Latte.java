package coffee;

public class Latte extends CoffeeMachine {
    private static final int[] ONE_CUP =  new int[] {350,75,20,1,7};

    public Latte() {
        buy(SUPPLY, ONE_CUP);
    }
}
