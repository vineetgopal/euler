package problems;

import java.math.BigInteger;

import util.StringUtil;

public class Problem055 implements Problem {

    @Override
    public String solve() {
        return "" + solve(10000, 50);
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
        num = num + StringUtil.reverse(num);
        long reverse = StringUtil.reverse(num);
        while (num < Long.MAX_VALUE / 10 && num != reverse && count < maxIter) {
            num = num + reverse;
            reverse = StringUtil.reverse(num);
            count++;
        }
        if (reverse == num || count == maxIter) {
            return count;
        } else {
            return count + getCount(new BigInteger("" + num), maxIter - count);
        }
    }
    
    private static int getCount(BigInteger num, int maxIter) {
        num = num.add(new BigInteger(StringUtil.reverse(num.toString())));
        int count = 0;
        BigInteger reverse = new BigInteger(StringUtil.reverse(num.toString()));
        while (!num.equals(reverse) && count < maxIter) {
            num = num.add(reverse);
            reverse = new BigInteger(StringUtil.reverse(num.toString()));
            count++;
        }
        return count;
    }

}
