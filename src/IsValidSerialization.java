import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/verify-preorder-serialization-of-a-binary-tree/
 * 引入槽位的概念，一个非空节点增加两个槽位，消耗一个槽位，空节点只消耗一个槽位。
 * 我想的太复杂了
 * chaoxi
 */
public class IsValidSerialization {
    public boolean isValidSerialization(String preorder) {
        int slot = 1;

        int len = preorder.length();
        if (preorder.charAt(len - 1) != '#') return false;

        for (int i = 0; i < len - 1; i++) {
            if (preorder.charAt(i) == ',') {
                if (--slot < 0) return false;
                if (preorder.charAt(i - 1) != '#') slot += 2;
            }
        }

        return slot == 1;
    }
}
