import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/pascals-triangle/
 */
public class Generate {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> op = new ArrayList<>();
        if (numRows < 1) return op;
        op.add(new ArrayList<>() {{
            add(1);
        }});
        if (numRows < 2) return op;
        for (int i = 1; i < numRows; i++) {
            List<Integer> temp = new ArrayList<>();
            temp.add(1);
            for (int j = 1; j < i; j++) {
                temp.add(op.get(i - 1).get(j - 1) + op.get(i - 1).get(j));
            }
            temp.add(1);
            op.add(temp);
        }
        return op;
    }
}
