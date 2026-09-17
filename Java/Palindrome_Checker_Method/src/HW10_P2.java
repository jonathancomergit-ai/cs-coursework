// HW10P2
// Jonathan Comer
// This program takes user input to see if the 4 digit integer
/// /is a number palindrome this time using a custome method and loop


import java.util.Scanner;

public class HW10_P2 {

    // boolean isPalindrome method
    public static boolean isPalindrome(int x) {
        int ones     = x % 10;
        int tens     = (x / 10) % 10;
        int hundreds = (x / 100) % 10;
        int thousands = x / 1000;

        //checking if number entered is a palindrome with if else
        if (ones == thousands && tens == hundreds) {
            return true;
        } else {
            return false;
        }
    }

    //main loop get user input and run method then print output
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a 4-digit number: ");
        int user_num = input.nextInt();

        //print to console
        if (isPalindrome(user_num)) {
            System.out.println(user_num + " is a palindrome");
        } else {
            System.out.println(user_num + " is NOT a palindrome");
        }
    }
}