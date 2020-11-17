import java.util.Map;
import java.util.TreeMap;

/**
 * https://leetcode-cn.com/problems/relative-sort-array/
 * 没有注意到最大值只有1000，可以直接用数组来做
 */
public class RelativeSortArray {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> count = new TreeMap<>();
        for (int val : arr1) count.put(val, count.getOrDefault(val, 0) + 1);
        int len, index = 0;

        for (int val : arr2) {
            len = count.get(val);
            while (len > 0) {
                arr1[index++] = val;
                len--;
            }
            count.remove(val);
        }
        for (int key : count.keySet()) {
            len = count.get(key);
            while (len > 0) {
                arr1[index++] = key;
                len--;
            }
        }
        return arr1;
    }
}
