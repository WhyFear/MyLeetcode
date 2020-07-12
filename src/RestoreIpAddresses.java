import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> op = new ArrayList<>();
        if (s.length() < 4 || s.length() > 12) return op;
        dfs(op, "", s, 0, 1);
        return op;
    }

    /**
     * @param op    输出
     * @param ip    递归路径可能的ip
     * @param s     输入值
     * @param index 在s的索引
     * @param level 递归层数
     */
    public void dfs(List<String> op, String ip, String s, int index, int level) {
        int len = s.length();
        if (len - index <= 4 - level || len - index > 3 * (5 - level)) return;  //剪枝，小于当前层数最少的数或者大于当前层数以后最多能添加的数
        if (level == 4) {
            if (canBeIP(s, index, len - index))
                op.add(ip + s.substring(index, len));
            return;
        }
        if (index <= len - 1 && canBeIP(s, index, 1)) //向后添加一位数字，一下以此类推
            dfs(op, ip + s.substring(index, index + 1) + ".", s, index + 1, level + 1);
        if (index <= len - 2 && canBeIP(s, index, 2))
            dfs(op, ip + s.substring(index, index + 2) + ".", s, index + 2, level + 1);
        if (index <= len - 3 && canBeIP(s, index, 3))
            dfs(op, ip + s.substring(index, index + 3) + ".", s, index + 3, level + 1);
    }

    /**
     * 判断这几位数字能否作为ip
     * 警惕0开头的字符串
     */
    private boolean canBeIP(String s, int index, int len) {
        String temp = s.substring(index, index + len);
        if (temp.charAt(0) == '0') return len == 1;
        if (temp.charAt(0) > '2') return len < 3;
        return Integer.parseInt(temp) < 256;
    }
}
