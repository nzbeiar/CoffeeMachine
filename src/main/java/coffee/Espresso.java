package coffee;

public class Espresso extends CoffeeMachine {

    private static final int[] ONE_CUP =  new int[] {250,0,16,1,4};

    public Espresso() {
        buy(SUPPLY, ONE_CUP);
    }
}
