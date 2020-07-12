import java.util.*;

/**
 * https://leetcode-cn.com/problems/minimum-index-sum-of-two-lists/
 */
public class FindRestaurant {
    public String[] findRestaurant(String[] list1, String[] list2) {
        List<String> op = new ArrayList<>();
        Map<String, Integer> first = new HashMap<>();
        Map<String, Integer> second = new HashMap<>();
        for (int i = 0; i < list1.length; i++) first.put(list1[i], i);
        for (int i = 0; i < list2.length; i++) second.put(list2[i], i);
        int minIndexSum = Integer.MAX_VALUE;
        if (list1.length > list2.length) {
            for (String temp : list2) {
                if (first.containsKey(temp)) {
                    int sum = first.get(temp) + second.get(temp);
                    if (sum < minIndexSum) {
                        minIndexSum = sum;
                        op = new ArrayList<>();
                        op.add(temp);
                    } else if (sum == minIndexSum) {
                        op.add(temp);
                    }
                }
            }
        } else {
            for (String temp : list1) {
                if (second.containsKey(temp)) {
                    int sum = first.get(temp) + second.get(temp);
                    if (sum < minIndexSum) {
                        minIndexSum = sum;
                        op = new ArrayList<>();
                        op.add(temp);
                    } else if (sum == minIndexSum) {
                        op.add(temp);
                    }
                }
            }
        }
        return op.toArray(new String[0]);
    }
}
