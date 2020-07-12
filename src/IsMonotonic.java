/**
 * https://leetcode-cn.com/problems/monotonic-array/
 */
public class IsMonotonic {
    public boolean isMonotonic(int[] A) {
        int len = A.length;
        if (A.length <= 1) return true;
        boolean increase = false;
        int i = 0;
        while (i < len - 2 && A[i] == A[i + 1]) i++;
        if (A[i] < A[i + 1]) increase = true;
        while (i < len-1) {
            if (increase && A[i] > A[i + 1]) return false;
            if (!increase && A[i] < A[i + 1]) return false;
            i++;
        }
        return true;
    }
}
