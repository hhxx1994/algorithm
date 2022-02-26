package three;

class Solution {

    static class ListNode {
        int val;
        ListNode next;

        public ListNode() {

        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode reverseList(ListNode head) {

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

    int step = 0;

    public ListNode getKthFromEnd(ListNode head, int k) {
        return traverse(head, k);

    }

    public ListNode traverse(ListNode node, int k) {
        if (node == null) {
            return null;
        }

        ListNode ret = traverse(node.next, k);
        if (ret != null) {
            return ret;
        }
        // 后续
        step++;
        if (step == k) {
            return node;
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        Solution solution = new Solution();
        ListNode kthFromEnd = solution.getKthFromEnd(node, 2);
    }
}