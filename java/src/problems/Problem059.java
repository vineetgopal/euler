package problems;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import util.NumberUtil;

import com.google.common.collect.Sets;
import com.google.common.primitives.Ints;

public class Problem059 implements Problem {

    @Override
    public void solve() {
        List<Integer> list = Ints.asList(NumberUtil.readInts("Problem059.txt", ","));
        System.out.println(solve(3, list));
    }
    
    private static int solve(int passwordSize, List<Integer> list) {
        double maxScore = 0;
        char[] best = new char[list.size()];
        char[] array = new char[list.size()];
        for (String password : getPasswords('a','z',3)) {
            double score = getString(list, password, array);
            if (score > maxScore) {
                best = Arrays.copyOf(array, array.length);
                maxScore = score;
            }
        }
        int sum = 0;
        for (char c : best) {
            sum += (int) c;
        }
        return sum;
    }
    
    private static double getString(List<Integer> list, String password, char[] arrayToSet) {
        int score = 0;
        for (int i = 0; i < list.size(); i++) {
            char c = (char) (list.get(i) ^ (password.charAt(i % password.length())));
            if (c == ' ' || ('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z')) {
                score++;
            }
            arrayToSet[i] = c;
        }
        return score * 1.0 / list.size();
    }
    
    private static Set<String> getPasswords(char start, char end, int length) {
        Set<String> ret = Sets.newHashSet();
        Set<String> right;
        if (length == 1) {
            right = Sets.newHashSet("");
        } else {
            right = getPasswords(start, end, length-1);
        }
        for (String string : right) {
            for (char s = start; s < end; s++) {
                ret.add(string + s);
            }
        }
        return ret;
    }

}
