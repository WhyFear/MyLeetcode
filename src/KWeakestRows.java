import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/the-k-weakest-rows-in-a-matrix/
 */
public class KWeakestRows {
    public int[] kWeakestRows(int[][] mat, int k) {
        int[] op = new int[k];
        int index = 0;
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < mat[0].length; i++) {
            for (int j = 0; j < mat.length; j++) {
                if (mat[j][i] == 0 && !visited.contains(j)) {
                    op[index++] = j;
                    visited.add(j);
                }
                if (index == k) return op;
            }
        }
        if (index != k) {
            for (int j = 0; j < mat.length; j++) {
                if (mat[j][mat[0].length - 1] == 1 && !visited.contains(j)) {
                    op[index++] = j;
                    visited.add(j);
                }
                if (index == k) return op;
            }
        }
        return op;
    }
}