package problems;

import util.CollectionsUtil;
import util.MathUtil;

public class Problem021 implements Problem {

    @Override
    public void solve() {
        System.out.println(solve(10000));
    }
    
    private static int solve(int max) {
        int[] divisors = new int[max];
        for (int i = 1; i < max; i++) {
            divisors[i] = CollectionsUtil.sum(MathUtil.properDivisors(i));
        }
        int sum = 0;
        for (int i = 1; i < max; i++) {
            if (divisors[i] < max && divisors[divisors[i]] == i && divisors[i] != i) {
                sum += i;
            }
        }
        return sum;
    }
    
}
