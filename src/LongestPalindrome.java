import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
 * https://leetcode-cn.com/problems/longest-palindrome/
 * 思路：除了放在中间的那个字符，其他字符必须是成对出现的，如果结果与字符串长度相同，则原样输出，否则加一
 * */
public class LongestPalindrome {
    public static void main(String[] args) {
        String str = "kyyrjtdplseovzwjkykrjwhxquwxsfsorjiumvxjhjmgeueafubtonhlerrgsgohfosqssmizcuqryqomsipovhhodpfyudtusjhonlqabhxfahfcjqxyckycstcqwxvicwkjeuboerkmjshfgiglceycmycadpnvoeaurqatesivajoqdilynbcihnidbizwkuaoegmytopzdmvvoewvhebqzskseeubnretjgnmyjwwgcooytfojeuzcuyhsznbcaiqpwcyusyyywqmmvqzvvceylnuwcbxybhqpvjumzomnabrjgcfaabqmiotlfojnyuolostmtacbwmwlqdfkbfikusuqtupdwdrjwqmuudbcvtpieiwteqbeyfyqejglmxofdjksqmzeugwvuniaxdrunyunnqpbnfbgqemvamaxuhjbyzqmhalrprhnindrkbopwbwsjeqrmyqipnqvjqzpjalqyfvaavyhytetllzupxjwozdfpmjhjlrnitnjgapzrakcqahaqetwllaaiadalmxgvpawqpgecojxfvcgxsbrldktufdrogkogbltcezflyctklpqrjymqzyzmtlssnavzcquytcskcnjzzrytsvawkavzboncxlhqfiofuohehaygxidxsofhmhzygklliovnwqbwwiiyarxtoihvjkdrzqsnmhdtdlpckuayhtfyirnhkrhbrwkdymjrjklonyggqnxhfvtkqxoicakzsxmgczpwhpkzcntkcwhkdkxvfnjbvjjoumczjyvdgkfukfuldolqnauvoyhoheoqvpwoisniv";
        System.out.println(longestPalindrome(str));
    }

    /**
     * 数字的回文
     * https://leetcode-cn.com/problems/longest-palindrome/
     */
    public static int longestPalindromeInt(String s) {
        int maxLength = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        char[] arr = s.toCharArray();
        for (char chr : arr) {
            if (!map.containsKey(chr)) {
                map.put(chr, 1);
            } else {
                int tmp = map.get(chr) + 1;
                if (tmp == 2) {
                    maxLength += 2;
                    map.put(chr, 0);
                } else {
                    map.put(chr, 1);
                }
            }
        }
        if (maxLength == s.length()) {
            return maxLength;
        } else {
            return maxLength + 1;
        }
    }

    /**
     * 字符串的回文
     */
    public static String longestPalindrome(String s) {
        if (s.length() <= 1) return s;
        String op = "";
        HashMap<Character, Integer> map = new HashMap<>();
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[i] == arr[j] && op.length() < j - i + 1) {
                    //判断从i到j是否是回文
                    int m = i, n = j;
                    boolean isPalindrome = true;
                    while (m <= n) {
                        if (arr[m++] != arr[n--]) {
                            isPalindrome = false;
                            break;
                        }
                    }
                    if (isPalindrome) {
                        op = String.valueOf(Arrays.copyOfRange(arr, i, j + 1));
                    }
                }
            }
        }
        if (op.equals(""))
            return String.valueOf(arr[0]);
        return op;
    }
}
