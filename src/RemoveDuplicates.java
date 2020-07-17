import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(removeDuplicates(nums));
    }

    /**
     * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
     */
    public static int removeDuplicates(int[] nums) {
        if (nums.length <= 1) return nums.length;
        int temp = nums[0];
        int i = 1, index = 1;
        while (i < nums.length) {
            if (nums[i] != temp) {
                temp = nums[i];
                nums[index++] = nums[i++];
            } else i++;
        }
        return index;
    }

    /**
     * https://leetcode-cn.com/problems/remove-all-adjacent-duplicates-in-string/
     * chaoxi
     */
    public String removeDuplicates(String S) {
        StringBuilder op = new StringBuilder();
        int sbLength = 0;
        for (char character : S.toCharArray()) {
            if (sbLength != 0 && character == op.charAt(sbLength - 1))
                op.deleteCharAt(sbLength-- - 1);
            else {
                op.append(character);
                sbLength++;
            }
        }
        return op.toString();
    }

    /**
     * https://leetcode-cn.com/problems/remove-all-adjacent-duplicates-in-string-ii/
     */
    public String removeDuplicates(String s, int k) {
        Deque<countChar> stack = new ArrayDeque<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; ) {
            int j = i;
            while (j < chars.length && chars[j] == chars[i] && j - i < k) j++;
            int chrCount = j - i;
            if (chrCount < k) {
                if (!stack.isEmpty() && stack.peek().chr == chars[i]) {
                    stack.peek().count += chrCount;
                    if (stack.peek().count == k) stack.pop();
                    else if (stack.peek().count > k) stack.peek().count -= k;
                } else
                    stack.push(new countChar(chars[i], chrCount));
            }
            i = j;
        }
        StringBuilder op = new StringBuilder();
        while (!stack.isEmpty()) {
            countChar temp = stack.pop();
            op.append(String.valueOf(temp.chr).repeat(temp.count));
        }
        return op.reverse().toString();
    }
}

class countChar {
    Character chr;
    int count;

    public countChar(Character chr) {
        this.chr = chr;
        count = 1;
    }

    public countChar(Character chr, int count) {
        this.chr = chr;
        this.count = count;
    }

    @Override
    public String toString() {
        return "countChar{" +
                "chr=" + chr +
                ", count=" + count +
                '}';
    }
}