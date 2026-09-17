// HW11
// Jonathan Comer
//This program models a Vacation Price Calculator. You are planning a trip to a resort and need to figure
// out how many rooms your group will need, what meal plan each room will utilize,
// and what special activities each room might want to purchase.

import java.util.Scanner;

public class HW11 {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Welcome to Likuliku Lagoon Resort - Malolo Island, Fiji.");

        System.out.print("Please enter number of guests: ");
        int numGuests = scanner.nextInt();

        System.out.print("How many nights will you be staying? ");
        int nights = scanner.nextInt();

        double totalCost = 0;

        for (int guest = 1; guest <= numGuests; guest++) {
            System.out.println("\nStart entering details for guest #" + guest);

            totalCost += calculateRoomCost(nights);
            totalCost += calculateMealPlan(nights);
            totalCost += getActivitiesCost();

        }

        System.out.printf("%nThe total cost estimate $%.2f%n", totalCost);
        displayAverageDailyCost(totalCost, nights, numGuests);
    }


     //Displays room types and prices, reads the user's choice,
     //and returns the total room cost for the given number of nights.

    public static double calculateRoomCost(int nights) {
        System.out.println("1: Standard Room no view $100/night");
        System.out.println("2: Luxury Room with view $200/night");
        System.out.println("3: Luxury Room with Balcony $300/night");
        System.out.print("Please enter your choice: ");
        int choice = scanner.nextInt();

        double pricePerNight;
        switch (choice) {
            case 1:
                pricePerNight = 100;
                break;
            case 2:
                pricePerNight = 200;
                break;
            case 3:
                pricePerNight = 300;
                break;
            default:
                System.out.println("Invalid choice. Defaulting to Standard Room.");
                pricePerNight = 100;
        }

        return pricePerNight * nights;
    }


     //Prompts the user for a daily meal plan and returns
    //the total meal cost for the given number of nights.

    public static double calculateMealPlan(int nights) {
        System.out.println("1: Lunch & Dinner only $65");
        System.out.println("2: 3-Meals a day $150");
        System.out.println("3: 3-Meals a day with drinks $225");
        System.out.println("4: No meal plan $0");
        System.out.print("Please enter your choice: ");
        int choice = scanner.nextInt();

        double pricePerDay;
        switch (choice) {
            case 1:
                pricePerDay = 65;
                break;
            case 2:
                pricePerDay = 150;
                break;
            case 3:
                pricePerDay = 225;
                break;
            case 4:
                pricePerDay = 0;
                break;
            default:
                System.out.println("Invalid choice. Defaulting to No meal plan.");
                pricePerDay = 0;
        }

        return pricePerDay * nights;
    }


     //Loops and allows the user to select one or more activities.
    //Returns the total activities cost for one guest.

    public static double getActivitiesCost() {
        double subtotal = 0;
        int choice = 0;

        while (choice != 6) {
            System.out.println("Choose from these activities");
            System.out.println("1 Scuba Adventure $300");
            System.out.println("2: Island Shopping Hop $100");
            System.out.println("3: Paddle Boarding $125");
            System.out.println("4: Deep Sea Fishing $500");
            System.out.println("5: Beach Sitting $0");
            System.out.println("6: That's all  Done!");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    subtotal += 300;
                    break;
                case 2:
                    subtotal += 100;
                    break;
                case 3:
                    subtotal += 125;
                    break;
                case 4:
                    subtotal += 500;
                    break;
                case 5:
                    subtotal += 0;
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Invalid choice. Please try againj.");
            }
        }

        return subtotal;
    }


     //Displays the average daily cost per person for the trip

    public static void displayAverageDailyCost(double tripTotal, int days, int numGuests) {
        double avgDailyCost = tripTotal / (days * numGuests);
        System.out.printf("The average nightly cost per person is $%.2f.%n", avgDailyCost);
    }
}