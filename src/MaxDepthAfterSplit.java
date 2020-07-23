import java.util.Arrays;

/*
 * https://leetcode-cn.com/problems/maximum-nesting-depth-of-two-valid-parentheses-strings/
 * 思路： 计算A B的深度，如果A《=B 则分配给A 否则给B
 * */
public class MaxDepthAfterSplit {
    public static void main(String[] args) {

        System.out.println(Arrays.toString(maxDepthAfterSplit("()(())()")));
    }

    public static int[] maxDepthAfterSplit(String seq) {
        int a_depth = 0, b_depth = 0;
        int[] op = new int[seq.length()];
        for (int i = 0; i < seq.length(); i++) {
            if (String.valueOf(seq.charAt(i)).equals("(")) {
                if (a_depth <= b_depth) {
                    a_depth++;
                    op[i] = 0;
                } else {
                    b_depth++;
                    op[i] = 1;
                }
            }else{
                if (a_depth > b_depth) {
                    a_depth--;
                    op[i] = 0;
                } else {
                    b_depth--;
                    op[i] = 1;
                }
            }
        }

        return op;
    }
}
