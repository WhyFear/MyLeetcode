import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode-cn.com/problems/minimum-number-of-arrows-to-burst-balloons/
 * chaoxi
 */
public class FindMinArrowShots {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        Arrays.sort(points, new Comparator<int[]>() {
            public int compare(int[] point1, int[] point2) {
                return Integer.compare(point1[1], point2[1]);
            }
        });
        int pos = points[0][1];
        int ans = 1;
        for (int[] balloon : points) {
            if (balloon[0] > pos) {
                pos = balloon[1];
                ++ans;
            }
        }
        return ans;
    }
}
