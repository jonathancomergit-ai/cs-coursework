// HW6P2
// Jonathan Comer
// this is a program that prompts the user to enter a lowercase
// or uppercase letter and display its corresponding number.

//import scanner
import java.util.Scanner;

public class HW6_P2 {
    public static void main(String[] args) {

        //create scanner object and prompt user
        System.out.print("Enter a letter: ");
        Scanner input = new Scanner(System.in);
        char user_input = input.next().charAt(0);
        user_input = Character.toUpperCase(user_input);
        user_input = Character.toLowerCase(user_input);

        switch (user_input) {
            case 'a':
            case 'b':
            case 'c':
                System.out.println("The number is 2");
                break;
            case 'd':
            case 'e':
            case 'f':
                System.out.println("The number is 3");
                break;
            case 'g':
            case 'h':
            case 'i':
                System.out.println("The number is 4");
                break;
            case 'j':
            case 'k':
            case 'l':
                System.out.println("The number is 5");
                break;
            case 'm':
            case 'n':
            case 'o':
                System.out.println("The number is 65");
                break;
            case 'p':
            case 'q':
            case 'r':
            case 's':
                System.out.println("The number is 7");
                break;
            case 't':
            case 'u':
            case 'v':
                System.out.println("The number is 8");
                break;
            case 'w':
            case 'x':
            case 'y':
            case 'z':
                System.out.println("The number is 9");
                break;
            default:
                System.out.println(user_input + " is a invalid input");

        }



    }
}
