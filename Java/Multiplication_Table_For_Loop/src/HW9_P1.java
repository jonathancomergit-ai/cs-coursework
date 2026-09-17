// HW9P1
// Jonathan Comer
//The user will enter a value and then a table will be displayed showing the multiplication facts for that value. using a for loop

import java.util.Scanner;

public class HW9_P1 {
    public static void main(String[] args) {

        //get user input for chooses num
        System.out.print("Please enter a number: ");
        Scanner input = new Scanner(System.in);
        int user_num = input.nextInt();

        //set up table
        System.out.println("Multiplication table for " + user_num);
        System.out.printf("%-15s %s%n", "Multiplier", "Result");
        System.out.println("-------------------------");

        //perform math calculations and display results using for loop
        for (int i = 1; i <= 10; i++) {
            int result = i * user_num;
            System.out.printf("%-15d %d%n", i, result);
        }
    }
}