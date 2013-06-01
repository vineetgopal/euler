package problems;

public class Problem030 implements Problem {

    @Override
    public void solve() {
        System.out.println(solve(5));
    }
    
    private static long solve(int power) {
        long totalSum = 0;
        long maxDigits = 1;
        while (maxDigits * Math.pow(9, power) >= Math.pow(10, maxDigits+1)) {
            maxDigits++;
        }
        long max = (long) Math.pow(9, power) * maxDigits;
        int first = Integer.parseInt((""+max).substring(0,1));
        max = (long) Math.pow(9, power) * (maxDigits - 1) + (long) Math.pow(first, power);
        int[] powers = new int[10];
        for (int i = 0; i < 10; i++) {
            powers[i] = (int) Math.pow(i, power);
        }
        for (long i = 2; i < max; i++) {
            long sum = 0;
            for (char c : String.valueOf(i).toCharArray()) {
                int val = (int) (c - '0');
                sum += powers[val];
            }
            if (sum == i) {
                totalSum += i;
            }
        }
        return totalSum;
    }

}
