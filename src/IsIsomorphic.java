import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/isomorphic-strings/
 */
public class IsIsomorphic {
    public boolean isIsomorphic(String s, String t) {
        return format(s).equals(format(t));
    }

    private String format(String str) {
        StringBuilder op = new StringBuilder();
        char start = 'a';
        Map<Character, Character> dict = new HashMap<>();
        for (char chr : str.toCharArray()) {
            if (!dict.containsKey(chr)) {
                op.append(start);
                dict.put(chr, start++);
            } else {
                op.append(dict.get(chr));
            }
        }
        return op.toString();
    }
}
