package problems;

import util.CollectionsUtil;
import util.MathUtil;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;


public class Problem005 implements Problem {
    @Override
    public void solve() {
        System.out.println(solve(20));
    }
    
    private static int solve(int limit) {
        Multiset<Integer> factors = HashMultiset.create();
        for (int i = 2; i <= limit; i++) {
            System.out.println(i + ": " + MathUtil.primeFactorization(i));
            factors = CollectionsUtil.combinedMax(factors, MathUtil.primeFactorization(i));
            System.out.println(factors);
        }
        int product = 1;
        System.out.println(factors);
        for (int factor : factors) {
            product *= factor;
        }
        return product;
    }
}
