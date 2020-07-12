import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/reconstruct-a-2-row-binary-matrix/
 */
public class ReconstructMatrix {
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        List<List<Integer>> op = new ArrayList<>();

        // 提前判断
        int sum = 0;
        int upAndLow = upper + lower;
        for (int value : colsum) {
            if (value == 2) {
                upper--;
                lower--;
            }
            sum += value;
        }
        if (sum != upAndLow) return op; //不相等直接返回
        if (upper < 0 || lower < 0) return op; //去掉所有的0和2之后如果upper或者lower小于零则直接返回。

        op.add(new ArrayList<>());
        op.add(new ArrayList<>());
        for (int num : colsum) {
            List<Integer> temp1 = op.get(0);
            List<Integer> temp2 = op.get(1);
            if (num == 2) {
                temp1.add(1);
                temp2.add(1);
                //这里不用减，因为上面已经减过了
//                upper--;
//                lower--;
            } else if (num == 0) {
                temp1.add(0);
                temp2.add(0);
            } else {
                if (upper >= lower) {
                    temp1.add(1);
                    temp2.add(0);
                    upper--;
                } else {
                    temp1.add(0);
                    temp2.add(1);
                    lower--;
                }
            }
            if (upper < 0 || lower < 0) return new ArrayList<>();
        }
        if (upper != 0 || lower != 0) return new ArrayList<>();
        return op;
    }
}
