import java.util.*;

public class Main {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        WiggleMaxLength fuck = new WiggleMaxLength();
        int[] temp = new int[]{1,17,5,10,13,15,10,5,16,8};
        char[][] board = new char[][]{{'1'}};
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
        System.out.println(fuck.wiggleMaxLength(temp));

        long endTime = System.currentTimeMillis();    //获取结束时间
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");

    }
}
