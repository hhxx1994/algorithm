package two;

public class Partition86 {

    public ListNode partition(ListNode head, int x) {
        ListNode l1 = new ListNode(-1);
        ListNode l2 = new ListNode(-1);
        ListNode h1 = l1;
        ListNode h2 = l2;

        while (head != null) {
            if (head.val < x) {
                l1.next = head;
                l1 = l1.next;
            } else {
                l2.next = head;
                l2 = l2.next;
            }

            head = head.next;
        }


        l1.next = h2.next;

        return h1.next;

    }

    public void test() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);
        ListNode partition = partition(head, 3);
    }

    public static void main(String[] args) {
        new Partition86().test();
    }
}
