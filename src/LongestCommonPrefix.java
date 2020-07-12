import java.util.Arrays;
import java.util.Scanner;

/*
 * https://leetcode-cn.com/problems/longest-common-prefix/
 * */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = new String[]{"aa","a"};
        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length > 0) {
            Arrays.sort(strs);
            String tmp = strs[0];
            if (strs.length != 1) {
                for (int i = 0; i < strs[0].length(); i++) {
                    for (String s : strs) {
                        if (tmp.charAt(i) != s.charAt(i)) {
                            return tmp.substring(0, i);
                        }
                    }
                }
            }
            return tmp;
        }
        return "";
    }
}
