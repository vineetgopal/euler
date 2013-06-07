package problems;

import java.util.Arrays;

public class Problem052 implements Problem {

    @Override
    public String solve() {
        return "" + solve(6);
    }
    
    private static int solve(int maxMultiply) {
        int numDigits = 1;
        while (true) {
            int min = (int) Math.pow(10, numDigits - 1);
            int max = (int) Math.pow(10, numDigits);
            max /= maxMultiply;
            for (int num = min; num < max; num++) {
                char[] array = Integer.toString(num).toCharArray();
                Arrays.sort(array);
                boolean equals = true;
                for (int mul = 2; mul <= maxMultiply; mul++) {
                    char[] arr2 = Integer.toString(num*mul).toCharArray();
                    Arrays.sort(arr2);
                    if (!Arrays.equals(array, arr2)) {
                        equals = false;
                        break;
                    }
                }
                if (equals) {
                    return num;
                }
            }
            numDigits++;
        }
    }

}
