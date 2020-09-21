import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/permutation-i-lcci/
 * 回溯法
 * chaoxi
 */
public class Permutation {
    /**
     如果字符串有重复字母，最简单的去重是使用Set，也可以排序后下标剪枝（相对比较难）
     重复字母的全排列可去做《全排列》系列题目。这道题好像和全排列I差不多。
     接着要做的就是回溯模板啦，选了的跳过，每次选或不选即可爆搜到所有解。
     */
    private List<String> res;
    private boolean[] used;
    private int len;

    public String[] permutation(String S) {
        len = S.length();
        used = new boolean[len];
        res = new ArrayList<>();

        dfs(S, new StringBuilder(), 0);

        return res.toArray(new String[0]);
    }

    private void dfs(String s, StringBuilder sb, int begin) {
        // end —— 当sb长度与s长度一致时结束，存储答案
        if (begin == len) {
            res.add(sb.toString());
            return;
        }

        // 回溯模板
        for (int i = 0; i < len; i++) {
            if (!used[i]) {
                used[i] = true;
                sb.append(s.charAt(i));
                dfs(s, sb, begin + 1);
                used[i] = false; // 回溯法精髓，用了之后恢复原状态
                sb.deleteCharAt(begin);
            }
        }
    }
}
