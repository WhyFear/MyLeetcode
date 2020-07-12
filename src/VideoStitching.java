import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/video-stitching/
 * 类似于给身高不同的人排序那道题。先按[i][0]升序排列，再按[i][1]降序排列。
 */
public class VideoStitching {
    public static void main(String[] args) {
//        int[][] clips = new int[][]{{0, 1}, {6, 8}, {0, 2}, {5, 6}, {0, 4}, {0, 3}, {6, 7}, {1, 3}, {4, 7}, {1, 4}, {2, 5}, {2, 6}, {3, 4}, {4, 5}, {5, 7}, {6, 9}};
//        int[][] clips = new int[][]{{0, 2}, {4, 8}};
        int[][] clips = new int[][]{{24, 28}, {10, 56}, {50, 78}, {38, 77}, {38, 78}, {3, 69}, {33, 49}, {66, 89}, {73, 83}, {6, 12}, {24, 86}, {67, 82}, {18, 26}, {1, 57}, {13, 30}, {8, 56}, {58, 78}, {2, 84}, {35, 39}, {45, 51}, {30, 32}, {19, 31}, {32, 70}, {1, 15}, {16, 18}, {32, 87}, {32, 87}, {39, 42}, {81, 84}, {25, 61}, {26, 34}, {10, 82}, {17, 34}, {56, 72}, {17, 22}, {8, 83}, {5, 21}, {3, 79}, {12, 73}, {0, 28}, {74, 76}, {41, 79}, {4, 60}, {51, 90}, {10, 41}, {47, 90}, {44, 56}, {13, 16}, {43, 83}, {0, 22}, {30, 40}, {8, 27}, {57, 58}, {0, 26}, {16, 66}, {62, 89}, {2, 74}, {17, 61}, {25, 28}, {23, 54}, {42, 79}, {14, 28}, {26, 77}, {34, 36}, {17, 42}, {72, 81}, {12, 87}, {3, 57}, {81, 88}, {65, 87}, {35, 74}, {19, 77}, {10, 53}, {38, 75}, {14, 90}, {10, 90}, {57, 62}, {37, 74}, {24, 80}, {52, 63}, {52, 55}, {64, 73}, {45, 79}, {12, 19}, {26, 38}, {40, 81}, {28, 48}, {33, 62}, {18, 50}, {9, 40}};
//        int[][] clips = new int[][]{{16, 18}, {16, 20}, {3, 13}, {1, 18}, {0, 8}, {5, 6}, {13, 17}, {3, 17}, {5, 6}};
        System.out.println(videoStitching(clips, 72));
    }

    public static int videoStitching(int[][] clips, int T) {
        int op = 0;
        Arrays.sort(clips, (o1, o2) -> {  //排序，左端点升序，右端点降序
            // if the heights are equal, compare k-values
            return o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0];
        });
        int maxLen = 0; //记录最长录制距离
        for (int i = 0; i < clips.length && maxLen < T; i++) {
            int[] temp = clips[i];
            while (i < clips.length && clips[i][0] < maxLen) {
                if (clips[i][1] > temp[1]) temp = clips[i];  //找到录制时间最长的那个
                i++;
            }
            if (i < clips.length && maxLen == clips[i][0]) maxLen = Math.max(clips[i][1], temp[1]);
            else if (maxLen > temp[0]) maxLen = temp[1];
            op++;
        }
        if (maxLen < T) return -1;
        return op;
    }
}
