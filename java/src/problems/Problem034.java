package problems;

import util.MathUtil;

public class Problem034 implements Problem {
    private static int[] factorials = new int[10];
    private static int[] powers = new int[7];
    static {
        for (int i = 0; i < factorials.length; i++) {
            factorials[i] = (int) MathUtil.factorial(i);
        }
        for (int i = 0; i < powers.length; i++) {
            powers[i] = (int) Math.pow(10, i);
        }
    }
    @Override
    public String solve() {
        int n = 1;
        while (n*MathUtil.factorial(9) > Math.pow(10, n-1)) {
            n++;
        }
        n--;
        long maxNum = MathUtil.factorial(9) * n;
        long sum = 0;
        for (long i = 10; i <= maxNum; i++) {
            long s = sumFactorials(i);
            if (s == i) {
                sum += i;
            } else {
                int diff = (int) (i - sum)/factorials[9];
                int shift = powers[diff];
                i = (i/shift + 1)*shift - 1;
            }
        }
        return "" + sum;
    }
    
    private static long sumFactorials(long i) {
        long sum = 0;
        for (char c : String.valueOf(i).toCharArray()) {
            sum += factorials[(int) (c-'0')];
        }
        return sum;
    }

}
