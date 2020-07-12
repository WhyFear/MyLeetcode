import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/unique-number-of-occurrences/
 */
public class UniqueOccurrences {
    public boolean uniqueOccurrences(int[] arr) {
        if (arr.length <= 1) return true;
        Arrays.sort(arr);
        Set<Integer> appear = new HashSet<>();
        for (int i = 0; i < arr.length; ) {
            int j = i;
            while (j < arr.length && arr[j] == arr[i]) j++;
            int count = j - i;
            if (!appear.contains(count)) appear.add(count);
            else return false;
            i = j;
        }
        return true;
    }
}
