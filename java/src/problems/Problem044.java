package problems;

import java.util.Set;

import com.google.common.collect.Sets;

public class Problem044 implements Problem {

    
    /**
     * This isn't technically right, since we just return the value that minimizes Pj+Pk.
     * @return
     */
    @Override
    public void solve() {
        int min = Integer.MAX_VALUE;
        Set<Integer> numbers = Sets.newHashSet();
        numbers.add(1);
        int n = 1;
        while (true) {
            n++;
            int c = n*(3*n-1)/2;
            boolean works = false;
            for (int num : numbers) {
                if (numbers.contains(c-num) && numbers.contains(c-2*num)) {
                    min = c - 2 * num;
                    works = true;
                    break;
                }
            }
            if (works) {
                break;
            }
            numbers.add(c);
        }
        System.out.println(min);
    }
}
