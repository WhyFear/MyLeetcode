/**
 * https://leetcode-cn.com/problems/count-triplets-that-can-form-two-arrays-of-equal-xor/
 * 两个相等的数进行异或运算必定是0，a、b两个数相等，
 * 所以需要求 i 到 k 的数异或为 0 的区间，因为 j > i，k >= j， 所以 k 必须大于 i，
 * 只要有异或为0的区间，就相加，至于为什么加(k - i)，自己可以写几个数推导一下很容易的
 */
public class CountTriplets {
    public int countTriplets(int[] arr) {
        int len = arr.length;
        int ans = 0;

        for (int i = 0; i < len - 1; i++) {
            int sum = 0;
            for (int k = i; k < len; k++) {
                sum ^= arr[k];
                if (sum == 0 && k > i) {
                    ans += (k - i);
                }
            }
        }
        return ans;
    }
}
