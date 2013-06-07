package problems;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import util.CollectionsUtil;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;


public class Problem061 implements Problem {

    @Override
    public String solve() {
        return "" + solve(4,2);
    }
    
    private static int solve(int numDigits, int numDigitsCycle) {
        List<Map<Integer, Set<Integer>>> list = Lists.newArrayList();
        int div = (int) Math.pow(10, numDigits - numDigitsCycle);
        int mod = (int) Math.pow(10, numDigitsCycle);
        int max = (int) Math.pow(10, numDigits);
        int min = (int) Math.pow(10, numDigits-1);
        for (int i = 3 ; i <= 8; i++) {
            Map<Integer, Set<Integer>> map = Maps.newHashMap();
            int n = 1;
            int c = getPolygonalNumber(n, i);
            while (c < max) {
                if (c >= min) {
                    if (!map.containsKey(c)) {
                        map.put(c/div, new HashSet<Integer>());
                    }
                    map.get(c/div).add(c);
                }
                n++;
                c = getPolygonalNumber(n, i);
            }
            list.add(map);
        }
        return CollectionsUtil.sum(solve(list, div, mod));
    }
    
    private static List<Integer> solve(List<Map<Integer, Set<Integer>>> list, int div, int mod) {
        Map<Integer, Set<Integer>> map = list.remove(0);
        for (int key : map.keySet()) {
            for (int num : map.get(key)) {
                List<Integer> ret = solve(list, num, num, div, mod);
                if (ret != null) {
                    ret.add(num);
                    return ret;
                }
            }
        }
        return null;
    }
    
    private static List<Integer> solve(List<Map<Integer, Set<Integer>>> list, int desired, int previous, int div, int mod) {
        if (list.size() == 1) {
            if (list.get(0).containsKey(previous %div)) {
                for (int num : list.get(0).get(previous % div)) {
                    if (num % mod == desired / div) {
                        return Lists.newArrayList(num);
                    }
                }
            }
            return null;
        } else {
            for (int i = 0; i < list.size(); i++) {
                Map<Integer, Set<Integer>> map = list.get(i);
                if (!map.containsKey(previous % mod)) {
                    continue;
                } else {
                    list.remove(i);
                    for (int num : map.get(previous % mod)) {
                        List<Integer> ret = solve(list, desired, num, div, mod);
                        if (ret != null) {
                            ret.add(num);
                            return ret;
                        }
                    }
                    list.add(i, map);
                }
            }
            return null;
        }
    }
    
    private static int getPolygonalNumber(int n, int type) {
        switch(type) {
        case 3: return n*(n+1)/2;
        case 4: return n*n;
        case 5: return n*(3*n-1)/2;
        case 6: return n*(2*n-1);
        case 7: return n*(5*n-3)/2;
        case 8: return n*(3*n-2);
        default: throw new RuntimeException("Unexpected polygonal type");
        }
    }

}
