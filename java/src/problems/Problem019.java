package problems;

import java.util.Calendar;

public class Problem019 implements Problem {

    @Override
    public String solve() {
        return "" + solve(1901, 1, 1, 2000, 12, 31);
    }
    
    private static int solve(int startYear, int startMonth, int startDate, int endYear, int endMonth, int endDate) {
        Calendar start = Calendar.getInstance();
        start.set(startYear, startMonth, startDate);
        
        Calendar finish = Calendar.getInstance();
        finish.set(endYear, endMonth, endDate);
        int count = 0;
        while (start.compareTo(finish) <= 0) {
            if (start.get(Calendar.DATE) == 1 && start.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY){
                count++;
            }
            start.add(Calendar.DATE, 1);
        }
        return count;
    }
}
