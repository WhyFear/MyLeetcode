/**
 * https://leetcode-cn.com/problems/lemonade-change/
 */
public class LemonadeChange {
    public boolean lemonadeChange(int[] bills) {
        int len = bills.length;
        if (len == 0) return true;
        if (bills[0] != 5) return false;
        int[] coins = new int[3]; // 5 10 20。其实20的数量不用存，不会用它找零。
        for (int bill : bills) {
            if (bill == 5) coins[0]++;
            else if (bill == 10) {
                if (coins[0] == 0) return false;
                coins[1]++;
                coins[0]--;
            } else {
                if (coins[0] < 3 && coins[1] < 1) return false; // 20块找零可以是10+5或者是5+5+5
                if (coins[1] < 1) coins[0] -= 3;
                else { // 有十块就判断五块的够不够
                    if (coins[0] < 1) return false;
                    coins[0]--;
                    coins[1]--;
                }
            }
        }
        return true;
    }
}
