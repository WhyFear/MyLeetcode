/**
 * https://leetcode-cn.com/problems/break-a-palindrome/
 * chaoxi
 */
public class BreakPalindrome {
    public String breakPalindrome(String palindrome) {
        int len = palindrome.length();
        if (len <= 1) {
            return "";
        }
        char[] palindromeChars = palindrome.toCharArray();

        for (int i = 0; i < len / 2; i++) {
            if (palindromeChars[i] != 'a') {
                palindromeChars[i] = 'a';
                return String.valueOf(palindromeChars);
            }
        }
        palindromeChars[len-1] = 'b';
        return String.valueOf(palindromeChars);
    }
}
