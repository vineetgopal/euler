package problems;

import util.MathUtil;

public class Problem046 implements Problem {

    @Override
    public String solve() {
        for (int i = 3; ; i+=2) {
            if (MathUtil.isPrime(i)) {
                continue;
            }
            int limit = (int) Math.sqrt(i/2);
            boolean works = false;
            for (int j = 1; j <= limit; j++) {
                if (MathUtil.isPrime(i-2*j*j)) {
                    works = true;
                    break;
                }
            }
            if (!works) {
                return "" + i;
            }
        }
    }

}
