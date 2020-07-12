/**
 * https://leetcode-cn.com/problems/get-equal-substrings-within-budget/
 * 注意是子字符串，不是随便抽三个出来，这是一道滑动窗口的题
 * chaoxi
 */
public class EqualSubstring {
    public int equalSubstring(String s, String t, int maxCost) {
        int len = s.length();
        int[] gap = new int[len];
        for (int index = 0; index < len; index++) {
            gap[index] = Math.abs(s.charAt(index) - t.charAt(index));
        }
        int maxLen = 0;
        int curGap = 0;
        for (int gindex = 0, startIndex = 0; gindex < len; gindex++) {
            if (curGap + gap[gindex] > maxCost) {
                curGap = curGap + gap[gindex] - gap[startIndex];
                startIndex++;
            } else {
                curGap += gap[gindex];
                maxLen = Math.max(maxLen, gindex - startIndex + 1);
            }
        }
        return maxLen;
    }
}
