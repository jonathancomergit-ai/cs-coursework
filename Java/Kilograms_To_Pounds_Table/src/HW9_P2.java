// HW9P2
// Jonathan Comer
//This program displays a table of kilograms to pounts using a for loop


public class HW9_P2 {
    public static void main(String[] args) {

        //set up table
        System.out.printf("%-10s %s%n", "Kilograms", "Pounds");
        System.out.println("-----------------");

        //perform for loop and calulations
        for (int i = 1; i <= 19; i++) {
            int kilograms = i;
            double pounds = kilograms * 2.2;
            System.out.printf("%-10d %.1f%n", kilograms, pounds);

        }
    }
}
