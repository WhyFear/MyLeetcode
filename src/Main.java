import java.util.*;

public class Main {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        Solve fuck = new Solve();
        int[] temp = new int[]{11, 13, 17, 23, 29, 31, 7, 5, 2, 3};
        char[][] board = new char[][]{{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
//        TreeNode root = new TreeNode(2);
//        root.left = new TreeNode(1);
//        root.left.right = new TreeNode(3);
//        root.left.right.right = new TreeNode(1);
//        root.left.left = new TreeNode(1);
//        root.right = new TreeNode(1);

//        root.right.right = new TreeNode(1);
//        ListNode head = new ListNode(0);
//        ListNode p = head;
//        for (int num : temp) {
//            p.next = new ListNode(num);
//            p = p.next;
//        }
        fuck.solve(board);
//        System.out.println(fuck.solve(board));

        long endTime = System.currentTimeMillis();    //获取结束时间
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");

    }
}
