package problems;

import java.util.Map;

import com.google.common.collect.Maps;

public class Problem043 implements Problem {

    @Override
    public void solve() {
        Map<Integer, Integer> divisors = Maps.newHashMap();
        divisors.put(1, 2);
        divisors.put(2, 3);
        divisors.put(3, 5);
        divisors.put(4, 7);
        divisors.put(5, 11);
        divisors.put(6, 13);
        divisors.put(7, 17);
        System.out.println(solve(divisors, 3));
    }
    
    private static long solve(Map<Integer, Integer> divisors, int length) {
        return getSum("", divisors, length, "0123456789");
    }
    
    private static long getSum(String string, Map<Integer, Integer> divisors, int length, String chars) {
        if (!isValid(string, divisors, length)) {
            return 0;
        } else if (chars.length() == 0) {
            return Long.parseLong(string);
        }
        long sum = 0;
        for (int i = 0; i < chars.length(); i++) {
            sum += getSum(string + chars.charAt(i), divisors, length, chars.substring(0,i) + chars.substring(i+1));
        }
        return sum;
    }
    private static boolean isValid(String string, Map<Integer, Integer> divisors, int length) {
        int strLength = string.length();
        for (int ind : divisors.keySet()) {
            if (ind+length <= strLength && Long.parseLong(string.substring(ind, ind+length)) % divisors.get(ind) != 0) {
                return false;
            }
        }
        return true;
    }

}
