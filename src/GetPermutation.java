import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * https://leetcode-cn.com/explore/interview/card/bytedance/243/array-and-sorting/1021/
 * 思路：k为1时，此时返回顺序序列即可。
 */
public class GetPermutation {
    public static void main(String[] args) {
        System.out.println(getPermutation(9, 46));
    }

    public static String getPermutation(int n, int k) {
        List<Integer> range = IntStream.rangeClosed(1, n).boxed().collect(Collectors.toList());  // 到n的递增列表
        String op = "";
        op = diGui(range, k, op);
        return op;
    }

    private static String diGui(List<Integer> n, int k, String op) {
        if (k == 1) {
            //剩下的数顺序输出
            StringBuilder sb = new StringBuilder();
            for (Integer integer : n) {
                sb.append(integer);
            }
            op = op + sb.toString();
            return op;
        }
        int index = (int) factorial(n.size()) / n.size();
        int waitForDelete = (int) Math.ceil((double) k / index) - 1; //确认位置
        op = op + n.get(waitForDelete);
        n.remove(waitForDelete);  //输出这个数之后将他删除，剩下的仍为递增列表。

        op = diGui(n, k - (waitForDelete) * index, op);

        return op;
    }

    public static long factorial(long number) {
        if (number <= 1)
            return 1;
        else
            return number * factorial(number - 1);
    }
}
