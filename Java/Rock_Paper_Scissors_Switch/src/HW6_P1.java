// HW6P1
// Jonathan Comer
//This program plays rock paper scissors using user input it randomly generates
//a number coralating to 1,2,3 and displays the winner using a switch method

//import scanner
import java.util.Scanner;

public class HW6_P1 {
    public static void main(String[] args) {

        //create scanner object and prompt user there guess
        System.out.println("Welcome to Rock Paper Scissors!");
        System.out.println("(0 = Scissor) (1 = Rock) (2 = Paper)");
        System.out.print("Enter your guess: ");
        Scanner input = new Scanner(System.in);
        int user_guess = input.nextInt();

        //Generate random number
        int computer_guess = (int) (Math.random() * 3);

        //Compare answer and print winner using switch method
        switch (user_guess) {
            case 0:  // user picked scissor
                if (computer_guess == 0) {
                    System.out.println("Tie game!");
                } else if (computer_guess == 2) {
                    System.out.println("Player Wins!");
                } else {
                    System.out.println("Computer Wins!");
                }
                break;
            case 1:  // user picked rock
                if (computer_guess == 1) {
                    System.out.println("Tie game!");
                } else if (computer_guess == 0) {
                    System.out.println("Player Wins!");
                } else {
                    System.out.println("Computer Wins!");
                }
                break;
            case 2:  // user picked paper
                if (computer_guess == 2) {
                    System.out.println("Tie game!");
                } else if (computer_guess == 1) {
                    System.out.println("Player wins!");
                } else {
                    System.out.println("Computer wins!");
                }
                break;
        }
    }
}