/**
 * https://leetcode-cn.com/problems/minimum-moves-to-equal-array-elements/
 * 恶心题
 */
public class MinMoves {
    public int minMoves(int[] nums) {
        int op = 0;
        int min = Integer.MAX_VALUE;
        for (int val : nums) {
            min = Math.min(val, min);
        }
        for (int val : nums) {
            op += val - min;
        }
        return op;
    }
}
