package machine;
import java.util.Arrays;
import java.util.Scanner;

class Espresso {
    static int waterPerCup = 250;
    static int milkPerCup = 0;
    static int coffeeBeansPerCup = 16;
    static int cost = 4;
    static int disposableCup = 1;
}

class Latte {
    static int waterPerCup = 350;
    static int milkPerCup = 75;
    static int coffeeBeansPerCup = 20;
    static int cost = 7;
    static int disposableCup = 1;
}

class Cappuccino {
    static int waterPerCup = 200;
    static int milkPerCup = 100;
    static int coffeeBeansPerCup = 12;
    static int cost = 6;
    static int disposableCup = 1;
}

public class CoffeeMachine {
    static int totalWater = 400;
    static int totalMilk = 540;
    static int totalCoffeebeans = 120;
    static int disposableCups = 9;
    static int totalMoney = 550;

    public CoffeeMachine() {
        this.totalWater = 400;
        this.totalMilk = 540;
        this.totalCoffeebeans = 120;
        this.disposableCups = 9;
        this.totalMoney = 550;
    }

    public static int fillWater() {
        System.out.println("Write how many ml of water the coffee machine has:");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static int fillMilk() {
        System.out.println("Write how many ml of milk the coffee machine has:");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static int fillCoffeeBeans() {
        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static int fillDisposableCups() {
        System.out.println("Write how many disposable cups you want to add: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static void printCoffeeMachineStatus() {
        System.out.println("The coffee machine has:");
        System.out.printf("%d ml of water\n", totalWater);
        System.out.printf("%d ml of milk\n", totalMilk);
        System.out.printf("%d g of coffee beans\n", totalCoffeebeans);
        System.out.printf("%d disposable cups\n", disposableCups);
        System.out.printf("$%d of money\n", totalMoney);
    }

    public static boolean isEnoughWater(int waterPerCup) {
        boolean isWaterAvailable = totalWater >= waterPerCup;
        if (isWaterAvailable) {
            return true;
        } else {
            System.out.println("Sorry, not enough water!");
            return false;
        }
    }

    public static boolean isEnoughMilk(int milkPerCup) {
        boolean isMilkAvailable = totalMilk >= milkPerCup;
        if (isMilkAvailable) {
            return true;
        } else {
            System.out.println("Sorry, not enough milk!");
            return false;
        }
    }

    public static boolean isEnoughCoffeeBeans(int coffeeBeansPerCup) {
        boolean isCoffeeBeansAvailable = totalCoffeebeans >= coffeeBeansPerCup;
        if (isCoffeeBeansAvailable) {
            return true;
        } else {
            System.out.println("Sorry, not enough coffee beans!");
            return false;
        }
    }

    public static boolean isEnoughCups(int cups) {
        boolean isCupsAvailable = disposableCups >= cups;
        if (isCupsAvailable) {
            return true;
        } else {
            System.out.println("Sorry, not enough coffee beans!");
            return false;
        }
    }

    public static void buyEspresso() {
        if (isEnoughWater(Espresso.waterPerCup) && isEnoughMilk(Espresso.milkPerCup) && isEnoughCoffeeBeans(Espresso.coffeeBeansPerCup) && isEnoughCups(Espresso.disposableCup)) {
            System.out.println("I have enough resources, making you a coffee!");
            totalWater -= Espresso.waterPerCup;
            totalMilk -= Espresso.milkPerCup;
            totalCoffeebeans -= Espresso.coffeeBeansPerCup;
            disposableCups -= Espresso.disposableCup;
            totalMoney += Espresso.cost;
        }
    }

    public static void buyLatte() {
        if (isEnoughWater(Latte.waterPerCup) && isEnoughMilk(Latte.milkPerCup) && isEnoughCoffeeBeans(Latte.coffeeBeansPerCup) && isEnoughCups(Latte.disposableCup)) {
            System.out.println("I have enough resources, making you a coffee!");
            totalWater -= Latte.waterPerCup;
            totalMilk -= Latte.milkPerCup;
            totalCoffeebeans -= Latte.coffeeBeansPerCup;
            disposableCups -= Latte.disposableCup;
            totalMoney += Latte.cost;
        }
    }

    public static void buyCappuccino() {
        if (isEnoughWater(Cappuccino.waterPerCup) && isEnoughMilk(Cappuccino.milkPerCup) && isEnoughCoffeeBeans(Cappuccino.coffeeBeansPerCup) && isEnoughCups(Cappuccino.disposableCup)) {
            System.out.println("I have enough resources, making you a coffee!");
            totalWater -= Cappuccino.waterPerCup;
            totalMilk -= Cappuccino.milkPerCup;
            totalCoffeebeans -= Cappuccino.coffeeBeansPerCup;
            disposableCups -= Cappuccino.disposableCup;
            totalMoney += Cappuccino.cost;
        }
    }

    public static void runCoffeeMachine() {
        while (true) {
            System.out.println("Write action (buy, fill, take, remaining, exit): ");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();

            if (input.equals("exit")) {
                break;
            } else if (input.equals("remaining")) {
                System.out.println();
                printCoffeeMachineStatus();
                System.out.println();
            } else if (input.equals("take")) {
                System.out.println();
                System.out.printf("I gave you %d\n", totalMoney);
                totalMoney = 0;
            } else if (input.equals("fill")) {
                totalWater += fillWater();
                totalMilk += fillMilk();
                totalCoffeebeans += fillCoffeeBeans();
                disposableCups += fillDisposableCups();

            } else if (input.equals("buy")) {
                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
                String requestedCoffee = scanner.nextLine();
                switch (requestedCoffee) {
                    case "1":
                        buyEspresso();
                        break;
                    case "2":
                        buyLatte();
                        break;
                    case "3":
                        buyCappuccino();
                        break;
                    case "back":
                        continue;
                    default:
                        break;
                }
            }

        }
    }

    public static void main(String[] args) {
        CoffeeMachine.runCoffeeMachine();
    }
}
