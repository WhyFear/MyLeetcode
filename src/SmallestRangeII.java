import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/smallest-range-ii/
 * [1,1,1,1,1,1] -> 0
 * chaoxi
 * 想复杂了
 */
public class SmallestRangeII {
    public int smallestRangeII(int[] A, int K) {
        Arrays.sort(A);
        int n = A.length;
        int res = A[n - 1] - A[0];
        for (int i = 1; i < n; i++) {
            int min = Math.min(A[0] + K, A[i] - K);
            int max = Math.max(A[n - 1] - K, A[i - 1] + K);
            res = Math.min(max - min, res);
        }
        return res;
    }
}
