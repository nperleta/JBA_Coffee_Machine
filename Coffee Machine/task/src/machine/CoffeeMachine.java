package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Starting to make a coffee\n" + "Grinding coffee beans\n" +
                "Boiling water\n" + "Mixing boiled water with crushed coffee beans\n" +
                "Pouring coffee into the cup\n" + "Pouring some milk into the cup\n" +
                "Coffee is ready!\n");

        /*System.out.println("Write how many cups of coffee you will need:");
        int br1 = scanner.nextInt();

        System.out.println("For " + br1 + " cups of coffee you will need:\n" +
                200 * br1 + " ml of water\n" + 50 * br1 + " ml of milk\n" +
                15 * br1 + " g of coffee beans\n");*/

        System.out.println("Write how many ml of water the coffee machine has: ");
        int voda = scanner.nextInt();
        System.out.println("Write how many ml of milk the coffee machine has: ");
        int mlijeko = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans the coffee machine has: ");
        int kava = scanner.nextInt();
        System.out.println("Write how many cups of coffee you will need: ");
        int br = scanner.nextInt();

        int vodaSalica = 200, mlijekoSalica = 50, kavaSalica = 15;

        // trazeni broj salica
        int[] treba = new int[3];
        treba[0] = br * vodaSalica;
        treba[1] = br * mlijekoSalica;
        treba[2] = br * kavaSalica;

        // salica koliko moze napraviti
        int[] max = new int[3];
        max[0] = voda / vodaSalica;
        max[1] = mlijeko / mlijekoSalica;
        max[2] = kava / kavaSalica;

        int N = Math.min(Math.min(max[0],max[1]),max[2] );

        // visak salica
        int[] visak = new int[3];
        visak[0] = max[0] - br;
        visak[1] = max[1] - br;
        visak[2] = max[2] - br;

        int M = Math.min(Math.min(visak[0],visak[1]),visak[2]);

        String n = null;

        if (treba[0] > voda || treba[1] > mlijeko || treba[2] > kava) {
            n = "No, I can make only " + N + " cup(s) of coffee";
        } else if (treba[0] == voda && treba[1] == mlijeko && treba[2] == kava) {
            n = "Yes, I can make that amount of coffee";
        } else if (treba[0] < voda && treba[1] < mlijeko && treba[2] < kava) {
            if (M >= 1) {
                n = "Yes, I can make that amount of coffee (and even " + M + " more than that)";
            } else if (M == 0) {
                n = "Yes, I can make that amount of coffee";
            }
        }
        System.out.println(n);
    }
}