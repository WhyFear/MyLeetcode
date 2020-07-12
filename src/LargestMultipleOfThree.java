import java.util.*;

/**
 * https://leetcode-cn.com/problems/largest-multiple-of-three/
 * 思路，一个数组记录除了当前节点外其他节点的和，然后从小到大遍历，余数为零的就排除这个结点
 * chaoxi
 * 数学题
 */
public class LargestMultipleOfThree {
    public String largestMultipleOfThree(int[] digits) {
        int[] dp = new int[10];
        for(int digit: digits)
            dp[digit]++;

        int sum = getSum(dp);
        boolean flag = false;
        while(sum % 3 != 0)
        {
            int var = sum % 3;
            for(int i = 0; i < 3; i++)
            {
                if(dp[i * 3 + var] > 0)
                {
                    dp[i * 3 + var]--;
                    flag = true;
                    break;
                }
            }
            if(flag)
                break;
            for(int i = 1; i <= 3; i++)
            {
                if(dp[i * 3 - var] > 0)
                {
                    dp[i * 3 - var]--;
                    break;
                }
            }
            sum = getSum(dp);
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 9; i >= 0; --i)
            sb.append(String.valueOf(i).repeat(dp[i]));//重复dp[i]次

        String res = sb.toString();
        if(res.startsWith("0"))
            return "0";
        return res;
    }

    private int getSum(int[] dp) {
        int sum = 0;
        for(int i = 1; i < 10; i++)
            sum += i * dp[i];
        return sum;
    }
}
