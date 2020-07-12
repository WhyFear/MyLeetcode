import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/subsets/
 */
public class Subsets {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4};
        System.out.println(subsets(nums).toString());
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> op = new ArrayList<>();
        if (nums.length == 0) return op;
        for (int num : nums) {
            int len = op.size();
            for (int j = 0; j < len; j++) {
                List<Integer> temp = new ArrayList<>(op.get(j));
                temp.add(num);
                op.add(temp);
            }
            List<Integer> self = new ArrayList<>();
            self.add(num);
            op.add(self);
        }
        op.add(new ArrayList<>());
        return op;
    }
}
