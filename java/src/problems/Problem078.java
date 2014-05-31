package problems;


public class Problem078 implements Problem {
    
    @Override
    public String solve() {
        return "" + solve(1000000);
    }
    
    private static String solve(int mod) {
        int n = 7;
        while(true) {
            int[] ret = new int[n+1];
            ret[0] = 1;
            for (int i = 1; i <= n; i++) {
                for (int j = i; j <= n; j++) {
                    ret[j] = (ret[j] + ret[j-i]) % mod;
                }
                if (ret[i] % mod == 0) {
                    return "" + i;
                }
            }
            n *= 2;
            System.out.println(n);
        }
        
//        
//        int num = 1;
//        int[][] dp = new int[10000][10000];
//        System.out.println(ways(100,100, dp));
//        while (ways(num, num, dp) % 1000000 != 0) {
//            num++;
//            System.out.println(num);
//        }
//        return "" + num;
    }
    
    private static int ways(int sum, int max, int[][] dp) {
        if (sum < 0) {
            return 0;
        }
        if (sum == 0) {
            return 1;
        }
        if (dp[sum][max] != 0) {
            return dp[sum][max];
        }
        int ways = 0;
        for (int i = 1; i <= max; i++){
            ways += ways(sum - i, i, dp);
        }
        dp[sum][max] = ways;
        return ways;
            
    }

}
