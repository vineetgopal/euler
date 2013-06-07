package problems;

import java.math.BigInteger;

public class Problem020 implements Problem {

    @Override
    public String solve() {
        return "" + solve(100);
    }
    
    private static int solve(int num) {
        BigInteger ret = BigInteger.ONE;
        for (int i = 2; i <= num; i++) {
            ret = ret.multiply(new BigInteger("" + i));
        }
        int sum = 0;
        for (char c : ret.toString().toCharArray()) {
            sum += Integer.parseInt("" + c);
        }
        return sum;
    }
    
}
