package problems;

import util.MathUtil;

public class Problem026 implements Problem {

    @Override
    public void solve() {
        System.out.println(solve(1, 1000));
    }
    
    private static int solve(int min, int max) {
        int longestCycle = 0;
        int longestNum = 0;
        for (int denominator = min; denominator <= max; denominator++) {
            int length = MathUtil.lengthCycle(1, denominator);
            if (length > longestCycle) {
                longestCycle = length;
                longestNum = denominator;
            }
        }
        return longestNum;
    }

}
