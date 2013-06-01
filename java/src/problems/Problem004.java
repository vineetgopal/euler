package problems;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

import util.MathUtil;
import util.StringUtil;

import com.google.common.collect.Sets;

public class Problem004 implements Problem {
    @Override
    public void solve() {
        System.out.println(solve(3));
    }
    
    private static long solve(int numDigits) {
        long upperLimit = (long) Math.pow(10, numDigits);
        long lowerLimit = (long) Math.pow(10, numDigits-1);
        Set<String> palindromes = StringUtil.generatePalindromes(Sets.newHashSet('1','2','3','4','5','6','7','8','9','0'), 6);
        TreeSet<String> ordered = Sets.newTreeSet(Collections.reverseOrder());
        ordered.addAll(palindromes);
        for (String string : ordered) {
            long num = Integer.parseInt(string);
            Set<Long> divisors = MathUtil.divisors(num);
            for (long divisor : divisors) {
                if (lowerLimit <= divisor && divisor < upperLimit && lowerLimit <= (num/divisor) && (num/divisor) < upperLimit) {
                    return num;
                }
            }
        }
        return -1;
    }
}
