package problems;

import java.util.BitSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import util.CollectionsUtil;
import util.MathUtil;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

public class Problem060 implements Problem {

    @Override
    public void solve() {
        System.out.println(solve(5));
    }
    
    private static int solve(int numPrimes) {
        Map<Integer, Set<Integer>> map = Maps.newHashMap();
        int numDigits = 1;
        while (true) {
            int limit2 = (int) Math.pow(10, numDigits*2);
            int limit = (int) Math.pow(10, numDigits);
            long time = System.currentTimeMillis();
            boolean[] primes = MathUtil.primeSieve(limit2-1);
            List<Integer> list = CollectionsUtil.getTrueIndices(primes, 0, limit);
            Set<Integer> set = Sets.newHashSet(list);
            if (numDigits == 4) {
                System.out.println(System.currentTimeMillis() - time);
            }
            time = System.currentTimeMillis();
            BitSet bitset = MathUtil.primeSieveBitSet(limit2-1);
            list = CollectionsUtil.getTrueIndices(bitset, 0, limit);
            if (numDigits == 4) {
                System.out.println(System.currentTimeMillis() - time);
            }
            for (int prime : set) {
                map.put(prime, Sets.<Integer>newHashSet(prime));
            }
            for (int i = 0; i < list.size(); i++) {
                for (int j = i+1; j < list.size(); j++) {
                    if (isValid(list.get(i), list.get(j), primes)) {
                        map.get(list.get(i)).add(list.get(j));
                        map.get(list.get(j)).add(list.get(i));
                    }
                }
            }
//            System.out.println(System.currentTimeMillis() - time);
            for (int prime : map.keySet()) {
                if (map.get(prime).size() < numPrimes) {
                    continue;
                }
                for (int other : map.get(prime)) {
                    if (map.get(other).size() < numPrimes) {
                        continue;
                    }
                    Set<Integer> intersection = Sets.intersection(map.get(prime), map.get(other));
                    Set<Integer> copy = Sets.newHashSet(intersection);
                    if (intersection.size() >= numPrimes) {
                        for (int p : copy) {
                            intersection = Sets.intersection(map.get(p), intersection);
                            if (intersection.size() < numPrimes) {
                                break;
                            }
                        }
                        if (intersection.size() >= numPrimes) {
//                            System.out.println(intersection);
//                            System.out.println(System.currentTimeMillis() - time);
                            return CollectionsUtil.sum(intersection);
                        }
                    }
                }
            }
            numDigits++;
        }
    }
    
    private static boolean isValid(int one, int two, boolean[] primes) {
        return primes[Integer.parseInt(""+one+two)] && primes[Integer.parseInt(""+two+one)];
    }

}
