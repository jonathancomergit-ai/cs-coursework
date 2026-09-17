// Jonathan Comer
// This program plays a lottery game where the user enters
// a random 2 integers and the program displays if they match the 2 it generated

//import scanner
import java.util.Scanner;

        public class HW5_P2 {
            public static void main(String[] args) {
                //get both of the users numbers guesses
                System.out.print("Please enter 2 integers: ");
                Scanner input = new Scanner(System.in);
                int guess1 = input.nextInt();
                int guess2 = input.nextInt();

                //generate 2 random numbers
                int number1 = (int) (Math.random() * 10 + 1);
                int number2 = (int) (Math.random() * 10 + 1);

                //compare guess and generated numbers
                //both correct in right order
                if (guess1 == number1 && guess2 == number2) {
                    System.out.println("You got both correct and the correct order!");
                    System.out.println("The Lottery numbers are: " + number1 + " " + number2);
                    //both correct wrong spots
                } else if (guess1 == number2 && guess2 == number1) {
                    System.out.println("You got both correct but the numbers were backwords");
                    System.out.println("The Lottery numbers are: " + number1 + " " + number2);
                    //one correct
                } else if (guess1 == number1 || guess1 == number2 || guess2 == number1 || guess2 == number2) {
                    System.out.println("You got one correct!");
                    System.out.println("The Lottery numbers are: " + number1 + " " + number2);
                    //non correct
                } else {
                    System.out.println("You got no numbers correct");
                    System.out.println("The Lottery numbers are: " + number1 + " " + number2);
                }
            }
        }