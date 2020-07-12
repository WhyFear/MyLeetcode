import java.util.*;

/**
 * https://leetcode-cn.com/problems/possible-bipartition/
 * chaoxi
 * 被注释掉的代码更好
 */
public class PossibleBipartition {
    ArrayList<Integer>[] graph;// 使用邻接表存储图
    Map<Integer, Integer> color;//记录上色结果

    public boolean possibleBipartition(int N, int[][] dislikes) {
        graph = new ArrayList[N + 1];// 0位其实不用,使用的使1~N位
        //ArrayList实例化
        for (int i = 0; i != N + 1; i++) {
            graph[i] = new ArrayList<>();
        }
        //图初始化
        for (int[] cp : dislikes) {
            graph[cp[0]].add(cp[1]);
            graph[cp[1]].add(cp[0]);
        }
        color = new HashMap<>();
        for (int node = 1; node != N + 1; node++) {// 对该组N人遍历
            if (!color.containsKey(node)) {// 还未上色
                boolean OK = dfs(node, 0);//从node开始深度遍历
                if (!OK) return false;
            }
        }
        return true;
    }

    private boolean dfs(int node, int c) {
        //从possibleBipartition调用时node是未上色的
        if (color.containsKey(node)) {// 若已经上色则看是否上色正确
            return color.get(node) == c;
        }
        color.put(node, c);// 上色
        // 深度遍历
        for (int noFriend : graph[node]) {
            boolean OK = dfs(noFriend, c ^ 1);
            if (!OK) return false;
        }
        return true;
    }
}

/**
 * 最快答案
 * 前提是dislike本身有序
 */
//    public boolean possibleBipartition(int N, int[][] dislikes) {
//        int[] dp = new int[N+1];
//        int k = 1;
//
//        for (int[] dislike : dislikes) {
//            int a = dislike[0], b = dislike[1];
//            if (dp[a] == 0 && dp[b] == 0) {//都为初始状态
//                dp[a] = k++;
//                dp[b] = k++;
//            } else if (dp[a] == 0) {
//                dp[a] = dp[b] % 2 == 0 ? dp[b] - 1 : dp[b] + 1;
//            } else if (dp[b] == 0) {
//                dp[b] = dp[a] % 2 == 0 ? dp[a] - 1 : dp[a] + 1;
//            } else { //都不为初始状态
//                if(dp[a] == dp[b]) return false;
//            }
//        }
//
//        return true;
//    }