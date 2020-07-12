import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyAtoi {
    public static void main(String[] args) {
        System.out.println(myAtoi("000000000000000000"));
    }

    public static <Int> int myAtoi(String str) {
        List<String> numbers = Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9");
        List<String> prefixs = Arrays.asList("-", "+");
        if (str.length() == 0) {  // 空字符串
            return 0;
        }

        int i = 0;
        while (Character.isSpaceChar(str.charAt(i))) {
            i++;
            if (i == str.length()) {  //空白字符串
                return 0;
            }
        }
        StringBuilder NumStr = new StringBuilder();
        String prefix = String.valueOf(str.charAt(i));
        long op = 0;
        if (!numbers.contains(prefix) && !prefixs.contains(prefix)) {
            return 0;  //除空格外第一个字符不是数字或者+-
        } else if (str.length() > 1) {
            if (prefixs.contains(prefix)) {  // 第一个字符是+-号
                i++;
                if (prefixs.contains(String.valueOf(str.charAt(i)))) {
                    return 0;
                }

            }
            while (String.valueOf(str.charAt(i)).equals("0")) {
                i++;
                if (i == str.length()) {
                    return 0;
                }
            }
            while (numbers.contains(String.valueOf(str.charAt(i)))) {
                NumStr.append(str.charAt(i));
                i++;
                if (i == str.length()) {
                    break;
                }
            }
            if (NumStr.length() == 0) {
                return 0;
            }
            if (!numbers.contains(String.valueOf(NumStr.charAt(NumStr.length() - 1)))) {
                NumStr = new StringBuilder(NumStr.substring(0, NumStr.length() - 1));
            }

        } else {
            if (prefixs.contains(prefix)) {  // 第一个字符是+-号
                return 0;
            } else {
                NumStr.append(str.charAt(i));
            }
        }

        if (NumStr.length() > 11) {
            if (prefix.equals("-")) {
                op = Integer.MIN_VALUE;
            } else {
                op = Integer.MAX_VALUE;
            }
        } else {
            op = Long.parseLong(NumStr.toString());
            if (prefix.equals("-")) {
                op = -op;
            }
            if (op < Integer.MIN_VALUE) {
                op = Integer.MIN_VALUE;
            }
            if (op > Integer.MAX_VALUE) {
                op = Integer.MAX_VALUE;
            }
        }
        return (int) op;
    }
}