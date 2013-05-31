package problems;

import util.NumberUtil;


public class Main {
    public static void main(String[] args) {
        long time = System.nanoTime();
        new Problem017().solve();
        System.out.println(NumberUtil.toEnglish(1000));
        System.out.printf("Time taken: %fms", (System.nanoTime() - time) / 1e6);
    }
}
