import java.math.BigInteger;
import java.math.BigDecimal;
import java.math.MathContext;

public class FibonacciSequence {

    static BigInteger fibBig(int n) {
        BigInteger a = BigInteger.ZERO;
        BigInteger b = BigInteger.ONE;

        for (int i = 0; i < n; i++) {
            BigInteger next = a.add(b);
            a = b;
            b = next;
        }
        return a;
    }

    public static void main(String[] args) {
        int n = 1_000_000;

        System.out.println("Calculating Fibonacci #" + n + "...");
        long startTime = System.currentTimeMillis();

        BigInteger result = fibBig(n);

        long endTime = System.currentTimeMillis();
        System.out.println("Done in " + (endTime - startTime) + "ms");
        System.out.println("Number of digits: " + result.toString().length());

        // Scientific notation
        BigDecimal sci = new BigDecimal(result).round(new MathContext(10));
        System.out.println("Scientific notation: " + sci.toEngineeringString());

        int show = Math.min(1000000, result.toString().length());
        System.out.println("First " + show + " digits: " + result.toString().substring(0, show));
    }
}