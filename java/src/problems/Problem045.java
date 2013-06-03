package problems;

public class Problem045 implements Problem {

    @Override
    public void solve() {
        System.out.println(solve(3));
    }
    
    /**
     * Returns the nth number that is triangular, pentagonal, and hexagonal. Uses the fact that 
     * all hexagonal numbers are triangular.
     * @param n
     * @return
     */
    private static long solve(int n) {
        int num = 0;
        int pN = 1;
        int hN = 1;
        while (num < n) {
            long p = getPentagonalNumbers(pN);
            long h = getHexagonalNumbers(hN);
            if (p == h) {
                num++;
                hN++;
                pN++;
            } else {
                if (p > h) {
                    hN++;
                } else {
                    pN++;
                }
            }
        }
        return getPentagonalNumbers(pN-1);
    }
    
    private static long getPentagonalNumbers(long n) {
        return n*(3*n-1)/2;
    }
    
    private static long getHexagonalNumbers(long n) {
        return n*(2*n-1);
    }

}
