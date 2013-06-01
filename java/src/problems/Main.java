package problems;

import java.util.List;

import com.google.common.collect.Lists;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        List<Double> times = runAllProblems();
        for (int i = 1; i <= times.size(); i++) {
            System.out.printf("Problem %d: %fms\n", i, times.get(i-1));
        }
//        System.out.printf("Running time: %fms\n", testRunningTime(40, 5));
       //testRunningTime(32, 50);
//        long time = System.nanoTime();
//        new Problem024().solve();
//        System.out.printf("Time taken: %fms\n", (System.nanoTime() - time) / 1e6);
    }
    
    public static double testRunningTime(int problemNum, int times) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Problem problem = getProblem(problemNum);
        long time = System.nanoTime();
        for (int i = 0; i < times; i++) {
            problem.solve();
        }
        double timeTaken = (System.nanoTime() - time) / 1e6 / times;
        //System.out.printf("Time taken per iter: %fms\n", timeTaken);
        return timeTaken;
    }
    
    public static List<Double> runAllProblems() {
        List<Double> times = Lists.newArrayList();
        int problemNum = 1;
        while(true) {
            double timeTaken;
            try {
                timeTaken = testRunningTime(problemNum, 10);
            } catch (ClassNotFoundException e) {
                break;
            } catch (InstantiationException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
            times.add(timeTaken);
            //System.out.printf("Problem %d: %fms\n", problemNum, (System.nanoTime() - time) / 1e6);
            problemNum++;
        }
        return times;
    }
    
    public static Problem getProblem(int num) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class<?> clazz = Class.forName(String.format("problems.Problem%03d", num));
        Problem problem = (Problem) clazz.newInstance();
        return problem;
    }
}
