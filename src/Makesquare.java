import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/matchsticks-to-square/solution/huo-chai-pin-zheng-fang-xing-by-leetcode/
 * 没做出来
 */
public class Makesquare {
    public boolean makesquare(int[] nums) {
        if (nums.length < 4) return false;
        int sum = 0, torch = nums.length, maxTorchLen = 0;
        Map<Integer, Integer> torches = new HashMap<>(); //存储所有长度的火柴
        for (int num : nums) {
            maxTorchLen = Math.max(maxTorchLen, num);
            sum += num;
            if (!torches.containsKey(num)) torches.put(num, 1);
            else torches.put(num, torches.get(num) + 1);
        }
        if (sum == 0) return true;
        if (sum % 4 != 0) return false;
        int len = sum / 4;
        if (maxTorchLen > len) return false; //最长火柴比平均边长则不行。
        for (int num : nums) {
            torch--;
            int x = len - num;
            while (x > 0) {
                //找到符合条件的低于x长度的火柴，没有则返回false
                int thatTorch = findEligibilityTorch(torches, x);
                if (thatTorch == -1) return false;
                torch--;
                x -= thatTorch;
            }
        }
        return torch == 0;
    }

    public int findEligibilityTorch(Map<Integer, Integer> torches, int len) {
        while (len > 0) {
            if (torches.containsKey(len)) {
                int nums = torches.get(len);
                if (nums == 1) torches.remove(len);
                else torches.put(len, torches.get(len) - 1);
                return len;
            }
            len--;
        }
        return -1;
    }
}
