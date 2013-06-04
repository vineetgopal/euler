package problems;

import java.math.BigInteger;

public class Problem057 implements Problem {

    @Override
    public void solve() {
        System.out.println(solve(1000));
    }
    
    private static int solve(int numExpansions) {
        BigInteger num = new BigInteger("3");
        BigInteger den = new BigInteger("2");
        BigInteger TWO = new BigInteger("2");
        int count = 0;
        for (int i = 1; i <= numExpansions; i++) {
            if (num.toString().length() > den.toString().length()) {
                count++;
            }
            num = num.add(den.multiply(TWO));
            den = num.subtract(den);
        }
        return count;
    }

}
