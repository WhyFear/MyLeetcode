import java.util.ArrayList;
import java.util.List;

/***
 * https://leetcode-cn.com/problems/triangle/
 */
public class MinimumTotal {
    public static void main(String[] args) {
        int[][] fuck = new int[][]{
                {2},
                {3, 4},
                {6, 5, 3},
                {4, 2, 8, 1}
        };
        List<List<Integer>> triangle = new ArrayList<>();
        for (int[] i : fuck) {
            List<Integer> asd = new ArrayList<>();
            for (int j : i) {
                asd.add(j);
            }
            triangle.add(asd);
        }
        System.out.println(minimumTotal(triangle));
    }

    public static int findMinPath(List<List<Integer>> triangle, int index, int level, int op) {
        if (level == triangle.size() - 1) {
            return op + triangle.get(level).get(index);
        }
        op += triangle.get(level).get(index);
        op = Math.min(findMinPath(triangle, index, level + 1, op), findMinPath(triangle, index + 1, level + 1, op));
        return op;
    }

    /**
     * 我自己的代码
     */
    public static int myMinimumTotal(List<List<Integer>> triangle) {
        int op;
        op = findMinPath(triangle, 0, 0, 0);
        return op;
    }

    /**
     * 根据别人的思路自己写的：https://leetcode-cn.com/problems/triangle/solution/zi-di-xiang-shang-dong-tai-gui-hua-lei-si-yu-cong-/
     */
    public static int minimumTotal(List<List<Integer>> triangle) {
        for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                triangle.get(i).set(j, triangle.get(i).get(j) + Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1)));
            }
        }
        return triangle.get(0).get(0);
    }
}
