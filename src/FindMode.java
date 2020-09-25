import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindMode {
    Map<Integer, Integer> count = new HashMap<>();
    int max = 0;

    public int[] findMode(TreeNode root) {
        dfs(root);
        List<Integer> op = new ArrayList<>();
        for (int key : count.keySet()) {
            if (count.get(key) == max) op.add(key);
        }
        int[] temp = new int[op.size()];
        for (int i = 0; i < op.size(); i++) temp[i] = op.get(i);
        return temp;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        count.put(root.val, count.getOrDefault(root.val, 0) + 1);
        max = Math.max(max, count.get(root.val));
        dfs(root.left);
        dfs(root.right);
    }
}
