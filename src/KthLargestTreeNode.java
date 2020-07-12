import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/
 * 这是二叉搜索树，不是普通树
 * 二叉搜索树的中序遍历为递增序列，那么右根左为递减序列，以此找到第K个
 */
public class KthLargestTreeNode {
    PriorityQueue<Integer> heap;

    public int kthLargest(TreeNode root, int k) {
        heap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        dfs(root);
        while (k > 1) {
            heap.poll();
            k--;
        }
        return heap.peek();
    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        heap.add(root.val);
        dfs(root.left);
        dfs(root.right);
    }
}
/*
根据性质的题解
class Solution {
    private int res, k;
    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        midTraverse(root);
        return res;
    }
    private void midTraverse(TreeNode root){
        if(root == null){
            return;
        }
        midTraverse(root.right);
        k--;
        if(k == 0){
            res = root.val;
            return;
        }
        midTraverse(root.left);
    }
}
 */
