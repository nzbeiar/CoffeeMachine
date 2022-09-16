package coffee;


import java.util.Map;

public class Latte extends CoffeeMachine {
    public Latte(Map<String,Integer> supply) {
        Map<String,Integer> one_cup = Map.of(
                "water", 350,
                "milk", 75,
                "beans",20,
                "cups", 1,
                "money",7);
        buy(supply, one_cup);
    }
}

