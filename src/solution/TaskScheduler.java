package solution;

import java.util.Arrays;

/**
 * Created by Sophie on 2019/2/20.
 * LeetCode 621. https://leetcode.com/problems/task-scheduler/
 */
public class TaskScheduler {

    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for(char c : tasks) {
            freq[c - 'A']++;
        }
        Arrays.sort(freq);

        int max_interval = freq[25] - 1;
        int max_idle = max_interval * n;

        for(int i = 24; i>=0; i--) {
            //we try to replace the idle time with a task (because anyway the task need to be executed, and instead of let the
            // slot be idle, we can execute a task as cooling down), but the maximum number of idle time that we can replace is
            // the number of max_interval
            //and we need to make sure that max_idle is positive, for example when n = 0, which means that we don't need to cool down
            //then the max_idle is 0*max_interval = 0, but the max_interval is not 0, in this case, there's no idle slot to replace
            max_idle = Math.max(0, max_idle - Math.min(max_interval, freq[i]));
        }
        return tasks.length + max_idle;
    }
}
