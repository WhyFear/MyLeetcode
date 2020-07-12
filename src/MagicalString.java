/**
 * https://leetcode-cn.com/problems/magical-string/
 * chaoxi
 */
public class MagicalString {
    public int magicalString(int n) {
        if (n == 0) return 0;
        if (n <= 3) return 1;
        int op = 1;
        StringBuilder sb = new StringBuilder("122");
        int strIndex = 2, countIndex = 2; //字符串尾指针和用来生成数字个数的指针
        while (strIndex < n - 1) {
            if (sb.charAt(countIndex) == '1') {
                if (sb.charAt(strIndex) == '1') {
                    sb.append("2");
                } else {
                    sb.append("1");
                    op++;
                }
                strIndex++;
            } else if (sb.charAt(countIndex) == '2') {
                if (sb.charAt(strIndex) == '2') {
                    sb.append("11");
                    op += 2;
                } else {
                    sb.append("22");
                }
                strIndex += 2;
            }
            countIndex++;
        }
        if (sb.length() > n && sb.charAt(sb.length() - 1) == '1')
            op -= 1;
        return op;
    }
}


/**
 *class Solution {
 *     public int magicalString(int n) {
 *         if (n == 0) return 0;
 *         if (n < 4) return 1;
 *
 *         //拼接最后一个数的时候可能有两个，多申请一位空间
 *         boolean[] res = new boolean[n+1];
 *         //初始字符串 = “122”
 *         //字符串尾指针
 *         int tailIndex = 3;
 *         //用来生成数字个数的指针
 *         int orderIndex = 2;
 *         //字符串的第一个1已经包含在结果中
 *         int ans = 1;
 *
 *         //false相当于2，上一次的尾数
 *         boolean value = false;
 *         while(tailIndex < n) {
 *             //先无脑在字符串尾部增加一个与前一位不同的字符
 *             value = !value;
 *             res[tailIndex++] = value;
 *             if (value) ans++;
 *
 *             //如果生成当前数字的命令符是2，则多加一位字符
 *             if (!res[orderIndex++]) {
 *                 res[tailIndex++] = value;
 *                 if (value) ans++;
 *             }
 *         }
 *         if (tailIndex == n + 1  && value) {
 *             return --ans;
 *         }
 *         return ans;
 *     }
 * }
 */