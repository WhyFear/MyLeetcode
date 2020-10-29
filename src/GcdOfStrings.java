/**
 * https://leetcode-cn.com/problems/greatest-common-divisor-of-strings/
 */
public class GcdOfStrings {
    public String gcdOfStrings(String str1, String str2) {
        StringBuilder sb = new StringBuilder();
        int len = Math.min(str1.length(), str2.length());
        for (int i = 0; i < len; i++) {
            if (str1.charAt(i) == str2.charAt(i)) {
                sb.append(str1.charAt(i));
            } else break;
        }
        for (int i = sb.length() - 1; i >= 0; i--) {
            if (check(str1, sb.toString()) && check(str2, sb.toString())) break;
            sb.deleteCharAt(i);
        }
        return sb.toString();
    }

    private boolean check(String str1, String str) {
        if (str.length() == 0) return false;
        if (str1.length() % str.length() != 0) return false;
        return str.repeat(str1.length() / str.length()).equals(str1);
    }
}
