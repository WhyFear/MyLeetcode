import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/flood-fill/
 * bfs
 */
public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        Deque<int[]> queue = new ArrayDeque<>();
        Set<int[]> visited = new HashSet<>();
        queue.push(new int[]{sr, sc});

        int oldColor = image[sr][sc];

        if (oldColor == newColor) return image;

        int row = image.length;
        int column = image[0].length;
        while (!queue.isEmpty()) {
            int[] coordinate = queue.pollFirst();
            int x = coordinate[0], y = coordinate[1];
            if (!visited.contains(coordinate)) {
                visited.add(coordinate);
                image[x][y] = newColor;
                if (x > 0 && image[x - 1][y] == oldColor) queue.push(new int[]{x - 1, y});
                if (x < row - 1 && image[x + 1][y] == oldColor) queue.push(new int[]{x + 1, y});
                if (y > 0 && image[x][y - 1] == oldColor) queue.push(new int[]{x, y - 1});
                if (y < column - 1 && image[x][y + 1] == oldColor) queue.push(new int[]{x, y + 1});
            }
        }
        return image;
    }
}
