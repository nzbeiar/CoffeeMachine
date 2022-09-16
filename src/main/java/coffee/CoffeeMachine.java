package coffee;



import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class CoffeeMachine {
    private static Scanner scanner;
    private Map<String, Integer> supply = new HashMap<>(
            Map.of(
                    "water", 400,
                    "milk", 540,
                    "beans", 120,
                    "cups", 9,
                    "money",550)
    );

    public CoffeeMachine() {
    }

    public CoffeeMachine(HashMap<String, Integer> supply) {
        this.supply = supply;
    }


    public int getWater() {
        return supply.get("water");
    }
    public void setWater(int water) {
        supply.replace("water",water);
    }
    public int getMilk() {
        return supply.get("milk");
    }
    public void setMilk(int milk) {
        supply.replace("milk",milk);
    }
    public int getBeans() {
        return supply.get("beans");
    }
    public void setBeans(int beans) {
        supply.replace("beans",beans);
    }
    public int getCups() {
        return supply.get("cups");
    }
    public void setCups(int cups) {
        supply.replace("cups",cups);
    }
    public int getMoney(){
        return supply.get("money");
    }
    public void setMoney(int money){
        supply.replace("money",money);
    }

    private void status(){
        System.out.println("The coffee machine has: ");
        System.out.printf("%d ml of water\n", getWater());
        System.out.printf("%d ml of milk\n", getMilk());
        System.out.printf("%d g of coffee beans\n", getBeans());
        System.out.printf("%d disposable cups\n", getCups());
        System.out.printf("$%d of money\n\n", getMoney());
    }
    private void fill () throws InputMismatchException {
        try {
            formattedInput("Write how many ml of water you want to add:");
            setWater(getWater() + scanner.nextInt());
            formattedInput("Write how many ml of milk you want to add:");
            setMilk(getMilk() + scanner.nextInt());
            formattedInput("Write how many grams of coffee beans you want to add:");
            setBeans(getBeans() + scanner.nextInt());
            formattedInput("Write how many disposable cups you want to add:");
            setCups(getCups() + scanner.nextInt());
            System.out.println();
        }
        catch (InputMismatchException e) {
            System.out.println("Wrong input! Must be an integer\n");
        }
    }

    private void take(){
        System.out.printf("I gave you $%d\n\n", getMoney());
        setMoney(0);
    }

    private void formattedInput(String s){
        System.out.printf("%s\n>",s);
    }

    private boolean checkSupply(Map<String,Integer> supply, Map<String,Integer> cup){
        for(String el : supply.keySet()) {
            if (supply.get(el) < cup.get(el)) {
                switch (el) {
                    case "water" -> System.out.println("Sorry, not enough water!\n");
                    case "milk" -> System.out.println("Sorry, not enough milk!\n");
                    case "beans" -> System.out.println("Sorry, not enough beans!\n");
                    case "cups" -> System.out.println("Sorry, not enough cups!\n");
                }
                return false;
            }
        }
        return true;
    }

    private void makeCoffee(Map<String,Integer> supply, Map<String,Integer> cup){
        for(String el : supply.keySet()) {
            if("money".equals(el)) {
                supply.replace(el, supply.get(el) + cup.get(el));
            } else {
                supply.replace(el, supply.get(el) - cup.get(el));
            }
        }
        System.out.println("I have enough resources, making you a coffee!\n");
    }

    protected void buy(Map<String,Integer> supply, Map<String,Integer> cup){;
        if (checkSupply(supply,cup)) {
            makeCoffee(supply,cup);
        }
    }

    private void operate(){
        scanner = new Scanner(System.in);
        formattedInput("Write action (buy, fill, take, remaining, exit):");
        String action = scanner.nextLine();
        switch (action) {
            case "buy" -> {
                System.out.println();
                formattedInput("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
                String choice = scanner.nextLine();
                switch (choice) {
                    case "1" -> {
                        Espresso espresso = new Espresso(supply);
                    }
                    case "2" -> {
                        Latte latte = new Latte(supply);
                    }
                    case "3" -> {
                        Cappuccino cappuccino = new Cappuccino(supply);
                    }
                    case "back" -> System.out.println();

                    default -> System.out.println("Wrong input!\n");
                }
            }
            case "fill" -> fill();
            case "take" -> take();
            case "remaining" -> status();
            case "exit" -> {
                scanner.close();
                System.out.println("Auf Wiedersehen!");
                return;
            }
            default -> System.out.println("Wrong input!\n");

        }
        operate();
    }

    public static void main(String[] args) {
        CoffeeMachine machine = new CoffeeMachine();
        machine.operate();
    }

}
