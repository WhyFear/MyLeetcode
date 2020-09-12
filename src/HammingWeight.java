/**
 * https://leetcode-cn.com/problems/number-of-1-bits/
 * chaoxi
 * 题都看不懂
 */
public class HammingWeight {
    public int hammingWeight(int n) {
        int op = 0;
        while (n != 0) {
            op++;
            n &= (n - 1);
        }
        return op;
    }
}
