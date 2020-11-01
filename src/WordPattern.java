import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/word-pattern/
 */
public class WordPattern {
    public boolean wordPattern(String pattern, String s) {
        String[] strings = s.split(" ");
        if (pattern.length() != strings.length) return false;
        Map<String, Character> map1 = new HashMap<>();
        Map<Character, String> map2 = new HashMap<>();
        int index = 0;
        for (int i = 0; i < strings.length; i++) {
            if (!map1.containsKey(strings[i])) {
                if (map2.containsKey(pattern.charAt(i))) return false;
                map1.put(strings[i], pattern.charAt(i));
                map2.put(pattern.charAt(i), strings[i]);
            }
            if (pattern.charAt(i) != map1.get(strings[i])) return false;
        }
        return true;
    }
}
