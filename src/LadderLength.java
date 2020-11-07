import java.util.*;

/**
 * https://leetcode-cn.com/problems/word-ladder/
 * chaoxi
 */
public class LadderLength {
    //BFS的思想
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue = new LinkedList<String>();//少不了队列
        queue.add(beginWord);
        boolean[] marked = new boolean[wordList.size()+1];//少不了标记
        int layer = 1;//注意返回的是层数+1.所以这里直接放1了
        while(!queue.isEmpty()) {//固定的层数记录形式
            layer++;
            int size = queue.size();
            while (size-->0) {
                String cur = queue.poll();
                for (int i = 0; i < wordList.size(); i++) {
                    if(marked[i])continue;
                    String dic = wordList.get(i);
                    if(canChange(dic, cur)) {
                        if(dic.equals(endWord))return layer;
                        queue.add(dic);
                        marked[i] = true;
                    }
                }
            }
        }

        return 0;
    }
    //是否可以转换的辅助函数
    public boolean canChange(String s,String t) {
        int len = s.length();
        int diff = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) != t.charAt(i))diff++;
        }
        return diff==1;
    }
}
/*
// 超时代码
public class LadderLength {
    int op = Integer.MAX_VALUE;

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        boolean haveEndWord = false;
        for (String str : wordList)
            if (str.equals(endWord)) {
                haveEndWord = true;
                break;
            }
        if (!haveEndWord) return 0;
        Set<String> visited = new HashSet<>();

        dfs(beginWord, endWord, wordList, 1, visited);

        return op == Integer.MAX_VALUE ? 0 : op;
    }

    private void dfs(String word, String endWord, List<String> wordList, int level, Set<String> visited) {
        if (word.equals(endWord)) {
            op = Math.min(op, level);
            return;
        }
        for (String str : wordList) {
            if (!visited.contains(str) && isDiffOne(str, word)) {
                visited.add(str);
                dfs(str, endWord, wordList, level + 1, visited);
                visited.remove(str);
            }
        }
    }

    private boolean isDiffOne(String word1, String word2) {
        if (word1.length() != word2.length()) return false;
        int diffCount = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) diffCount++;
            if (diffCount > 1) return false;
        }
        return true;
    }
}
 */