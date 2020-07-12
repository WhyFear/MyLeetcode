/**
 * https://leetcode-cn.com/problems/add-binary/
 * 不管谁大，直接a比b大
 */
public class AddBinary {
    public String addBinary(String a, String b) {
        if (b.length() > a.length()) {
            String temp = a;
            a = b;
            b = temp;
        }
        StringBuilder op = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1;
        boolean add = false;
        while (i >= 0 && j >= 0) {
            char aI = a.charAt(i);
            char bJ = b.charAt(j);
            if (aI == '1' && bJ == '1') { // 两者都为1
                op.append(add ? "1" : "0");
                add = true;
            } else if (aI == '1' || bJ == '1') { //两者有一个为1
                op.append(add ? "0" : "1");
            } else { //两者都为0
                op.append(add ? "1" : "0");
                add = false;
            }
            i--;
            j--;
        }
        while (i >= 0) {
            char aI = a.charAt(i);
            if (aI == '1') {
                op.append(add ? "0" : "1");
            } else {
                op.append(add ? "1" : "0");
                add = false;
            }
            i--;
        }
        if (add) op.append("1");
        return op.reverse().toString();
    }
}
