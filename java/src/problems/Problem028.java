package problems;

public class Problem028 implements Problem {

    @Override
    public String solve() {
        return "" + solve(1001);
    }
    
    private static long solve(int dimension) {
        long sum = 1;
        for (int i = 3; i <= dimension; i+=2) {
            sum += (4*i*i - 6 * (i-1));
        }
        return sum;
    }

}
