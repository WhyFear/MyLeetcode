import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/diving-board-lcci/
 */
public class DivingBoard {

    public int[] divingBoard(int shorter, int longer, int k) {
        if (k == 0) return new int[0];
        if (shorter == longer) return new int[]{shorter * k};
        int min = shorter * k;
        int max = longer * k;
        int dis = longer - shorter;
        int len = ((max - min) / dis) + 1;
        int[] op = new int[len];
        for (int i = 0; i < len; i++) {
            op[i] = min + dis * i;
        }
        return op;
    }
}
