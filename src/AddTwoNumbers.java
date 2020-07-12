/**
 * https://leetcode-cn.com/problems/add-two-numbers/
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);

        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
        System.out.println(addTwoNumbers(l1, l2));
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode op = new ListNode(-1), temp, end = op;
        boolean carry = false;//进位
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val;
            if (carry) {
                sum++;
                carry = false;
            }
            int val = sum % 10;
            if (sum >= 10) carry = true;
            temp = new ListNode(val);
            end.next = temp;
            end = end.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            if (carry) {
                l1.val++;
                carry = false;
            }
            if (l1.val >= 10) {
                l1.val = 0;
                carry = true;
            }
            end.next = l1;
            end = end.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            if (carry) {
                l2.val++;
                carry = false;
            }
            if (l2.val >= 10) {
                l2.val = 0;
                carry = true;
            }
            end.next = l2;
            end = end.next;
            l2 = l2.next;
        }
        if (carry) {
            temp = new ListNode(1);
            end.next = temp;
        }
        return op.next;
    }
}
