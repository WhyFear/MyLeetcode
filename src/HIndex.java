/**
 * https://leetcode-cn.com/problems/h-index-ii/
 * 给定一位研究者论文被引用次数的数组（被引用次数是非负整数），数组已经按照升序排列。编写一个方法，计算出研究者的 h 指数。
 * h 指数的定义: “h 代表“高引用次数”（high citations），一名科研人员的 h 指数是指他（她）的 （N 篇论文中）总共有 h 篇论文分别被引用了至少 h 次。
 * （其余的 N - h 篇论文每篇被引用次数不多于 h 次。）"
 * 倒着来更快：
 //    public int hIndex(int[] citations) {
 //        int n = citations.length;
 //        for (int h = n; h > 0; h--) {
 //            if (citations[n - h] >= h) {
 //                return h;
 //            }
 //        }
 //        return 0;
 //    }
 */
public class HIndex {
    public int hIndex(int[] citations) {
        if (citations.length == 0) return 0;
        int op = citations.length;
        for (int citation : citations) {
            if (op > citation) op--;
            else return op;
        }
        return Math.min(op, citations[citations.length - 1]);
    }

}
