/**
 * https://leetcode-cn.com/problems/replace-elements-with-greatest-element-on-right-side/
 */
public class ReplaceElements {
    public int[] replaceElements(int[] arr) {
        int max = -1;
        for (int i = arr.length - 1; i >= 0; i--) {
            int temp = max;
            max = Math.max(max,arr[i]);
            arr[i] = temp;
        }
        return arr;
    }
}
