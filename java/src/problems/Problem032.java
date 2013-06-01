package problems;

import java.util.Set;

import util.CollectionsUtil;

import com.google.common.collect.Sets;

public class Problem032 implements Problem {

    @Override
    public void solve() {
        System.out.println(solveFor9());
    }
    
    private static int solveFor9() {
        Set<Integer> products = Sets.newHashSet();
        for (int i = 10; i <= 99; i++) {
            if (!isPossible(i)) {
                continue;
            }
            for (int j = 100; j <= 999; j++) {
                if (j % 10 != 0 && isValid(i,j)) {
                    products.add(i*j);
                }
            }
        }
        
        for (int i = 1; i <= 9; i++) {
            if (!isPossible(i)) {
                continue;
            }
            for (int j = 1000; j <= 9999; j++) {
                if (isValid(i,j)) {
                    products.add(i*j);
                }
            }
        }
        return CollectionsUtil.sum(products);
    }
    
    private static boolean isPossible(int i) {
        Set<Integer> set = Sets.newHashSet();
        int size = (int) Math.log10(i) + 1;
        while (i > 0) {
            set.add(i % 10);
            i /= 10;
        }
        return set.size() == size && !set.contains(0);
    }
   
    private static boolean isValid(int i, int j) {
        int k = i*j;
        if (!(1000 <= k && k <= 9999)) {
            return false;
        }
        Set<Integer> set = Sets.newHashSet();
        while (i > 0) {
            set.add(i % 10);
            i /= 10;
        }
        while (j > 0) {
            set.add(j % 10);
            j /= 10;
        }
        while (k > 0) {
            set.add(k % 10);
            k /= 10;
        }
        return set.size() == 9 && !set.contains(0);
    }

}
