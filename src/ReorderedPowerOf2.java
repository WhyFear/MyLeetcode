import java.util.*;

/**
 * https://leetcode-cn.com/problems/reordered-power-of-2/
 * 剑指offer P103 相关题目1
 */
public class ReorderedPowerOf2 {
    public static void main(String[] args) {
        System.out.println(reorderedPowerOf2(2918));
    }

    public static boolean reorderedPowerOf2(int N) {
        Set<Integer> powerOf2 = new HashSet<>(Arrays.asList(1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 131072, 262144, 524288, 1048576, 2097152, 4194304, 8388608, 16777216, 33554432, 67108864, 134217728, 268435456, 536870912));
        Set<List<Character>> temp = new HashSet<>();
        if (powerOf2.contains(N)) return true;
        for (int num : powerOf2) {
            String temp1 = String.valueOf(num);
            char[] temp2 = temp1.toCharArray();
            List<Character> temp3 = new ArrayList<>();
            for (char temp4 : temp2) {
                temp3.add(temp4);
            }
            Collections.sort(temp3);
            temp.add(temp3);
        }
        String temp1 = String.valueOf(N);
        char[] temp2 = temp1.toCharArray();
        List<Character> temp3 = new ArrayList<>();
        for (char temp4 : temp2) {
            temp3.add(temp4);
        }
        Collections.sort(temp3);
        return temp.contains(temp3);
    }
}
