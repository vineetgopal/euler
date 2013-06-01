package problems;

import util.MathUtil;

public class Problem012 implements Problem{

    @Override
    public void solve() {
        System.out.println(solve(500));
    }
    
    private static int solve(int numDivisors) {
        int n = 1;
        int one = MathUtil.numDivisors(n);
        int two = MathUtil.numDivisors((n+1)/2);
        
        // we can use the fact that MathUtil.numDivisors(n) * MathUtil.numDivisors((n+1)/2) = MathUtil.numDivisors(n*(n+1)/2) 
        // because n and n+1 share no factors, so n and (n+1)/2 share no factors.
        while (one*two <= numDivisors) {
            n++;
            one = two;
            two = MathUtil.numDivisors(n+1);
            if (one*two > numDivisors) {
                break;
            }
            n++;
            one = two;
            two = MathUtil.numDivisors((n+1)/2);
        }
        return n*(n+1)/2;
    }
}
