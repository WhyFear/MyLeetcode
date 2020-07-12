import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/
 */
public class FirstUniqChar {
    public char firstUniqChar(String s) {
        if (s.equals("")) return ' ';
        int[] count = new int[26];
        char[] sChar = s.toCharArray();
        for (char temp : sChar) {
            count[temp - 'a']++;
        }
        for (char temp : sChar) {
            if (count[temp - 'a'] == 1) return temp;
        }
        return ' ';
    }
}
