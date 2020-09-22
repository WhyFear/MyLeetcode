import java.util.ArrayList;
import java.util.List;


public class FindLadders {
    public List<String> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<String> op = new ArrayList<>();
        if (!wordList.contains(endWord)) return op;
        List<String> temp = new ArrayList<>() {{
            add(beginWord);
        }};
        dfs(beginWord, endWord, temp, op, wordList);
        return op;
    }

    private void dfs(String word, String endWord, List<String> temp, List<String> op, List<String> wordList) {
        if (word.equals(endWord)) {
            op = new ArrayList<>(temp);
            return;
        }
        for (String str : wordList) {
            if (!temp.contains(str) && isDiffOne(str, word)) {
                temp.add(str);
                dfs(str, endWord, temp, op, wordList);
                temp.remove(temp.size() - 1);
            }
        }
    }

    private boolean isDiffOne(String word, String word1) {
        if (word.length() != word1.length()) return false;
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) != word1.charAt(i)) count++;
            if (count > 1) return false;
        }
        return true;
    }
}
