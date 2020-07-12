import java.util.*;

public class Merge {
    public static void main(String[] args) {
//        int[][] intervals = new int[][]{{1, 3, 5, 7}, {2, 4, 6, 8}};
//        System.out.println(Arrays.deepToString(merge(intervals)));
        int[] nums1 = new int[]{1, 3, 5, 7};
        int[] nums2 = new int[]{2, 4, 6, 8};
        merge(nums1, 4, nums2, 4);
    }

    /**
     * https://leetcode-cn.com/problems/merge-intervals/
     */
    public static int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0])); //排序
        List<int[]> op = new ArrayList<>();
        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            int begin = interval[0];
            int end = interval[1];
            if (begin <= intervals[i - 1][1]) {
                if (end < intervals[i - 1][1]) {
                    intervals[i] = new int[]{intervals[i - 1][0], intervals[i - 1][1]};
                } else {
                    intervals[i] = new int[]{intervals[i - 1][0], end};
                }
                intervals[i - 1] = new int[]{-1, -1};
            }
        }
        for (int[] interval : intervals) {
            if (interval[0] != -1 && interval[1] != -1) {
                op.add(interval);
            }
        }
        return op.toArray(new int[op.size()][2]);
    }

    /**
     * https://leetcode-cn.com/problems/merge-sorted-array/
     */
    public static void myMerge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0, j = 0, index = 0;
        int[] temp = new int[m + n];
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) temp[index++] = nums1[i++];
            else temp[index++] = nums2[j++];
        }
        while (i < m) temp[index++] = nums1[i++];
        while (j < n) temp[index++] = nums2[j++];
        if (temp.length >= 0) System.arraycopy(temp, 0, nums1, 0, temp.length);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        // two get pointers for nums1 and nums2
        int p1 = m - 1;
        int p2 = n - 1;
        // set pointer for nums1
        int p = m + n - 1;

        // while there are still elements to compare
        while ((p1 >= 0) && (p2 >= 0))
            // compare two elements from nums1 and nums2
            // and add the largest one in nums1
            nums1[p--] = (nums1[p1] < nums2[p2]) ? nums2[p2--] : nums1[p1--];

        // add missing elements from nums2
        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
    }
}
