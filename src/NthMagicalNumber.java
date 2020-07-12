import java.util.*;

/**
 * https://leetcode-cn.com/problems/nth-magical-number/
 */
public class NthMagicalNumber {
    public static void main(String[] args) {
        System.out.println(nthMagicalNumber(1000000000, 40000, 40000));
    }

    public static int nthMagicalNumber(int N, int A, int B) {
        int MOD = 1_000_000_007;
        int L = A / gcd(A, B) * B;

        long lo = 0;
        long hi = (long) 1e15;
        while (lo < hi) {
            long mi = lo + (hi - lo) / 2;
            // If there are not enough magic numbers below mi...
            if (mi / A + mi / B - mi / L < N)
                lo = mi + 1;
            else
                hi = mi;
        }

        return (int) (lo % MOD);
    }

    public static int gcd(int x, int y) {
        if (x == 0) return y;
        return gcd(y % x, x);
    }
}
