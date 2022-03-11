package four;

import pub.ListNode;

/**
 * @author huanghaoxing
 */
public class SortList148 {

    public ListNode sortList(ListNode head) {
        return sort(head);
    }

    public ListNode sort(ListNode node) {
        if (node == null || node.next == null) {
            return node;
        }
        ListNode mid = findMid(node);
        ListNode next = mid.next;
        mid.next = null;

        ListNode left = sort(node);
        ListNode right = sort(next);
        return merge(left, right);
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        while (left != null && right != null) {
            if (left.val < right.val) {
                p.next = left;
                left = left.next;
                p = p.next;
            } else {
                p.next = right;
                right = right.next;
                p = p.next;
            }
        }

        if (left == null) {
            p.next = right;
        }
        if (right == null) {
            p.next = left;
        }

        return dummy.next;
    }

    private ListNode findMid(ListNode node) {
        ListNode fast = node;
        ListNode slow = node;
        ListNode pre = node;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            pre = slow;
            slow = slow.next;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(4);
        root.next = new ListNode(2);
        root.next.next = new ListNode(1);
        root.next.next.next = new ListNode(3);
        new SortList148().sortList(root);

    }

}
