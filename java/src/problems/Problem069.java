package problems;

import util.MathUtil;

public class Problem069 implements Problem{

    @Override
    public String solve() {
        return "" + solve(1000000);
    }
    
    private static int solve(int limit) {
        int bestNum = 1;
        for (int i = 2; i*bestNum <= limit; i++) {
            if (MathUtil.isPrime(i)) {
                bestNum *= i;
            }
        }
        return bestNum;
    }

}
