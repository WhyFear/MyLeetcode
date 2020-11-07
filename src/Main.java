import java.util.*;

public class Main {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        int[] temp = new int[]{8, 1, 1, 2, 3};

        int[][] temp1 = new int[][]{{1, 2}, {3, 4}, {1, 4}, {2, 3}};
        char[] tasks = new char[]{'A', 'A', 'B', 'B', 'C', 'C', 'D', 'D', 'E', 'E', 'F', 'F', 'G', 'G', 'H', 'H', 'I', 'I', 'J', 'J', 'K', 'K', 'L', 'L', 'M', 'M', 'N', 'N', 'O', 'O', 'P', 'P', 'Q', 'Q', 'R', 'R', 'S', 'S', 'T', 'T', 'U', 'U', 'V', 'V', 'W', 'W', 'X', 'X', 'Y', 'Y', 'Z', 'Z'};
        char[][] board = new char[][]{{'5', '3', '.', '.', '7', '.', '.', '.', '.'}, {'6', '.', '.', '1', '9', '5', '.', '.', '.'}, {'.', '9', '8', '.', '.', '.', '.', '6', '.'}, {'8', '.', '.', '.', '6', '.', '.', '.', '3'}, {'4', '.', '.', '8', '.', '3', '.', '.', '1'}, {'7', '.', '.', '.', '2', '.', '.', '.', '6'}, {'.', '6', '.', '.', '.', '.', '2', '8', '.'}, {'.', '.', '.', '4', '1', '9', '.', '.', '5'}, {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        String[] A = new String[]{"hot", "dot", "dog", "lot", "log", "log"};
        List<String> listString = new ArrayList<>(Arrays.asList(A));
//        List<List<Integer>> rooms = new ArrayList<>();
//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(3);
//        root.left.right = new TreeNode(2);
//        root.left.right.right = new TreeNode(5);
//        root.left.left = new TreeNode(1);
//        root.right = new TreeNode(4);
//        root.right.right = new TreeNode(1);

//        ListNode head = new ListNode(0);
//        ListNode p = head;
//        for (int num : temp) {
//            p.next = new ListNode(num);
//            p = p.next;
//        }

        LadderLength fuck = new LadderLength();
//        fuck.solveSudoku(board);
        Scanner in = new Scanner(System.in);
        System.out.println(fuck.ladderLength("hit", "cog", listString));
//        System.out.println(Arrays.toString(fuck.permutation("aab")));

        long endTime = System.currentTimeMillis();    //获取结束时间
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");
    }
}