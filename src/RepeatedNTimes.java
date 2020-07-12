import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/n-repeated-element-in-size-2n-array/
 */
public class RepeatedNTimes {
    public int repeatedNTimes(int[] A) {
        Arrays.sort(A);
        int len = A.length;
        int half = len / 2;
        for (int i = 0; i < len; ) {
            int j = i;
            while (j < len && A[j] == A[i]) j++;
            if (half == j - i) return A[i];
            i = j;
        }
        return 0;
    }
}
