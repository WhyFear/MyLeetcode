/**
 * https://leetcode-cn.com/problems/number-of-sub-arrays-of-size-k-and-average-greater-than-or-equal-to-threshold/
 * 子数组，连续的
 * 滑动窗口
 */
public class NumOfSubarrays {

    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int op = 0, sum = 0;
        int len = arr.length;
        if (len < k) return 0;

        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }
        if (sum / k >= threshold) op++;

        int right = k;
        while (right < len) {
            sum -= arr[right - k];
            sum += arr[right];
            if (sum / k >= threshold) op++;
            right++;
        }
        return op;
    }
}
