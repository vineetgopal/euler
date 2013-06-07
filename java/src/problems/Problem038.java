package problems;

import java.util.Set;

import util.StringUtil;

import com.google.common.collect.Sets;

public class Problem038 implements Problem {

    @Override
    public String solve() {
        Set<Character> desired = StringUtil.DIGITS;
        desired.remove('0');
        return "" + solve(desired);
    }
    
    public static long solve(Set<Character> desired) {
        int num = 1;
        long maxNum = 0;
        while (num < 1e5) {
            String s = "";
            int n = 1;
            while (s.length() < desired.size()) {
                s += n*num;
                n++;
            }
            num++;
            if (s.length() != desired.size()) {
                continue;
            }
            Set<Character> set = Sets.newHashSet();
            for (char c: s.toCharArray()) {
                set.add(c);
            }
            if (set.equals(desired)) {
                maxNum = Math.max(Integer.parseInt(s), maxNum);
            }
        }
        return maxNum;
    }

}
