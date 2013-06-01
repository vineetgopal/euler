package problems;

import util.NumberUtil;

public class Problem017 implements Problem {

    @Override
    public void solve() {
        System.out.println(solve(1, 1000));
    }
    
    private static int solve(int start, int finish) {
        int numCharacters = 0;
        for (int i = start; i <= finish; i++) {
            numCharacters += (NumberUtil.toEnglish(i).replace(" ", "").length());
        }
        return numCharacters;
    }

}
