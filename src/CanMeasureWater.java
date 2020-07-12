import static java.lang.Integer.min;
import static java.lang.Math.max;

/*
 * https://leetcode-cn.com/problems/water-and-jug-problem/
 * 输入: x = 3, y = 5, z = 4
 * 输出: True
 * 思路：3->5, 3->5 此时3剩1，5清空、1->5 3->5 共4
 * z能否整除x和y的最大公约数是关键
 * */
public class CanMeasureWater {
    public static void main(String[] args) {
        System.out.println(canMeasureWater(1, 1, 12));
    }

    public static boolean canMeasureWater(int x, int y, int z) {
        int tmp, t = 0, times = 0;
        int m = min(x, y), n = max(x, y);
        if (m == 0 && n == 0) {
            return z == 0;
        }
        while (m % 2 == 0 && n % 2 == 0) {
            m = m / 2;
            n = n / 2;
            times++;
        }
        tmp = n - m;
        while (tmp != 0) {
            t = tmp;
            tmp = m > tmp ? m - tmp : tmp - m;
            m = t;
        }
        int result = (int) (t * (Math.pow(2, times)));
        return z % result == 0;
    }
}
