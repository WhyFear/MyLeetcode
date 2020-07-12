/**
 * https://leetcode-cn.com/problems/reverse-string-ii/
 */
public class ReverseStr {
    public String reverseStr(String s, int k) {
        char[] a = s.toCharArray();
        for (int start = 0; start < a.length; start += 2 * k) {
            int i = start, j = Math.min(start + k - 1, a.length - 1);
            while (i < j) {
                char tmp = a[i];
                a[i++] = a[j];
                a[j--] = tmp;
            }
        }
        return new String(a);
    }

    public String myReverseStr(String s, int k) {
        if (s.length() == 1) return s;
        StringBuilder op = new StringBuilder();
        for (int i = 0; i < s.length(); ) {
            int end = Math.min(i + k, s.length());
            String temp = s.substring(i, end);
            if ((i / k) % 2 == 0) {
                op.append(reverseString(temp));
            } else
                op.append(temp);
            i += k;
        }
        return op.toString();
    }

    private String reverseString(String s) {
        int i = 0, j = s.length() - 1;
        char[] ss = s.toCharArray();
        while (i < j) {
            char temp = ss[i];
            ss[i] = ss[j];
            ss[j] = temp;
            i++;
            j--;
        }
        return String.valueOf(ss);
    }
}
