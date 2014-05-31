package problems;

import util.MathUtil;

public class Problem075 implements Problem {

    @Override
    public String solve() {
        return "" + solve(1500000);
    }
    
    private static int solve(int max) {
        int n = 1;
        int m = 2;
        int a, b, c;
        int maxM = (int) (Math.sqrt(max) + 1);
        int[] array = new int[max+1];
        while (m <= maxM) {
            n = m % 2 + 1;
            while (n < m) {
                if (MathUtil.gcd(m,n) != 1) {
                    n+=2;
                    continue;
                }
                a = m*m - n*n;
                b = 2*m*n;
                c = m*m + n*n;
                int perimeter = a+b+c;
                if (perimeter > max) {
                    break;
                }
                n+=2;
                int total = perimeter;
                while (total <= max) {
                    array[total]++;
                    total += perimeter;
                }
            }
            m++;
        }
        int count = 0;
        for (int i: array) {
            if (i == 1) {
                count++;
            }
        }
        return count;
    }
}
