package problems;

import util.MathUtil;


public class Problem033 implements Problem {

    @Override
    public void solve() {
        System.out.println(solve(10, 99, 99));
    }
    
    private static int solve(int minNum, int maxNum, int maxDen) {
        int totalNumerator = 1;
        int totalDenominator = 1;
        for (int i = 10; i <= maxNum; i++) {
            for (int j = i+1; j <= maxDen; j++) {
                if (i/10 == j % 10) {
                    if (i * (j/10) == (i%10)*j) {
                        totalNumerator *= i;
                        totalDenominator *= j;
                    }
                }
                
                if (i%10 == j / 10) {
                    if (i * (j%10) == (i/10)*j) {
                        totalNumerator *= i;
                        totalDenominator *= j;
                    }
                }
            }
        }
        return totalDenominator / MathUtil.gcd(totalNumerator, totalDenominator);
    }

}
