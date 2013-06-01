package problems;


public class Problem025 implements Problem{
    private static double PHI = (1+Math.sqrt(5)) / 2;
    private static double PSI = (1-Math.sqrt(5)) / 2;
    @Override
    public void solve() {
        System.out.println(solve(1000));
    }
    
//    private static int bigIntegerSolve(int numDigits) {
//        BigInteger first = BigInteger.ONE;
//        BigInteger second = BigInteger.ONE;
//        int term = 1;
//        while (first.toString().length() < numDigits) {
//            BigInteger tmp = second;
//            second = second.add(first);
//            first = tmp;
//            term++;
//        }
//        return term;
//    }
    
    private static int solve(int numDigits) {
        int n = (int) Math.round((numDigits + Math.log10(Math.sqrt(5))) / (Math.log10((1+Math.sqrt(5))/2)));
        while (getNumDigits(n) >= numDigits) {
            n--;
        }
        return n+1;
    }
    
    private static int getNumDigits(int n) {
        // using log(a+b) = log(a) + log(1+b/a)
        return (int) ((n * Math.log10(PHI) + Math.log10(1 + Math.pow(PSI / PHI, n))) - Math.log10(Math.sqrt(5))) + 1;
    }
    
}
