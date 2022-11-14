package one;

/**
 * @author huanghaoxing
 */
public class addTwoNumbers2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        int bit = 0;
        while (l1 != null && l2 != null) {
            int val = (l1.val + l2.val + bit) % 10;
            bit = (l1.val + l2.val + bit) / 10;
            p.next = new ListNode(val);
            p = p.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        ListNode l = l1 != null ? l1 : l2;
        while (l != null) {
            int val = (l.val + bit) % 10;
            bit = (l.val + bit) / 10;
            p.next = new ListNode(val);
            p = p.next;
            l = l.next;
        }
        if (bit != 0) {
            p.next = new ListNode(bit);
        }
        return dummy.next;
    }

}
