import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/pascals-triangle-ii/
 */
public class GetRow {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> op = new ArrayList<>();
        op.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            List<Integer> temp = new ArrayList<>();
            temp.add(1);
            for (int j = 0; j < op.size() - 1; j++) {
                temp.add(op.get(j) + op.get(j + 1));
            }
            temp.add(1);
            op = temp;
        }
        return op;
    }
}
