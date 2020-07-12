import java.util.*;

/**
 * 浪潮2020/7/7 笔试题
 */
public class Stone {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//        int n = 5;
//        int[] stones = new int[]{4, 2, 1, 5, 3};
        int n = in.nextInt();
        in.nextLine();
        String temp = in.nextLine();
        String[] input = temp.split(" ");

        int[] stones = new int[n];
        for (int i = 0; i < n; i++) {
            stones[i] = Integer.parseInt(input[i]);
        }


        Map<Integer, Integer> stoneIndex = new HashMap<>();
        for (int i = 0; i < n; i++) {
            stoneIndex.put(stones[i], i);
        }
        int maxIncrease = 0;
        for (int i = 1; i <= n; ) {
            int start = stoneIndex.get(i);
            int j = i + 1;
            while (j <= n) {
                int tmp = stoneIndex.get(j);
                if (start > stoneIndex.get(j)) break;
                start = tmp;
                j++;
            }
            maxIncrease = Math.max(maxIncrease, j - i);
            i = j;
        }
        System.out.println(n - maxIncrease);
    }
}
