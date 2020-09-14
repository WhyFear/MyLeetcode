/**
 * https://leetcode-cn.com/problems/escape-the-ghosts/
 * 算鬼到终点的最近距离，如果自己的距离小于这个距离就可以，否则不行
 * chaoxi
 */
public class EscapeGhosts {
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        int min_dis = Integer.MAX_VALUE;
        int dis = Math.abs(target[0]) + Math.abs(target[1]);
        for (int[] ghost : ghosts) {
            min_dis = Math.min(min_dis, getDis(ghost, target));
        }
        return dis < min_dis;
    }

    private int getDis(int[] dot, int[] target) {
        return Math.abs(dot[0] - target[0]) + Math.abs(dot[1] - target[1]);
    }
}
