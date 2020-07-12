/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/solution/yi-ge-fang-fa-tuan-mie-6-dao-gu-piao-wen-ti-by-lab/
 */
public class MaxProfitWithCoolDown {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) return 0;

        //0表示本不持有，1表示持有，2表示当天卖出，不持有
        int[][] dp = new int[len][3];  //用二维数组记录当天各种情况的最优解(收益的最大值)
        dp[0][1] = -prices[0];  //第一天若持有，则收益为负；不持有则收益为零

        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2]);  //当天的本不持有可以由前一天本不持有或前一天卖出得到
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);  //当天的持有可以由前一天的持有或前一天的本不持有-当天的股票价格得到, 即买进一只股票
            dp[i][2] = dp[i - 1][1] + prices[i];  //当天卖出可以由前一天的持有+当天的股票价格得到, 即卖出手中的股票
        }
        return Math.max(dp[len - 1][0], dp[len - 1][2]);  //返回最后一天不持有股票的状态，此处可以得到收益的最大值
    }
}
