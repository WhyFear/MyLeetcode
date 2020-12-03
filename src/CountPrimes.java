/**
 * https://leetcode-cn.com/problems/count-primes/submissions/
 * 这题搜到一个非常牛逼的算法,叫做厄拉多塞筛法.
 * 比如说求20以内质数的个数,首先0,1不是质数.2是第一个质数,然后把20以内所有2的倍数划去.
 * 2后面紧跟的数即为下一个质数3,然后把3所有的倍数划去.
 * 3后面紧跟的数即为下一个质数5,再把5所有的倍数划去.以此类推.
 */
public class CountPrimes {
    public int countPrimes(int n) {
        if (n <= 2) return 0;
        int op = 1;
        for (int i = 1; i < n; i += 2) {
            if (isPrime(i)) op++;
        }
        return op;
    }

    public boolean isPrime(int num) {
        if (num <= 3) {
            return num > 1;
        }
        // 不在6的倍数两侧的一定不是质数
        if (num % 6 != 1 && num % 6 != 5) {
            return false;
        }
        int sqrt = (int) Math.sqrt(num);
        for (int i = 5; i <= sqrt; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }
}
