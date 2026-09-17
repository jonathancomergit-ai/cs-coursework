//HW13
//Jonathan Comer
//This program simulates a grocery store giving the user to set up stock, prices and names of stock
//the program then builds a table and lets the user manipulate it and see total invesments and amounts.,

import java.util.Scanner;

public class HW13 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String[] items = new String[5];
        double[] prices = new double[5];
        int[] quantities = new int[5];

        readItems(items, input);
        readPrices(items, prices, input);
        input.nextLine(); // clear scanner buffer after nextDouble
        readQuantities(items, quantities, input);
        input.nextLine(); // clear scanner buffer after nextInt
        displayTable(items, prices, quantities);
        searchItem(items, prices, quantities, input);
        displayTotal(items, prices, quantities);
        displayLowStock(items, quantities);
        reduceInventory(items, prices, quantities, input);
    }

    //Lets user write items to the array items
    public static void readItems(String[] items, Scanner input) {
        for (int i = 0; i < items.length; i++) {
            System.out.print("Enter grocery item: ");
            items[i] = input.nextLine();
        }
    }

    //lets player set price of items in prices array using for loop
    public static void readPrices(String[] items, double[] prices, Scanner input) {
        for (int i = 0; i < items.length; i++) {
            System.out.print("Enter price for " + items[i] + ": ");
            prices[i] = input.nextDouble();
        }
    }

    //lets user set the amount of items in each catigory inside the quantities array using for loop.
    public static void readQuantities(String[] items, int[] quantities, Scanner input) {
        for (int i = 0; i < items.length; i++) {
            System.out.print("Enter current inventory for " + items[i] + ": ");
            quantities[i] = input.nextInt();
        }
    }

    //Displays all arrays in a table formate for ech item
    public static void displayTable(String[] items, double[] prices, int[] quantities) {
        System.out.printf("%n%-10s %-15s %s%n", "Quantity", "Item", "Cost");
        for (int i = 0; i < items.length; i++) {
            System.out.printf("%-10d %-15s %.2f%n", quantities[i], items[i], prices[i]);
        }
    }

    //Lets user search for a items information using its name. displays prices, amount, and item name in table
    public static void searchItem(String[] items, double[] prices, int[] quantities, Scanner input) {
        System.out.print("\nEnter item to display: ");
        String lookupItem = input.nextLine();
        for (int i = 0; i < items.length; i++) {
            if (lookupItem.equals(items[i])) {
                System.out.printf("Item: %s Qty: %d Cost: %.2f%n", items[i], quantities[i], prices[i]);
            }
        }
    }

    //displays the total amount of inventory by * quant and prices set by user in arrays
    public static void displayTotal(String[] items, double[] prices, int[] quantities) {
        double totalInvCost = 0;
        for (int i = 0; i < items.length; i++) {
            totalInvCost = totalInvCost + (prices[i] * quantities[i]);
        }
        System.out.printf("%nThe total investment in inventory is: %.2f%n", totalInvCost);
    }

    //uses a for loop to search for stock below 3 in total. if found prints to consel
    public static void displayLowStock(String[] items, int[] quantities) {
        int lowItemCount = 0;
        System.out.print("\nItems that are low in stock: ");
        for (int i = 0; i < items.length; i++) {
            if (quantities[i] < 3) {
                System.out.println(items[i]);
                lowItemCount++;
            }
        }
        if (lowItemCount == 0) {
            System.out.println("None");
        }
        System.out.printf("There are a total of %d items that are low.%n", lowItemCount);
    }

    // lets the user redouce the amount of a item usings for loop and user input. then writes that data to the table and displays updated table.
    public static void reduceInventory(String[] items, double[] prices, int[] quantities, Scanner input) {
        System.out.print("\nEnter item to reduce inventory: ");
        String itemReduce = input.nextLine();
        System.out.print("Enter quantity to reduce: ");
        int reduceAmount = input.nextInt();

        for (int i = 0; i < items.length; i++) {
            if (itemReduce.equals(items[i])) {
                quantities[i] = quantities[i] - reduceAmount;
                System.out.printf("Reducing %s by %d%n", itemReduce, reduceAmount);
            }
        }
        displayTable(items, prices, quantities);
    }
}