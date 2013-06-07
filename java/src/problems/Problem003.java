package problems;

import util.CollectionsUtil;
import util.MathUtil;

public class Problem003 implements Problem {
    @Override
    public String solve() {
        return "" + solve(600851475143L);
    }
    
    private static long solve(long num) {
        return CollectionsUtil.maxLong(MathUtil.primeFactors(num));
    }
}
