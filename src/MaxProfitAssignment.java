import java.awt.*;
import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode-cn.com/problems/most-profit-assigning-work/
 * 难度和收益是否成正比
 */
public class MaxProfitAssignment {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        if (difficulty == null || profit == null || worker == null || difficulty.length == 0 || profit.length == 0 || worker.length == 0)
            return 0;

        int N = difficulty.length;
        Point[] jobs = new Point[N];  //类似于X,Y坐标。比较像字典
        //双数组联合排序可以使用这个方法，好用
        for (int i = 0; i < N; ++i) jobs[i] = new Point(difficulty[i], profit[i]);
        Arrays.sort(jobs, Comparator.comparingInt(a -> a.x));
        Arrays.sort(worker);

        int op = 0, i = 0, best = 0;
        for (int skill : worker) {
            while (i < N && skill >= jobs[i].x) best = Math.max(best, jobs[i++].y);
            op += best;
        }
        return op;
    }
}
