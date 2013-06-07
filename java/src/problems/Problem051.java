package problems;

import java.util.List;
import java.util.Set;

import util.CollectionsUtil;
import util.MathUtil;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

public class Problem051 implements Problem {

    @Override
    public String solve() {
        return "" + solve(8);
    }
    
    private static int solve(int size) {
        int numDigits = 2;
        while (true) {
            int limit = (int) Math.pow(10, numDigits);
            int start = (int) Math.pow(10, numDigits-1);
            boolean[] primes = MathUtil.primeSieve(limit-1);
            List<Integer> list = CollectionsUtil.getTrueIndices(primes, start, limit-1);
            for (int prime : list) {
                String pString = Integer.toString(prime);
                Set<String> permutations = getMatchingIndices(pString, 10 - size);
                for (String perm : permutations) {
                    if (size >= 8 && perm.length() % 3 != 0) {
                        continue;
                    }
                    char[] pArr = pString.toCharArray();
                    int count = 0;
                    int[] array = getInts(perm.toCharArray());
                    for (char d = '0'; d <= '9'; d++) {
                        for (int c : array) {
                            pArr[c] = d;
                        }
                        int val = Integer.parseInt(String.copyValueOf(pArr));
                        if (val >= start && primes[Integer.parseInt(String.copyValueOf(pArr))]) {
                            count++;
                        }
                        if (size - count > '9'-d) {
                            break;
                        }
                    }
                    if (count == size) {
                        return prime;
                    }
                }
            }
            numDigits++;
        }
    }
    
    private static int[] getInts(char[] array) {
        int[] ret = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            ret[i] = array[i] - '0';
        }
        return ret;
    }
    
    private static char[] chars = new char[] {'0','1','2','3','4','5','6','7','8','9'};
    private static Set<String> getMatchingIndices(String string, int max) {
        Set<String> ret = Sets.newHashSet();
        for (int i = 0; i <= max; i++) {
            ret.addAll(getMatchingIndices(string, chars[i]));
        }
        return ret;
    }
    
    private static List<String> getMatchingIndices(String string, char match) {
        List<String> ret = Lists.newArrayList("");
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == match) {
                int size = ret.size();
                for (int j = 0; j < size; j++) {
                    ret.add(ret.get(j)+i);
                }
            }
        }
        ret.remove(0);
        return ret;
    }
}
