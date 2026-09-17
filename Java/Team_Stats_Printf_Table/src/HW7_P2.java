// HW7P2
// Jonathan Comer
// This program uses only 3 printf variable to display
//desired statement

public class HW7_P2 {
    public static void main(String[] args) {
        //set up variables no user input
        String team = "Chiefs";
        int week = 4;
        int wins = 1;
        int losses = 2;
        int tie = 0;
        double pct = .333333;

        // print out printf lines to console
        System.out.printf("%s Week %d Statistics\n", team, week);
        System.out.printf("%6s%6s%6s%8s\n", "Wins", "Loss", "Tie", "Pct");
        System.out.printf("%6d%6d%6d%8.3f\n", wins, losses, tie, pct);
    }
}
