/**
 * https://leetcode-cn.com/problems/student-attendance-record-i/
 */
public class CheckRecord {
    public boolean checkRecord(String s) {
        int ACount = 0, len = s.length();
        char[] chars = s.toCharArray();
        for (int i = 0; i < len; i++) {
            char chr = chars[i];
            if (chr == 'A') ACount++;
            if (ACount > 1) return false;
            if (chr == 'L') {
                int j = i;
                while (j < len && chars[j] == 'L') j++;
                if (j - i > 2) return false;
            }
        }
        return true;
    }
}
