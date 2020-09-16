import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/largest-time-for-given-digits/
 * 只能暴力遍历.
 */
public class LargestTimeFromDigits {
    public String largestTimeFromDigits(int[] arr) {
        if (arr.length < 4) return "";
        StringBuilder sb = new StringBuilder();
        List<Integer> temp = new ArrayList<>();
        for (int val : arr) temp.add(val);
        int first = 0;
        int start;
        for (int i = 2; i >= 0; i--) {
            if (temp.contains(i)) {
                sb.append(i);
                first = i;
                for (int j = 0; j < temp.size(); j++) {
                    if (temp.get(j) == i) {
                        temp.remove(j);
                        break;
                    }
                }
                break;
            }
        }
        start = first == 2 ? 3 : 9;
        for (int i = start; i >= 0; i--) {
            if (temp.contains(i)) {
                sb.append(i);
                for (int j = 0; j < temp.size(); j++) {
                    if (temp.get(j) == i) {
                        temp.remove(j);
                        break;
                    }
                }
                break;
            }
        }

        for (int i = 5; i >= 0; i--) {
            if (temp.contains(i)) {
                sb.append(i);
                for (int j = 0; j < temp.size(); j++) {
                    if (temp.get(j) == i) {
                        temp.remove(j);
                        break;
                    }
                }
                break;
            }
        }
        for (int i = 9; i >= 0; i--) {
            if (temp.contains(i)) {
                sb.append(i);
                for (int j = 0; j < temp.size(); j++) {
                    if (temp.get(j) == i) {
                        temp.remove(j);
                        break;
                    }
                }
                break;
            }
        }
        if (sb.length() < 4) return "";
        sb.insert(2, ":");
        return sb.toString();
    }
}

