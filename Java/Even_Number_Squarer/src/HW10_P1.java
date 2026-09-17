// HW10P1
// Jonathan Comer
//program that will attempt to read 6 integers and print the square of the value,


import java.util.Scanner;

public class HW10_P1 {
    public static void main(String[] args) {
        for (int count = 0; count < 6; count++) {
            Scanner input = new Scanner(System.in);
            System.out.print("Enter a number: ");
            int user_num = input.nextInt();

            if (user_num % 2 == 0) {
                int num_sqrd = user_num * user_num;
                System.out.println("Square is " + num_sqrd);
            } else if (user_num == 99) {
                break;
            }
        }
        System.out.println("ALL DONE!");
    }
}
