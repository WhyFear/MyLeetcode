import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/valid-anagram/
 */
public class IsAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.equals(t) && s.length() <= 1) return true;
        if (s.equals(t) || s.length() != t.length()) return false;
        char[] chrS = s.toCharArray();
        char[] chrT = t.toCharArray();
        Arrays.sort(chrS);
        Arrays.sort(chrT);
        return Arrays.equals(chrS, chrT);
    }
}
