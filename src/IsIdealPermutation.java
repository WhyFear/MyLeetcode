/**
 * https://leetcode-cn.com/problems/global-and-local-inversions/
 * 首先要明确题意，即长度为n的数组A中的元素是0到n-1，并且不重复。
 *
 * 如果第i个数距离它自己本身应在的位置（理想排列时）大于1，那么全局倒置一定大于局部倒置
 */
public class IsIdealPermutation {
    public boolean isIdealPermutation(int[] A) {
        for (int i = 0; i < A.length; i++) {
            if (Math.abs(A[i] - i) > 1)
                return false;
        }
        return true;
    }
}
