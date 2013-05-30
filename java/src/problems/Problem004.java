package problems;

import util.NumberUtil;

public class Problem004 {
    public static long solve() {
        return solve(3);
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
