package problems;

public class Problem071 implements Problem {

    @Override
    public String solve() {
        return "" + solve(1000000, 3, 7);
    }
    
    public static int solve(int max, int numerator, int denominator) {
        int bestNumerator = 0;
        int bestDenominator = 1;
        for (int i = 1; i <= max; i++) {
            if (i % denominator == 0) {
                continue;
            }
            int testNumerator = i * numerator / denominator;
            if (testNumerator * bestDenominator > bestNumerator * i) {
                bestNumerator = testNumerator;
                bestDenominator = i;
            }
        }
        return bestNumerator;
    }
}
