import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/robot-return-to-origin/
 */
public class JudgeCircle {
    public boolean judgeCircle(String moves) {
        int[] pos = new int[2];
        for (char operator : moves.toCharArray()) {
            if (operator == 'R') pos[0]++;
            else if (operator == 'L') pos[0]--;
            else if (operator == 'U') pos[1]++;
            else if (operator == 'D') pos[1]--;
        }
        return Arrays.equals(pos, new int[2]);
    }
}
