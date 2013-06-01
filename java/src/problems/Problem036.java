package problems;

import java.util.Set;

import util.StringUtil;

public class Problem036 implements Problem {

    @Override
    public void solve() {
        System.out.println(solve(1000000));
    }
    
    private static long solve(int limit) {
        long sum = 0;
        for (int i = 1; i <= Math.log10(limit); i++) {
            Set<String> palindromes = StringUtil.generatePalindromes(StringUtil.DIGITS, i);
            for (String string : palindromes) {
                int val = Integer.parseInt(string);
                if (Integer.toString(val).equals(string) && StringUtil.isPalindrome(Integer.toBinaryString(val))) {
                    sum += val;
                }
            }
        }
        return sum;
    }

}
