// HW8P3
// Jonathan Comer
//program that prompts the user to enter a string and displays the number of vowels and consonants in the string

import java.util.Scanner;

public class HW8_P3 {
    public static void main(String[] args) {
        //get user message
        System.out.print("Enter a string: ");
        Scanner input = new Scanner(System.in);
        String user_message = input.nextLine();

        //prepare variables
        int count = 0;
        int vowel_count = 0;
        int consonants_count = 0;

        //get length of message
        int message_length = user_message.length();

        //perform checks on each char to see if it is a vowel or constant
        while (count < message_length) {
            char currentChar = user_message.charAt(count);
            if (Character.isLetter(currentChar)) {
                char upperChar = Character.toUpperCase(currentChar);
                if (upperChar == 'A' || upperChar == 'E' || upperChar == 'I' || upperChar == 'O' || upperChar == 'U') {
                    vowel_count++;
                } else {
                    consonants_count++;
                }
            }
            count++;
        }
        //print out calulated data
        System.out.println("The number of vowels is " + vowel_count);
        System.out.println("The number of consonants is " + consonants_count);
    }
}
