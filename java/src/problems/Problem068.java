package problems;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import com.google.common.collect.Sets;

public class Problem068 implements Problem {

    @Override
    public String solve() {
        return "" + solve(10, 16);
    }
    
    private static String solve(int num, int desiredLength) {
        TreeSet<String> results = Sets.newTreeSet(Collections.reverseOrder());
        int[] array = new int[num];
        generateRings(array, num, 0, desiredLength, new HashSet<Integer>(), results);
        return results.first();
    }
    
    public static void generateRings(int[] array, int goal, int length, int desiredLength, Set<Integer> nums, Set<String> results) {
        if (!isValid(array, length-1)) {
            return;
        }
        if (length == goal) {
            String string = getString(array);
            if (string.length() == desiredLength) {
                results.add(string);
            }
            return;
        }
        for (int i = 1; i <= goal; i++) {
            if (!nums.contains(i)) {
                nums.add(i);
                array[length] = i;
                generateRings(array, goal, length+1, desiredLength, nums, results);
                nums.remove(i);
            }
        }
    }
    
    public static String getString(int[] array) {
        int min = array[0];
        String ret = "";
        ret += "" + array[0]+array[1]+array[2];
        for (int i = 2; i+2< array.length; i+=2) {
            if (array[i+1] < min) {
                return "";
            }
            ret += ""+array[i+1]+array[i] + array[i+2];
        }
        if (array[array.length - 1] < min) {
            return "";
        }
        ret += "" + array[array.length - 1] + array[array.length - 2] + array[1];
        return ret;
    }
    
    public static boolean isValid(int[] array, int last_index) {
        if (last_index < 2) {
            return true;
        }
        int sum = array[0] + array[1] + array[2];
        for (int i = 2; i+2 <= last_index; i+=2) {
            if (sum != array[i] + array[i+1] + array[i+2]) {
                return false;
            }
        }
        if (last_index == array.length - 1) {
            return sum == array[last_index - 1] + array[last_index] + array[1];
        } else if (last_index % 2 == 1) {
            return array[last_index - 1] + array[last_index] < sum;
        }

        return true;
    }
}

