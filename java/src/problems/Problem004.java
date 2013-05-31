package problems;

import util.NumberUtil;

public class Problem004 implements Problem {
    @Override
    public void solve() {
        System.out.println(solve(3));
    }
    
    private static long solve(int numDigits) {
        long limit = (long) Math.pow(10, numDigits);
        long max = 0;
        for (long i = 1; i < limit; i++) {
            for (long j = 1; j < limit; j++) {
                if (NumberUtil.isPalindrome(i*j)) {
                    max = Math.max(max, i*j);
                }
            }
        }
        return max;
    }
}
