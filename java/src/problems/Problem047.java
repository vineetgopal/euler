package problems;

import util.MathUtil;

public class Problem047 implements Problem {

    @Override
    public String solve() {
        return "" + solve(4,4);
    }
    
    private static int solve(int consecutive, int divisors) {
        int num = 1;
        int count = 0;
        while (count < consecutive) {
            if (MathUtil.primeFactors(num).size() == divisors) {
                count++;
            } else {
                count = 0;
            }
            num++;
        }
        return num - consecutive;
    }

}
