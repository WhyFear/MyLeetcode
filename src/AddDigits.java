/**
 * https://leetcode-cn.com/problems/add-digits/
 */
public class AddDigits {
    public int addDigits(int num) {
        int op = 0;
        while (num > 0) {
            op += num % 10;
            num /= 10;
            if (num == 0 && op >= 10) {
                num = op;
                op = 0;
            }
        }
        return op;
    }
}
