// 92. Reverse Linked List II
// https://leetcode.com/problems/reverse-linked-list-ii/
/*
Reverse a linked list from position m to n. Do it in one-pass.

Note: 1 ≤ m ≤ n ≤ length of list.

Example:
Input: 1->2->3->4->5->NULL, m = 2, n = 4
Output: 1->4->3->2->5->NULL
 */
public class Solution092 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummyHead = new ListNode(-1);
        ListNode prev = dummyHead;

        // 找到m的前一个节点
        for (int i = 1; i < m; ++i) {
            ListNode node = head;
            head = head.next;
            node.next = null;

            prev.next = node;
            prev = prev.next;
        }

        // 将[m...n]之间的节点翻转后添加在prev后面
        for (int i = m; i <= n; ++i) {
            ListNode node = head;
            head = head.next;
            node.next = null;

            node.next = prev.next;
            prev.next = node;
        }

        // 找到当前索引为n的节点
        while (prev.next != null) {
            prev = prev.next;
        }

        prev.next = head;
        return dummyHead.next;
    }

    public static void main(String[] args) {
        Solution092 s = new Solution092();
        System.out.println(s.reverseBetween(new ListNode(new int[]{1, 2, 3, 4, 5}), 2, 4));
    }
}
// Runtime: 4 ms, faster than 14.97% of Java online submissions for Reverse Linked List II.
