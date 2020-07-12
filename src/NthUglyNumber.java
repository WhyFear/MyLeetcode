import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/ugly-number-ii/
 * 垃圾题目，面试很多
 * 答案请看提交记录
 */
public class NthUglyNumber {
    public static void main(String[] args) {
        System.out.println(nthUglyNumber(1352));
    }

    public static int nthUglyNumber(int n) {
        if (n <= 3) return n;
        Set<Integer> isUglyNum = new HashSet<>();
        isUglyNum.add(1);
        isUglyNum.add(2);
        isUglyNum.add(3);
        int count = 3, i = 4;
        while (count < n) {
            if (i % 5 == 0 && isUglyNum.contains(i / 5)) {
                isUglyNum.add(i);
                count++;
            } else if (i % 3 == 0 || i % 2 == 0) {
                if (isUglyNum.contains(i / 3) && i % 3 == 0) {
                    isUglyNum.add(i);
                    count++;
                } else if (isUglyNum.contains(i / 2) && i % 2 == 0) {
                    isUglyNum.add(i);
                    count++;
                }
            }
            i++;
        }
        return i - 1;
    }
}
