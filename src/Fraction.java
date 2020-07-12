/**
 * https://leetcode-cn.com/problems/deep-dark-fraction/comments/
 * chaoxi
 * 题解
 * https://leetcode-cn.com/problems/deep-dark-fraction/comments/154356 倒序循环计算，不断颠倒分子分母即可（不用约分）
 */
public class Fraction {
    public int[] fraction(int[] cont) {
        int[] res = new int[2];
        res[0] = 1;
        for (int i = cont.length - 1; i >= 0; i--) {
            int temp1 = res[1];
            res[1] = res[0];
            res[0] = cont[i] * res[1] + temp1;
        }
        return res;
    }
}
