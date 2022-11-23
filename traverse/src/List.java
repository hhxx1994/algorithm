public class List {

    public void traverse(ListNode head) {
        for (ListNode p = head; p != null; p = p.next) {
            System.out.println(p.val);
        }
    }

    public void traverse2(ListNode p) {
        if (p == null) {
            return;
        }
        // 前序遍历
        traverse2(p.next);
        // 后序遍历
    }
}
