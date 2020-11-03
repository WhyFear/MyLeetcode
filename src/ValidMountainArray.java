/**
 * https://leetcode-cn.com/problems/valid-mountain-array/
 */
public class ValidMountainArray {
    public boolean validMountainArray(int[] A) {
        int len = A.length;
        if (len < 3) return false;
        boolean increase = true;
        for (int i = 1; i < len; i++) {
            if (A[i] == A[i - 1]) return false;
            if (A[i] > A[i - 1]) {
                if (!increase) return false;
            } else {
                if (i == 1) return false;
                increase = false;
            }
        }
        return !increase;
    }
}
