/**
 * https://leetcode-cn.com/problems/string-to-url-lcci/
 */
public class ReplaceSpaces {
    public String replaceSpaces(String S, int length) {
        StringBuilder op = new StringBuilder();
        char[] chars = S.toCharArray();
        for (int i = 0; i < length; i++) {
            char chr = chars[i];
            if (chr == ' ') op.append("%20");
            else op.append(chr);
        }
        return op.toString();
    }
}
