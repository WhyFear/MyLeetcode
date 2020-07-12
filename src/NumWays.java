public class NumWays {
    public int numWays(int n) {
        if (n <= 3) {
            return n == 0 ? 1 : n;
        }
        long i1 = 1;
        long i2 = 2;
        for (int i = 3; i <= n; i++) {
            long temp = (i1 + i2) % 1000000007;  //可以跳一个台阶可以跳两个台阶
            i1 = i2;
            i2 = temp;
        }
        return (int) (i2 % 1000000007);
    }
}
