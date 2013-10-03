package problems;


public class Problem074 implements Problem {
    
    @Override
    public String solve() {
        return "" + solve(1000000, 60);
    }

    private static int solve(int max, int desiredLength) {
        int[] factorials = new int[10];
        int total = 1; 
        int count = 0;
        factorials[0] = 1;
        for (int i = 1; i < factorials.length; i++) {
            total *= i;
            factorials[i] = total;
        }
        int[] lengths = new int[max+1];
        
        // Only three loops of size > 1, as stated in problem
        lengths[169] = 3;
        lengths[871] = 2;
        lengths[872] = 2;
        for (int i = 1; i <= max; i++) {
            int num = sumFactorials(i, factorials);
            if (num == i) {
                lengths[i] = 1;
            } else {
                int unique = 1;
                while (num >= lengths.length || lengths[num] == 0) {
                    unique++;
                    int next = sumFactorials(num, factorials);
                    if (next == num) {
                        break;
                    }
                    num = next;
                }
                lengths[i] = unique + lengths[num];
            }
            if (lengths[i] == desiredLength) {
                count++;
            }
        }
        return count;
    }
    
    private static int sumFactorials(int num, int[] factorials) {
        int next = 0;
        while (num > 0) {
            next += factorials[num % 10];
            num /= 10;
        }
        return next;
    }
    
    
}
