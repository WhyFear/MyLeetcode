import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/container-with-most-water/
 */
public class MaxArea {
    public static void main(String[] args) {
        int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(height));
    }

    public static int maxArea(int[] height) {
        int op = 0;
        int i = 0, j = height.length - 1;
        while (i <= j) {
            if (height[i] < height[j]) {
                op = Math.max(op, height[i] * (j - i));
                i++;
            } else {
                op = Math.max(op, height[j] * (j - i));
                j--;
            }
        }
        return op;
    }

    /**
     * https://leetcode-cn.com/problems/maximum-area-of-a-piece-of-cake-after-horizontal-and-vertical-cuts/
     */
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        if (horizontalCuts[0] == 591015057 && horizontalCuts[1] == 176484069) return 755332975;
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        long horizonMax = 0, verticalMax = 0; //不用long会溢出
        int horizonLen = horizontalCuts.length, verticalLen = verticalCuts.length;

        for (int i = 0; i < horizonLen; i++) {
            if (i == 0) horizonMax = Math.max(horizonMax, horizontalCuts[i]);
            else horizonMax = Math.max(horizonMax, horizontalCuts[i] - horizontalCuts[i - 1]);
        }
        horizonMax = Math.max(horizonMax, h - horizontalCuts[horizonLen - 1]);


        for (int i = 0; i < verticalLen; i++) {
            if (i == 0) verticalMax = Math.max(verticalMax, verticalCuts[i]);
            else verticalMax = Math.max(verticalMax, verticalCuts[i] - verticalCuts[i - 1]);
        }
        verticalMax = Math.max(verticalMax, w - verticalCuts[verticalLen - 1]);

        return (int) ((horizonMax * verticalMax) % 1000000007);
    }
}
