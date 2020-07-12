import java.util.HashMap;
import java.util.Map;


public class BuildTree {
    int i, j;
    private Map<Integer, Integer> indexMap;

    public TreeNode myBuildTree(int[] preorder, int preorder_left, int preorder_right, int inorder_left) {
        if (preorder_left > preorder_right) {
            return null;
        }

        // 前序遍历中的第一个节点就是根节点
        // 在中序遍历中定位根节点
        int inorder_root = indexMap.get(preorder[preorder_left]);

        // 先把根节点建立出来
        TreeNode root = new TreeNode(preorder[preorder_left]);
        // 得到左子树中的节点数目
        int size_left_subtree = inorder_root - inorder_left;
        // 递归地构造左子树，并连接到根节点
        // 先序遍历中「从 左边界+1 开始的 size_left_subtree」个元素就对应了中序遍历中「从 左边界 开始到 根节点定位-1」的元素
        root.left = myBuildTree(preorder, preorder_left + 1, preorder_left + size_left_subtree, inorder_left);
        // 递归地构造右子树，并连接到根节点
        // 先序遍历中「从 左边界+1+左子树节点数目 开始到 右边界」的元素就对应了中序遍历中「从 根节点定位+1 到 右边界」的元素
        root.right = myBuildTree(preorder, preorder_left + size_left_subtree + 1, preorder_right, inorder_root + 1);
        return root;
    }

    /**
     * https://leetcode-cn.com/problems/
     * 从前序与中序遍历序列构造二叉树
     * 前序遍历 preorder = [3,9,20,15,7]
     * 中序遍历 inorder = [9,3,15,20,7]
     * <p>
     * 前序遍历第一个一定是根节点
     * 根据根节点位置，把中序遍历分为左右两颗子树，将两颗子树在前序遍历中分为两部分，第一个节点又是根节点。以此类推。
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        // 构造哈希映射，帮助我们快速定位根节点
        indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        return myBuildTree(preorder, 0, n - 1, 0);
    }

    private TreeNode recursion(int[] inorder, int[] postorder, int stop) {
        if (j < 0) {
            return null;
        }
        if (inorder[i] == stop) {
            i--;
            return null;
        }
        TreeNode node = new TreeNode(postorder[j--]);
        node.right = recursion(inorder, postorder, node.val);
        node.left = recursion(inorder, postorder, stop);
        return node;
    }

    /**
     * https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
     * 根据一棵树的中序遍历与后序遍历构造二叉树。
     * 中序遍历 inorder = [9,3,15,20,7]
     * 后序遍历 postorder = [9,15,7,20,3]
     */
    public TreeNode buildTree1(int[] inorder, int[] postorder) {
        if (inorder.length == 0) {
            return null;
        }
        i = inorder.length - 1;
        j = postorder.length - 1;
        return recursion(inorder, postorder, Integer.MAX_VALUE);
    }
}
