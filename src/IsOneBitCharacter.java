/**
 * https://leetcode-cn.com/problems/1-bit-and-2-bit-characters/
 * 只与最后一个元素0的前面的连续1的个数有关系。（最高赞）
 * 似乎大家都沒有理解最高贊的評論，都是從0開始遍歷數組。
 * 事實上因為只要數組最後一個數是0，那麼這個數組肯定可以被0，10，11分割。
 * 那麼只需要考慮最後一個0前面連續1的個數，個數是偶數則TRUE，否則FALSE。
 * 所以從數組末尾開始遍歷效率會更高。
 */
public class IsOneBitCharacter {
    public boolean isOneBitCharacter(int[] bits) {
        if (bits.length <= 1) return true;
        int i = bits.length - 2;
        while (i >= 0 && bits[i] == 1) i--;
        return (bits.length - i) % 2 == 0;
    }
}
