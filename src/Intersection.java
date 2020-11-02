import java.util.*;

/**
 * https://leetcode-cn.com/problems/intersection-of-two-arrays/
 */
public class Intersection {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> added = new HashSet<>();
        for (int num : nums1) set1.add(num);
        List<Integer> op = new ArrayList<>();
        for (int num : nums2) {
            if (set1.contains(num) && !added.contains(num)) {
                op.add(num);
                added.add(num);
            }
        }
        int[] res = new int[op.size()];
        for (int i = 0; i < op.size(); i++) {
            res[i] = op.get(i);
        }
        return res;
    }
}
