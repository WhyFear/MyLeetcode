/**
 * https://leetcode-cn.com/problems/number-of-substrings-containing-all-three-characters/
 */
public class NumberOfSubstrings {
    public int numberOfSubstrings(String s) {
        int op = 0;
        int len = s.length();
        if (len < 3) return 0;

        int left = 0, right = 0;
        int[] count = new int[3];
        while (right <= len) {
            while (right < len && !panduan(count)) {
                count[s.charAt(right) - 'a']++;
                right++;
            }
            if (!panduan(count)) break;
            op += (len - right);
            if (left < right && panduan(count)) {
                count[s.charAt(left) - 'a']--;
                left++;
                op++;
            }
        }
        return op;
    }

    private boolean panduan(int[] count) {
        for (int val : count) {
            if (val < 1) return false;
        }
        return true;
    }
}
