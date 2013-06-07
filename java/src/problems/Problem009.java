package problems;

public class Problem009 implements Problem{

    @Override
    public String solve() {
        return "" + solve(1000);
    }
    
    private static long solve(int sum) {
        for (int a = 1; a < sum / 3; a++) {
            for (int b = a+1; b < 500; b++) {
                int c = 1000 - a - b;
                if (c*c == a*a + b*b) {
                    return a*b*c;
                }
            }
        }
        return -1;
    }
}
