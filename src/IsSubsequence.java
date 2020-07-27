/**
 * https://leetcode-cn.com/problems/is-subsequence/
 */
public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        if (sLen > tLen) return false;
        int i = 0, j = 0;
        while (i < sLen && j < tLen) {
            char temp = s.charAt(i);
            while (t.charAt(j) != temp) {
                j++;
                if (j == tLen) return false;
            }
            i++;
            j++;
        }
        return i == sLen;
    }
}
