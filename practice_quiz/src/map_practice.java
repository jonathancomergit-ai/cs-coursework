
import java.util.Scanner;

public class map_practice {
    public static void main(String[] args){

        //prep the map
        char[][] grid = new char[10][10];
        int size = 10;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid[i][j] = '.';
            }
        }

        //prep the player
        int playerRow = 5;
        int playerCol = 5;
        grid[playerRow][playerCol] = 'X';

        //prep the scanner
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("Enter a direction: ");

        while (running) {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    System.out.println(grid[i][j] + "");
                }
                System.out.println();
            }
        }
        

                    

    }
}
