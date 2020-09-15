import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/roman-to-integer/
 */
public class RomanToInt {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>() {{
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }};
        int op = 0;
        int last = Integer.MAX_VALUE;
        char[] sChars = s.toCharArray();
        for (int i = 0; i < sChars.length; i++) {
            int result = map.get(sChars[i]);
            if (last < result) {
                result -= 2 * map.get(sChars[i - 1]);
            }
            last = result;
            op += result;
        }
        return op;
    }
}
