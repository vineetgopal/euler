package util;

import java.math.BigInteger;
import java.util.Set;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;
import com.google.common.collect.Sets;

public class MathUtil {
    
    /**
     * Returns the sum of all integers between start and last, inclusive.
     * @param start
     * @param last
     * @return
     */
    public static int sum(int start, int last) {
        assert(start >= 0);
        assert(last >= 0);
        if (last < start) {
            return 0;
        }
        return (last * (last+1) / 2) - (start-1)*(start)/2;
    }
    
    /**
     * Returns the greatest common denominator of a and b,
     * for a, b >= 0. 
     * @param a
     * @param b
     * @return
     */
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }
    
    /**
     * Returns the greatest common denominator of a and b,
     * for a, b >= 0. 
     * @param a
     * @param b
     * @return
     */
    public static long gcd(long a, long b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }
    
    /**
     * Returns the least common multiple of a and b,
     * for a, b >= 0 and a*b <= MAX_INT.
     * @param a
     * @param b
     * @return
     */
    public static int lcm(int a, int b) {
        return (a*b) / gcd(a, b);
    }
    
    /**
     * Returns the least common multiple of a and b,
     * for a, b >= 0 and a*b <= MAX_INT.
     * @param a
     * @param b
     * @return
     */
    public static long lcm(long a, long b) {
        return (a*b) / gcd(a, b);
    }
    
    /**
     * Returns the set of prime factors for the given int num.
     * @param num
     * @return
     */
    public static Set<Integer> primeFactors(int num) {
        Set<Integer> factors = Sets.newHashSet();
        while (num % 2 == 0) {
            num /= 2;
            factors.add(2);
        }
        int factor = 3;
        int max = (int) Math.sqrt(num) + 1;
        while (num > 1 && factor <= max) {
            if (num % factor == 0) {
                factors.add(factor);
                num /= factor;
            } else {
                factor += 2;
            }
        }
        if (num != 1) {
            factors.add(num);
        }
        return factors;
    }
    
    /**
     * Returns the set of prime factors for the given long num.
     * @param num
     * @return
     */
    public static Set<Long> primeFactors(long num) {
        Set<Long> factors = Sets.newHashSet();
        while (num % 2 == 0) {
            num /= 2;
            factors.add(2L);
        }
        long factor = 3;
        long max = (int) Math.sqrt(num) + 1;
        while (num > 1 && factor <= max) {
            if (num % factor == 0) {
                factors.add(factor);
                num /= factor;
            } else {
                factor += 2;
            }
        }
        if (num != 1) {
            factors.add(num);
        }
        return factors;
    }
    
    /**
     * Returns the prime factorization for the given int num.
     * @param num
     * @return
     */
    public static Multiset<Integer> primeFactorization(int num) {
        Multiset<Integer> factors = HashMultiset.create();
        while (num % 2 == 0) {
            num /= 2;
            factors.add(2);
        }
        int factor = 3;
        int max = (int) Math.sqrt(num) + 1;
        while (num > 1 && factor <= max) {
            if (num % factor == 0) {
                factors.add(factor);
                num /= factor;
            } else {
                factor += 2;
            }
        }
        if (num != 1) {
            factors.add(num);
        }
        return factors;
    }
    
    /**
     * Returns the set of prime factors for the given long num.
     * @param num
     * @return
     */
    public static Multiset<Long> primeFactorization(long num) {
        Multiset<Long> factors = HashMultiset.create();
        while (num % 2 == 0) {
            num /= 2;
            factors.add(2L);
        }
        long factor = 3;
        long max = (int) Math.sqrt(num) + 1;
        while (num > 1 && factor <= max) {
            if (num % factor == 0) {
                factors.add(factor);
                num /= factor;
            } else {
                factor += 2;
            }
        }
        if (num != 1) {
            factors.add(num);
        }
        return factors;
    }
    
    public static Set<Integer> factors(int num) {
        Set<Integer> factors = Sets.newHashSet();
        int factor = 1;
        int max = (int) Math.sqrt(num) + 1;
        while (factor <= max) {
            if (num % factor == 0) {
                factors.add(factor);
                factors.add(num / factor);
            }
            factor++;
        }
        return factors;
    }
    
    public static int numDivisors(int num) {
        Multiset<Integer> set = primeFactorization(num);
        int numDivisors = 1;
        for (int i : set.elementSet()) {
            numDivisors *= set.count(i) + 1;
        }
        return numDivisors;
    }
    
    public static long numDivisors(long num) {
        Multiset<Long> set = primeFactorization(num);
        long numDivisors = 1;
        for (long i : set.elementSet()) {
            numDivisors *= set.count(i) + 1;
        }
        return numDivisors;
    }
    
    public static Set<Long> factors(long num) {
        Set<Long> factors = Sets.newHashSet();
        long factor = 2;
        long max = (int) Math.sqrt(num) + 1;
        while (factor <= max) {
            if (num % factor == 0) {
                factors.add(factor);
                factors.add(num / factor);
            }
            factor++;
        }
        return factors;
    }
    
    public static boolean isPrime(long num) {
        return new BigInteger("" + num).isProbablePrime(10);
    }
    
    public static boolean[] primeSieve(int max) {
        boolean[] array = new boolean[max+1];
        for (int i = 2; i <= max; i++) {
            array[i] = true;
        }
        for (int i = 2; i <= max / 2; i++) {
            if (array[i]) {
                for (int j = 2*i; j <= max; j+=i) {
                    array[j] = false;
                }
            }
        }
        return array;
    }
    
    public static long choose(int n, int k) {
        double prod = 1;
        k = Math.max(k, n-k);
        for (int i = k + 1, j = n-k; i <= n && j>=1; i++, j--) {
            prod *= i;
            prod /= j;
        }
        return Math.round(prod);
    }
}
