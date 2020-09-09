/**
 * https://leetcode-cn.com/problems/license-key-formatting/
 */
public class LicenseKeyFormatting {
    public String licenseKeyFormatting(String S, int K) {
        if (S.length() < 1) return "";
        int len = S.length();
        StringBuilder op = new StringBuilder();
        char[] chars = S.toCharArray();
        int count = 0;
        for (int i = len - 1; i >= 0; i--) {
            if (chars[i] != '-') {
                if (count == K) {
                    count = 0;
                    op.append("-");
                }
                op.append(chars[i]);
                count++;
            }
        }
        return op.reverse().toString().toUpperCase();
    }
}
