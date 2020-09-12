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

    /**
     * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
     * 714.买卖股票的最佳时机含手续费
     * 买入卖出需要手续费，卖出后买入不需要手续费！！！
     */
    public int maxProfit(int[] prices, int fee) {
        int len = prices.length;
        if (len < 2) return 0;
        int[][] dp = new int[len][2]; // 0是未持有股票，1是持有股票
        dp[0][1] = -prices[0]; // 初始就持有，那么我的利润就是负的。
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee); //要嘛继续持有，要嘛将昨天的股票卖出
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]); //要嘛继续持有，要嘛买入新的股票。
        }
        return dp[len - 1][0];
    }
}
