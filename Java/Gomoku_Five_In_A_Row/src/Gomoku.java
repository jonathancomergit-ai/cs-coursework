//Jonathan Comer
//CS 1110
//This program will run the game Gomoku allowing to players to play against each other in the counsel

import java.util.Scanner;

public class Gomoku
{
    public static void main(String[] args)
    {
        //setup scanner for user input
        Scanner scanner = new Scanner(System.in);

        //Create the 19x19 board
        char[][] board = new char[19][19];

        //Fill every cell with '.'
        for (int i = 0; i < board.length; i++)
        {
            for (int j = 0; j < board[i].length; j++)
            {
                board[i][j] = '.';
            }
        }

        // Main while loop varible
        boolean running = true;

        //player switcher variable
        int player = 1;

        //main while loop
        while (running)
        {
            //print out board and lines for separation
            System.out.println("-------------------------------------------------------");
            displayBoard(board);
            System.out.println("-------------------------------------------------------");

            //run player placement
            playerPos(board, scanner, player);

            //check if a player has won or if the board is full
            if (hasPlayerWon(board,player))
            {
                displayBoard(board);
                System.out.println("player " + player + " Wins!");
                running = false;
            }
            else if (isBoardFull(board))
            {
                displayBoard(board);
                System.out.println("Its a Draw!");
            }
            else
            {
                //swaps player
                player = 3 - player;
                displayBoard(board);
            }
        }
    }

    //display board method
    public static void displayBoard(char[][] board)
    {
        for (int i = 0; i < board.length; i++)
        {
            for (int j = 0; j < board[i].length; j++)
            {
                //spacing for dots
                System.out.print(board[i][j] + "  ");
            }
            System.out.println();
        }
    }

    //this method handles player type and placement
    public static void playerPos(char[][] board, Scanner scanner, int player)
    {
        System.out.println("Player " + player + "'s Turn!");

        char stone;
        if (player == 1)
            stone = '●';
        else
            stone = '○';

        int row, col;

        do
        {
            System.out.print("Enter row: ");
            int playerRow = scanner.nextInt();

            System.out.print("Enter Column: ");
            int playerCol = scanner.nextInt();

            row = playerRow - 1;
            col = playerCol - 1;

            if (!isValidMove(board, row, col))
            {
                System.out.println("Invalid move! Try again!");
            }
        }
        while (!isValidMove(board, row, col));

        board[row][col] = stone;
    }

    //checker for if a move is valid
    public static boolean isValidMove(char[][] board, int row, int column)
    {

        if (row < 0 || row >= board.length)
            return false;

        if (column < 0 || column >= board[row].length)
            return false;

        if (board[row][column] != '.')
            return false;

        return true;
    }

    //checks if the board is full by looking for '.' if it finds one it returns false
    public static boolean isBoardFull(char[][] board)
    {
        for (int i = 0; i < board.length; i++)
        {
            for (int j = 0; j < board[i].length; j++)
            {
                if (board[i][j] == '.')
                {
                 return false   ;
                }
            }
        }
        return true;
    }

    public static boolean hasPlayerWon(char[][] board, int player)
    {
        return isHorizontalWin(board, player) || isVerticalWin(board, player);
    }

    public static boolean isHorizontalWin(char[][] board, int player)
    {
        char stone;
        if (player == 1)
            stone = '●';
        else
            stone = '○';

        for (int i = 0; i < board.length; i++)
        {
            for (int j = 0; j <= board[i].length - 5; j++)
            {
                if (board[i][j]   == stone &&
                        board[i][j+1] == stone &&
                        board[i][j+2] == stone &&
                        board[i][j+3] == stone &&
                        board[i][j+4] == stone)
                {
                    return true;
                }
            }
        }
        return false;

    }

    public static boolean isVerticalWin(char[][] board, int player)
    {
        char stone;
        if (player == 1)
            stone = '●';
        else
            stone = '○';

        for (int i = 0; i <= board.length - 5; i++)
        {
            for (int j = 0; j < board[i].length; j++)
            {
                if (board[i][j]   == stone &&
                        board[i+1][j] == stone &&
                        board[i+2][j] == stone &&
                        board[i+3][j] == stone &&
                        board[i+4][j] == stone)
                {
                    return true;
                }
            }
        }
        return false;
    }
}