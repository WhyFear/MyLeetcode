import java.util.HashSet;
import java.util.Set;

public class ReverseVowels {
    public String reverseVowels(String s) {
        int len = s.length();
        int i = 0, j = len - 1;
        StringBuilder front = new StringBuilder();
        StringBuilder tail = new StringBuilder();

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
            while (i < j && !set.contains(s.charAt(i))) {
                front.append(s.charAt(i));
                i++;
            }
            while (j > i && !set.contains(s.charAt(j))) {
                tail.append(s.charAt(j));
                j--;
            }
            front.append(s.charAt(j));
            tail.append(s.charAt(i));
            i++;
            j--;
        }
        return front.append(tail.reverse()).toString();
    }
}
