package problems;

import util.MathUtil;

public class Problem072 implements Problem {

    @Override
    public String solve() {
        return "" + solve(1000000);
    }
    
    private static long solve(int max) {
        long sum = 0;
        for (int i = 2; i <= max; i++) {
            sum += MathUtil.phi(i);
        }
        return sum;
    }
    
}
