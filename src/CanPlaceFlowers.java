/**
 * https://leetcode-cn.com/problems/can-place-flowers/
 */
public class CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len = flowerbed.length;
        for (int i = 0; i < len && n > 0; i++) {
            if (flowerbed[i] == 0) {
                if (i > 0) if (flowerbed[i - 1] != 0) continue;
                if (i < len - 1) if (flowerbed[i + 1] != 0) continue;
                flowerbed[i] = 1;
                n--;
            }
        }
        return n == 0;
    }
}
