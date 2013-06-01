package problems;

import java.math.BigInteger;

public class Problem016 implements Problem {

    @Override
    public void solve() {
        System.out.println(solve(2,1000));
    }
    
    private static int solve(int e, int power) {
        BigInteger num = BigInteger.ONE;
        BigInteger exp = new BigInteger("" + e);
        for (int i = 0; i < power; i++) {
            num = num.multiply(exp);
        }
        int sum = 0;
        for (char c : num.toString().toCharArray()) {
            sum += Integer.parseInt(""+c);
        }
        return sum;
    }
}
