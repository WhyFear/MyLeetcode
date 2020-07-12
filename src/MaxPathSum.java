/**
 * https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/
 * [5,4,8,11,null,13,4,7,2,null,null,null,1]
 * 为什么结果是48不是所有数相加的值55？
 */
public class MaxPathSum {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(-2);
        root.right = new TreeNode(-3);
        root.right.left = new TreeNode(-2);
        root.left.left = new TreeNode(1);
        root.left.left.left = new TreeNode(-1);
        root.left.right = new TreeNode(3);
        System.out.println(maxPathSum(root));
    }

    public static int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        return findMax(root, root);
    }

    public static int findMax(TreeNode root, TreeNode rootNode) {
        if (root == null) return 0;
        int leftSum = Integer.MIN_VALUE, rightSum = Integer.MIN_VALUE, temp = root.val;
        if (root.left != null) {
            leftSum = findMax(root.left, rootNode);
            if (leftSum > 0) {
                temp += leftSum;
            }
        }
        if (root.right != null) {
            rightSum = findMax(root.right, rootNode);
            if (rightSum > 0) {
                temp += rightSum;
            }
        }
        if (temp > 0 && root != rootNode) return temp;
        if (temp > leftSum && temp > rightSum)
            return temp;
        else {
            return Math.max(leftSum, rightSum);
        }
    }
}
