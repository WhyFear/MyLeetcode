import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
 * 用自带排序再返回指定位置的做法很蠢。
 * 使用堆排序找到符合条件的数。
 */
public class FindKthLargest {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6};
//        int[] nums = new int[]{3, 2, 1, 5, 6, 4};
//        int[] nums = new int[]{2, 0, 1};
        System.out.println(findKthLargest1(nums, 4));
    }

    public static int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    /**
     * 别人的
     * PriorityQueue作为堆
     */
    public static int findKthLargest1(int[] nums, int k) {
        // init heap 'the smallest element first' 小顶堆
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        // keep k largest elements in the heap
        for (int n : nums) {
            heap.add(n);
            if (heap.size() > k) //超过大小就弹出最小元素。最后剩下的就是第K个元素
                heap.poll();
        }

        // output
        return heap.poll();
    }
}
