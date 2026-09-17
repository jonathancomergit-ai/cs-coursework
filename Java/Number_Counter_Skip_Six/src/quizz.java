public class quizz {
    public static void main(String[] args) {
        int count = 1;
        while (count < 10) {
            if (count == 6) {
                count++;
                continue;
            }
            System.out.print(count + " ");
            count++;
        }
    }
}
