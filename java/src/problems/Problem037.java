package problems;

import java.util.Set;

import util.CollectionsUtil;
import util.MathUtil;

import com.google.common.collect.Sets;

public class Problem037 implements Problem {

    @Override
    public String solve() {
        return "" + solve(11);
    }
    
    private static long solve(int num) {
        int count = 0;
        int sum = 0;
        int MAX = 1000000;
        
        // lets do a small prime sieve first, and iterate through primes. 
        // if this doesn't work, then we'll just start at prime = MAX+1, and go up by one each iteration.
        Set<Integer> primes = Sets.newHashSet(CollectionsUtil.getTrueIndices(MathUtil.primeSieve(MAX)));
        for (int prime : primes) {
            if (prime >= 10 && isTruncateable(prime, primes, MAX)) {
                sum += prime;
                count++;
                if (count == num) {
                    return sum;
                }
            }
        }
        
        int prime = MAX+1;
        while (count < num) {
            if (isTruncateable(prime, primes, MAX)) {
                sum += prime;
                count++;
            }
            prime++;
        }
        return sum;
    }
    
    private static boolean isTruncateable(int prime, Set<Integer> primes, int setMax) {
        int copy = prime;
        while (copy > 0) {
            if (!isPrime(copy, primes, setMax)) {
                return false;
            }
            copy /= 10;
        }
        
        copy = prime;
        copy = copy % (int) (Math.pow(10, (int) Math.log10(copy)));
        while (copy > 0) {
            if (!isPrime(copy, primes, setMax)) {
                return false;
            }
            copy = copy % (int) (Math.pow(10, (int) Math.log10(copy)));
        }
        return true;
    }
    
    private static boolean isPrime(int prime, Set<Integer> primes, int setMax) {
        if (setMax >= prime) {
            return primes.contains(prime);
        } else {
            return MathUtil.isPrime(prime);
        }
    }
}
