// 328. Odd Even Linked List
// https://leetcode.com/problems/odd-even-linked-list/
/*
Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking
about the node number and not the value in the nodes.You should try to do it in place. The program should run in O(1)
space complexity and O(nodes) time complexity.

Example 1:
Input: 1->2->3->4->5->NULL
Output: 1->3->5->2->4->NULL

Example 2:
Input: 2->1->3->5->6->4->7->NULL
Output: 2->3->6->7->1->5->4->NULL

Note:
    1. The relative order inside both the even and odd groups should remain as it was in the input.
    2. The first node is considered odd, the second node even and so on ...
 */
public class Solution328 {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummyHead1 = new ListNode(-1);
        dummyHead1.next = head;

        ListNode dummyHead2 = new ListNode(-1);

        int i = 0;
        ListNode prev1 = dummyHead1;
        ListNode prev2 = dummyHead2;
        while (prev1.next != null) {
            ++i;
            if (i % 2 == 1) {
                ListNode node = prev1.next;
                prev1.next = node.next;
                node.next = null;

                prev2.next = node;
                prev2 = prev2.next;
            } else {
                prev1 = prev1.next;
            }
        }
        prev2.next = dummyHead1.next;
        dummyHead1.next = null;

        return dummyHead2.next;
    }

    public static void main(String[] args) {
        Solution328 s = new Solution328();
        System.out.println(s.oddEvenList(new ListNode(new int[]{1, 2, 3, 4, 5})));
        System.out.println(s.oddEvenList(new ListNode(new int[]{2, 1, 3, 5, 6, 4, 7})));
    }
}
// Runtime: 4 ms, faster than 84.80% of Java online submissions for Odd Even Linked List.
