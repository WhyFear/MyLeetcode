/**
 * https://leetcode-cn.com/problems/add-strings/
 */
public class AddStrings {
    public String addStrings(String num1, String num2) {
        StringBuilder op = new StringBuilder();
        int i = num1.length() - 1, j = num2.length() - 1;
        boolean add = false;
        while (i >= 0 && j >= 0) {
            int result = Character.getNumericValue(num1.charAt(i)) + Character.getNumericValue(num2.charAt(j));
            if (add) {
                result++;
                add = false;
            }
            if (result > 9) {
                add = true;
                result %= 10;
            }
            op.append(result);
            i--;
            j--;
        }
        while (i >= 0) {
            int result = Character.getNumericValue(num1.charAt(i));
            if (add) {
                result++;
                add = false;
            }
            if (result > 9) {
                add = true;
                result %= 10;
            }
            op.append(result);
            i--;
        }
        while (j >= 0) {
            int result = Character.getNumericValue(num2.charAt(j));
            if (add) {
                result++;
                add = false;
            }
            if (result > 9) {
                add = true;
                result %= 10;
            }
            op.append(result);
            j--;
        }
        if (add) op.append(1);
        return op.reverse().toString();
    }
}
