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

        return sb.toString();
    }
}

