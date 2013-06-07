package util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Set;

import com.google.common.collect.Sets;

public class StringUtil {
    public static Set<Character> DIGITS = Sets.newHashSet();
    
    static {
        for (int i = 0; i <= 9; i++) {
            DIGITS.add(Character.forDigit(i, 10));
        }
    }
    
    public static int[][] getTriangle(String[] array) {
        int[][] triangle = new int[array.length][array.length];
        for (int i = 0; i < array.length; i++) {
            String[] line = array[i].split(" ");
            for (int j = 0; j < line.length; j++) {
                triangle[i][j] = Integer.parseInt(line[j]);
            }
        }
        return triangle;
    }
    public static int[][] read2DArray(String string, String delim, String rowDelim) {
        String[] rows = string.split(rowDelim);
        int numRows = rows.length;
        int numCols = rows[0].split(delim).length;
        int[][] array = new int[numRows][numCols];
        for (int i = 0; i < rows.length; i++) {
            String[] row = rows[i].split(delim);
            for (int j = 0; j < row.length; j++) {
                array[i][j] = Integer.parseInt(row[j]);
            }
        }
        return array;
    }
    
    public static Set<String> generatePalindromes(Set<Character> set, int length) {
        Set<String> strings = Sets.newHashSet();
        if (length == 0) {
            strings.add("");
            return strings;
        } else if (length == 1) {
            for (char c : set) {
                strings.add("" + c);
            }
            return strings;
        } else {
            Set<String> ret = generatePalindromes(set, length-2);
            for (char c : set) {
                for (String s : ret) {
                    strings.add("" + c + s + c);
                }
            }
            return strings;
        }
    }
    
    public static boolean isPalindrome(String string) {
        int length = string.length();
        for (int i = 0; i < length/2; i++) {
            if (string.charAt(i) != string.charAt(length - 1 - i)) {
                return false;
            }
        }
        return true;
    }
    
    public static String[] readStringsFromFile(String filename, String delim, String around) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(filename));
        String[] strings = scanner.nextLine().split(delim);
        for (int i = 0; i < strings.length; i++) {
            strings[i] = strings[i].replace(around, "");
        }
        return strings;
    }
    
    public static Set<String> permutations(String string) {
        Set<String> set = Sets.newHashSet();
        permutations(string, "", set, string.length());
        return set;
    }
    
    public static Set<String> permutations(String string, int length) {
        Set<String> set = Sets.newHashSet();
        permutations(string, "", set, length);
        return set;
    }
    
    public static String reverse(String string) {
        StringBuilder b = new StringBuilder(string);
        b.reverse();
        return b.toString();
    }
    
    public static long reverse(long num) {
        long ret = 0;
        while (num > 0) {
            ret = ret * 10 + num % 10;
            num /= 10;
        }
        return ret;
    }
    
    private static void permutations(String chars, String prefix, Set<String> set, int length) {
        if (length == prefix.length()) {
            set.add(prefix);
        } else if (chars.length() == 1) {
            set.add(prefix+chars);
        } else {
            for (int i = 0; i < chars.length(); i++) {
                permutations(chars.substring(0, i) + chars.substring(i + 1), 
                        prefix + chars.charAt(i), set, length);
            }
        }
    }
    
    public static int sumDigits(String string) {
        int sum = 0;
        for (int i = 0; i < string.length(); i++) {
            sum += (int) (string.charAt(i) - '0');
        }
        return sum;
    }
}
