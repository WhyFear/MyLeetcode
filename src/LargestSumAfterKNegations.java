import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/maximize-sum-of-array-after-k-negations/
 * 每次取最小的值进行反转
 */
public class LargestSumAfterKNegations {
    public int largestSumAfterKNegations(int[] A, int K) {
        int op = 0;
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int val : A) heap.add(val);
        int count = 0;
        while (count < K) {
            int temp = heap.poll();
            heap.add(-temp);
            count++;
        }
        while (!heap.isEmpty()) {
            op += heap.poll();
        }
        return op;
    }
}
