public class Solution148_V2 {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;//指向 slow 的前一个节点
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;//将链表从prev位置处切断成两部分 [head...prev(slow-1)]、[slow...tail]
        // 循环结束后slow指向链表的中间位置
        ListNode node1 = sortList(head);
        ListNode node2 = sortList(slow);

        return merge(node1, node2);
    }

    private ListNode merge(ListNode node1, ListNode node2) {
        if (node1 == null) {
            return node2;
        }
        if (node2 == null) {
            return node1;
        }
        if (node1.val <= node2.val) {
            node1.next = merge(node1.next, node2);
            return node1;
        } else {
            node2.next = merge(node2.next, node1);
            return node2;
        }
    }

    public static void main(String[] args) {
        Solution148_V2 s = new Solution148_V2();
        System.out.println(s.sortList(new ListNode(new int[]{1, 3, 4, 2, 5})));
    }
}
// Runtime: 7 ms, faster than 40.96% of Java online submissions for Sort List.
