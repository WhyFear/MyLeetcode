/**
 * https://leetcode-cn.com/problems/split-a-string-in-balanced-strings/
 */
public class BalancedStringSplit {
    public int balancedStringSplit(String s) {
        if (s.length() <= 1) return s.length();
        int op = 0;
        char[] sChr = s.toCharArray();
        int len = sChr.length;
        int[] LRCount = new int[2];
        if (sChr[0] == 'R') LRCount[0]++;
        else LRCount[1]++;
        for (int i = 1; i < len; i++) {
            int j = i;
            while (j < len && LRCount[0] != LRCount[1]) {
                if (sChr[j] == 'R') LRCount[0]++;
                else LRCount[1]++;
                j++;
            }
            if (j < len) {  //上面相等之后这里不添加元素上面的if就永远进不去
                if (sChr[j] == 'R') LRCount[0]++;
                else LRCount[1]++;
            }
            op++;
            i = j;
        }
        return op;
    }
}
