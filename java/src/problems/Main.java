package problems;

import java.util.List;

import com.google.common.collect.Lists;
public class Main {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
//        List<Double> times = runAllProblems(1);
//        for (int i = 1; i <= times.size(); i++) {
//            System.out.printf("Problem %d: %fms\n", i, times.get(i-1));
//        }
//        System.out.println(System.currentTimeMillis() - time);
//        List<Integer> set = Lists.newArrayList(1,2,3);
//        System.out.println(CollectionsUtil.combinations(set, 2));
        System.out.printf("Running time: %fms\n", testRunningTime(70, 1));
    }
    
    public static void runProblem(int problemNum) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Problem problem = getProblem(problemNum);
        System.out.println(problem.solve());
    }
    public static double testRunningTime(int problemNum, int times) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Problem problem = getProblem(problemNum);
        long time = System.nanoTime();
        String answer = "";
        for (int i = 0; i < times; i++) {
            answer = problem.solve();
        }
        System.out.println("Answer: " + answer);
        double timeTaken = (System.nanoTime() - time) / 1e6 / times;
        return timeTaken;
    }
    
    public static List<Double> runAllProblems(int numTimesToRun) {
        List<Double> times = Lists.newArrayList();
        int problemNum = 1;
        while(true) {
            double timeTaken;
            try {
                timeTaken = testRunningTime(problemNum, numTimesToRun);
            } catch (ClassNotFoundException e) {
                break;
            } catch (InstantiationException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
            times.add(timeTaken);
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
