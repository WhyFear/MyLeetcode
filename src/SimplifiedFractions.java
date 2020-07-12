import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/simplified-fractions/
 * 最大公约数应该为1
 */
public class SimplifiedFractions {
    public List<String> simplifiedFractions(int n) {
        List<String> op = new ArrayList<>();
        if (n < 2) return op;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                if (gcd(i, j) == 1)
                    op.add(j + "/" + i);
            }
        }
        return op;
    }

    public int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
