package problems;

import util.MathUtil;

public class Problem015 implements Problem{

    @Override
    public void solve() {
        System.out.println(solve(20,20));
    }
    
    private static long solve(int row, int col) {
        return MathUtil.choose(row+col, row);
    }

}
