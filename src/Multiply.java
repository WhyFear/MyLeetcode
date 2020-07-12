/**
 * https://leetcode-cn.com/problems/multiply-strings/
 */
public class Multiply {
    public static void main(String[] args) {
        String num1 = "123456789";
        String num12 = "987654321";
        System.out.println(addNums("944977892635269", "9876543120000000"));
        System.out.println(multiply(num1, num12));
    }

    /**
     * 多位数乘一位数
     */
    public static String multiplyone(String num1, String sNum2) {
        int num2 = Integer.parseInt(sNum2);
        if (num2 == 1) return num1;
        if (num2 == 0) return "0".repeat(num1.length());

        StringBuilder op = new StringBuilder();
        int carry = 0; //进位标志
        char[] nums = num1.toCharArray();
        for (int i = nums.length - 1; i >= 0; i--) {
            int multiplicand = Integer.parseInt(String.valueOf(nums[i])); //被乘数
            int result = multiplicand * num2 + carry;
            if (result >= 10) carry = result / 10;
            else carry = 0;
            op.append((result % 10));
        }
        if (carry != 0) op.append(carry);
        return op.reverse().toString();
    }

    /**
     * 将两组数相加
     *
     * @param num1 低位数
     * @param num2 高位数
     * @return 结果
     */
    public static String addNums(String num1, String num2) {
        StringBuilder op = new StringBuilder();
        char[] nums1 = num1.toCharArray();
        char[] nums2 = num2.toCharArray();
        int carry = 0; //进位标志
        int i = nums1.length - 1, j = nums2.length - 1;
        while (i >= 0 && j >= 0) {
            int result = Integer.parseInt(String.valueOf(nums1[i--])) + Integer.parseInt(String.valueOf(nums2[j--])) + carry;
            if (result >= 10) carry = 1;
            else carry = 0;
            op.append(result % 10);
        }
        while (j >= 0) {
            int result = Integer.parseInt(String.valueOf(nums2[j--])) + carry;
            if (result >= 10) carry = 1;
            else carry = 0;
            op.append(result % 10);
        }
        if (carry == 1) op.append("1");
        return op.reverse().toString();
    }

    public static String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        if (num1.length() < num2.length()) {
            String temp = num1;
            num1 = num2;
            num2 = temp;
        }

        char[] nums2 = num2.toCharArray();
        String op = multiplyone(num1, String.valueOf(nums2[nums2.length - 1]));
        for (int i = nums2.length - 2; i >= 0; i--) {
            String highPosResult = multiplyone(num1, String.valueOf(nums2[i]));
            op = addNums(op, highPosResult + "0".repeat(nums2.length - i - 1));
        }
        return op;
    }
}
