// HW10P3
// Jonathan Comer
// This program takes user entered string using non normal symbols
// and returns a broken down version using a custome method which is later called

import java.util.Scanner;

public class HW10_P3 {
    public static void dollarCents(String s) {

        //use dotindex to split up dollars and cents and remove unwanted symbols
        int dotIndex = s.indexOf('.');
        String dollars = s.substring(1, dotIndex);
        String cents = s.substring(dotIndex + 1);
        System.out.println("There are " + dollars + " dollars and " + cents + " cents.");
    }

    public static void main(String[] args) {

        //get user information
        Scanner user_input = new Scanner(System.in);
        System.out.print("Please enter a amount: ");
        String input = user_input.next();

        //call custom method
        dollarCents(input);
    }
}
