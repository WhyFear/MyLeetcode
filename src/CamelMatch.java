import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/camelcase-matching/
 * 烦！
 */
public class CamelMatch {
    public static void main(String[] args) {
        String[] queries = new String[]{"nfamrgmWkrwxElepjEfzqheaPZlW","onfaarmWkwElspjEfheajPbleZlW","nffaryimWgkwElpjEfheajPZlzjW","nfaermfWbkwEplpjEfheeaPcZclW","lnfagrmWkwElpujEwfheaxoPaZlW","xnfarmWkwEljpljEfhgeacPZhwlW","vfnfaermjWkwElpjpjEfheaoPZlW","nfaayrmWkwElpjEfhyhjjeeaPZlW"};
        String pattern = "nfarmWkwElpjEfheaPZlW";
        System.out.println(camelMatch(queries, pattern));
    }

    /**
     * 找到字符数组中大写字母的index
     */
    public static List<Integer> calcCapital(char[] chars) {
        List<Integer> op = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] <= 'Z' && chars[i] >= 'A') {
                op.add(i); //是大写字母
            }
        }
        return op;
    }

    public static List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> op = new ArrayList<>();
        char[] patternChars = pattern.toCharArray();
        int capitalCount = 0;
        for (char patternChar : patternChars) {
            if (patternChar <= 'Z' && patternChar >= 'A') {
                capitalCount++;
            }
        }
        for (String query : queries) {
            char[] queryChars = query.toCharArray();
            List<Integer> capitalIndex = calcCapital(queryChars);
            if (capitalCount != capitalIndex.size()) op.add(false);
            else {
                int i = 0, j = 0;
                while (i < patternChars.length && j < queryChars.length) {
                    if (queryChars[j] >= 'A' && queryChars[j] <= 'Z' && patternChars[i] > 'Z') {
                        break;
                    }
                    if (patternChars[i] == queryChars[j]) {
                        i++;
                    }
                    j++;
                }
                op.add(i == patternChars.length);
            }
        }
        return op;
    }
}
