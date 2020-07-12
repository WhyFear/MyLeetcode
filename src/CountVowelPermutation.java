import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/count-vowels-permutation/
 * 究极乱写
 */
public class CountVowelPermutation {
    private final int[] fuck = new int[]{1, 2, 4, 2, 1};
    private final Map<Integer, Map<Integer, Long>> value = new HashMap<>();
    private long op;

    private void insertDict(int str, int level, long result) {
        result = (int) (result % (Math.pow(10, 9) + 7));
        if (value.containsKey(str))
            value.get(str).put(level, result);
        else {
            Map<Integer, Long> temp = new HashMap<>();
            temp.put(level, result);
            value.put(str, temp);
        }
    }

    /**
     * 0:a
     * 1:e
     * 2:i
     * 3:o
     * 4:u
     */
    public long digui(int str, int level) {
        if (value.containsKey(str) && value.get(str).containsKey(level)) {
            op += value.get(str).get(level);
            return value.get(str).get(level);
        } else if (level == 2) {
            op += fuck[str];
            return fuck[str];
        } else {
            switch (str) {
                case 0:
                    long tmp0 = digui(1, level - 1);
                    insertDict(str, level, tmp0);
                    return tmp0;
                case 1:
                    long tmp1 = digui(0, level - 1);
                    tmp1 += digui(2, level - 1);
                    insertDict(str, level, tmp1);
                    return tmp1;
                case 2:
                    long tmp2 = digui(0, level - 1);
                    tmp2 += digui(1, level - 1);
                    tmp2 += digui(3, level - 1);
                    tmp2 += digui(4, level - 1);
                    insertDict(str, level, tmp2);
                    return tmp2;
                case 3:
                    long tmp3 = digui(2, level - 1);
                    tmp3 += digui(4, level - 1);
                    insertDict(str, level, tmp3);
                    return tmp3;
                case 4:
                    long tmp4 = digui(0, level - 1);
                    insertDict(str, level, tmp4);
                    return tmp4;
            }
        }
        return 0;
    }

    public int myCountVowelPermutation(int n) {
        if (n <= 1) return n * 5;
        op = 0;
        for (int i = 0; i < 5; i++) {
            digui(i, n);
        }
        return (int) (op % (Math.pow(10, 9) + 7));
    }

    /**
     * 和我的代码本质上是一样的，但是我就是不会
     */
    public int countVowelPermutation(int n) {
        int M = (int) (Math.pow(10, 9) + 7);
        long a = 1, e = 1, i = 1, o = 1, u = 1;
        for (int k = 2; k <= n; k++) {
            long aa = (e + i + u) % M;
            long ee = (a + i) % M;
            long ii = (e + o) % M;
            long oo = i;
            long uu = (o + i) % M;
            a = aa;
            e = ee;
            i = ii;
            o = oo;
            u = uu;
        }
        return (int) ((a + e + i + o + u) % M);
    }
}
