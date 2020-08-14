import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/task-scheduler/
 * 排序，每次取剩余次数最多的
 */
public class LeastInterval {
    public int leastInterval(char[] tasks, int n) {
        if (n == 0) return tasks.length;
        int op = 0;
        int[] taskCount = new int[26];
        for (char task : tasks) {
            taskCount[task - 'A']++;
        }
        Arrays.sort(taskCount);
        while (taskCount[25] > 0) {
            int count = 0;
            while (count <= n) {
                if (taskCount[25] == 0) break;
                if (count < 26 && taskCount[25 - count] > 0) taskCount[25 - count]--;
                op++;
                count++;
            }
            Arrays.sort(taskCount);
        }
        return op;
    }
}
