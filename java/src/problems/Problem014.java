package problems;

public class Problem014 implements Problem{
    private int[] lengths;
    @Override
    public void solve() {
        int limit = 1000000;
        lengths = new int[limit];
        System.out.println(solve(limit));
    }
    
    private int solve(int limit) {
        int maxLength = 0;
        int maxNum = 0;
        for (int i = 1; i < limit; i+=2) {
            int count = getCollatzChainLength(i);
            if (count > maxLength) {
                maxLength = count;
                maxNum = i;
            }
        }
        return maxNum;
    }
    
    private int getCollatzChainLength(long start) {
        if (start < lengths.length && lengths[(int) start] != 0) {
            return lengths[(int) start];
        } else if (start == 1) {
            return 1;
        } else if (start % 2 == 0) {
            int ret = getCollatzChainLength(start/2) + 1;
            if (start < lengths.length) {
                lengths[(int) start] = ret;
            }
            return ret;
        } else {
            int ret = getCollatzChainLength((3*start + 1)/2) + 2;
            if (start < lengths.length) {
                lengths[(int) start] = ret;
            }
            return ret;
        }
    }
    
}
