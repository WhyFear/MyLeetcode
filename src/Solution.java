import java.util.*;


public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        int bracket_count = 0;
        List<List<Integer>> pos = new ArrayList<>();
        Deque<Integer> stack = new ArrayDeque<>();
        Deque<Integer> level = new ArrayDeque<>();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(') {
                level.push(stack.size());
                stack.push(i);
            } else if (input.charAt(i) == ')') {
                int level1 = level.pop();
                if (level1 >= pos.size()) {
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(stack.pop());
                    tmp.add(i);
                    pos.add(tmp);
                }else {
                    pos.get(level1).add(stack.pop());
                    pos.get(level1).add(i);
                }
                bracket_count++;
            }
        }
        System.out.println(bracket_count);
        for (List<Integer> temp : pos) {
            for (int num : temp)
                System.out.println(num);
        }
    }
}

