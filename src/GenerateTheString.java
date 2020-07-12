/**
 * https://leetcode-cn.com/problems/generate-a-string-with-characters-that-have-odd-counts/
 */
public class GenerateTheString {
    public String generateTheString(int n) {
        if (n % 2 == 1) return "z".repeat(n);
        else return "z".repeat(n - 1) + "l";
    }
}
