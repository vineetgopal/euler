package problems;

import java.util.Arrays;

public class Problem031 implements Problem {
    private int[][] dp;
    @Override
    public String solve() {
        int desired = 200;
        int[] values = new int[] {1, 2, 5, 10, 20, 50, 100, 200};
        dp = new int[desired+1][values.length];
        for (int[] array : dp) {
            Arrays.fill(array, -1);
        }
        return "" + solve(desired, values);
    }
    
    private int solve(int desired, int[] values) {
        return possibilities(desired, values, 0);
    }
    
    private int possibilities(int desired, int[] values, int index) {
        if (desired == 0) {
            return 1;
        } else if (desired < 0 || index >= values.length) {
            return 0;
        } else if (dp[desired][index] != -1) {
            return dp[desired][index];
        }
        int ret = possibilities(desired-values[index], values, index) + possibilities(desired, values, index+1);
        dp[desired][index] = ret;
        return ret;
    }

}
