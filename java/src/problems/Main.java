package problems;



public class Main {
    public static void main(String[] args) {
        long time = System.nanoTime();
        System.out.println(Problem007.solve());
        System.out.printf("Time taken: %fms", (System.nanoTime() - time) / 1e6);
    }
}
