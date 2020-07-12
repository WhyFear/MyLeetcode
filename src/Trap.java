import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/trapping-rain-water/
 */
public class Trap {
    public static void main(String[] args) {
        int[] height = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
//        int[] height = new int[]{4, 2, 3};
        System.out.println(trap1(height));
    }

    public static int trap(int[] height) {
        int op = 0;
        int tmp = 0;
        boolean fuck = false;
        for (int h = 0; h < height.length - 1; h++) {
            for (int j = h + 1; height[j] < height[h]; j++) {
                if (height[h] >= height[j]) {
                    op += height[h] - height[j];
                } else {
                    h = j;
                }
                if (j == height.length - 1) {
                    if (height[height.length - 1] < height[h]) {  //最后一位的值比存储的最大值小
                        for (int i = h; i < height.length; i++)
                            op = op - height[h] + height[i];  //删除之前获得的值
                        height[h]--; //将最高值减1，然后重新开始计算。
                        tmp = h - 1; //h回到当前位置
                    }
                    break;
                }
                tmp = j;
                fuck = true; //只有真的向前遍历了才改变h的值，不然会死循环
            }
            if (fuck) {
                h = tmp;
                fuck = false;
            }
        }
        return op;
    }

    /**
     * 别人的
     */
    public static int trap1(int[] height) {
        int left = 0, right = height.length - 1;
        int left_max = 0, right_max = 0, ans = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] > left_max) {
                    left_max = height[left];
                } else {
                    ans += left_max - height[left];
                }
                left++;
            } else {
                if (height[right] > right_max) {
                    right_max = height[right];
                } else {
                    ans += right_max - height[right];
                }
                right--;
            }
        }
        return ans;
    }
}
