package problems;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

import util.CollectionsUtil;
import util.MathUtil;
import util.StringUtil;

import com.google.common.collect.Sets;

public class Problem041 implements Problem {

    @Override
    public void solve() {
        System.out.println(solve(7));
    }
    
    public static int solve(int n) {
        for (; n >= 1; n--) {
            String string = "";
            for (int i = 1; i <= n; i++) {
                string+=i;
            }
            Set<String> strings = StringUtil.permutations(string);
            TreeSet<String> ordered = Sets.newTreeSet(Collections.reverseOrder());
            ordered.addAll(strings);
            for (String s : ordered) {
                if (MathUtil.isPrime(Integer.parseInt(s))) {
                    return Integer.parseInt(s);
                }
            }
        }
        
        return -1;
    }
}
