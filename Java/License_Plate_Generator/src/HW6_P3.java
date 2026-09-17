// HW6P3
// Jonathan Comer
//this program generates a plate number and displays it to the screen.


public class HW6_P3 {
    public static void main(String[] args) {
        //generate 3 random letters for licence plate
        int rand1 = (int)(Math.random() * 26) + 65;
        char letter1 = (char) rand1;

        int rand2 = (int)(Math.random() * 26) + 65;
        char letter2 = (char) rand2;

        int rand3 = (int)(Math.random() * 26) + 65;
        char letter3 = (char) rand3;

        //generate 4 random numbers for licence plate
        int digit1 = (int)(Math.random() * 10);
        int digit2 = (int)(Math.random() * 10);
        int digit3 = (int)(Math.random() * 10);
        int digit4 = (int)(Math.random() * 10);
        //combined them all together and print
        System.out.println("" + letter1 + letter2 + letter3 + digit1 + digit2 + digit3 + digit4);

    }
}
