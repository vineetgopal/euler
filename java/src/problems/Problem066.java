package problems;

import java.math.BigInteger;

public class Problem066 implements Problem {

    @Override
    public String solve() {
        return "" + solve(1,1000);
    }
    
    private static int solve(int min, int max) {
        BigInteger maxX = BigInteger.ZERO;
        int maxNum = 0;
        for (int i = min; i <= max; i++) {
            if ((Math.sqrt(i) % 1 < 0.00001)) {
                continue;
            }
            BigInteger x = getX(i);
            if (x.compareTo(maxX) > 0) {
                maxX = x;
                maxNum = i;
            }
        }
        return maxNum;
    }

    private static BigInteger getX(int num) {
        BigInteger start = new BigInteger("" + num);
        BigInteger hOne = new BigInteger("" +(int) Math.sqrt(num));
        BigInteger kOne = BigInteger.ONE;
        Value value = new Value(1, num, (int) Math.sqrt(num), 1);
        BigInteger val = new BigInteger("" + value.getInt());
        BigInteger hTwo = hOne.multiply(val).add(BigInteger.ONE);
        BigInteger kTwo = val;
        BigInteger ONE = BigInteger.ONE;
        while (true) {
            if (hTwo.multiply(hTwo).subtract(ONE).equals(kTwo.multiply(kTwo).multiply(start))) {
                return hTwo;
            }
            value = value.getNextValue();
            BigInteger an = new BigInteger("" + value.getInt());
            BigInteger hThree = an.multiply(hTwo).add(hOne);
            BigInteger kThree = an.multiply(kTwo).add(kOne);
            hOne = hTwo;
            kOne = kTwo;
            hTwo = hThree;
            kTwo = kThree;
        }
    }

}

