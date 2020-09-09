/**
 * https://leetcode-cn.com/problems/smallest-integer-divisible-by-k/
 * 2和5一定无解，其他一定有解。
 */
public class SmallestRepunitDivByK {
    public int smallestRepunitDivByK(int K) {
        if (K % 2 == 0 || K % 5 == 0)
            return -1;
        int op = 1;
        for (int n = 1; n % K != 0; op++) {
            n %= K;
            n = n * 10 + 1;
        }
        return op;
    }
}
