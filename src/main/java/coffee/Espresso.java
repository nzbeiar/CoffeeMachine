package coffee;


import java.util.Map;

public class Espresso extends CoffeeMachine {
    public Espresso(Map<String,Integer> supply) {
        Map<String,Integer> one_cup = Map.of(
                "water", 250,
                "milk", 0,
                "beans",16,
                "cups", 1,
                "money",4);
        buy(supply, one_cup);
    }
}
