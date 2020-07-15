import java.util.*;

/**
 * 字节跳动2020-7-15笔试题
 * 输入为用户id 网站 访问时长
 * 求出访问总时长超过180分钟的用户数最多的那个网站
 * 每个id访问一个网站只会有一条记录
 * 如
 * 12678687 www.toutiao.com 31
 * 12678687 www.byte.com 60
 * 12678687 www.bytedance.com 210
 * 12678685 www.toutiao.com 20
 * 12678685 www.byte.com 90
 * 12678683 www.toutiao.com 15
 * 12678683 www.byte.com 40
 * 12678688 www.toutiao.com 15
 * 输出： www.bytedance.com
 *
 * 126786859 www.huoshan.com 10
 * 输出： null
 */
public class MostVisitedWebsite {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<String> history = new ArrayList<>();
        while (in.hasNextLine()) {
            history.add(in.nextLine());
        }
        Map<String, int[]> websites = new HashMap<>();
        for (String record : history) {
            String[] temp = record.split(" ");
            int[] result = websites.getOrDefault(temp[1], new int[2]);
            result[0]++; //users
            result[1] += Integer.parseInt(temp[2]); // visited times
            websites.put(temp[1], result);
        }
        List<String> maybeMax = new ArrayList<>();
        for (String key : websites.keySet()) {
            int[] result = websites.get(key);
            if (result[1] > 180) maybeMax.add(key);
        }
        String max = null;
        for (String website : maybeMax) {
            if (max == null) max = website;
            else {
                if (websites.get(max)[0] < websites.get(website)[0]) {
                    max = website;
                }
            }
        }
        if (maybeMax.size() == 0)
            System.out.println("null");
        else {
            System.out.println(max);
        }
    }
}
