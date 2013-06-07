package problems;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import util.CollectionsUtil;
import util.StringUtil;

public class Problem067 implements Problem {

    @Override
    public void solve() {
        String string = "";
        Scanner scanner;
        try {
            scanner = new Scanner(new File("Problem067.txt"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        while (scanner.hasNextLine()) {
            string += scanner.nextLine() + "\n";
        }
        int[][] triangle = StringUtil.getTriangle(string.split("\n"));
        System.out.println(solve(triangle));
    }
    

    
    /**
     * Assumes triangle is of the form:
     * 1
     * 2 3
     * 5 5 2
     * 6 6 9 4
     * 
     * The other numbers in the square matrix do not matter.
     * @param triangle
     */
    private static int solve(int[][] triangle) {
        int[][] dp = new int[triangle.length][triangle[0].length];
        dp[0][0] = triangle[0][0];
        for (int row = 1; row < triangle.length; row++) {
            dp[row][0] = dp[row-1][0] + triangle[row][0];
            for (int col = 1; col < row; col++) {
                dp[row][col] = triangle[row][col] + Math.max(dp[row-1][col-1], dp[row-1][col]);
            }
            dp[row][row] = dp[row-1][row-1] + triangle[row][row]; 
        }
        return CollectionsUtil.maxInt(dp[dp.length - 1]);
    }
    
    

}
