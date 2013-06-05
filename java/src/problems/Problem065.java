package problems;

import java.math.BigInteger;

public class Problem065 implements Problem {

    @Override
    public void solve() {
        System.out.println(solve(2));
    }
    
    private static int solve(int desiredN) {
        if (desiredN == 1) {
            return 2;
        }
        int n = desiredN-2;
        BigInteger numer = new BigInteger("" +seq(n));
        BigInteger denom = BigInteger.ONE;
        while (n > 0) {
            n--;
            BigInteger tmp = numer;
            numer = getNextNumerator(numer, denom, seq(n));
            denom = tmp;
        }
        numer = getNextNumerator(numer, denom, 2);
        int sum = 0;
        String string = numer.toString();
        for (int i = 0; i < string.length(); i++) {
            sum += Character.digit(string.charAt(i), 10);
        }
        return sum;
    }
    
    private static BigInteger getNextNumerator(BigInteger numer, BigInteger denom, int next) {
        return denom.add(numer.multiply(new BigInteger("" + next)));
    }
    
    private static int seq(int n) {
        if (n % 3 == 1) {
             return n / 3 * 2 + 2;
        } else {
            return 1;
        }
    }

}
