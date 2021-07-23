/**
 * https://leetcode-cn.com/problems/check-if-all-the-integers-in-a-range-are-covered/
 * 1 <= left <= right <= 50 直接生成一个数组就行了。
 */
public class IsCovered {
    public boolean isCovered(int[][] ranges, int left, int right) {
        int[] array = new int[51];
        for (int[] range : ranges) {
            for (int i = range[0]; i <= range[1]; i++) {
                array[i] = 1;
            }
        }
        for (int i = left; i <= right; i++) {
            if (array[i] != 1) return false;
        }
        return true;
    }
}
