/**
 * https://leetcode-cn.com/problems/clumsy-factorial/solution/java-bao-li-di-gui-by-don-vito-corleone/
 * chaoxi
 */
public class Clumsy {
    public static void main(String[] args) {
        System.out.println(clumsy(10));
    }

    public static int clumsy(int N) {
        if (N <= 2) return N;
        if (N == 3) return 6;
        int sum = N * (N - 1) / (N - 2) + N - 3;
        N -= 4;
        while (N >= 4) {
            sum += (-N * (N - 1) / (N - 2) + N - 3);
            N -= 4;
        }
        return sum - clumsy(N);
    }
}
