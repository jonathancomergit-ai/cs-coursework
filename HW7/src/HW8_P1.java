// HW8P1
// Jonathan Comer
//The user will enter a value and then a table will be displayed showing the multiplication facts for that value.

import java.util.Scanner;

public class HW8_P1 {
    public static void main(String[] args) {

        //get user input for chooses num
        System.out.print("Please enter a number: ");
        Scanner input = new Scanner(System.in);
        int user_num = input.nextInt();

        //set up table
        System.out.println("Multiplication table for " + user_num);
        System.out.printf("%-15s %s%n", "Multiplier", "Result");
        System.out.println("-------------------------");

        //perform math calculations and display results
        int count = 1;
        while (count <= 10) {
            int result = count * user_num;
            System.out.printf("%-15d %d%n", count, result);
            count++;

        }
    }
}
