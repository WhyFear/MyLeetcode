import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/maximum-number-of-balloons/
 */
public class MaxNumberOfBalloons {
    public int maxNumberOfBalloons(String text) {
        if (text.length() < 7) return 0;
        int op = Integer.MAX_VALUE;
        Map<Character, Integer> count = new HashMap<>();
        count.put('b', 0);
        count.put('a', 0);
        count.put('l', 0);
        count.put('o', 0);
        count.put('n', 0);
        for (char chr : text.toCharArray()) {
            if (count.containsKey(chr)) {
                int tempCount = count.get(chr);
                count.put(chr, tempCount + 1);
            }
        }
        for (char chr : count.keySet()) {
            int result = count.get(chr);
            if (chr == 'l' || chr == 'o') result /= 2;
            op = Math.min(op, result);
        }
        return op;
    }

    /**
     * 别人的代码，利用数组，效率非常高。要熟悉字符串相减的操作
     * https://leetcode-cn.com/problems/maximum-number-of-balloons/comments/437023
     */
    public int maxNumberOfBalloons1(String text) {
        int[] bucket = new int[26];
        for (char c : text.toCharArray()) {
            bucket[c - 'a']++;
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < bucket.length; i++) {
            if (i == 'l' - 'a' || i == 'o' - 'a') {
                res = Math.min(res, bucket[i] / 2);
            } else if (i == 'a' - 'a' || i == 'b' - 'a' || i == 'n' - 'a') {
                res = Math.min(res, bucket[i]);
            }
        }
        return res;
    }
}

