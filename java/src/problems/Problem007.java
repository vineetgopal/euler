package problems;

import util.MathUtil;

public class Problem007 implements Problem {
    @Override
    public String solve() {
        return "" + solve(10001);
    }
    
    /**
     * Returns the nth prime number, where 
     * @param limit
     * @return
     */
    private static long solve(int n) {
        // upper limit given by wikipedia on the nth prime number
        int upperlimit = (int) Math.max(6, n*(Math.log(n) + Math.log(Math.log(n))) + 1);
        boolean[] primesieve = MathUtil.primeSieve(upperlimit);
        int count = 0;
        for (int i = 0; i < primesieve.length; i++) {
            if (primesieve[i]) {
                count++;
                if (count == n) {
                    return i;
                }
            }
        }
        // if it ever gets here, then the upperlimit is wrong
        return -1;
    }
}
