package one;

/**
 * @author huanghaoxing
 */
public class sortList148 {

    public ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }
        return sort(head);
    }

    public ListNode sort(ListNode node) {
        if (node == null || node.next == null) {
            return node;
        }
        ListNode fast = node;
        ListNode slow = node;
        ListNode pre = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            pre = slow;
            slow = slow.next;
        }
        ListNode mid = pre.next;
        pre.next = null;
        ListNode left = sort(node);
        ListNode right = sort(mid);
        return merge(left, right);
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        while (left != null && right != null) {
            if (left.val < right.val) {
                p.next = left;
                p = p.next;
                left = left.next;
            } else {
                p.next = right;
                p = p.next;
                right = right.next;
            }
        }
        if (left != null) {
            p.next = left;
        } else {
            p.next = right;
        }
        return dummy.next;
    }
}
