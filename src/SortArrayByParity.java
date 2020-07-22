/**
 * https://leetcode-cn.com/problems/sort-array-by-parity/
 */
public class SortArrayByParity {
    public int[] sortArrayByParity(int[] A) {
        int len = A.length;
        int i = 0, j = len - 1;
        while (i < j) {
            if (A[i] % 2 == 1 && A[j] % 2 == 0) {
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            } else if (A[i] % 2 == 0 && A[j] % 2 == 1) {
                i++;
                j--;
            } else if (A[i] % 2 == 1 && A[j] % 2 == 1) {
                j--;
            } else if (A[i] % 2 == 0 && A[j] % 2 == 0) {
                i++;
            }
        }
        return A;
    }
}
