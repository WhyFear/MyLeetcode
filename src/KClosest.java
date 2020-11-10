import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/k-closest-points-to-origin/
 */
public class KClosest {
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(this::compare);
        for (int[] temp : points) {
            queue.add(temp);
            if (queue.size() > K) {
                queue.poll();
            }
        }
        int[][] res = new int[K][2];
        for (int i = 0; i < K; i++) {
            res[i] = queue.poll();
        }
        return res;
    }

    private int compare(int[] a, int[] b) {
        long aLen = a[0] * a[0] + a[1] * a[1];
        long bLen = b[0] * b[0] + b[1] * b[1];
        return (int) (bLen - aLen);
    }
}
