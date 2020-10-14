/*
 * https://leetcode-cn.com/problems/find-common-characters/
 */

import java.util.ArrayList;
import java.util.List;

public class CommonChars {
    public List<String> commonChars(String[] A) {
        List<String> op = new ArrayList<>();
        int[] count = new int[26];
        for (char chr : A[0].toCharArray()) {
            count[chr - 'a']++;
        }
        for (int i = 1; i < A.length; i++) {
            int[] tempCount = new int[26];
            for (char chr : A[i].toCharArray()) {
                tempCount[chr - 'a']++;
            }
            for (int j = 0; j < 26; j++) {
                count[j] = Math.min(count[j], tempCount[j]);
            }
        }
        for (int i = 0; i < 26; i++) {
            if (count[i] > 0) {
                for (int j = 0; j < count[i]; j++) op.add(String.valueOf((char) ('a' + i)));
            }
        }
        return op;
    }
}
