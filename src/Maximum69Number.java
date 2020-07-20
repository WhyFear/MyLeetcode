/**
 * https://leetcode-cn.com/problems/maximum-69-number/
 */
public class Maximum69Number {
    public int maximum69Number(int num) {
        String temp = String.valueOf(num);
        String result = temp.replaceFirst("6","9");
        return Integer.parseInt(result);
    }
}
