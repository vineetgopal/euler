package problems;

import util.CollectionsUtil;
import util.MathUtil;

public class Problem003 {
    public static long solve() {
        return solve(600851475143L);
    }
    
    private static long solve(long num) {
        System.out.println(MathUtil.primeFactors(num));
        return CollectionsUtil.maxLong(MathUtil.primeFactors(num));
    }
}
