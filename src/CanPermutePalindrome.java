public class CanPermutePalindrome {
    public boolean canPermutePalindrome(String s) {
        boolean odd = false;
        int[] chars = new int[128];
        for (char temp : s.toCharArray()) {
            chars[temp]++;
        }
        for (int num : chars) {
            if (num % 2 == 1) {
                if (!odd) odd = true;
                else return false;
            }
        }
        return true;
    }
}
