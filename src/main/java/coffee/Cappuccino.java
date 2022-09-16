package coffee;


import java.util.Map;

public class Cappuccino extends CoffeeMachine {
    public Cappuccino(Map<String,Integer> supply) {
        Map<String,Integer> one_cup = Map.of(
                "water", 200,
                "milk", 100,
                "beans",12,
                "cups", 1,
                "money",6);
        buy(supply, one_cup);
    }
}

