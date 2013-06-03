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
        permutations(string, "", set);
        return set;
    }
    
    private static void permutations(String chars, String prefix, Set<String> set) {
        if (chars.length() == 1) {
            set.add(prefix+chars);
        } else {
            for (int i = 0; i < chars.length(); i++) {
                permutations(chars.substring(0, i) + chars.substring(i + 1), 
                        prefix + chars.charAt(i), set);
            }
        }
    }
}
