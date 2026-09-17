// HW7P1
// Jonathan Comer
// This program takes user entered string using non normal symbols
// and returns a broken down version

import java.util.Scanner;

public class HW7_P1 {
    public static void main(String[] args) {

        //get user information
        Scanner user_input = new Scanner(System.in);
        System.out.print("Please enter a amount: ");
        String input = user_input.next();

        //use dotindex to split up dollars and cents and remove unwanted symbols
        int dotIndex = input.indexOf('.');
        String dollars = input.substring(1, dotIndex);
        String cents = input.substring(dotIndex + 1);

        //print line to counsel for user
        System.out.println("There are " + dollars + " and " + cents + " cents.");
    }
}
