public class IsUgly {
    /**
     * https://leetcode-cn.com/problems/ugly-number/
     */
    public boolean isUgly(int n) {
        if (n == 1) return true;
        if (n < 1) return false; //负数没有丑数
        n = Math.abs(n);
        // 定义最小素数
        int i = 2;

        // 进行辗转相除法
        while (i <= n) {
            // 若num 能整除 i ，则i 是num 的一个因数
            if (n % i == 0) {
                // 同时将 num除以i 的值赋给 num
                n = n / i;
                // 将i重新置为2
                i = 2;
            } else {
                // 若无法整除，则i 自增
                i++;
                //质因数大于五，说明不是丑数
                if (i > 5) return false;
            }
        }
        return true;
    }
}
