/**
 * https://leetcode-cn.com/problems/arranging-coins/
 */
public class ArrangeCoins {
    public int arrangeCoins(int n) {
        int op = 0;
        long sum = 0;
        int count = 1;
        while (sum < n) {
            sum += count++;
            op++;
        }
        if (sum > n) op--;
        return op;
    }
}
