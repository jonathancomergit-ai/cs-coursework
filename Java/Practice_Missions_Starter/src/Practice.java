public class Practice {

    // ===== MISSION 1: Temperature Converter =====
    // Convert Celsius to Fahrenheit.  F = c * 9/5 + 32
    // WATCH OUT: 9/5 in integer math equals 1, not 1.8! Use doubles.
    static double celsiusToFahrenheit(double c) {
        // TODO: your code here
        return 0;
    }

    // ===== MISSION 2: Dice Roller =====
    // Return a random whole number from 1 to 6 (inclusive).
    // Hint: Math.random() returns a double in [0.0, 1.0)
    static int rollDice() {
        // TODO: your code here
        return 0;
    }

    // ===== MISSION 3: Initials =====
    // "john fitzgerald kennedy" -> "JFK"
    // Hint: fullName.split(" ") gives you an array of words.
    static String getInitials(String fullName) {
        // TODO: your code here
        return "";
    }

    // ===== MISSION 4: Number Guesser hint =====
    // Return "too high", "too low", or "correct!"
    static String hint(int guess, int secret) {
        // TODO: your code here
        return "";
    }

    // ===== MISSION 5: Countdown =====
    // Print n, n-1, ... down to 1, then print "Blastoff!"
    static void countdown(int n) {
        // TODO: your code here
    }


    // ========================================================
    //  TEST RUNNER  -  run the file and watch your score climb!
    //  You don't need to edit anything below here.
    // ========================================================
    static int passed = 0, total = 0;

    static void check(String label, Object got, Object want) {
        total++;
        boolean ok = (got == null) ? want == null : got.equals(want);
        if (ok) { passed++; System.out.println("  PASS  " + label + "  -> " + got); }
        else    { System.out.println("  FAIL  " + label + "  got: " + got + "   want: " + want); }
    }

    public static void main(String[] args) {
        System.out.println("\n=== MISSION 1: Temperature ===");
        check("celsiusToFahrenheit(0)",   celsiusToFahrenheit(0),   32.0);
        check("celsiusToFahrenheit(100)", celsiusToFahrenheit(100), 212.0);
        check("celsiusToFahrenheit(37)",  celsiusToFahrenheit(37),  98.6);

        System.out.println("\n=== MISSION 2: Dice (rolls 1-6) ===");
        boolean diceOk = true;
        for (int i = 0; i < 1000; i++) {
            int r = rollDice();
            if (r < 1 || r > 6) { diceOk = false; break; }
        }
        check("rollDice() stays in 1..6", diceOk, true);

        System.out.println("\n=== MISSION 3: Initials ===");
        check("getInitials(\"john fitzgerald kennedy\")", getInitials("john fitzgerald kennedy"), "JFK");
        check("getInitials(\"ada lovelace\")",            getInitials("ada lovelace"),            "AL");

        System.out.println("\n=== MISSION 4: Guesser hint ===");
        check("hint(8, 5)", hint(8, 5), "too high");
        check("hint(2, 5)", hint(2, 5), "too low");
        check("hint(5, 5)", hint(5, 5), "correct!");

        System.out.println("\n=== MISSION 5: Countdown (visual) ===");
        countdown(3);

        System.out.println("\n========================================");
        System.out.println("  SCORE: " + passed + " / " + total + " tests passing");
        System.out.println("========================================\n");
    }
}
