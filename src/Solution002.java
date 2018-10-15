import java.util.LinkedList;
import java.util.Queue;

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
public class Solution002 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Queue<Integer> q1 = new LinkedList<>();
        for (ListNode cur = l1; cur != null; cur = cur.next) {
            q1.offer(cur.val);
        }

        Queue<Integer> q2 = new LinkedList<>();
        for (ListNode cur = l2; cur != null; cur = cur.next) {
            q2.offer(cur.val);
        }

        Queue<Integer> q = new LinkedList<>();
        int overflow = 0;
        while (!(q1.isEmpty() && q2.isEmpty())) {
            int a = 0;
            if (!q1.isEmpty()) {
                a = q1.poll();
            }

            int b = 0;
            if (!q2.isEmpty()) {
                b = q2.poll();
            }

            q.offer((a + b + overflow) % 10);
            overflow = (a + b + overflow) / 10;
        }
        if (overflow > 0) {
            q.offer(overflow);
        }

        ListNode dummyHead = new ListNode(-1);
        ListNode cur = dummyHead;
        while (!q.isEmpty()) {
            cur.next = new ListNode(q.poll());
            cur = cur.next;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        Solution002 s = new Solution002();
        System.out.println(s.addTwoNumbers(new ListNode(new int[]{2, 4, 3}), new ListNode(new int[]{5, 6, 4})));
    }
}
// Runtime: 32 ms, faster than 59.80% of Java online submissions for Add Two Numbers.
