import java.util.*;

/**
 * https://leetcode-cn.com/problems/house-robber/
 */
public class Rob {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 5, 9, 7, 1};
        System.out.println(rob(nums));
    }

    /**
     * 简单题居然用到了dp
     * 使用temp存储当前节点两个之前的最大值
     */
    public static int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        int op = nums[0];
        int temp = nums[0];
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i <= 1) dp[i] = nums[i];
            else {
                temp = Math.max(temp, dp[i - 2]);
                dp[i] = nums[i] + temp;
            }
            op = Math.max(op, dp[i]);
        }
        return op;
    }

    /**
     * https://leetcode-cn.com/problems/house-robber-ii/solution/213-da-jia-jie-she-iidong-tai-gui-hua-jie-gou-hua-/
     * chaoxi
     */
    public int robii(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        return Math.max(myRob(Arrays.copyOfRange(nums, 0, nums.length - 1)),
                myRob(Arrays.copyOfRange(nums, 1, nums.length)));
    }

    private int myRob(int[] nums) {
        int pre = 0, cur = 0, tmp;
        for (int num : nums) {
            tmp = cur;
            cur = Math.max(pre + num, cur);
            pre = tmp;
        }
        return cur;
    }

    /**
     * https://leetcode-cn.com/problems/house-robber-iii/
     * chaoxi
     * 其实还是easy dp 但是就是想不到应该用什么方法
     */
    Map<TreeNode, Integer> sums;

    public int rob(TreeNode root) {
        sums = new HashMap<>();
        return dfs(root);
    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;
        if (sums.containsKey(root)) return sums.get(root);
        //要偷取当前层
        int res = 0;
        if (root.left != null) res += dfs(root.left.left) + dfs(root.left.right);
        if (root.right != null) res += dfs(root.right.left) + dfs(root.right.right);
        res += root.val;
        //不偷取当前层
        int res2 = dfs(root.left) + dfs(root.right);

        sums.put(root, Math.max(res, res2));
        return sums.get(root);
    }
}
