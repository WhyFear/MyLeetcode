/**
 * https://leetcode-cn.com/problems/longest-mountain-in-array/
 */
public class LongestMountain {
    public int longestMountain(int[] A) {
        int op = 0;
        if (A.length < 1) return op;
        int left, right, pre;
        for (int i = 1; i < A.length - 1; i++) {
            left = i - 1;
            right = i + 1;
            pre = A[i];
            while (left >= 0 && A[left] < pre) {
                pre = A[left];
                left--;
            }
            pre = A[i];
            while (right < A.length && A[right] < pre) {
                pre = A[right];
                right++;
            }
            if (right > i + 1 && left < i - 1)
                op = Math.max(op, right - left - 1);
        }
        return op >= 3 ? op : 0;
    }
}
