import java.util.*;

/**
 * https://leetcode-cn.com/problems/recover-binary-search-tree/
 * O(N)解法很容易实现,使用中序遍历然后找到错误的两个节点
 */
public class RecoverTree {
    List<Integer> inorder;

    public void recoverTree(TreeNode root) {
        if (root == null) return;
        inorder = new ArrayList<>();
        dfs(root);
        int[] inorderTemp = new int[inorder.size()];
        for (int i = 0; i < inorder.size(); i++) {
            inorderTemp[i] = inorder.get(i);
        }
        Arrays.sort(inorderTemp);

        Map<Integer, Integer> notInPlace = new HashMap<>();
        for (int i = 0; i < inorderTemp.length; i++) {
            if (inorderTemp[i] != inorder.get(i)) {
                notInPlace.put(inorder.get(i), inorderTemp[i]);
                notInPlace.put(inorderTemp[i], inorder.get(i));
                break;
            }
        }
        change(root, notInPlace);
    }

    private void change(TreeNode root, Map<Integer, Integer> map) {
        if (map.size() == 0) return;
        if (root == null) return;
        if (map.containsKey(root.val)) {
            int temp = root.val;
            root.val = map.get(root.val);
            map.remove(temp);
        }
        change(root.left, map);
        change(root.right, map);
    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        inorder.add(root.val);
        dfs(root.right);
    }
}
