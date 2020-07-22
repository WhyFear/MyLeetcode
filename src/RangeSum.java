import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/range-sum-of-sorted-subarray-sums/
 */
public class RangeSum {
    public int rangeSum(int[] nums, int n, int left, int right) {
        int op = 0, MOD = 1000000007;
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.comparingInt(o -> o));
        for (int i = 0; i < n; i++) {
            int start = nums[i];
            heap.add(start);
            for (int j = i + 1; j < n; j++) {
                start += nums[j];
                heap.add(start);
            }
        }
        for (int i = 1; i <= right; i++) {
            if (i < left) heap.poll();
            else {
                op = (op + heap.poll()) % MOD;
            }
        }
        return op % MOD;
    }
}
