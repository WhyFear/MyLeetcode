import java.util.Arrays;

/**
 * https://leetcode.cn/problems/longest-uncommon-subsequence-ii/
 */
public class FindLUSLength {
    public int findLUSlength(String[] strs) {
        if (strs.length == 0) return -1;
        if (strs.length == 1) return strs[0].length();
        Arrays.sort(strs, (o1, o2) -> o2.length() - o1.length());

        boolean find = false;
        int len = strs[0].length();
        for (int i = 0; i < strs.length; i++) {
            len = strs[i].length();
            boolean special = true;
            for (int j = 0; j < strs.length; j++) {
                if (i == j) {
                    continue;
                }
                if (strs[j].length() < len) {
                    break;
                }
                if (judge(strs[i], strs[j])) {
                    special = false;
                    break;
                }
            }
            if (special) {
                find = true;
                break;
            }
        }

        return find ? len : -1;
    }

    private boolean judge(String s1, String s2) {
        if (s1.length() == s2.length()) {
            return s1.equals(s2);
        }
        int i = 0, j = 0;
        while (i < s1.length() && j < s2.length()) {
            if (s1.charAt(i) == s2.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == s1.length();
    }
}
