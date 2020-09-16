import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MajorityElement {
    /**
     * https://leetcode-cn.com/problems/majority-element/
     * 投票算法比较好
     */
    public int majorityElement(int[] nums) {
        if (nums.length == 1) return nums[0];
        int len = nums.length / 2;
        Map<Integer, Integer> quantity = new HashMap<>();
        for (int num : nums) {
            if (!quantity.containsKey(num)) quantity.put(num, 1);
            else {
                int temp = quantity.get(num) + 1;
                if (temp > len) return num;
                quantity.put(num, temp);
            }
        }
        return 0;
    }

    /**
     * https://leetcode-cn.com/problems/majority-element-ii/
     * 摩尔投票法改进
     * chaoxi
     */
    public List<Integer> majorityElementII(int[] nums) {
        // 创建返回值
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        // 初始化两个候选人candidate，和他们的计票
        int cand1 = nums[0], count1 = 0;
        int cand2 = nums[0], count2 = 0;

        // 摩尔投票法，分为两个阶段：配对阶段和计数阶段
        // 配对阶段
        for (int num : nums) {
            // 投票
            if (cand1 == num) {
                count1++;
                continue;
            }
            if (cand2 == num) {
                count2++;
                continue;
            }

            // 第1个候选人配对
            if (count1 == 0) {
                cand1 = num;
                count1++;
                continue;
            }
            // 第2个候选人配对
            if (count2 == 0) {
                cand2 = num;
                count2++;
                continue;
            }
            // 都不匹配 都减一
            count1--;
            count2--;
        }

        // 计数阶段
        // 找到了两个候选人之后，需要确定票数是否满足大于 N/3
        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (cand1 == num) count1++;
            else if (cand2 == num) count2++;
        }

        if (count1 > nums.length / 3) res.add(cand1);
        if (count2 > nums.length / 3) res.add(cand2);

        return res;
    }
}
