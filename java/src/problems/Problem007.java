package problems;

import util.MathUtil;

public class Problem007 {
    public static long solve() {
        return solve(10001);
    }
    
    /**
     * Returns the nth prime number, where 
     * @param limit
     * @return
     */
    private static long solve(int n) {
        int count = 1;
        int val = 3;
        while (count < n) {
            if (MathUtil.isPrime(val)) {
                count++;
            }
            val += 2;
        }
        return val - 2;
    }
}