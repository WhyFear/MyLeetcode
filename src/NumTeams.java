/**
 * https://leetcode-cn.com/problems/count-number-of-teams/
 * baoli
 */
public class NumTeams {
    public int numTeams(int[] rating) {
        int len = rating.length, op = 0;
        for (int i = 0; i < len - 2; ++i) {
            for (int j = i + 1; j < len - 1; ++j) {
                for (int k = j + 1; k < len; ++k)
                    if ((rating[i] < rating[j] && rating[j] < rating[k]) || (rating[i] > rating[j] && rating[j] > rating[k]))
                        ++op;
            }
        }
        return op;
    }
}
