/**
 * https://leetcode-cn.com/problems/rearrange-words-in-a-sentence/
 * 我的思路是使用链表
 */
public class ArrangeWords {
    public String arrangeWords(String text) {
        StringBuilder op = new StringBuilder();
        MyStrNode tempNode = new MyStrNode("begin");
        //首字母大写转小写
        char[] temp = text.toCharArray();
        temp[0] += 32;
        text = String.valueOf(temp);

        for (int i = 0; i < text.length(); i++) {
            int j = i;
            while (j < text.length() && text.charAt(j) != ' ') j++;
            buildNode(text.substring(i, j), tempNode);
            i = j;
        }

        for (MyStrNode node = tempNode.next; node != null; node = node.next) {
            op.append(node.val);
            op.append(" ");
        }

        //首字母小写转大写
        char[] temp1 = op.toString().toCharArray();
        temp1[0] -= 32;
        return String.valueOf(temp1).substring(0, temp1.length - 1);
    }

    public void buildNode(String str, MyStrNode head) {
        if (head.next == null) head.next = new MyStrNode(str);
        else {
            MyStrNode p = head;
            while (p.next != null && p.next.val.length() <= str.length()) p = p.next;
            if (p.next == null) p.next = new MyStrNode(str);
            else {
                MyStrNode temp = new MyStrNode(str);
                temp.next = p.next;
                p.next = temp;
            }
        }
    }
}

class MyStrNode {
    String val;
    MyStrNode next;

    public MyStrNode(String str) {
        val = str;
    }
}