package problems;

import java.util.*;

import util.CollectionsUtil;
import util.MathUtil;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

public class Problem049 implements Problem {

    @Override
    public void solve() {
        Set<Integer> primes = Sets.newHashSet(CollectionsUtil.getTrueIndices(MathUtil.primeSieve(9999)));
        Map<String, TreeSet<Integer>> digits = Maps.newHashMap();
        for (int prime : primes) {
            char[] array = String.valueOf(prime).toCharArray();
            Arrays.sort(array);
            String string = String.copyValueOf(array);
            if (!digits.containsKey(string)) {
                digits.put(string, new TreeSet<Integer>());
            }
            digits.get(string).add(prime);
        }
        for (TreeSet<Integer> set: digits.values()) {
            List<Integer> list = Lists.newArrayList(set);
            for (int i = 0; i < list.size() - 2; i++) {
                for (int j = i+1; j < list.size() - 1; j++) {
                    if (set.contains(2*list.get(j) - list.get(i))) {
                        System.out.println("" + list.get(i) + list.get(j) + (2*list.get(j) - list.get(i)));
                    }
                }
            }
        }
        System.out.println(digits.get("1478"));
    }

}
