// HW12
// Jonathan Comer
//This program reads user inputs between 1- 10 and tells the user how many tiems that int was typed and exits with 0

import java.util.Scanner;

public class HW12P2 {
    public static void main(String[] args) {
        // Create a Scanner object for user input
        Scanner input = new Scanner(System.in);

        // sets up array
        int[] userinputs = new int[11];

        System.out.print("Enter the integers between 1 and 10: ");

        int num;
        // Read input until 0 is entered
        do {
            num = input.nextInt();

            // Check if the number is within the valid range
            if (num >= 1 && num <= 10) {
                userinputs[num]++;
            }
        } while (num != 0);

        // Display the results
        for (int i = 1; i <= 10; i++) {
            if (userinputs[i] > 0) {
                // out puts using proper grammar for amount
                String suffix = (userinputs[i] > 1) ? " times" : " time";
                System.out.println(i + " occurs " + userinputs[i] + suffix);
            }
        }

        input.close();
    }
}

