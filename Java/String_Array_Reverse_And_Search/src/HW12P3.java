// HW12
// Jonathan Comer
//This takes strings from the user and stores them in a array. it then displays that array in order reverse order and lets the user search using chars

import java.util.Scanner;

public class HW12P3 {
    public static void main(String[] args) {
        //Create a Scanner object and an array of 10 strings
        Scanner input = new Scanner(System.in);
        String[] strings = new String[10];

        //Read in 10 strings and store them in the array
        System.out.println("Enter 10 strings:");
        for (int i = 0; i < strings.length; i++) {
            System.out.print("String " + (i + 1) + ": ");
            strings[i] = input.nextLine();
        }

        //Display the contents of the array
        System.out.println("\nArray contents in order:");
        for (int i = 0; i < strings.length; i++) {
            System.out.println(strings[i]);
        }

        //display in reverse order
        System.out.println("\nArray contents in reverse order:");
        for (int i = strings.length - 1; i >= 0; i--) {
            System.out.println(strings[i]);
        }

        //Prompt the user for a character and find matching strings
        System.out.print("\nEnter a character to search for: ");
        String s = input.nextLine();
        if (s.length() > 0) {
            char c = s.charAt(0);
            System.out.println("Strings starting with '" + c + "':");

            for (int i = 0; i < strings.length; i++) {
                String str = strings[i];
                if (str.length() > 0 && str.charAt(0) == c) {
                    System.out.println(str);
                }
            }
        }

        input.close();
    }
}