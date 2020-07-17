import java.util.*;

public class Main {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        NumberOfArrays fuck = new NumberOfArrays();
        int[] temp = new int[]{11, 13, 17, 23, 29, 31, 7, 5, 2, 3};
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
        System.out.println(fuck.numberOfArrays("48486250454844645287030712560644579294181", 989));

        long endTime = System.currentTimeMillis();    //获取结束时间
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");

    }
}
