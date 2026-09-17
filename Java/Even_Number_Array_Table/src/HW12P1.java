// HW12
// Jonathan Comer
//This program displays a formatted array to the counsel using a for loop for each index

public class HW12P1 {
    public static void main(String[] args) {
        //making array and starting text
        int[] array = {2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24};
        System.out.println("The contents of the array is:");
        System.out.printf("%-10s %-10s%n", "Index", "Value");

        //for loop and print using padding for correct placement
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%-10d %-10d%n", i, array[i]);
        }
    }
}
