import java.util.*;

/**
 * https://leetcode-cn.com/problems/substring-with-concatenation-of-all-words/
 */
public class FindSubstring {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> op = new ArrayList<>();
        Set<Character> headChar = new HashSet<>(); // 降用时
        if (words.length == 0 || words[0].length() == 0) return op;
        int wordLen = words[0].length();
        int len = wordLen * words.length;
        if (s.length() < len) return op;
        for (String str : words) {
            headChar.add(str.charAt(0));
        }
        int right = s.length() - len;
        for (int i = 0; i <= right; i++) {
            if (headChar.contains(s.charAt(i))) {
                if (isContains(s, i, i + len, words, wordLen)) op.add(i);
            }
        }
        return op;
    }

    private boolean isContains(String str, int left, int right, String[] words, int wordLen) {
        int[] used = new int[words.length];//存储words中被用过字符串的index
        for (int i = left; i < right; i += wordLen) {
            if (!wordsIsContainSubstring(str.substring(i, i + wordLen), words, used)) return false;
        }
        return true;
    }

    private boolean wordsIsContainSubstring(String s, String[] words, int[] used) {
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(s)) {
                if (used[i] == 0) {
                    used[i] = 1;
                    return true;
                }
            }
        }
        return false;
    }
}
