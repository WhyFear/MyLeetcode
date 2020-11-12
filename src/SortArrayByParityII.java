import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode-cn.com/problems/sort-array-by-parity-ii/
 */
public class SortArrayByParityII {
    public int[] sortArrayByParityII(int[] A) {
        Deque<Integer> odd = new ArrayDeque<>();
        Deque<Integer> even = new ArrayDeque<>();
        for (int num : A) {
            if (num % 2 == 1) odd.add(num);
            else even.add(num);
        }
        for (int i = 0; i < A.length; i++) {
            if (i % 2 == 0) A[i] = even.poll();
            else A[i] = odd.poll();
        }
        return A;
    }
}
