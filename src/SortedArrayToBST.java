/**
 * https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/
 * 每次找中间,偶数就随便
 */
public class SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        return nums == null ? null :dfs(nums, 0, nums.length - 1);
    }

    private TreeNode dfs(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = left + ((right - left) >> 1);
        TreeNode root = new TreeNode(nums[mid]);
        root.left = dfs(nums, left, mid - 1);
        root.right = dfs(nums, mid + 1, right);
        return root;
    }
}
