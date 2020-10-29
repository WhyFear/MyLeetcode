/**
 * https://leetcode-cn.com/problems/number-of-substrings-with-only-1s/
 * 我不知道我的代码哪里出了问题,留在这里以后再解决.
 */
public class NumSub {
    public int numSub(String s) {
        int MOD = 1000000007;
        int op = 0;
        int len = s.length();
        System.out.println(len);
        int length;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '1') {
                int j = i;
                while (j < len && s.charAt(j) == '1') j++;
                length = j - i;
                op += (1 + length) * length / 2;
                op %= MOD;
                i = j - 1;
            }
        }
        return op % MOD;
    }
}
