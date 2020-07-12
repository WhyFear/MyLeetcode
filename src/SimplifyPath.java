import java.util.Arrays;
import java.util.Stack;

/*
https://leetcode-cn.com/explore/interview/card/bytedance/242/string/1013/
 */
public class SimplifyPath {
    public static void main(String[] args) {
        System.out.println(simplifyPath("/../"));
    }

    public static String simplifyPath(String path) {
        Stack<String> tmp = new Stack<>(); // 以此来记录路径
        StringBuilder op = new StringBuilder();
        String[] dot = new String[]{"", ".", ".."};
        String[] pathArray = path.split("/");
        for (String s : pathArray) {
            if (Arrays.asList(dot).contains(s)) {
                if (s.equals("..")) {
                    if (!tmp.empty()) {
                        tmp.pop();
                    }
                }
            } else {
                tmp.push(s);
            }
        }

        if (tmp.empty()) {
            return "/";
        }
        for (String s : tmp) {
            op.append("/").append(s);
        }
        return op.toString();
    }
}
