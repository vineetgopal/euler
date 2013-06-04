package problems;

import java.math.BigInteger;

import util.StringUtil;

public class Problem056 implements Problem {

    @Override
    public void solve() {
        System.out.println(solve(1,100,1,100));
    }
    
    private static int solve(int minA, int maxA, int minB, int maxB) {
        int maxSum = 0;
        for (int a = minA; a < maxA; a++) {
            BigInteger num = BigInteger.ONE;
            BigInteger mult = new BigInteger("" + a);
            for (int b = minB; b < maxB; b++) {
                num = num.multiply(mult);
                int sum = StringUtil.sumDigits(num.toString());
                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }

}
