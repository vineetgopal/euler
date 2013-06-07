package problems;

import java.math.BigInteger;

public class Problem048 implements Problem {

    @Override
    public String solve() {
        return "" + solve(1,1000, (long) 1e10);
    }
    
    private static long solve(int start, int finish, long mod) {
        BigInteger num = new BigInteger("0");
        for (int i = start; i <= finish; i++) {
            if (i % 10 == 0) {
                continue;
            }
            BigInteger n = new BigInteger("" + i);
            num = num.add(n.pow(i));
        }
        BigInteger modB = new BigInteger("" + mod);
        return num.mod(modB).longValue();
    }

}
