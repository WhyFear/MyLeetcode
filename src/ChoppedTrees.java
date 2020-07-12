import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/**
 * 浪潮2020/7/7 笔试题
 */
public class ChoppedTrees {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = 5;
        int[] tempTrees = new int[]{9, 15, 27, 35, 48};
//        int n = in.nextInt();
//        in.nextLine();
//        String temp = in.nextLine();
//        String[] input = temp.split(" ");
//
//        int[] tempTrees = new int[n];
//        for (int i = 0; i < n; i++) {
//            tempTrees[i] = Integer.parseInt(input[i]);
//        }
        int[] trees = new int[n + 2];
        System.arraycopy(tempTrees, 0, trees, 0, n);
        n += 2;
        trees[n - 2] = 101;
        trees[n - 1] = 102;

        Arrays.sort(trees);

        Stack<Integer> oddTrees = new Stack<>();
        Stack<Integer> evenTrees = new Stack<>();
        oddTrees.push(-1);
        evenTrees.push(0);
        int[] max = new int[2]; // index and maxlen
        int result = 0;

        for (int i = 0; i < n; i++) {
            int tree = trees[i];
            if (tree % 2 == 0) {
                result = (tree - evenTrees.peek()) / 2 - 1;
                if (max[1] < result) {
                    max[0] = evenTrees.peek() + 2;
                    max[1] = result;
                }
                evenTrees.add(tree);
            } else {
                result = (tree - oddTrees.peek()) / 2 - 1;
                if (max[1] < result) {
                    max[0] = oddTrees.peek() + 2;
                    max[1] = result;
                }
                oddTrees.add(tree);
            }

        }

        System.out.println(max[0] + " " + max[1]);
    }
}
