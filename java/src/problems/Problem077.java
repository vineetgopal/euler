package problems;

import java.util.List;

import util.CollectionsUtil;
import util.MathUtil;

public class Problem077 implements Problem {
    
    @Override
    public String solve() {
        return "" + solve(1000);
    }
    
    private static String solve(int ways) {
        int MAX = ways;
        List<Integer> primes = CollectionsUtil.getTrueIndices(MathUtil.primeSieve(MAX));

        int num = 1;
        while (ways(num, num, primes) < 5000) {
            num++;
        }
        return "" + num;
    }
    
    private static int ways(int sum, int max, List<Integer> primes) {
        if (sum < 0) {
            return 0;
        }
        if (sum == 0) {
            return 1;
        }
        int ways = 0;
        for (int i = 0; i < primes.size() && primes.get(i) <= max; i++){
            ways += ways(sum - primes.get(i), primes.get(i), primes);
        }
        return ways;
            
    }

}
