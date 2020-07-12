/*
 * https://leetcode-cn.com/problems/sort-an-array/
 * */

import java.util.*;

public class SortArray {
    public static void main(String[] args) {
        int[] nums = new int[]{5, 1, 1, 2, 0, 0};
        int[] result = sortArray(nums);
        System.out.println(Arrays.toString(result));
    }

    public static int[] sortArray(int[] nums) {
        Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
        int[] result = new int[nums.length];
        int i = 0;
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                int tmp = map.get(num) + 1;
                map.put(num, tmp);
            }
        }
        Set<Integer> keySet = map.keySet();
        for (Integer key : keySet) {
            int times = map.get(key);
            if (times == 1) {
                result[i] = key;
                i++;
            } else {
                for (int j = 0; j < times; j++, i++) {
                    result[i] = key;
                }
            }
            System.out.println(key + ":" + map.get(key));
        }
        return result;
    }
}
