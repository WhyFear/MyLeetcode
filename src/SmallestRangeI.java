/**
 * https://leetcode-cn.com/problems/smallest-range-i/
 * 根据评论区里面思路做出来的
 */
public class SmallestRangeI {
    public int smallestRangeI(int[] A, int K) {
        int min = A[0], max = A[0];
        for (int num : A) {
            if (num > max) max = num;
            if (num < min) min = num;
        }
        return Math.max(0, max - min - 2 * K);
    }
}
