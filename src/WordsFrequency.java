import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/words-frequency-lcci/
 * 为什么难度是中等？
 */
public class WordsFrequency {
    Map<String, Integer> map;

    public WordsFrequency(String[] book) {
        map = new HashMap<>();
        for (String str : book) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
    }

    public int get(String word) {
        return map.getOrDefault(word, 0);
    }
}
