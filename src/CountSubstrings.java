/**
 * https://leetcode-cn.com/problems/palindromic-substrings/
 * 暴力法通过，其实可以用dp
 */
public class CountSubstrings {
    public int countSubstrings(String s) {
        int len = s.length();
        int op = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i; j <= len; j++) {
                if (isPalindrome(s.substring(i, j))) op++;
            }
        }
        return op;
    }

    private boolean isPalindrome(String str) {
        int len = str.length();
        if (len < 1) return false;
        if (len == 1) return true;
        int i = 0, j = len - 1;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}
