/**
 * https://leetcode-cn.com/problems/final-prices-with-a-special-discount-in-a-shop/
 */
public class FinalPrices {
    public int[] finalPrices(int[] prices) {
        int len = prices.length;
        int[] op = new int[len];
        if (len < 1) return prices;
        int min = prices[len - 1];
        for (int i = len - 1; i >= 0; i--) {
            if (prices[i] < min) {  //比最小的还小，那就没有折扣
                op[i] = prices[i];
                min = prices[i];
            } else { // 找到离自己最近的比自己小的值。
                int j = i + 1;
                while (j < len && prices[j] > prices[i]) j++;
                if (j == len) op[i] = prices[i];
                else op[i] = prices[i] - prices[j];
            }
        }
        return op;
    }
}
