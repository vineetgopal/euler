package problems;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import util.CollectionsUtil;
import util.MathUtil;

public class Problem070 implements Problem {

    @Override
    public String solve() {
        return "" + solve(10000000);
    }

    private static int solve(int max) {
        double bestRatio = Double.MAX_VALUE;
        int bestNum = 0;
        System.out.println(System.currentTimeMillis());
        List<Integer> primes = CollectionsUtil.getTrueIndices(MathUtil.primeSieve(max));
        System.out.println(System.currentTimeMillis());
        System.out.println(primes.size());
        int limit = (int) Math.sqrt(max) + 1;
        for (int i = 1; i < primes.size(); i++) {
            if (primes.get(i) > limit) {
                break;
            }
            for (int j = i + 1; j < primes.size(); j++) {
                int n = primes.get(i)*primes.get(j);
                if (n > max) {
                    break;
                }
                int phi = n;
                phi -= phi/primes.get(i);
                phi -= phi/primes.get(j);
                if (isValid(n, phi) && n*1.0/phi < bestRatio) {
                    bestRatio = n*1.0/phi;
                    bestNum = n;
                }
            }
        }
        System.out.println(System.currentTimeMillis());
        return bestNum;
//        for (int numPrimes = 1; numPrimes <= primes.size(); numPrimes++) {
//            Set<Set<Integer>> combinations = CollectionsUtil.combinations(
//                    primes, numPrimes);
//            System.out.println(numPrimes);
//            for (Set<Integer> set : combinations) {
//                int n = 1;
//                for (int num : set) {
//                    n *= num;
//                }
//                int phi = n;
//                for (int num : set) {
//                    phi -= phi / num;
//                }
//                double ratio = n * 1.0 / phi;
//                if (ratio < bestRatio) {
//                    char[] arr1 = Integer.toString(n).toCharArray();
//                    char[] arr2 = Integer.toString(phi).toCharArray();
//                    Arrays.sort(arr1);
//                    Arrays.sort(arr2);
//                    if (Arrays.equals(arr1, arr2)) {
//                        bestRatio = ratio;
//                        bestNum = n;
//                    }
//                }
//            }
//            System.out.println(numPrimes);
//            if (bestNum != 0) {
//                return bestNum;
//            }
//        }
//        // for (int i = 2; i <= max; i++) {
//        // Set<Integer> divisors = MathUtil.primeFactors(i);
//        // int phi = i;
//        // for (int num : divisors) {
//        // phi -= phi/num;
//        // }
//        // if (i*1.0/phi < bestRatio) {
//        // char[] arr1 = Integer.toString(i).toCharArray();
//        // char[] arr2 = Integer.toString(phi).toCharArray();
//        // Arrays.sort(arr1);
//        // Arrays.sort(arr2);
//        // if (Arrays.equals(arr1, arr2)) {
//        // // System.out.println(i + " " + phi);
//        // bestRatio = i*1.0/phi;
//        // bestNum = i;
//        // }
//        // }
//        // // System.out.println(i + ": " + phi);
//        // }
//        return bestNum;
    }

    private static boolean isValid(int n, int phi) {
        char[] arr1 = Integer.toString(n).toCharArray();
        char[] arr2 = Integer.toString(phi).toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        return Arrays.equals(arr1, arr2);
    }

    private static int phi(int n) {
        Set<Integer> divisors = MathUtil.primeFactors(n);
        int phi = n;
        for (int num : divisors) {
            phi -= phi / num;
        }
        return phi;
    }

}
