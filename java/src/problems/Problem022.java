package problems;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Problem022 implements Problem{

    @Override
    public String solve() {
        Scanner scanner;
        try {
            scanner = new Scanner(new File("Problem022.txt"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        String[] names = scanner.nextLine().split(",");
        for (int i = 0; i < names.length; i++) {
            names[i] = names[i].replace("\"", "").toUpperCase();
        }
        return "" + solve(names);
    }
    
    private static long solve(String[] names) {
        Arrays.sort(names);
        long total = 0;
        for (int i = 0; i < names.length; i++) {
            long score = 0;
            for (char c : names[i].toCharArray()) {
                score += (int) (c-64);
            }
            total += (i+1) * score;
        }
        return total;
    }

}
