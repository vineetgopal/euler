package problems;


public class Problem053 implements Problem {

    @Override
    public void solve() {
        System.out.println(solve(1,100, 1000000));
    }
    
    private static int solve(int minN, int maxN, int limit) {
        int total = 0;
        for (int n = minN; n <= maxN; n++) {
            for (int k = 1; k <= n/2; k++) {
                if (chooseGreaterThan(n, k, limit)) {
                    if (n % 2 == 0) {
                        total += (n/2 - k)*2 + 1; 
                    } else {
                        total += (n/2- k + 1)*2;
                    }
                    break;
                }
            }
        }
        return total;
    }
    
    private static boolean chooseGreaterThan(int n, int k, int limit) {
        double prod = 1;
        k = Math.max(k, n-k);
        for (int i = k + 1, j = n-k; i <= n; i++, j--) {
            prod *= i;
            prod /= j;
            if (prod >= limit) {
                return true;
            }
        }
        return false;
    }

}
