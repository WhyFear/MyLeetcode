import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/redundant-connection/
 * 联通的部分都放在一起,不连通的部分就分开放置,如果有两个节点在同一个联通部分内,说明有重复边.
 * 并查集写法。
 */
public class FindRedundantConnection {
    public int[] findRedundantConnection(int[][] edges) {
        int len = edges.length;
        int[] parent = new int[len + 1];
        int[] op = new int[2];
        for (int i = 1; i <= len; i++) {
            parent[i] = i;
        }
        for (int[] temp : edges) {
            if (find(parent, temp[0]) == find(parent, temp[1])) {
                op = temp;
            } else {
                union(parent, temp[0], temp[1]);
            }
        }
        return op;
    }

    private void union(int[] parent, int x, int y) {
        int parentX = find(parent, x);
        int parentY = find(parent, y);
        if (parentX != parentY) {
            parent[parentY] = parentX;
        }
    }

    private int find(int[] parent, int node) {
        while (parent[node] != node) {
            node = parent[node];
        }
        return node;
    }
}
/*
public int[] findRedundantConnection(int[][] edges) {
        int[] op = new int[2];
        List<Set<Integer>> setList = new ArrayList<>();
        for (int[] temp : edges) {
            int start = temp[0];
            int end = temp[1];
            int startIndex = -1;
            int endIndex = -1;
            for (int i = 0; i < setList.size(); i++) {
                Set<Integer> tmp = setList.get(i);
                if (tmp.contains(start)) startIndex = i;
                if (tmp.contains(end)) endIndex = i;
            }
            if (startIndex == -1 && endIndex == -1) { // 两个都是新节点
                Set<Integer> add = new HashSet<>();
                add.add(start);
                add.add(end);
                setList.add(add);
            } else if (startIndex == endIndex) { //两个在同一个部分内，说明出现重复边。
                op = temp;
            } else { // 有一个节点是新节点或者两个节点分属不同的部分，需要将这两个节点合并。
                if (startIndex == -1) setList.get(endIndex).add(start);
                else if (endIndex == -1) setList.get(startIndex).add(end);
                else {
                    setList.get(startIndex).addAll(setList.get(endIndex));
                    setList.remove(endIndex);
                }
            }
        }
        return op;
    }
 */