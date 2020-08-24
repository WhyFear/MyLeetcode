/**
 * 汇顶科技 2020-08-24 笔试题
 */
public class PrintMaxChar {
    public String printMaxChar(String str) {
        // write code here
        char[] chars = str.toCharArray();
        int max = 0;
        for (int i = 0; i < chars.length; ) {
            int j = i;
            while (j < chars.length && chars[j] == chars[i]) j++;
            int result = j - i;
            max = Math.max(max, result);
            i = j;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; ) {
            int j = i;
            while (j < chars.length && chars[j] == chars[i]) j++;
            int result = j - i;
            if (result == max) {
                sb.append(chars[i]);
                sb.append(";");
            }
            i = j;
        }
        return sb.substring(0, sb.length() - 1);
    }
}
