/**
 * https://leetcode-cn.com/problems/total-hamming-distance/
 * chaoxi
 * 题解：https://leetcode-cn.com/problems/total-hamming-distance/solution/yi-ming-ju-chi-zong-he-by-leetcode/
 */
public class TotalHammingDistance {
    public int totalHammingDistance(int[] nums) {
        int[] count = new int[32];
        for (int value : nums) {
            int num = value;
            int j = 0;
            while (num > 0) {
                count[j] += num & 1;
                num = num >> 1;
                j++;
            }
        }
        int op = 0;
        for (int c : count) {
            op += c * (nums.length - c);
        }
        return op;
    }
}
