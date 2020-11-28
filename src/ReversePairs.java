import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * https://leetcode-cn.com/problems/reverse-pairs/
 * chaoxi
 */
class ReversePairs {
    public int reversePairs(int[] nums) {
        Set<Long> allNumbers = new TreeSet<Long>();
        for (int x : nums) {
            allNumbers.add((long) x);
            allNumbers.add((long) x * 2);
        }
        // 利用哈希表进行离散化
        Map<Long, Integer> values = new HashMap<Long, Integer>();
        int idx = 0;
        for (long x : allNumbers) {
            values.put(x, idx);
            idx++;
        }

        int ret = 0;
        BIT bit = new BIT(values.size());
        for (int num : nums) {
            int left = values.get((long) num * 2), right = values.size() - 1;
            ret += bit.query(right + 1) - bit.query(left + 1);
            bit.update(values.get((long) num) + 1, 1);
        }
        return ret;
    }
}

class BIT {
    int[] tree;
    int n;

    public BIT(int n) {
        this.n = n;
        this.tree = new int[n + 1];
    }

    public static int lowbit(int x) {
        return x & (-x);
    }

    public void update(int x, int d) {
        while (x <= n) {
            tree[x] += d;
            x += lowbit(x);
        }
    }

    public int query(int x) {
        int ans = 0;
        while (x != 0) {
            ans += tree[x];
            x -= lowbit(x);
        }
        return ans;
    }
}
