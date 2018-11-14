// 234. Palindrome Linked List
// https://leetcode.com/problems/palindrome-linked-list/
/*
Given a singly linked list, determine if it is a palindrome.

Example 1:
Input: 1->2
Output: false

Example 2:
Input: 1->2->2->1
Output: true

Follow up:
Could you do it in O(n) time and O(1) space?
 */

public class Solution234 {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        // 将链表分成两段
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode head2 = slow.next;
        slow.next = null;
        // 将链表head2反转
        ListNode dummyHead = new ListNode(-1);
        while (head2 != null) {
            ListNode node = head2;
            head2 = head2.next;
            node.next = null;

            node.next = dummyHead.next;
            dummyHead.next = node;
        }
        head2 = dummyHead.next;

        // 比较两个链表
        while (head != null && head2 != null) {
            if (head.val != head2.val) {
                return false;
            }
            head = head.next;
            head2 = head2.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(new int[]{1, 2, 1});
        Solution234 s = new Solution234();
        System.out.println(s.isPalindrome(head));
    }
}
// Runtime: 2 ms, faster than 49.13% of Java online submissions for Palindrome Linked List.
