



public class Main {
    public static void main(String args) {
        System.out.println(countVowels("hello"));
        System.out.println(countVowels("SKY"));
        System.out.println(countVowels("AEIOU"));
        System.out.println(countVowels(""));
    }
    
    public static int countVowels(String s) {
        int count = 0
        for (int i = 0; i < s.length(); i++) {
            char c = s[i]
            switch (c) {
                case 'a':
                    count++;
                    break;
                case 'e':
                    count++;
                    break;
                case 'i':
                    count++;
                    break;
                case 'o':
                    count++;
                    break;
                case 'u':
                    count++;
                    break;
                default:
                    break;
            }
        }
        return count;
    }
}
