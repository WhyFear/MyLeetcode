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
}
