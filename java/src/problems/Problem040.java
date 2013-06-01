package problems;

import java.util.List;

import com.google.common.collect.Lists;

public class Problem040 implements Problem {

    @Override
    public void solve() {
        System.out.println(solve(Lists.newArrayList(1, 10, 100, 1000, 10000, 100000, 1000000)));
    }
    
    private static long solve(List<Integer> indices) {
        long product = 1;
        for (int index : indices) {
            product *= getDigit(index);
        }
        return product;
    }
    
    private static int getDigit(int index) {
        index--;
        int digits = 1;
        while (index >= digits * 9 * Math.pow(10, digits - 1)) {
            index -= digits * 9 * Math.pow(10, digits - 1);
            digits++;
        }
        int num = index / digits + (int) Math.pow(10, digits - 1);
        int ch = index % digits;
        return Integer.parseInt("" + String.valueOf(num).charAt(ch));
    }

}
