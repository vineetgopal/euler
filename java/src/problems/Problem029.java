package problems;

import java.math.BigInteger;
import java.util.Set;

import com.google.common.collect.Sets;


public class Problem029 implements Problem {

    @Override
    public String solve() {
        return "" + solve(100,100);
    }
    
    private static int solve(int maxA, int maxB) {
      Set<BigInteger> set = Sets.newHashSet();
      for (int a = 2; a <= maxA; a++) {
          BigInteger power = new BigInteger("" + a);
          for (int b = 2; b <= maxB; b++) {
              BigInteger num = BigInteger.ONE;
              for (int i = 0; i < b; i++) {
                  num = num.multiply(power);
              }
              set.add(num);
          }
      }
      return set.size();
    }
    

}
