package machine;

import java.util.Scanner;

public class CoffeeMachine {
    final static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {

        int[] inventory = new int[5];
        inventory[0] = 400;     // water
        inventory[1] = 540;     // milk
        inventory[2] = 120;     // coffee beans
        inventory[3] = 9;       // disposable cups
        inventory[4] = 550;     // money

        action(inventory);
        }

    public static void makeEspresso(int[] inventory) {

        /*Espresso:
        250 ml of water, 16 g of coffee, 1 cup
        It costs $4*/

        if (inventory[0] < 250) {
            System.out.println("Sorry, not enough water!");
        } else if (inventory[2] < 16) {
            System.out.println("Sorry, not enough coffee beans!");
        }  else if (inventory[3] < 1) {
            System.out.println("Sorry, not enough cups!");
        } else {
            System.out.println("I have enough resources, making you a coffee!\n");

            inventory[0] -= 250;
            inventory[2] -= 16;
            inventory[3] -= 1;
            inventory[4] += 4;
        }
    }

    public static void makeLatte(int[] inventory) {

        /*Latte:
        350 ml of water,
        75 ml of milk, and 20 g of coffee, 1 cup
        It costs $7.*/

            if (inventory[0] < 350) {
                System.out.println("Sorry, not enough water!");
            } else if (inventory[1] < 75) {
                System.out.println("Sorry, not enough milk!");
            } else if (inventory[2] < 20) {
                System.out.println("Sorry, not enough coffee beans!");
            }  else if (inventory[3] < 1) {
                System.out.println("Sorry, not enough cups!");
            } else {
                System.out.println("I have enough resources, making you a coffee!\n");

                inventory[0] -= 350;
                inventory[1] -= 75;
                inventory[2] -= 20;
                inventory[3] -= 1;
                inventory[4] += 7;
            }
    }

    public static void makeCappuccino(int[] inventory) {

        /*Cappuccino:
        200 ml of water, 100 ml of milk, and 12 g of coffee, 1 cup
        It costs $6.*/

        if (inventory[0] < 200) {
            System.out.println("Sorry, not enough water!");
        } else if (inventory[1] < 100) {
            System.out.println("Sorry, not enough milk!");
        } else if (inventory[2] < 12) {
            System.out.println("Sorry, not enough coffee beans!");
        }  else if (inventory[3] < 1) {
            System.out.println("Sorry, not enough cups!");
        } else {
            System.out.println("I have enough resources, making you a coffee!\n");

            inventory[0] -= 200;
            inventory[1] -= 100;
            inventory[2] -= 12;
            inventory[3] -= 1;
            inventory[4] += 6;
        }
    }

    public static void fill(int[] inventory) {

        System.out.println("Write how many ml of water you want to add:");
        int newWater = s.nextInt();
        System.out.println("Write how many ml of milk you want to add:");
        int newMilk = s.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add: ");
        int newCoffee = s.nextInt();
        System.out.println("Write how many disposable cups of coffee you want to add: ");
        int newCup = s.nextInt();

        inventory[0] = inventory[0] + newWater;
        inventory[1] = inventory[1] + newMilk;
        inventory[2] = inventory[2] + newCoffee;
        inventory[3] = inventory[3] + newCup;
    }

    public static void take(int[] inventory) {

        System.out.println("I gave you $" + inventory[4] + "\n");

        inventory[4] = 0;
    }

    public static void action( int[] inventory) {
        boolean out = false;
        do {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            String action = s.next();
            switch (action) {
                case "buy":
                    System.out.println("What do you want to buy?" +
                            " 1 - espresso, 2 - latte, 3 - cappuccino:");
                    String buy = s.next();

                    switch (buy) {
                        case "1":
                            makeEspresso(inventory);
                            break;
                        case "2":
                            makeLatte(inventory);
                            break;
                        case "3":
                            makeCappuccino(inventory);
                            break;
                        default:
                            System.out.println("There is no such option");
                            break;
                }
                    break;
                case "fill":
                    fill(inventory);
                    break;
                case "take":
                    take(inventory);
                    break;
                case "remaining":
                    System.out.println("The coffee machine has: \n" + inventory[0]  + " ml of water\n" + inventory[1] +
                            " ml of milk\n" + inventory[2] + " g of coffee beans\n" + inventory[3] +
                            " disposable cups\n" + "$" + inventory[4] + " of money\n");
                    break;
                case "exit":
                    out = true;
                    break;
                default:
                    System.out.println("There is no such option");
                    break;
            }
        } while (out == false);
    }
}