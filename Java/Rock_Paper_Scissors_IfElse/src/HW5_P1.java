// HW5P1
// Jonathan Comer
// This program that plays rock paper scissors, using if else statements

//import scanner
import java.util.Scanner;

public class HW5_P1 {
    public static void main(String[] args) {

        //create scanner object and prompt user there guess
        System.out.println("Welcome to Rock Paper Scissors!");
        System.out.println("(0 = Scissor) (1 = Rock) (2 = Paper)");
        System.out.print("Enter your guess: ");
        Scanner input = new Scanner(System.in);
        int user_guess = input.nextInt();

        //Generate random number
        int computer_guess = (int) (Math.random() * 3);

        //Compare answer and print winner
        if (user_guess == computer_guess) {
            System.out.println("Tie game! " + "Player: " + user_guess + " Computer: " + computer_guess);
        } else if (user_guess == 0 && computer_guess == 2) {
            System.out.println("Player Wins! " + "Player: " + user_guess + " Computer: " + computer_guess);
        } else if (user_guess == 1 && computer_guess == 0) {
            System.out.println("Player Wins! " + "Player: " + user_guess + " Computer: " + computer_guess);
        } else if (user_guess == 2 && computer_guess == 1) {
            System.out.println("Player Wins! " + "Player: " + user_guess + " Computer: " + computer_guess);
        } else {
            System.out.println("Computer Wins! " + "Player: " + user_guess + " Computer: " + computer_guess);
        }
    }
}
