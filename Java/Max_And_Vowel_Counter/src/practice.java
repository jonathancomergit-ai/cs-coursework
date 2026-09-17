public class practice {
    //checks which int is larger
    public static int max(int a, int b) {
        if (a > b) {
            return a;
        }
        else {
            return b;
        }
    }

    //checks the lenght of a string
    public static int countVowels(String s) {
        int count = 0;
        String upper = s.toUpperCase();
        String lower = upper.toLowerCase();
        for (int i = 0; i < lower.length(); i++){
            char c = lower.charAt(i);
            switch (c) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    count++;
                    break;
            }
        }
        return count;
    }
    
    //Provides ints to be checked by the other methods
    public static void main(String[] args) {
    System.out.println(countVowels("hello"));      // should print 2
    System.out.println(countVowels("rhythm"));     // should print 0
    System.out.println(countVowels("aeiou"));      // should print 5
    System.out.println(countVowels(""));           // should print 0
    }

}

