/**
 * https://leetcode-cn.com/problems/maximum-length-of-repeated-subarray/
 * 滑动窗口
 * chaoxi
 */
public class FindLength {
    public int findLength(int[] A, int[] B) {
        int a = A.length;
        int b = B.length;
        int i = a-1;
        int j = 0;
        int res = 0;
        while(j < b){
            int n = i;
            int m = j;
            int k = 0;
            while(n < a && m < b){
                if(A[n] == B[m]){
                    k++;
                }else{
                    res = Math.max(k, res);
                    k = 0;
                }
                n++;
                m++;
            }
            res = Math.max(k, res);
            if(i != 0)
                i--;
            else
                j++;
        }
        return res;
    }
}
