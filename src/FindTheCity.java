/**
 * https://leetcode-cn.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/
 * 高于阈值的边直接不记录就行了
 */
public class FindTheCity {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[] cities = new int[n];
        for (int[] edge : edges) {
            if (edge[2] <= distanceThreshold) {
                cities[edge[0]]++;
                cities[edge[1]]++;
            }
        }
        int min = Integer.MAX_VALUE;
        for (int val : cities) {
            min = Math.min(min, val);
        }
        for (int i = n - 1; i >= 0; i--) {
            if (cities[i] == min) return i;
        }
        return 0;
    }
}
