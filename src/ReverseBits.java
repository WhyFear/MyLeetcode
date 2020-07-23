/**
 * https://leetcode-cn.com/problems/reverse-bits-lcci/
 * 双百，但解法不够优美
 */
public class ReverseBits {
    int op = 1;

    public int reverseBits(int num) {
        String temp = DtoB(num);
        for (int i = 0; i < temp.length(); i++) {
            int j = i;
            while (j < temp.length() && temp.charAt(j) == '1') j++;
            dfs(temp, j + 1, j - i + 1);
            i = j;
        }
        return op;
    }

    private void dfs(String str, int index, int count) {
        while (index < str.length() && str.charAt(index) == '1') {
            index++;
            count++;
        }
        op = Math.max(op, count);
    }

    private String DtoB(int num) {
        StringBuilder op = new StringBuilder();
        while (num > 0) {
            op.append(num % 2);
            num /= 2;
        }
        return op.reverse().toString();
    }
}
