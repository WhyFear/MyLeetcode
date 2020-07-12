import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/minimum-number-of-refueling-stops/
 * 我的思路正确，但是因为不知道优先队列（堆）这个知识点，所以没做出来。
 */
public class MinRefuelStops {
    public static void main(String[] args) {
//        int[][] stations = new int[][]{{47, 220}, {65, 1}, {98, 113}, {126, 196}, {186, 218}, {320, 205}, {686, 317}, {707, 325}, {754, 104}, {781, 105}};
        int[][] stations = new int[][]{{13, 100}, {25, 117}, {122, 82}, {189, 123}, {268, 56}, {382, 214}, {408, 280}, {421, 272}, {589, 110}, {899, 4}};
        System.out.println(minRefuelStops(1000, 299, stations));
    }

    /**
     * 我自己的代码
     */
    public static int myminRefuelStops(int target, int startFuel, int[][] stations) {
        if (stations.length == 0) {
            if (target > startFuel) return -1;
            else return 0;
        }
        if (startFuel < stations[0][0]) return -1;
        int op = 0;
        int maxLen = startFuel;
        for (int i = 0; i < stations.length && maxLen < target; i++) {
            int[] temp = stations[i];
            while (i < stations.length && stations[i][0] < maxLen) {
                if ((stations[i][0] + stations[i][1]) > (temp[0] + temp[1])) temp = stations[i];  //找到录制时间最长的那个
                i++;
            }
            if (i < stations.length && maxLen == stations[i][0]) maxLen += Math.max(stations[i][1], temp[1]);
            else if (maxLen > temp[0]) maxLen += temp[1];
            // 写到这里我就发现设计错误，如果之前加油没有办法到达下一个加油站，那么应该使用堆来存储之前的油量最多的（能跑最远）加油站，
            // 这样直到能到达下一个加油站或者返回-1为止
            // 具体请看别人的代码
            if (i < stations.length && maxLen < stations[i][0] && stations[i - 1] != temp) maxLen += stations[i - 1][1];
            op++;
        }
        if (maxLen < target) return -1;
        return op;
    }

    /**
     * 别人的代码。真的强！
     */
    public static int minRefuelStops(int target, int startFuel, int[][] stations) {

        //这一题就是优先队列的应用，太扯淡了
        //完全就是特题特解，别的方法都相形见绌
        //优先队列可以是nlogn的解法，这太霸道了

        if (stations.length == 0)
            return startFuel >= target ? 0 : -1;
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1); //堆
        int sum = startFuel;
        int ans = 0;
        for (int[] station : stations) {
            while (sum < station[0]) {
                Integer ii = queue.poll();
                if (ii == null) return -1;
                sum += ii;
                ans++;
            }
            queue.offer(station[1]);
        }
        while (sum < target) {
            Integer ii = queue.poll();
            if (ii == null) return -1;
            sum += ii;
            ans++;
        }
        return ans;
    }
}
