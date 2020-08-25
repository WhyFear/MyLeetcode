
import java.util.*;

public class Main {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        FindSubsequences fuck = new FindSubsequences();
        int[] temp = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 1, 1, 1, 1};
        char[] tasks = new char[]{'A', 'A', 'B', 'B', 'C', 'C', 'D', 'D', 'E', 'E', 'F', 'F', 'G', 'G', 'H', 'H', 'I', 'I', 'J', 'J', 'K', 'K', 'L', 'L', 'M', 'M', 'N', 'N', 'O', 'O', 'P', 'P', 'Q', 'Q', 'R', 'R', 'S', 'S', 'T', 'T', 'U', 'U', 'V', 'V', 'W', 'W', 'X', 'X', 'Y', 'Y', 'Z', 'Z'};
        int[][] temp1 = new int[][]{{1, 0}, {1, 0}, {1, 0}, {1, 1}};
        char[][] board = new char[][]{{'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'M', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'}};
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
        System.out.println(fuck.findSubsequences(temp).size());
//        fuck.recoverTree(root);

        long endTime = System.currentTimeMillis();    //获取结束时间
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");

    }
}