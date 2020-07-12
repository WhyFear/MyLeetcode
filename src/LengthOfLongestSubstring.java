/**
 * https://leetcode-cn.com/explore/interview/card/bytedance/242/string/1012/
 */


import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        String str = "aabaab!bb";
        System.out.println(lengthOfLongestSubstring(str));
    }

    /**
     * 之前写的
     */
    public static int lengthOfLongestSubstring1(String s) {
        int maxLength = 0;
        char[] arr = s.toCharArray();
        for (int i = 0, j = 0; j < s.length(); ) {
            for (int k = i; k < j; k++) {
                if (arr[k] == arr[j]) {
                    i = k + 1;
                    break;
                }
            }
            j++;
            if (j - i > maxLength) {
                maxLength = j - i;
            }
        }
        return maxLength;
    }

    /**
     * 这个方法更直观，但是更慢了，144ms。上面的2ms
     */
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) return s.length();
        int op = 0;
        for (int i = 0; i < s.length(); i++) {
            Set<Character> temp = new HashSet<>();
            for (int j = i; j < s.length(); j++) {
                if (temp.contains(s.charAt(j))) break;
                temp.add(s.charAt(j));
            }
            op = Math.max(op, temp.size());
        }
        return op;
    }
}
