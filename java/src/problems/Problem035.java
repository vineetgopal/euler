package problems;

import java.util.List;
import java.util.Set;

import util.CollectionsUtil;
import util.MathUtil;

import com.google.common.collect.Sets;

public class Problem035 implements Problem {

    @Override
    public String solve() {
        return "" + solve(1000000);
    }

    private static int solve(int limit) {
        List<Integer> list = CollectionsUtil.getTrueIndices(MathUtil.primeSieve(limit-1));
        Set<Integer> primes = Sets.newHashSet(list);
        int count = 0;
        for (int prime : primes) {
            boolean works = true;
            for (int rot : rotations(prime)) {
                if (!primes.contains(rot)) {
                    works = false;
                    break;
                }
            }
            if (works) {
                count++;
            }
        }
        return count;
    }

    private static int[] rotations(int prime) {
        int[] array = new int[(int) Math.log10(prime) + 1];
        int mod = (int) Math.pow(10, array.length - 1);
        for (int i = 0; i < array.length; i++) {
            prime = 10 * (prime % mod) + prime/mod;
            array[i] = prime;
        }
        return array;
    }
}
