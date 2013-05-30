package util;

public class NumberUtil {
    public static boolean isPalindrome(long num) {
        String string = String.valueOf(num);
        int length = string.length();
        for (int i = 0; i < length/2; i++) {
            if (string.charAt(i) != string.charAt(length - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
