package problems;

import util.CollectionsUtil;
import util.MathUtil;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;


public class Problem005 implements Problem {
    @Override
    public String solve() {
        return "" + solve(20);
    }
    
    private static int solve(int limit) {
        Multiset<Integer> factors = HashMultiset.create();
        for (int i = 2; i <= limit; i++) {
            factors = CollectionsUtil.combinedMax(factors, MathUtil.primeFactorization(i));
        }
        int product = 1;
        for (int factor : factors) {
            product *= factor;
        }
        return product;
    }
}
