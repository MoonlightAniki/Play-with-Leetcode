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
public class Solution206_V3 {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummyHead = new ListNode(-1);
        while (head != null) {
            ListNode node = head;
            head = head.next;
            node.next = null;

            node.next = dummyHead.next;
            dummyHead.next = node;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        Solution206_V3 s = new Solution206_V3();
        System.out.println(s.reverseList(new ListNode(new int[]{1, 2, 3, 4, 5})));
        System.out.println(s.reverseList(new ListNode(new int[]{1})));
    }
}
// Runtime: 0 ms, faster than 100.00% of Java online submissions for Reverse Linked List.
