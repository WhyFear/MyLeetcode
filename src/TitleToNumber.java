/**
 * https://leetcode-cn.com/problems/excel-sheet-column-number/
 */
public class TitleToNumber {
    public int titleToNumber(String s) {
        int op = 0;
        int level = s.length() - 1;
        for (char temp : s.toCharArray()) {
            int dis = temp - 'A' + 1;
            op += (int) (Math.pow(26, level) * dis);
            level--;
        }
        return op;
    }
}
