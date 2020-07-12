import java.util.Arrays;

public class ReverseWords {
    public static void main(String[] args) {
//        System.out.println(reverseWords("a good   example"));
        System.out.println(reverseWordsIII("a good   example"));
    }

    /**
     * https://leetcode-cn.com/explore/interview/card/bytedance/242/string/1011/
     */
    public static String reverseWords(String s) {
        String tmp = s.trim();
        StringBuilder op = new StringBuilder();
        int j;
        for (int i = tmp.length() - 1; i >= 0; ) {
            j = i;
            while (j >= 0 && !Character.isSpaceChar(tmp.charAt(j))) j--;
            op.append(tmp, j + 1, i + 1);
            if (j < 0) break;
            i = j;
            while (Character.isSpaceChar(tmp.charAt(i))) {
                i--;
            }
            op.append(" ");
        }
        return op.toString();
    }

    /**
     * https://leetcode-cn.com/problems/reverse-words-in-a-string-iii/
     */
    public static String reverseWordsIII(String s) {
        char[] ss = s.toCharArray();
        for (int i = 0; i < ss.length; ) {
            int j = i;
            while (j < ss.length && !String.valueOf(ss[j]).equals(" ")) j++;
            int tmp = j;
            j--;
            while (i < j) {
                char temp = ss[i];
                ss[i] = ss[j];
                ss[j] = temp;
                i++;
                j--;
            }
            i = tmp;
            while (i < ss.length && String.valueOf(ss[i]).equals(" ")) i++;
        }
        return new String(ss);
    }
}
