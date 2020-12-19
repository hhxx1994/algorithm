package two;

import pub.ListNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author huanghaoxing
 */
public class ReverseList {

    public ListNode reverse(ListNode head) {
        //base case
        if (head.next == null) {
            return head;
        }

        ListNode ret = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return ret;
    }

    public ListNode reverseWithoutRecursive(ListNode head) {

        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }


    public ListNode reverseWithStack(ListNode head) {
        Deque<ListNode> stack = new LinkedList<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }

        ListNode dummyNode = new ListNode(-1);
        ListNode temp = dummyNode;
        while (!stack.isEmpty()) {
            ListNode node = stack.pop();
            temp.next = node;
            temp = node;
        }
        temp.next = null;
        return dummyNode.next;

    }

    public static void main(String[] args) {
        ReverseList reverseList = new ReverseList();
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);

        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;


        ListNode reverse = reverseList.reverseWithStack(one);

        while (reverse != null) {
            System.out.println(reverse.val);
            reverse = reverse.next;
        }

    }

}
