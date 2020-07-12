/**
 * https://leetcode-cn.com/problems/monotone-increasing-digits/
 * 从左至右遍历，如果后比前小，则从当前位置到最后全部置9
 * 如果相等或者后比前大则继续。
 */
public class MonotoneIncreasingDigits {
    public int monotoneIncreasingDigits(int N) {
        char[] temp = String.valueOf(N).toCharArray();
        for (int i = 0; i < temp.length;) {
            int j = i;
            while (j < temp.length && temp[i] == temp[j]) j++;
            if (j < temp.length && temp[i] > temp[j]) {
                temp[i] -= 1;
                int m = i + 1;
                while (m < temp.length) temp[m++] = '9';
                break;
            }
            i = j;
        }
        return Integer.parseInt(String.valueOf(temp));
    }
}
