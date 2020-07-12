public class DailyTemperatures {
    /**
     * https://leetcode-cn.com/problems/daily-temperatures/
     * 从后往前遍历，设置一个max变量，如果比max大或者等于就置为零，否则就从当前位置往后遍历。
     * 遍历时如果当前值比对比值小就读取他的op值，跳转到对应的位置，直到大于为止
     */
    public int[] dailyTemperatures(int[] T) {
        int[] op = new int[T.length];
        if (T.length <= 1) return op;
        int max = T[T.length - 1];
        for (int i = T.length - 2; i >= 0; i--) {
            if (T[i] >= max) {
                op[i] = 0;
                max = T[i];
            } else {
                int j = i + 1;
                while (j < T.length && T[j] <= T[i]) j = j + op[j];
                op[i] = j - i;
            }
        }
        return op;
    }
}
