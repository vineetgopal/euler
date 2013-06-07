package problems;


public class Problem063 implements Problem {

    @Override
    public String solve() {
        int count = 0;
        for (int numDigits = 1; ; numDigits++) {
            int x = (int) (Math.ceil(Math.pow(10, (numDigits-1.0)/numDigits)));
            if (x > 9) {
                break;
            } else {
                count += (10-x);
            }
        }
        return "" + count;
    }
}
