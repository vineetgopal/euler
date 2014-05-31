package problems;

public class Problem076 implements Problem {
    @Override
    public String solve() {
        for (int i = 1; i < 20; i++) {
            System.out.println(solve(i));
        }
        return "" + solve(100);
    }
    
    private static long solve(int n) {
        long[] ret = new long[n+1];
        ret[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                ret[j] += ret[j-i];
            }
        }
        return ret[n] - 1;
    }
}
