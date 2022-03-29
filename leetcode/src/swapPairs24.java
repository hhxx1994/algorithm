/**
 * @author huanghaoxing
 */
public class swapPairs24 {

    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            ListNode next = cur.next;
            pre.next = next;
            cur.next = next.next;
            next.next = cur;

            pre = cur;
            cur = cur.next;
        }
        return dummy.next;
    }
}
