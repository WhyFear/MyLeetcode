/**
 * https://leetcode-cn.com/problems/repeated-substring-pattern/
 */
public class RepeatedSubstringPattern {
    public boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        int i = len / 2;
        while (i >= 1) {
            while (i >= 1 && s.charAt(0) != s.charAt(i)) i--;
            if (i < 1) return false;
            int j = i, start = 0;
            while (j < len) {
                if (s.charAt(j) != s.charAt(start)) break;
                j++;
                start = ++start % i;
            }
            if (j == len && start == 0) return true; // 比较完成
            i--;
        }
        return false;
    }
}
