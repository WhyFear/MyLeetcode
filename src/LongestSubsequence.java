import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/longest-arithmetic-subsequence-of-given-difference/
 */
public class LongestSubsequence {
    public int longestSubsequence(int[] arr, int difference) {
        int op = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int val : arr) {
            int result = map.getOrDefault(val - difference, 0) + 1;
            map.put(val, result);
            op = Math.max(op, result);
        }
        return op;
    }
}
