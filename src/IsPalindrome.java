public class IsPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome("  "));
    }

    /**
     * https://leetcode-cn.com/problems/valid-palindrome/
     */
    public static boolean isPalindrome(String s) {
        if (s.length() <= 1) return true;
        char[] ss = s.toCharArray();
        int i = 0, j = ss.length - 1;
        while (i <= j) {
            while (i < j && !Character.isDigit(ss[i]) && !Character.isAlphabetic(ss[i])) i++;
            while (i < j && !Character.isDigit(ss[j]) && !Character.isAlphabetic(ss[j])) j--;
            String strI = String.valueOf(ss[i]).toLowerCase();
            String strJ = String.valueOf(ss[j]).toLowerCase();
            if (!strI.equals(strJ)) return false;
            i++;
            j--;
        }
        return true;
    }

    /**
     * https://leetcode-cn.com/problems/palindrome-number/
     */
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        if (x == 0) return true;
        if (x % 10 == 0) return false;
        char[] temp = String.valueOf(x).toCharArray();
        int i = 0, j = temp.length - 1;
        while (i <= j) {
            if (temp[i++] != temp[j--]) {
                return false;
            }
        }
        return true;
    }
}
