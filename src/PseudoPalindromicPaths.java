import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/pseudo-palindromic-paths-in-a-binary-tree/
 */
public class PseudoPalindromicPaths {
    int op;

    public int pseudoPalindromicPaths(TreeNode root) {
        op = 0;
        if (root == null) return op;
        dfs(root, "");
        return op;
    }

    private void dfs(TreeNode root, String path) {
        if (root.left == null && root.right == null) {
            if (isPalindromic(path + root.val)) op++;
            return;
        }
        if (root.left != null)
            dfs(root.left, path + root.val);
        if (root.right != null)
            dfs(root.right, path + root.val);
    }

    /**
     * 判断回文，只能有一个奇数。
     * 本题限定只能使用1-9数字，可以使用数组，如果有大数，则使用map更好
     */
    private boolean isPalindromic(String path) {
        boolean odd = false;
        Map<Character, Integer> count = new HashMap<>();
        for (char val : path.toCharArray()) {
            count.put(val, count.getOrDefault(val, 0) + 1);
        }
        for (char key : count.keySet()) {
            if (count.get(key) % 2 == 1) {
                if (!odd) odd = true;
                else return false;
            }
        }
        return true;
    }
}
