package problems;

import util.MathUtil;

public class Problem001 implements Problem {
    @Override
    public void solve() {
        System.out.println(solve(3,5,1000));
    }
    
    /**
     * Returns the sum of all multiples of a or b, between 0 and limit exclusive
     * @param a
     * @param b
     * @param limit
     */
    private static int solve(int a, int b, int limit) {
        int sumFirst = a * MathUtil.sum(1, (limit-1)/a);
        int sumSecond = b * MathUtil.sum(1, (limit-1)/b);
        int lcm = MathUtil.lcm(a, b);
        int sumLCM = lcm * MathUtil.sum(1, (limit-1)/lcm);
        return sumFirst + sumSecond - sumLCM;
    }
}
