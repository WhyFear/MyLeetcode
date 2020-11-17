import java.util.*;

/**
 * https://leetcode-cn.com/problems/matrix-cells-in-distance-order/
 */
public class AllCellsDistOrder {
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        List<int[]> op = new ArrayList<>();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                op.add(new int[]{i, j});
            }
        }
        op.sort((Comparator.comparingInt(o -> Math.abs(o[0] - r0) + Math.abs(o[1] - c0))));
        int[][] res = new int[op.size()][2];
        for (int i = 0; i < op.size(); i++) {
            res[i] = op.get(i);
        }
        return res;
    }
}
