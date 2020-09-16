import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/two-sum-iv-input-is-a-bst/
 */
public class FindTarget {
    Set<Integer> set = new HashSet<>();

    public boolean findTarget(TreeNode root, int k) {
        if (root == null) return false;
        if (set.contains(k - root.val)) return true;
        set.add(root.val);
        return findTarget(root.left, k) || findTarget(root.right, k);
    }
}
