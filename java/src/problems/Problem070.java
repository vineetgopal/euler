package problems;

import java.util.Arrays;
import java.util.List;

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
        List<Integer> primes = CollectionsUtil.getTrueIndices(MathUtil.primeSieve(max));
        int limit = (int) Math.sqrt(max) + 1;
        for (int i = primes.size() - 1; i >= 0; i--) {
            if (primes.get(i) > limit) {
                continue;
            }
            if ((1 - 1.0 / primes.get(i)) < 1/bestRatio) {
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
        return bestNum;
    }

    private static boolean isValid(int n, int phi) {
        char[] arr1 = Integer.toString(n).toCharArray();
        char[] arr2 = Integer.toString(phi).toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        return Arrays.equals(arr1, arr2);
    }
}
