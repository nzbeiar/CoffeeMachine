package coffee;


import java.util.InputMismatchException;
import java.util.Scanner;

public class CoffeeMachine {
    private static Scanner scanner;
    private int[] SUPPLY = new int[] {400, 540, 120, 9, 550}; // [water,milk,beans,cups, money]

    public CoffeeMachine() {
    }

    public CoffeeMachine(int[] supply) {
        this.SUPPLY = supply;
    }


    public int getWater() {
        return SUPPLY[0];
    }
    public void setWater(int water) {
        SUPPLY[0] = water;
    }
    public int getMilk() {
        return SUPPLY[1];
    }
    public void setMilk(int milk) {
        SUPPLY[1] = milk;
    }
    public int getBeans() {
        return SUPPLY[2];
    }
    public void setBeans(int beans) {
        SUPPLY[2] = beans;
    }
    public int getCups() {
        return SUPPLY[3];
    }
    public void setCups(int cups) {
        SUPPLY[3] = cups;
    }
    public int getMoney(){
        return SUPPLY[4];
    }
    public void setMoney(int money){
        SUPPLY[4] = money;
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

    public void buy(int[] SUPPLY, int[] cup){
        for(int i = 0; i < SUPPLY.length-1; i++) {
            if (SUPPLY[i] >= cup[i])
            {
                SUPPLY[i] -= cup[i];
            } else {
                switch (i) {
                    case 0 -> System.out.println("Sorry, not enough water!");
                    case 1 -> System.out.println("Sorry, not enough milk!");
                    case 2 -> System.out.println("Sorry, not enough beans!");
                    case 3 -> System.out.println("Sorry, not enough cups!");
                }
                return;
            }
        }
        System.out.println("I have enough resources, making you a coffee!\n");
        SUPPLY[4] += cup[4]; // getting paid for the coffee

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
                        Espresso espresso = new Espresso(SUPPLY);
                        break;
                    case "2":
                        Latte latte = new Latte(SUPPLY);
                        break;
                    case "3":
                        Cappuccino cappuccino = new Cappuccino(SUPPLY);
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
