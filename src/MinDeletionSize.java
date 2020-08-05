/**
 * https://leetcode-cn.com/problems/delete-columns-to-make-sorted/
 * 这道题本质就是判断一个矩阵里，有多少列是降序排序的
 */
public class MinDeletionSize {
    public static void main(String[] args) {
        String[] str = new String[]{"xc", "yb", "za"};
//        String[] str = new String[]{"ca","bb","ac"};
        System.out.println(minDeletionSize(str));
    }

    public static int minDeletionSize(String[] A) {
        int minDeletionSize = 0;
        for (int i = 0; i < A[0].length(); i++) {
            for (int j = 0; j < A.length - 1; j++) {
                if (A[j].charAt(i) > A[j + 1].charAt(i)) {
                    minDeletionSize++;
                    break;
                }
            }
        }
        return minDeletionSize;
    }
}
