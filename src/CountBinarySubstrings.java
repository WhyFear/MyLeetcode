/**
 * https://leetcode-cn.com/problems/count-binary-substrings/
 * 思路chaoxi
 */
public class CountBinarySubstrings {
    public int countBinarySubstrings(String s) {
        int op = 0;
        int len = s.length();
        int start = 0;
        while (start < len && s.charAt(start) == s.charAt(0)) start++;
        int pre = start;
        for (int i = start; i < len; ) {
            int j = i;
            while (j < len && s.charAt(j) == s.charAt(i)) j++;
            op += Math.min(pre, j - i);
            pre = j - i;
            i = j;
        }
        return op;
    }
}
