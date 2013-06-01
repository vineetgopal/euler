package util;

import java.util.Map;

import com.google.common.collect.Maps;

public class NumberUtil {
    private static Map<Integer, String> numberMap = Maps.newHashMap();
    
    static {
        numberMap.put(1, "one"); numberMap.put(2, "two");numberMap.put(3, "three");
        numberMap.put(4, "four");numberMap.put(5, "five");numberMap.put(6, "six");
        numberMap.put(7, "seven");numberMap.put(8, "eight");numberMap.put(9, "nine");
        
        numberMap.put(10, "ten");numberMap.put(20, "twenty");numberMap.put(30, "thirty");
        numberMap.put(40, "forty");numberMap.put(50, "fifty");numberMap.put(60, "sixty");
        numberMap.put(70, "seventy");numberMap.put(80, "eighty");numberMap.put(90, "ninety");
        
        numberMap.put(11, "eleven");numberMap.put(12, "twelve");numberMap.put(13, "thirteen");
        numberMap.put(14, "fourteen");numberMap.put(15, "fifteen");numberMap.put(16, "sixteen");
        numberMap.put(17, "seventeen");numberMap.put(18, "eighteen");numberMap.put(19, "nineteen");
    }
    
    /**
     * Assumes num is between 0 and 999,999
     * @param num
     * @return
     */
    public static String toEnglish(int num) {
        if (num == 0) {
            return "zero";
        }
        String string = "";
        if (num % 10 != 0) {
            string = numberMap.get(num % 10);
        }
        if ((num % 100) / 10 != 0) {
            int val = (num % 100) / 10;
            if (val == 1) {
                string = numberMap.get(num % 100);
            } else {
                string = numberMap.get(val * 10) + " " + string;
            }
        }
        if ((num % 1000) / 100 != 0) {
            if (string == "") {
                string = numberMap.get((num % 1000) / 100) + " hundred";
            } else {
                string = numberMap.get((num % 1000) / 100) + " hundred and " + string;
            }
        }
        if (num >= 1000) {
            String ret = toEnglish(num / 1000);
            if (string != "zero") {
                string = ret + " thousand " + string;
            } else {
                string = ret + " thousand";
            }
        }
        return string;
    }
}
