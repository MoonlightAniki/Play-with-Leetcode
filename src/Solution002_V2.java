// 2. Add Two Numbers
// https://leetcode.com/problems/add-two-numbers/
/*
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:
Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
 */
public class Solution002_V2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(-1);
        ListNode cur = dummyHead;
        ListNode node1 = l1;
        ListNode node2 = l2;
        int overflow = 0;
        while (node1 != null || node2 != null) {
            int a = 0;
            if (node1 != null) {
                a = node1.val;
                node1 = node1.next;
            }
            int b = 0;
            if (node2 != null) {
                b = node2.val;
                node2 = node2.next;
            }
            int sum = a + b + overflow;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            overflow = sum / 10;
        }
        if (overflow > 0) {
            cur.next = new ListNode(overflow);
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        Solution002_V2 s = new Solution002_V2();
//        System.out.println(s.addTwoNumbers(new ListNode(new int[]{2, 4, 3}), new ListNode(new int[]{5, 6, 4})));
        System.out.println(s.addTwoNumbers(new ListNode(new int[]{1, 8}), new ListNode(new int[]{0})));
    }
}
// Runtime: 36 ms, faster than 50.74% of Java online submissions for Add Two Numbers.
