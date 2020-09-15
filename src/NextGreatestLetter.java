/**
 * https://leetcode-cn.com/problems/find-smallest-letter-greater-than-target/
 */
public class NextGreatestLetter {
    public char nextGreatestLetter(char[] letters, char target) {
        for (char chr : letters) {
            if (target < chr) return chr;
        }
        return letters[0];
    }
}
