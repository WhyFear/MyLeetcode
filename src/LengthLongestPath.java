import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode-cn.com/problems/longest-absolute-file-path/
 */
public class LengthLongestPath {
    public int lengthLongestPath(String input) {
        if (input == null || input.length() == 0) return 0;
        String[] words = input.split("\n");
        int op = 0, countStrLen = 0;
        Deque<Integer> stack = new ArrayDeque<>(); //栈存储字符串的长度
        for (String word : words) {
            int level = word.lastIndexOf('\t') + 1;
            while (stack.size() > level) {
                countStrLen -= stack.pop();
            }
            int stringLen = word.length() - level + 1;
            stack.push(stringLen);
            countStrLen += stringLen;
            if (word.contains(".")) op = Math.max(op, countStrLen);
        }
        return op == 0 ? 0 : op - 1;
    }
}
/*
dp
    public int lengthLongestPath(String input) {
        if (input == null || input.length() == 0) return 0;
        String[] words = input.split("\n");
        int[] pathLens = new int[words.length + 1];//pathLens[i]存放地i层次的最后面的元素的路径长度
        pathLens[0] = -1;//层次最少是1，为了统一dp操作（具体看下面循环体），取pathLens[0]=-1
        int ans = 0;
        //自左向右，dp
        for (String word : words) {
            int level = word.lastIndexOf('\t') + 2;//层次计算
            int nameLen = word.length() - (level - 1);//计算名字长度
            //word的父文件夹必定目前是level-1层次的最后一个，因此pathLens[level-1]就是父文件夹路径长度
            //这个word必然是目前本层次的最后一个，因此需要刷新pathLens[level],+1是因为要加一个'\'
            pathLens[level] = pathLens[level - 1] + 1 + nameLen;
            //如果是文件，还需要用路径长度刷新ans
            if (word.contains(".")) ans = Math.max(ans, pathLens[level]);
        }
        return ans;
    }
 */