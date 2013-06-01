package problems;

import java.io.FileNotFoundException;

import util.StringUtil;

public class Problem042 implements Problem {
    private static final int MAX_N = 40;
    private static final int MAX_TRIANGLE = (MAX_N)*(MAX_N+1)/2;
    private static final boolean[] triangles = new boolean[MAX_TRIANGLE];
    static {
        for (int i = 0; i < MAX_N; i++) {
            triangles[i*(i+1) / 2] = true;
        }
    }
    @Override
    public void solve() {
        try {
            String[] strings = StringUtil.readStringsFromFile("Problem042.txt", ",", "\"");
            System.out.println(solve(strings));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    
    private static int solve(String[] strings) {
        int count = 0;
        int max = 0;
        for (String string : strings) {
            int score = 0;
            for (int i = 0; i < string.length(); i++) {
                score += Character.toUpperCase(string.charAt(i)) - 'A' + 1;
            }
            max = Math.max(score, max);
            if (isTriangular(score)) {
                count++;
            }
        }
        return count;
    }
    
    private static boolean isTriangular(int num) {
        if (num <= MAX_TRIANGLE) {
            return triangles[num];
        } else {
            int sqrt = (int) Math.sqrt(num);
            return sqrt*(sqrt+1) == 2 * num;
        }
    }
    
    

}
