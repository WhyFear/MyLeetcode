import java.util.*;

public class Main {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        CountBinarySubstrings fuck = new CountBinarySubstrings();
        int[] temp = new int[]{1, 2, 3, 4, 5};
        int[][] temp1 = new int[][]{{1, 2}, {2, 3}};
        char[][] board = new char[][]{{'1'}};
//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(3);
//        root.left.right = new TreeNode(2);
//        root.left.right.right = new TreeNode(1);
//        root.left.left = new TreeNode(1);
//        root.right = new TreeNode(3);
//        root.right.right = new TreeNode(1);

//        ListNode head = new ListNode(0);
//        ListNode p = head;
//        for (int num : temp) {
//            p.next = new ListNode(num);
//            p = p.next;
//        }
        System.out.println(fuck.countBinarySubstrings("10101"));
//        fuck.recoverTree(root);

        long endTime = System.currentTimeMillis();    //获取结束时间
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");

    }
}
