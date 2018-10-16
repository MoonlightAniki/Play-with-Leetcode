// 206. Reverse Linked List
// https://leetcode.com/problems/reverse-linked-list/
/*
Reverse a singly linked list.

Example:
Input: 1->2->3->4->5->NULL
Output: 5->4->3->2->1->NULL

Follow up:
A linked list can be reversed either iteratively or recursively. Could you implement both?
 */
public class Solution206_V2 {

    // 递归
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode node = head;
        head = head.next;
        node.next = null;

        ListNode newHead = reverseList(head);
        if (newHead == null) {
            return node;
        }

        ListNode cur = newHead;
        while (cur.next != null) {
            cur = cur.next;
        }

        cur.next = node;
        return newHead;
    }

    public static void main(String[] args) {
        Solution206_V2 s = new Solution206_V2();
        System.out.println(s.reverseList(new ListNode(new int[]{1, 2, 3, 4, 5})));
        System.out.println(s.reverseList(new ListNode(new int[]{1})));
    }
}
// Runtime: 20 ms, faster than 1.44% of Java online submissions for Reverse Linked List.
