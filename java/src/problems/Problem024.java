package problems;

import java.util.Arrays;

import util.MathUtil;

public class Problem024 implements Problem {

    @Override
    public String solve() {
        return "" + solve("0123456789".toCharArray(), 1000000);
    }
    
    /**
     * Finds the nth permutation, where the first permutation is 1 indexed.
     * @param chars
     * @param permutation
     * @return
     */
    private static String solve(char[] chars, int permutation) {
        permutation--;
        int numChars = chars.length;
        Arrays.sort(chars);
        String ret = "";
        int last = 0;
        while (ret.length() < numChars) {
            long total = MathUtil.factorial(chars.length);
            int index = (int) ((permutation - last) / (total / chars.length));
            ret += chars[index];
            last += index * (total / chars.length);
            String string = String.copyValueOf(chars).replace("" + chars[index], "");
            chars = string.toCharArray();
        }
        return ret;
    }
    
}
