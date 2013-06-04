package problems;

import java.util.List;
import java.util.Set;

import util.CollectionsUtil;
import util.MathUtil;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

public class Problem051 implements Problem {

    @Override
    public void solve() {
        System.out.println(solve(8));
    }
    
    private static int solve(int size) {
        int numDigits = 2;
        while (true) {
            int limit = (int) Math.pow(10, numDigits);
            int start = (int) Math.pow(10, numDigits-1);
            List<Integer> list = CollectionsUtil.getTrueIndices(MathUtil.primeSieve(limit-1), start, limit-1);
            Set<Integer> primes = Sets.newHashSet(list);
            for (int prime : list) {
                String pString = Integer.toString(prime);
                Set<String> permutations = getMatchingIndices(pString);
                for (String perm : permutations) {
                    if (size >= 8 && perm.length() % 3 != 0) {
                        continue;
                    }
                    char[] pArr = pString.toCharArray();
                    int count = 0;
                    char[] array = perm.toCharArray();
                    for (char d = '0'; d <= '9'; d++) {
                        for (char c : array) {
                            pArr[(int) (c-'0')] = d;
                        }
                        if (primes.contains(Integer.parseInt(String.copyValueOf(pArr)))) {
                            count++;
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
    
    private static Set<String> getMatchingIndices(String string) {
        Set<String> ret = Sets.newHashSet();
        for (char c : new char[] {'0','1','2','3','4','5','6','7','8','9'}) {
            ret.addAll(getMatchingIndices(string, 0, c));
        }
        return ret;
    }
    
    private static List<String> getMatchingIndices(String string, int index, char match) {
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
