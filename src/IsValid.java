import java.util.Stack;

public class IsValid {
    public static void main(String[] args) {
        String s = "([)]";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        Stack<Character> temp = new Stack<>();
        char[] strs = s.toCharArray();
        for (char str : strs) {
            if (String.valueOf(str).equals("[") || String.valueOf(str).equals("{") || String.valueOf(str).equals("(")) {
                temp.push(str);
            } else {
                if (temp.isEmpty()) return false;
                char tmp = temp.pop();
                if (String.valueOf(tmp).equals("[") && !String.valueOf(str).equals("]")) return false;
                else if (String.valueOf(tmp).equals("{") && !String.valueOf(str).equals("}")) return false;
                else if (String.valueOf(tmp).equals("(") && !String.valueOf(str).equals(")")) return false;
            }
        }
        return temp.isEmpty();
    }

    /**
     * https://leetcode-cn.com/problems/check-if-word-is-valid-after-substitutions/
     */
    public boolean isValid1(String s) {
        if (s.length() < 3) return false;
        while (!s.equals("") && s.contains("abc")) {
            s = s.replace("abc", "");
        }
        return s.equals("");
    }
}
