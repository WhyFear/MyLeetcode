/**
 * https://leetcode-cn.com/problems/number-of-days-between-two-dates/
 * 闰年需要判断吗？
 */
public class DaysBetweenDates {
    public int daysBetweenDates(String date1, String date2) {
        return Math.abs(isday(date1) - isday(date2));
    }

    /**
     * 距离1971-1-1是多少天
     */
    public int isday(String date) {
        int i, d = 0;
        int[] days = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        for (i = 1971; i <= Integer.parseInt(date.substring(0, 4)); i++)
            d += (i % 4 == 0 && i % 100 != 0) || i % 400 == 0 ? 366 : 365;
        i--;
        if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0)
            days[1] = 29;
        for (int j = 11; j >= Integer.parseInt(date.substring(5, 7)) - 1; j--)
            d -= days[j];
        return d + Integer.parseInt(date.substring(8));
    }
}
