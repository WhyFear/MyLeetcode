import java.util.*;

/**
 * https://www.nowcoder.com/questionTerminal/fbc417f314f745b1978fc751a54ac8cb?f=discussion
 * 没写出来
 */
public class JudgePoint24 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] arrays = new int[4];
        for (int i = 0; i < 4; i++) {
            arrays[i] = in.nextInt();
        }
        char[] operators = new char[]{'+', '-', '*', '/'};
        boolean is24 = false;
        for (char first : operators) {
            for (char second : operators) {
                for (char third : operators) {
                    char[] operator = new char[]{first, second, third};
                    if (compute(arrays, operator)) {
                        is24 = true;
                        break;
                    }
                }
            }
        }
        System.out.println(is24);
    }

    private static boolean compute(int[] arrays, char[] operators) {
        Deque<Float> stackNum = new ArrayDeque<>();
        Deque<Character> stackOperator = new ArrayDeque<>();
        stackNum.push((float) arrays[0]);
        int i = 1, j = 0;
        while (i < 4 && j < 3) {
            if (operators[j] == '/' || operators[j] == '*') {
                float first = stackNum.pop();
                int last = arrays[i];
                float result;
                if (operators[j] == '*') {
                    result = (first * last);
                } else result = first / last;
                stackNum.push(result);
            } else {
                stackNum.push((float) arrays[i]);
                stackOperator.push(operators[j]);
            }
            i++;
            j++;
        }
        while (!stackOperator.isEmpty()) {
            float last = stackNum.pop();
            float first = stackNum.pop();
            float result;
            if (stackOperator.pop() == '+') {
                result = last + first;
            } else result = first - last;
            stackNum.push(result);
        }
        return stackNum.peek() == 24;
    }
}
