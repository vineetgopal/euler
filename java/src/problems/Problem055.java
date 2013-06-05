package problems;

import java.math.BigInteger;

import util.StringUtil;

public class Problem055 implements Problem {

    @Override
    public void solve() {
        System.out.println(solve(10000, 50));
    }
    
    private static int solve(int limit, int maxIter) {
        int total = 0;
        for (int i = 1; i < limit; i++) {
            int count = getCount(i, maxIter);
            if (count == maxIter) {
                total++;
            }
        }
        return total;
    }
    
    private static int getCount(long num, int maxIter) {
        int count = 0;
        num = num + Long.parseLong(StringUtil.reverse(Long.toString(num)));
        while (num < Long.MAX_VALUE / 10 && !StringUtil.isPalindrome(Long.toString(num)) && count < maxIter) {
            num = num + Long.parseLong(StringUtil.reverse(Long.toString(num)));
            count++;
        }
        if (StringUtil.isPalindrome(Long.toString(num)) || count == maxIter) {
            return count;
        } else {
            return count + getCount(new BigInteger("" + num), maxIter - count);
        }
    }
    
    private static int getCount(BigInteger num, int maxIter) {
        num = num.add(new BigInteger(StringUtil.reverse(num.toString())));
        int count = 0;
        while (!StringUtil.isPalindrome(num.toString()) && count < maxIter) {
            num = num.add(new BigInteger(StringUtil.reverse(num.toString())));
            count++;
        }
        return count;
    }

}