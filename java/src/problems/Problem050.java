package problems;

import java.util.List;
import java.util.Set;

import util.CollectionsUtil;
import util.MathUtil;

import com.google.common.collect.Sets;

public class Problem050 implements Problem {

    @Override
    public String solve() {
        return "" + solve(1000000);
    }
    
    private static long solve(int max) {
        List<Integer> primes = CollectionsUtil.getTrueIndices(MathUtil.primeSieve(max));
        Set<Integer> set = Sets.newHashSet(primes);
        int maxLength = 0;
        int maxNum = 0;
        int sum = 0;
        int remember = 0;
        for (int i = 0; i < primes.size(); i++) {
            if (i != 0) {
                sum = remember - primes.get(i-1) + primes.get(i+maxLength - 1);
            }
            if (maxLength * primes.get(i) > max) {
                break;
            }
            remember = sum;
            if (set.contains(sum)) {
                maxNum = sum;
            }
            for (int j = i + maxLength; j < primes.size(); j++) {
                sum += primes.get(j);
                if (sum > max) {
                    break;
                } else if (set.contains(sum) && j-i+1 >= maxLength) {
                    maxNum = sum;
                    maxLength = j-i+1;
                }
                
                if (j-i+1 == maxLength) {
                    remember = sum;
                }
            }
        }
        return maxNum;
    }

}
