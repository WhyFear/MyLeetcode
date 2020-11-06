import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/sort-integers-by-the-number-of-1-bits/submissions/
 */
public class SortByBits {
    public int[] sortByBits(int[] arr) {
        int len = arr.length;
        Integer[] temp = new Integer[len];
        for (int i = 0; i < len; i++) {
            temp[i] = arr[i];
        }
        Arrays.sort(temp, this::countNums);
        for (int i = 0; i < len; i++) {
            arr[i] = temp[i];
        }
        return arr;
    }

    private int countNums(int num1, int num2) {
        int count1 = countOne(num1);
        int count2 = countOne(num2);
        return count1 == count2 ? num1 - num2 : count1 - count2;
    }

    private int countOne(int num) {
        int count = 0;
        while (num > 0) {
            count += num & 1;
            num >>= 1;
        }
        return count;
    }
}
