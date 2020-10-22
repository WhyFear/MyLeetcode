import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/partition-labels/
 */
public class PartitionLabels {
    public List<Integer> partitionLabels(String S) {
        List<Integer> op = new ArrayList<>();
        int len = S.length();
        Map<Character, Integer> index = new HashMap<>();
        for (int i = 0; i < len; i++) {
            char temp = S.charAt(i);
            index.put(temp, i);
        }
        int last = 0;
        for (int i = 0; i < len; i++) {
            char temp = S.charAt(i);
            int right = index.get(temp);
            for (int j = i; j <= right; j++) {
                if (index.get(S.charAt(j)) > right) right = index.get(S.charAt(j));
            }
            i = right;
            op.add(i + 1 - last);
            last = i + 1;
        }
        return op;
    }
}
