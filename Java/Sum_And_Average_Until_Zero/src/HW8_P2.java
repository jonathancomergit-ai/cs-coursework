// HW8P2
// Jonathan Comer
//program that reads integers greater than zero and displays the average and sum of the numbers entered. The program will continue to prompt for numbers until the user enters a 0, to indicate termination of input.

import java.util.Scanner;

public class HW8_P2 {
    public static void main(String[] args) {

        //prepare variables
        int terminate = 1;
        double final_num = 0;
        int count = 0;

        //while loop with if statement for int gathering and stop when 0 is entered
        while (terminate == 1) {
            System.out.print("Please enter a value and terminate with 0: ");
            Scanner input = new Scanner(System.in);
            double user_num = input.nextDouble();
            if (user_num == 0) {
                terminate = (terminate - 1);
            } else {
                final_num = final_num + user_num;
                count++;
            }

        }
        //calculate avg and display to counsel
        double avg = final_num / count;
        System.out.println("The sum is " + final_num);
        System.out.println("The average is " + avg);

    }
}
