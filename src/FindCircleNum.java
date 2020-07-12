import java.util.*;

/**
 * https://leetcode-cn.com/explore/interview/card/bytedance/243/array-and-sorting/1036/
 * 只用遍历一半数组
 */
public class FindCircleNum {
    public static void main(String[] args) {
        int[][] nums = new int[][]{
                {1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0}, {0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0}, {0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1}, {0, 0, 0, 1, 0, 1, 0, 0, 1, 0, 0, 0, 0, 1, 0}, {0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0}, {0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0}, {1, 0, 0, 1, 0, 0, 0, 0, 1, 1, 1, 0, 0, 1, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 0, 0, 0}, {0, 0, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 1}, {0, 1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0}, {0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1}};
        System.out.println(findCircleNum(nums));

    }

    public static int findCircleNum(int[][] M) {
//        for (int i = 0; i < M.length; i++)
//            for (int j = i + 1; j < M[0].length; j++) {
//                if (M[i][j] == 1) System.out.println(i + " " + j);
//            }
        int[] friends = new int[M.length];
        Arrays.fill(friends, -1);
        for (int i = 0; i < M.length; i++) {
            for (int j = i + 1; j < M[0].length; j++) {
                if (M[i][j] == 1) {
                    if (friends[i] != -1 && friends[j] == -1) friends[j] = friends[i];
                    else if (friends[j] != -1 && friends[i] == -1) {
                        friends[i] = friends[j];
                    } else if (friends[j] != -1) {
                        int tmp = friends[i];
                        friends[i] = friends[j];
                        for (int k = 0; k < friends.length; k++) {
                            if (friends[k] == tmp) {
                                friends[k] = friends[j];
                            }
                        }
                    } else {
                        friends[i] = i;
                        friends[j] = i;
                    }
                }
            }
        }
//        System.out.println(Arrays.toString(friends));
        // 求出所有不同的元素
        //计算一维数组的长度
        int n = friends.length;
        //将数组拷贝到新的地址，这样对新数组操作不会改变原数组
        int[] tmp = new int[n];
        System.arraycopy(friends, 0, tmp, 0, n);
        //统计元素种类数
        int Num = 1;
        //将数组按元素大小重新排序
        Arrays.sort(tmp);
        for (int i = 1; i < n; i++) {
            if (tmp[i] == -1) Num++;
            else if (tmp[i] != tmp[i - 1]) {
                Num++;
            }
        }
        return Num;
    }
}
