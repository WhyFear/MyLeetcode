import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * https://leetcode-cn.com/problems/largest-number/
 * CHAOXI
 */


public class LargestNumber {
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "";
        }

        String[] strArr = new String[nums.length];
        for (int i = 0; i < strArr.length; i++) {
            //将int类型转换为String 类型
            //string = String.valueOf(int)
            strArr[i] = String.valueOf(nums[i]);
        }

        //从大到小，倒序排列 (o2 + o1).compareTo(o1 + o2)
        Arrays.sort(strArr, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));

        StringBuilder op = new StringBuilder();
        for (String sa : strArr) {
            op.append(sa);
        }

        String result = op.toString();

        return result.startsWith("0") ? "0" : result;
    }
}
