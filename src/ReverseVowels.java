import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/reverse-vowels-of-a-string/
 * 好蠢的写法
 */
public class ReverseVowels {
    public String reverseVowels(String s) {
        int len = s.length();
        if (len < 2) return s;
        int i = 0, j = len - 1;
        char[] chars = s.toCharArray();

        Set<Character> set = new HashSet<>() {
            {
                add('a');
                add('e');
                add('i');
                add('o');
                add('u');
            }
        };
        while (i < j) {
            if (set.contains(Character.toLowerCase(chars[i])) && set.contains(Character.toLowerCase(chars[j]))) {
                //swap
                char temp = chars[i];
                chars[i] = chars[j];
                chars[j] = temp;
                i++;
                j--;
            } else if (set.contains(Character.toLowerCase(chars[i]))) {
                j--;
            } else if (set.contains(Character.toLowerCase(chars[j]))) {
                i++;
            } else {
                i++;
                j--;
            }
        }
        return String.valueOf(chars);
    }
}
/*
    public String reverseVowels(String s) {
        int len = s.length();
        if (len < 2) return s;
        int i = 0, j = len - 1;
        StringBuilder front = new StringBuilder();
        StringBuilder tail = new StringBuilder();

        Set<String> set = new HashSet<>() {
            {
                add("a");
                add("e");
                add("i");
                add("o");
                add("u");
            }
        };
        while (i <= j) {
            while (i < j && !set.contains(String.valueOf(s.charAt(i)).toLowerCase())) {
                front.append(s.charAt(i));
                i++;
            }
            while (j > i && !set.contains(String.valueOf(s.charAt(j)).toLowerCase())) {
                tail.append(s.charAt(j));
                j--;
            }
            if (i < j) {
                front.append(s.charAt(j));
                tail.append(s.charAt(i));
            } else if (i == j) front.append(s.charAt(j));
            i++;
            j--;
        }
        return front.append(tail.reverse()).toString();
    }
 */