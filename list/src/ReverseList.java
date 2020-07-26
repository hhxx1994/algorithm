/**
 * @author huanghaoxing
 */
public class ReverseList {

  public static ListNode reverse(ListNode head) {
    if (head.next == null) {
      return head;
    }

    ListNode last = reverse(head.next);
    head.next.next = head;
    head.next = null;
    return last;
  }

  public static void main(String[] args) {
    ListNode first = new ListNode(0);
    first.next = new ListNode(1);
    first.next.next = new ListNode(2);
    first.next.next.next = new ListNode(3);
    ListNode reverse = reverse(first);
  }


}
