package problems;

import util.MathUtil;

public class Problem010 implements Problem {

    @Override
    public void solve() {
        System.out.println(solve(2000000));
    }
    
    private static long solve(int max) {
        boolean[] array = MathUtil.primeSieve(max-1);
        long sum = 0;
        for (int i = 2; i < max; i++) {
            if (array[i]) {
                sum += i;
            }
        }
        return sum;
    }

}
