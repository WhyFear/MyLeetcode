import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/lexicographical-numbers/
 */
public class LexicalOrder {
    List<Integer> op;
    int maxN;

    public List<Integer> lexicalOrder(int n) {
        op = new ArrayList<>();
        maxN = n;
        for (int i = 1; i < 10; i++)
            dfs(i);
        return op;
    }

    private void dfs(int num) {
        if (num > maxN) return;
        op.add(num);
        for (int i = 0; i < 10; i++) {
            dfs(num * 10 + i);
        }
    }
}
