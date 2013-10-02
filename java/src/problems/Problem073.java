package problems;

import util.MathUtil;

public class Problem073 implements Problem {

    @Override
    public String solve() {
        return "" + solve(12000, 1, 3, 1, 2);
    }
    
    private static int solve(int max, int lowNum, int lowDen, int highNum, int highDen) {
        int total = 0;
        int n1 = Problem071.solve(max, lowNum, lowDen);
        int d1 = n1 * lowDen / lowNum + 1;
        int n2 = lowNum;
        int d2 = lowDen;
        
        // Use Farey sequences
        while (n2 * highDen < d2 * highNum) {
            int n3 = ((max + d1) / d2) * n2 - n1;
            int d3 = ((max + d1) / d2) * d2 - d1;
            n1 = n2;
            d1 = d2;
            n2 = n3;
            d2 = d3;
            total++;
        }
        return total - 1;
    }

}
