/**
 * https://leetcode-cn.com/problems/rotate-string/submissions/
 */
public class RotateString {
    public boolean rotateString(String A, String B) {
        if (A.equals(B)) return true;
        if (A.length() != B.length()) return false;
        StringBuilder temp;
        char[] AChars = A.toCharArray();
        for (int i = 0; i < A.length(); i++) {
            if (AChars[i] == B.charAt(0)) {
                temp = new StringBuilder();
                temp.append(A.substring(i));
                temp.append(A, 0, i);
                if (temp.toString().equals(B)) return true;
            }
        }
        return false;
    }

    public boolean rotateStringI(String A, String B) {
        if (A.equals(B)) return true;
        if (A.length() != B.length()) return false;
        A += A;
        return A.contains(B);
    }

}
