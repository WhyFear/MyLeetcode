/**
 * https://leetcode-cn.com/problems/consecutive-characters/
 */
public class MaxPower {
    public int maxPower(String s) {
        int op = 1;
        char[] temp = s.toCharArray();
        for (int i = 0; i < temp.length;) {
            char chr = temp[i];
            int j = i + 1;
            while (j < temp.length && temp[j] == chr) j++;
            op = Math.max(op, j - i);
            i = j;
        }
        return op;
    }
}
