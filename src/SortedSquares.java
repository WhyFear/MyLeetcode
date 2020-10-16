import java.util.Arrays;

/*
https://leetcode-cn.com/problems/squares-of-a-sorted-array/
 */
public class SortedSquares {
    public int[] sortedSquares(int[] A) {
        int[] op = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            op[i] = A[i] * A[i];
        }
        Arrays.sort(op);
        return op;
    }
}
