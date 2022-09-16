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
                    "milk", 200,
                    "beans", 100,
                    "cups", 10,
                    "money",500)
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

    public void status(){
        System.out.println("The coffee machine has: ");
        System.out.printf("%d ml of water\n", getWater());
        System.out.printf("%d ml of milk\n", getMilk());
        System.out.printf("%d g of coffee beans\n", getBeans());
        System.out.printf("%d disposable cups\n", getCups());
        System.out.printf("$%d of money\n\n", getMoney());
    }
    public void fill () throws InputMismatchException {
        try {
            formattedInput("Write how many ml of water you want to add:");
            setWater(getWater() + scanner.nextInt());
            formattedInput("Write how many ml of milk you want to add:");
            setMilk(getMilk() + scanner.nextInt());
            formattedInput("Write how many grams of coffee beans you want to add:");
            setBeans(getBeans() + scanner.nextInt());
            formattedInput("Write how many disposable cups you want to add:");
            setCups(getCups() + scanner.nextInt());
        }
        catch (InputMismatchException e) {
            System.out.println("Wrong input! Must be an integer\n");
        }
    }

    public void take(){
        System.out.printf("I gave you $%d\n\n", getMoney());
        setMoney(0);
    }

    public void formattedInput(String s){
        System.out.printf("%s\n>",s);
    }

    public void buy(Map<String,Integer> supply, Map<String,Integer> cup){
        for(String el : supply.keySet()) {
            if (supply.get(el) >= cup.get(el))
            {
                if("money".equals(el)){
                    supply.replace(el, supply.get(el) + cup.get(el));
                } else {
                    supply.replace(el, supply.get(el) - cup.get(el));
                }
            } else {
                switch (el) {
                    case "water" -> System.out.println("Sorry, not enough water!");
                    case "milk" -> System.out.println("Sorry, not enough milk!");
                    case "beans" -> System.out.println("Sorry, not enough beans!");
                    case "cups" -> System.out.println("Sorry, not enough cups!");
                }
                return;
            }
        }
        System.out.println("I have enough resources, making you a coffee!\n");

    }

    public void operate(){
        scanner = new Scanner(System.in);
        formattedInput("Write action (buy, fill, take, remaining, exit):");
        String action = scanner.nextLine();
        switch (action) {
            case "buy" -> {
                formattedInput("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
                String choice = scanner.nextLine();
                switch (choice) {
                    case "1":
                        Espresso espresso = new Espresso(supply);
                        break;
                    case "2":
                        Latte latte = new Latte(supply);
                        break;
                    case "3":
                        Cappuccino cappuccino = new Cappuccino(supply);
                        break;
                    case "back":
                        break;
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
        }
        operate();
    }

    public static void main(String[] args) {
        CoffeeMachine machine = new CoffeeMachine();
        machine.operate();
    }

}
