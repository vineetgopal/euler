package problems;

import java.util.Arrays;
import java.util.List;

import util.CollectionsUtil;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;

public class Problem062 implements Problem {

    @Override
    public void solve() {
        System.out.println(solve(5));
    }
    
    private static long solve(int num) {
        int numDigits = 1;
        while (true) {
            long minLimit = (long) Math.pow(10, numDigits-1);
            long maxLimit = (long) Math.pow(10, numDigits);
            List<Long> list = getCubes(minLimit, maxLimit - 1);
            
            Multimap<String, Long> map = HashMultimap.create();
            for (int i = 0; i < list.size(); i++) {
                char[] array = Long.toString(list.get(i)).toCharArray();
                Arrays.sort(array);
                map.put(String.copyValueOf(array), list.get(i));
            }
            long min = Long.MAX_VALUE;
            for (String string : map.keySet()) {
                if (map.get(string).size() >= num) {
                    min = Math.min(min, CollectionsUtil.minLong(map.get(string)));
                }
            }
            if (min != Long.MAX_VALUE) {
                return min;
            }
            numDigits++;
        }
    }
    
    private static List<Long> getCubes(long min, long max) {
        long n = (long) Math.ceil(Math.pow(min, 1.0/3));
        long c = n*n*n;
        List<Long> list = Lists.newArrayList();
        while (c <= max) {
            list.add(c);
            n++;
            c = n*n*n; 
        }
        return list;
    }

}
