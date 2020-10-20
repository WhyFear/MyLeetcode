/**
 * https://leetcode-cn.com/problems/duplicate-zeros/
 */
public class DuplicateZeros {
    public void duplicateZeros(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            if (arr[i] == 0) {
                if (len - 1 - i >= 0) System.arraycopy(arr, i, arr, i + 1, len - 1 - i);
                i++;
            }
        }
    }
}
