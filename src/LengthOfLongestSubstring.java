/*
 * https://leetcode-cn.com/explore/interview/card/bytedance/242/string/1012/
 */


import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        String str = "aabaab!bb";
        System.out.println(lengthOfLongestSubstring1(str));
    }

    /**
     * 之前写的
     */
    public static int lengthOfLongestSubstring1(String s) {
        int maxLength = 0;
        char[] arr = s.toCharArray();
        for (int left = 0, right = 0; right < s.length(); ) {
            for (int k = left; k < right; k++) {
                if (arr[k] == arr[right]) {
                    left = k + 1;
                    break;
                }
            }
            right++;
            if (right - left > maxLength) {
                maxLength = right - left;
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


    public static int lengthOfLongestSubstring2(String s) {
        int res = 0;
        Set<Character> set = new HashSet<>();
        for (int l = 0, r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            while (set.contains(c)) {
                set.remove(s.charAt(l++));
            }
            set.add(c);
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}
