package problems;

import util.MathUtil;

public class Problem053 implements Problem {

    @Override
    public void solve() {
        System.out.println(solve(1,100, 1000000));
    }
    
    private static int solve(int minN, int maxN, int limit) {
        int total = 0;
        for (int n = minN; n <= maxN; n++) {
            for (int k = 1; k <= n/2; k++) {
                if (MathUtil.choose(n, k) >= limit) {
                    if (n % 2 == 0) {
                        total += (n/2 - k)*2 + 1; 
                    } else {
                        total += (n/2- k + 1)*2;
                    }
                    break;
                }
            }
        }
        return total;
    }

}
