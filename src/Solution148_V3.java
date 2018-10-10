public class Solution148_V3 {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;//cut this list

        ListNode node1 = sortList(head);
        ListNode node2 = sortList(slow);

        return merge(node1, node2);
    }

    private ListNode merge(ListNode node1, ListNode node2) {

        ListNode dummyHead = new ListNode(-1);
        ListNode cur = dummyHead;
        while (true) {
            if (node1 == null) {
                cur.next = node2;
                break;
            }
            if (node2 == null) {
                cur.next = node1;
                break;
            }
            if (node1.val <= node2.val) {
                ListNode node = node1;
                node1 = node.next;
                node.next = null;
                cur.next = node;
                cur = cur.next;
            } else {
                ListNode node = node2;
                node2 = node.next;
                node.next = null;
                cur.next = node;
                cur = cur.next;
            }
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        Solution148_V3 s = new Solution148_V3();
        System.out.println(s.sortList(new ListNode(new int[]{1, 3, 4, 2, 5})));
    }
}
// Runtime: 5 ms, faster than 85.56% of Java online submissions for Sort List.
