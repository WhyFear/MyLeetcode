import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/4sum-ii/
 * chaoxi
 */
public class FourSumCount {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int op = 0;
        Map<Integer, Integer> abMap = new HashMap<>();
        int sum;
        for (int a : A) {
            for (int b : B) {
                sum = a + b;
                abMap.put(sum, abMap.getOrDefault(sum, 0) + 1);
            }
        }
        for (int c : C) {
            for (int d : D) {
                sum = -(c + d);
                if (abMap.containsKey(sum)) op += abMap.get(sum);
            }
        }
        return op;
    }
}
