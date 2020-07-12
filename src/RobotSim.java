import java.util.HashSet;
import java.util.Set;

public class RobotSim {
    /**
     * https://leetcode-cn.com/problems/walking-robot-simulation/
     * chaoxi
     */
    public int robotSim(int[] commands, int[][] obstacles) {
        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{1, 0, -1, 0};
        int x = 0;
        int y = 0;
        int direction = 0;

        // Encode obstacles (x, y) as (x + 30000) * (2^16) + (y + 30000)
        // 或者，我们也可以将坐标编码为 字符串 string。
        Set<Integer> obstacleSet = new HashSet<>((int) (obstacles.length / 0.75) + 1);
        for (int[] o : obstacles) {
            int ox = o[0] + 30000;
            int oy = o[1] + 30000;
            obstacleSet.add((ox << 16) | oy);
        }

        int op = 0;
        for (int cmd : commands) {
            if (cmd == -2) {
                direction = (direction + 3) % 4;
            } else if (cmd == -1) {
                direction = (direction + 1) % 4;
            } else {
                for (int k = 0; k < cmd; k++) {
                    x += dx[direction];
                    y += dy[direction];
                    int code = ((x + 30000) << 16) | (y + 30000);
                    if (obstacleSet.contains(code)) {
                        x -= dx[direction];
                        y -= dy[direction];
                        break;
                    }
                }
                op = Math.max(op, x * x + y * y);
            }
        }
        return op;
    }
}
