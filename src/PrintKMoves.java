import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/langtons-ant-lcci/
 * 不会，瞎几把写
 */
public class PrintKMoves {
    Character[] nextDirection = new Character[]{'U', 'R', 'D', 'L'};

    public List<String> printKMoves(int K) {
        List<StringBuilder> temp = new ArrayList<>();
        temp.add(new StringBuilder("R"));
        dfs(K, temp, 0, 0, 'X');
        List<String> op = new ArrayList<>();
        for (StringBuilder tmp : temp) {
            op.add(tmp.toString());
        }
        return op;
    }

    private void dfs(int K, List<StringBuilder> temp, int i, int j, Character color) {
        if (K == 0) return;
        char direction = temp.get(i).charAt(j);
        char currentColor = 'X';
        temp.get(i).replace(j, j + 1, String.valueOf(color == '_' ? 'X' : '_'));
        if (direction == 'U') i--;
        if (direction == 'R') j++;
        if (direction == 'D') i++;
        if (direction == 'L') j--;

        // 如果超出边界，那么一定是踩到白色方块。
        if (i < 0) {
            temp.add(0, new StringBuilder("_".repeat(temp.get(0).length())));
            i = 0;
        } else if (i >= temp.size()) {
            temp.add(new StringBuilder("_".repeat(temp.get(0).length())));
        }
        if (j < 0) {
            temp.get(i).insert(0, '_');
            j = 0;
        } else if (j >= temp.get(i).length()) {
            temp.get(i).append('_');
        }

        currentColor = temp.get(i).charAt(j);
        temp.get(i).replace(j, j + 1, direction(direction, currentColor));

        dfs(K - 1, temp, i, j, currentColor);
    }

    private String direction(Character direction, Character currentDirection) {
        int index = 0;
        for (; index < 4; index++) {
            if (nextDirection[index] == direction) break;
        }
        if (currentDirection == '_') {
            return String.valueOf(nextDirection[(index + 1) % 4]);
        } else return String.valueOf(nextDirection[(index - 1) % 4]);
    }
}
