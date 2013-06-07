package problems;

public class Problem006 implements Problem {
    @Override
    public String solve() {
        return "" + solve(100);
    }
    
    private static long solve(long limit) {
        long sumOfSquares = (2 * limit * limit * limit + 3 * limit * limit + limit) / 6;
        
        long sum = limit * (limit + 1) / 2;
        long squareAfterSum = sum * sum;
        return squareAfterSum - sumOfSquares;
    }
}
