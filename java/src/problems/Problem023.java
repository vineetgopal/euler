package problems;

import util.CollectionsUtil;
import util.MathUtil;

import com.google.common.primitives.Ints;

public class Problem023 implements Problem {

    @Override
    public String solve() {
        return "" + solve(20161);
    }
    
    private static long solve(int MAX) {
        boolean[] abundants = new boolean[MAX+1];
        for (int i = 1; i <= MAX; i++) {
            if (!abundants[i] && CollectionsUtil.sum(MathUtil.divisors(i)) > 2*i) {
                int j = i;
                while (j <= MAX) {
                    abundants[j] = true;
                    j+=i;
                }
            }
        }
        int[] list = Ints.toArray(CollectionsUtil.getTrueIndices(abundants));
        boolean[] canSum = new boolean[MAX+1];
        for (int i = 0; i < list.length; i++) {
            for (int j = i; j < list.length; j++) {
                if (list[i]+list[j] <= MAX) {
                    canSum[list[i]+list[j]] = true;
                } else {
                    break;
                }
            }
        }
        long sum = 0;
        for (int i = 0; i <= MAX; i++) {
            if (!canSum[i]) {
                sum += i;
            } 
        }
        return sum;
    }
    
}
