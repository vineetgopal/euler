package problems;

import java.util.List;

import util.CollectionsUtil;
import util.MathUtil;

public class Problem027 implements Problem {

    @Override
    public void solve() {
        System.out.println(solve(1000,1000));
    }
    
    private static int solve(int maxA, int maxB) {
        int maxNumPrimes = 0;
        int maxNum = 0;
        maxA = maxA % 2 == 0? maxA - 1: maxA;
        List<Integer> primes = CollectionsUtil.getTrueIndices(MathUtil.primeSieve(maxB));
        boolean[] primesieve = MathUtil.primeSieve(maxB*maxB + maxA*maxB + maxB);
        // b has to be a prime, since n^2 +an +b = b for n=0
        // a has to be odd, since n^2+an+b = a+b+1 for n = 0
        // a has to be >= -b since n^2 +an + b = (-b) + b + 1 = 1 for n = 1
        
        for (int b : primes) {
            for (int a = Math.max(-b, -maxA); a <= maxA; a+=2) {
                int numPrimes = numPrimes(a,b, primesieve);
                if (numPrimes > maxNumPrimes) {
                    maxNumPrimes = numPrimes;
                    maxNum = a*b;
                }
            }
        }
        return maxNum;
    }
    
    /**
     * The primesieve has to have length >= b*b+a*b+b.
     * @param a
     * @param b
     * @param primesieve
     * @return
     */
    private static int numPrimes(int a, int b, boolean[] primesieve) {
        int n = 0;
        int s = n*n+a*n+b;
        while (s>=0 && primesieve[n*n + a*n + b]) {
            n++;
            s = n*n+a*n+b;
        }
        return n+1;
    }

}
