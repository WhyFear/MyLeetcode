import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/online-stock-span/submissions/
 */
class StockSpanner {
    private final List<Integer> list;
    private final List<Integer> dp;

    public StockSpanner() {
        list = new ArrayList<>();
        dp = new ArrayList<>();
    }

    public int next(int price) {
        int op = 1;
        if (list.size() == 0) {
            list.add(price);
            dp.add(1);
        } else {
            int index = list.size() - 1;
            int oldPrice = list.get(index);
            while (oldPrice <= price) {
                index -= dp.get(index);
                if (index < 0) break;
                oldPrice = list.get(index);
            }
            op = list.size() - index;

            list.add(price);
            dp.add(op);
        }
        return op;
    }
}
