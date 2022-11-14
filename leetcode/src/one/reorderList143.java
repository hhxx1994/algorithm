package one;

/**
 * @author huanghaoxing
 */
public class reorderList143 {

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            pre = slow;
            slow = slow.next;
        }
        ListNode middle = pre.next;
        pre.next = null;
        ListNode reverse = reverse(middle);

        ListNode p = head;
        ListNode a = head.next;
        while (a != null && reverse != null) {
            p.next = reverse;
            p = p.next;
            reverse = reverse.next;

            p.next = a;
            a = a.next;
            p = p.next;
        }
        if (a != null) {
            p.next = a;
        } else {
            p.next = reverse;
        }
    }

    public ListNode reverse(ListNode node) {

        if (node.next == null) {
            return null;
        }

        ListNode r = reverse(node.next);
        node.next.next = node;
        node.next = null;
        return r;
    }

}
