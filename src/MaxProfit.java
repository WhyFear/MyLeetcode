/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 */
public class MaxProfit {
    public static void main(String[] args) {
        int[] ip = new int[]{3, 2, 6, 5, 0, 3};
        System.out.println(maxProfit(ip));
    }

    /**
     * 我自己写的，n方时间复杂度。
     * @param prices
     * @return
     */
    public static int myMaxProfit(int[] prices) {
        int op = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = prices.length - 1; j >= i; j--) {
                if (prices[i] < prices[j]) {
                    op = Math.max(op, prices[j] - prices[i]);
                }
            }
        }
        return op;
    }

    /**
     * 别人的代码
     */
    public static int maxProfit(int[] prices) {
        if (prices.length <= 1)
            return 0;
        int min = prices[0], max = 0;
        for (int i = 1; i < prices.length; i++) {
            max = Math.max(max, prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        return max;
    }
}
