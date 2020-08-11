/**
 * https://leetcode-cn.com/problems/one-away-lcci/
 * 其实应该用dp来做,三种改变就是三种状态
 */
public class OneEditAway {
    public boolean oneEditAway(String first, String second) {
        int len1 = first.length(), len2 = second.length();
        if (Math.abs(len1 - len2) > 1) return false;
        if (Math.abs(len1 - len2) == 1) { //插入或者删除的情况
            int i = 0, j = 0;
            boolean change = false;
            while (i < len1 && j < len2) {
                if (first.charAt(i) == second.charAt(j)) {
                    i++;
                    j++;
                } else {
                    if (change) return false;
                    change = true;
                    if (len1 > len2) i++;
                    else j++;
                }
            }
        } else { //编辑的情况
            int count = 0;
            int i = 0, j = 0;
            while (i < len1 && j < len2) {
                if (first.charAt(i) != second.charAt(j)) {
                    if (count == 1) return false;
                    count++;
                }
                i++;
                j++;
            }
        }
        return true;
    }
}
