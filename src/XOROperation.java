/**
 * https://leetcode-cn.com/problems/xor-operation-in-an-array/
 */
public class XOROperation {
    public int xorOperation(int n, int start) {
        int op = start;
        for (int i = 1; i < n; i++) {
            op ^= (start + 2 * i);
        }
        return op;
    }
}
