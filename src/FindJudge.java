import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/find-the-town-judge/
 * 有一个人出度为零，入度为N-1
 */
public class FindJudge {
    public int findJudge(int N, int[][] trust) {
        int[][] persons = new int[N + 1][N + 1]; //前出度,后入度
        for (int[] person : trust) {
            persons[person[0]][0]++;
            persons[person[1]][1]++;
        }
        for (int i = 1; i <= N; i++) {
            if (persons[i][0] == 0 && persons[i][1] == N - 1) return i;
        }
        return -1;
    }
}
