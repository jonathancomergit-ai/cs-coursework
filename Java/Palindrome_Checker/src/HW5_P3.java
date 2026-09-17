// HW5P3
// Jonathan Comer
// This program takes user input to see if the 4 digit integer
//is a number palindrome

//import scanner
import java.util.Scanner;

public class HW5_P3 {
    public static void main(String[] args) {
        //get users 4 digit number
        System.out.print("Please enter a 4 digit number: ");
        Scanner input = new Scanner(System.in);
        int user_number = input.nextInt();

        //take users number and get each digit
        int ones = user_number % 10;
        int tens = (user_number / 10) % 10;
        int hundreds = (user_number / 100) % 10;
        int thousands = user_number / 1000;

        //compare digits to see if it is a palindrome and prints if it is or isnt
        if (ones == thousands && tens == hundreds) {
            System.out.println("Your number is a palindrome");
        } else {
            System.out.println("Your number is not a palindrome");
        }


    }
}
