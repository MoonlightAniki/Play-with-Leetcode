// 19. Remove Nth Node From End of List
// https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
class Solution019 {

    // 虚拟头结点
//    public ListNode removeNthFromEnd(ListNode head, int n) {
//        int count = 0;
//        for (ListNode cur = head; cur != null; cur = cur.next) {
//            ++count;
//        }
//        int index = count - n;
//        ListNode dummyHead = new ListNode(-1);
//        dummyHead.next = head;
//        ListNode prev = dummyHead;
//        for (int i = 0; i < index; ++i) {
//            prev = prev.next;
//        }
//        ListNode delNode = prev.next;
//        prev.next = delNode.next;
//        delNode.next = null;
//        return dummyHead.next;
//    }

    // 双索引技术
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode p = dummyHead;
        ListNode q = dummyHead;
        for (int i = 0; i < n + 1; ++i) {
            q = q.next;
        }
        while (q != null) {
            p = p.next;
            q = q.next;
        }
        ListNode delNode = p.next;
        p.next = delNode.next;
        delNode.next = null;
        ListNode retNode = dummyHead.next;
        dummyHead.next = null;
        return retNode;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(new int[]{1, 2, 3, 4, 5});
        Solution019 s = new Solution019();
        System.out.println(s.removeNthFromEnd(node, 2));
    }
}
