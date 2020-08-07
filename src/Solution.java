import java.util.*;


public class Solution {
    int res = 0;

    /**
     * 返回亲7数个数
     *
     * @param digit int整型一维数组 组成亲7数的数字数组
     * @return int整型
     */
    public int reletive_7(int[] digit) {
        // write code here
        dfs(digit, new HashSet<>(), "");
        return res;
    }

    private void dfs(int[] digit, Set<Integer> visited, String sb) {
        if (sb.length() == digit.length) {
            //可能超位数
            long result = Long.parseLong(sb.toString());
            if (result % 7 == 0) res++;
            return;
        }
        for (int i = 0; i < digit.length; i++) {
            if (!visited.contains(i)) {
                visited.add(i);
                dfs(digit, visited, sb + digit[i]);
                visited.remove(i);
            }
        }
    }
}