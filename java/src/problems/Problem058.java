package problems;

import util.MathUtil;

public class Problem058 implements Problem{

    @Override
    public void solve() {
        System.out.println(solve(0.1));
    }
    
    private static long solve(double desired) {
        int primes = 0;
        double percent = 1;
        long n = 3;
        for (; percent >= desired; n+=2) {
            long square = n*n;
            long m = n-1;
            if (MathUtil.isPrime(square-m)) {
                primes++;
            }
            if (MathUtil.isPrime(square-2*m)) {
                primes++;
            }
            if (MathUtil.isPrime(square-3*m)) {
                primes++;
            }
            percent = primes * 1.0 / (1 + n/2 * 4);
        }
        return n-2;
    }
    
}
