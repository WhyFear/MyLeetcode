import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof/
 */
public class PermutationII {
    public String[] permutation(String s) {
        Set<String> op = new HashSet<>();
        boolean[] used = new boolean[8];
        dfs(s, used, new StringBuilder(), op);
        return op.toArray(new String[0]);
    }

    private void dfs(String s, boolean[] used, StringBuilder sb, Set<String> op) {
        if (sb.length() == s.length()) {
            op.add(new String(sb));
        }
        for (int i = 0; i < s.length(); i++) {
            if (!used[i]) {
                used[i] = true;
                sb.append(s.charAt(i));
                dfs(s, used, sb, op);
                sb.deleteCharAt(sb.length()-1);
                used[i] = false;
            }
        }
    }
}
