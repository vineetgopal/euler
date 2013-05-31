package problems;

public class Problem002 implements Problem {
    @Override
    public void solve() {
        System.out.println(solve(4000000));
    }
    
    /**
     * Returns the sum of the even-valued terms in the fibonacci sequence, up to and including limit.
     * @param limit
     */
    private static int solve(int limit) {
        int first = 1;
        int second = 1;
        int sum = 0;
        while (first <= limit) {
            if (first % 2 == 0) {
                sum += first;
            }
            int tmp = second;
            second = second + first;
            first = tmp;
        }
        return sum;
    }
}
