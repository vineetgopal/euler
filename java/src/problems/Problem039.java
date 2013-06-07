package problems;

import java.util.Set;

import com.google.common.collect.Sets;
import com.google.common.primitives.Ints;

public class Problem039 implements Problem {

    @Override
    public String solve() {
        return "" + solve(1000);
    }
    
    private static int solve(int limit) {
        Set<Integer> squares = Sets.newHashSet();
        for (int i = 1; i <= limit; i++) {
            squares.add(i*i);
        }
        int[] values = new int[limit+1];
        // since a+b+c <= limit, and a+b > c, then c < limit/2
        for (int c = 1; c < limit/2; c++) {
            for (int a = 1; a < c; a++) {
                if (squares.contains(c*c - a*a)) {
                    int p = a+c+(int) (Math.sqrt(c*c-a*a));
                    if (p <= limit) {
                        values[p]++;
                    }
                }
            }
        }
        
        return Ints.indexOf(values, Ints.max(values));
    }

}
