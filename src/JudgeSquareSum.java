/**
 * https://leetcode-cn.com/problems/sum-of-square-numbers/
 * chaoxi
 * https://leetcode-cn.com/problems/sum-of-square-numbers/comments/15111 双指针解法真厉害。
 */
public class JudgeSquareSum {
    public boolean judgeSquareSum(int c) {
        int i = 0;
        int j = (int) Math.sqrt(c);
        int sum;
        while (i <= j) {
            sum = i * i + j * j;
            if (sum > c) j--;
            else if (sum < c) i++;
            else return true;
        }
        return false;
    }
}
