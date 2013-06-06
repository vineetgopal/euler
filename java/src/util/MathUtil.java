package util;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Lists;
import com.google.common.collect.Multiset;
import com.google.common.collect.Sets;

public class MathUtil {
//    private static int MAX_LOW_PRIME = 1000000;
//    private static final boolean[] LOW_PRIMES = primeSieve(MAX_LOW_PRIME);
//    static {
//        LOW_PRIMES.addAll(CollectionsUtil.getTrueIndices(primeSieve(MAX_LOW_PRIME)));
//        for (int i : CollectionsUtil.getTrueIndices(primeSieve(MAX_LOW_PRIME))) {
//            LOW_PRIMES.add((long) i);
//        }
//    }
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
    
    public static Set<Integer> divisors(int num) {
        Set<Integer> divisors = Sets.newHashSet();
        int factor = 1;
        int max = (int) Math.sqrt(num) + 1;
        while (factor <= max) {
            if (num % factor == 0) {
                divisors.add(factor);
                divisors.add(num / factor);
            }
            factor++;
        }
        return divisors;
    }
    
    public static Set<Integer> properDivisors(int num) {
        Set<Integer> divisors = divisors(num);
        divisors.remove(num);
        return divisors;
    }
    
    public static int numDivisors(int num) {
        if (num < 20000) {
            return divisors(num).size();
        }
        Multiset<Integer> set = primeFactorization(num);
        return numDivisors(set);
    }
    
    public static int numDivisors(Multiset<Integer> primeFactorization) {
        int numDivisors = 1;
        for (int i : primeFactorization.elementSet()) {
            numDivisors *= primeFactorization.count(i) + 1;
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
    
    public static Set<Long> divisors(long num) {
        Set<Long> divisors = Sets.newHashSet();
        long factor = 1;
        long max = (int) Math.sqrt(num) + 1;
        while (factor <= max) {
            if (num % factor == 0) {
                divisors.add(factor);
                divisors.add(num / factor);
            }
            factor++;
        }
        return divisors;
    }
    
    public static Set<Long> properDivisors(long num) {
        Set<Long> divisors = divisors(num);
        divisors.remove(num);
        return divisors;
    }
    
    public static boolean isPrime(int num) {
            return new BigInteger("" + num).isProbablePrime(30);
    }
    
    public static boolean isPrime(long num) {
            return new BigInteger("" + num).isProbablePrime(10);
    }
    
    public static boolean[] primeSieve(int max) {
        boolean[] array = new boolean[max+1];
        Arrays.fill(array, 2,max,true);
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
        for (int i = k + 1, j = n-k; i <= n; i++, j--) {
            prod *= i;
            prod /= j;
        }
        return Math.round(prod);
    }
    
    public static long factorial(long num) {
        long ret = 1;
        for (int i = 2; i <= num; i++) {
            ret *= i;
        }
        return ret;
    }
    
    public static int lengthCycle(int numerator, int denominator) {
        Set<Integer> insides = Sets.newHashSet();
        List<Integer> list = Lists.newArrayList();
        numerator = numerator % denominator;
        int inside = numerator;
        while (inside != 0 && !insides.contains(inside)) {
            insides.add(inside);
            list.add(inside);
            inside *= 10;
            inside = inside - (inside / denominator) * denominator;
        }
        if (inside == 0) {
            return 0;
        }
        return list.size() - list.indexOf(inside);
    }
}
